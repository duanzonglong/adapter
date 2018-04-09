import com.cwms.qm.ws.inter.IBaseAdapter;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

public class SapAdatperTest
{
    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    @Test
    public void cl1() {
        try {
            // 接口地址
            String address = "http://localhost:8030/services/SapAdapter";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(IBaseAdapter.class);

            jaxWsProxyFactoryBean.getOutInterceptors().add(new LoginInterceptor("root","admin"));

            // 创建一个代理接口实现
            IBaseAdapter cs = (IBaseAdapter) jaxWsProxyFactoryBean.create();

            // 调用代理接口的方法调用并返回结果
            String result = cs.business("101",",,,,,,,,,,",new String[]{"detail1","detail2","detail3"});
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class LoginInterceptor extends AbstractPhaseInterceptor<SoapMessage>
    {
        private String username="root";
        private String password="admin";
        public LoginInterceptor(String username, String password) {
            //设置在发送请求前阶段进行拦截
            super(Phase.PREPARE_SEND);
            this.username=username;
            this.password=password;
        }

        @Override
        public void handleMessage(SoapMessage soapMessage) throws Fault
        {
            List<Header> headers = soapMessage.getHeaders();
            Document doc = DOMUtils.createDocument();
            Element auth = doc.createElementNS("http://ws.qm.cwms.com/","SecurityHeader");
            Element UserName = doc.createElement("username");
            Element UserPass = doc.createElement("password");

            UserName.setTextContent(username);
            UserPass.setTextContent(password);

            auth.appendChild(UserName);
            auth.appendChild(UserPass);

            headers.add(0, new Header(new QName("SecurityHeader"),auth));
        }
    }

}
