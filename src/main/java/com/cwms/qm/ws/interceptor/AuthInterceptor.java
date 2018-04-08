package com.cwms.qm.ws.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPException;
import java.util.List;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>
{

    private static final String USERNAME = "root";

    private static final String PASSWORD = "admin";

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    public AuthInterceptor()
    {
        super(Phase.PRE_PROTOCOL);
    }

    @Override
    public void handleMessage(SoapMessage soapMessage)
        throws Fault
    {
        List<Header> headers = null;
        String username = null;
        String password = null;
        try
        {
            headers = soapMessage.getHeaders();
        }
        catch (Exception e)
        {
            logger.error("getSOAPHeader error: {}", e.getMessage(), e);
        }

        if (headers == null)
        {
            throw new Fault(new IllegalArgumentException("header is empty"));
        }
        //获取用户名,密码
        for (Header header : headers)
        {
            SoapHeader soapHeader = (SoapHeader)header;
            Element e = (Element)soapHeader.getObject();
            NodeList usernameNode = e.getElementsByTagName("username");
            NodeList pwdNode = e.getElementsByTagName("password");
            username = usernameNode.item(0).getTextContent();
            password = pwdNode.item(0).getTextContent();
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            {
                throw new Fault(new IllegalArgumentException("Auth message is empty."));
            }
        }
        //校验用户名密码
        if (!(username.equals(USERNAME) && password.equals(PASSWORD)))
        {
            SOAPException soapExc = new SOAPException("Auth failed");
            logger.debug("用户认证信息错误");
            throw new Fault(soapExc);
        }

    }
}
