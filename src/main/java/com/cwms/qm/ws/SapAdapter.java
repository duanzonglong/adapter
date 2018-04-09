package com.cwms.qm.ws;

import com.cwms.qm.model.QmCommonResponseDto;
import com.cwms.qm.model.stockout.QmStockoutRequestDto;
import com.cwms.qm.util.DtoXmlUtils;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.WebUtils;
import com.cwms.qm.ws.inter.IBaseAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * First you need expose this class with webservice.You can use @WebService to do it.
 * Second you can receive sap message.Then send http+xml message to wms.
 * http://localhost:8030/services/SapAdapter?wsdl
 */

@Component
@WebService
public class SapAdapter implements IBaseAdapter
{
    @Value("${qm.appKey}")
    private String qmAppKey;
    
    @Value("${qm.secret}")
    private String qmSecret;
    
    @Value("${qm.customerId}")
    private String qmCustomerId;
    
    @Value("${qm.url}")
    private String qmUrl;
    
    public QmCommonResponseDto sendMessaeg(QmStockoutRequestDto qmStockoutRequestDto)
        throws Exception
    {
        String xml = DtoXmlUtils.DtoToXml(qmStockoutRequestDto);
        
        Map<String, String> requestParamter = WebUtils.getRequestParameter("stockout.create", qmAppKey, qmCustomerId);
        
        String sign = QimenSignUtils.sign(requestParamter, xml, qmSecret);
        requestParamter.put("sign", sign);
        String url = qmUrl + "?" + QimenSignUtils.joinRequestParams(requestParamter);
        String result = WebUtils.doQmPost(url, xml);
        QmCommonResponseDto responseDto = (QmCommonResponseDto)DtoXmlUtils.xmlToDto(result,QmCommonResponseDto.class);
        return responseDto;
    }

    @Override
    public String business(String header,String body)
    {
        // Read 101 message,then fill wms object.
        QmStockoutRequestDto qmStockoutRequestDto = new QmStockoutRequestDto();
        boolean flag = false;
        String errorMsg = null;
        try
        {
            QmCommonResponseDto responseDto = sendMessaeg(qmStockoutRequestDto);
            if ("success".equals(responseDto.getFlag()))
            {
                flag = true;
            }
            else
            {
                errorMsg = responseDto.getMessage();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // TODO
        if (flag)
        {

        }

        return "success:success";
    }
}
