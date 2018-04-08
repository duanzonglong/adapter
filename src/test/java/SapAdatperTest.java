import com.cwms.qm.ws.inter.IBaseAdapter;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

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
            // 创建一个代理接口实现
            IBaseAdapter cs = (IBaseAdapter) jaxWsProxyFactoryBean.create();
            // 调用代理接口的方法调用并返回结果
            String result = cs.business("101","mainOrder",new String[]{"detail1","detail2","detail3"});
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
