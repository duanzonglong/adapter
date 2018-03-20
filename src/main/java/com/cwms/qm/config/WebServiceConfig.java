package com.cwms.qm.config;

import com.cwms.qm.ws.SapAdapter;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig
{
    @Autowired
    private Bus bus;
    @Autowired
    private SapAdapter sapAdapter;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,sapAdapter);
        endpoint.publish("/SapAdapter");//接口发布在 /NetbarServices 目录下
        return endpoint;
    }
}
