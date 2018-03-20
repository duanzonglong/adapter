package com.cwms.qm.controller;

import com.cwms.qm.model.QmInboundFeekBackDto;
import com.cwms.qm.model.QmOutboundResponseDto;
import com.cwms.qm.model.feedback.DeliveryOrderConfirm;
import com.cwms.qm.util.DtoXmlUtils;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.QimenUtils;
import com.cwms.qm.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by duanzonglong on 2017/8/3.
 */
@RestController
public class QmController
{
    private  static  final Logger logger = LoggerFactory.getLogger(QmController.class);

    @Value("${qm.appKey}")
    private String qmAppKey;

    @Value("${qm.secret}")
    private String qmSecret;

    @RequestMapping(value = "/api/qm")
    public String index(HttpServletRequest request,@RequestBody String requestData)
        throws UnsupportedEncodingException
    {
        String data = URLDecoder.decode(requestData,"UTF-8");
        String requestUrl = request.getRequestURI() + "?" + request.getQueryString();

        Map<String,String> params = QimenUtils.getParamsFromUrl(requestUrl);

        String method = params.get("method");
        String sign = params.get("sign");

        String xml = null;

        if (data.indexOf("<") > 0)
        {
            xml = data.substring(data.indexOf("<"));;
        }

        logger.info("接收到的请求为:" + requestUrl);
        logger.info("接收到的报文为:" + xml);

        String response = null;

        try
        {
            String mySign = QimenSignUtils.sign(params, xml, qmSecret);

            if (!sign.equals(mySign))
            {
                response = QimenUtils.getCommonResponse("400","failer","Invalid Sign");
            }
            else
            {
                doApi(xml,method);
                response = QimenUtils.getCommonResponse("200","success","Deal Success");
            }
        }
        catch (Exception e)
        {
            logger.error("奇门接口处理失败",e);
            response = QimenUtils.getCommonResponse("400","failer","failer");
        }

        return  response;
    }

    private void doApi(String requestData, String method) throws Exception {
        //103 confirm
        if (method.equals("taobao.qimen.entryorder.confirm"))
        {
            QmInboundFeekBackDto responseDto = (QmInboundFeekBackDto) DtoXmlUtils.xmlToDto(requestData, QmInboundFeekBackDto.class);

            //TODO send message to sap
        }
        //102 confirm
        else if (method.equals("taobao.qimen.deliveryorder.confirm"))
        {
            DeliveryOrderConfirm responseDto = (DeliveryOrderConfirm) DtoXmlUtils.xmlToDto(requestData, DeliveryOrderConfirm.class);

            //TODO send message to sap
        }
    }


    private String getReqestData(HttpServletRequest request) {
        String requestData = "";
        BufferedReader br = null;
        try {
            br = request.getReader();
            StringBuilder sbData = new StringBuilder();
			/*String line = null;
			while ((line = br.readLine()) != null) {
				sbData.append(line).append("\n");
			}*/

            char[]buff = new char[1024];
            int len;
            while((len = br.read(buff)) != -1) {
                sbData.append(buff,0, len);
            }

            requestData = sbData.toString();
        } catch (Exception ex) {
            logger.error("获取ERP请求数据异常", ex);
        } finally {
            try {
                br.close();
            } catch (IOException e) {

            }

        }
        return requestData;
    }
}
