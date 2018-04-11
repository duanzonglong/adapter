import com.cwms.qm.ws.dto.*;
import com.cwms.qm.ws.inter.IBaseAdapter;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.junit.Test;
import org.junit.runner.Request;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
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
            I01DTO i01DTO = new I01DTO();
            I01ShipOrder shipOrder = new I01ShipOrder();
            shipOrder.setDeliveryNumber("123");
            shipOrder.setDeliveryType("123");
            shipOrder.setQuantityToShip(1);
            shipOrder.setShipmentConditionCode("123");
            shipOrder.setShipmentConditionEN("123");
            shipOrder.setShipmentDate("2018/04/09");
            shipOrder.setShippingPoint("123");
            shipOrder.setShipToAddressZH("江苏省南京市雨花区软件大道XXX路");
            shipOrder.setShipToCode("00001");
            shipOrder.setShipToMobile("18765489087");
            shipOrder.setShipToPhone("025-89765678");
            shipOrder.setShipToNameEN("123");
            shipOrder.setShipToNameZH("123");
            i01DTO.setI01ShipOrder(shipOrder);
            I01SHipDetails i01SHipDetails = new I01SHipDetails();
            I01ShipDetail detail1 = new I01ShipDetail();
            detail1.setDeliveryLineNo("00001");
            detail1.setMaterialCode("ST0001");
            detail1.setQuantity(150);
            detail1.setMinPackagingQuantity(50);
            detail1.setSalesOrderNumber("123456789");
            detail1.setSalesOrderLine("000001");
            detail1.setStorageLocaiton("123");
            detail1.setVin("12398374234");
            detail1.setDescriptionEN("en");
            i01SHipDetails.getDetail().add(detail1);
            I01ShipDetail detail2 = new I01ShipDetail();
            detail2.setDeliveryLineNo("00002");
            detail2.setMaterialCode("ST0002");
            detail2.setQuantity(150);
            detail2.setMinPackagingQuantity(50);
            detail2.setSalesOrderNumber("123456789");
            detail2.setSalesOrderLine("000002");
            detail2.setStorageLocaiton("123");
            detail2.setVin("12398374235");
            detail2.setDescriptionEN("en");
            i01SHipDetails.getDetail().add(detail2);
            i01DTO.setI01SHipDetails(i01SHipDetails);

            // 调用代理接口的方法调用并返回结果
            Response result = cs.shipOrder(i01DTO);
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

            Header header = new Header(new QName("SecurityHeader"),auth);

            System.out.println(doc2String(doc));

            headers.add(0, header);


        }


    }

    public static String doc2String(Document doc){
        try {
            Source source = new DOMSource(doc);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            return null;
        }
    }

}
