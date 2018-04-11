package com.cwms.qm.ws.inter;

import com.cwms.qm.ws.dto.I01DTO;
import com.cwms.qm.ws.dto.Response;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IBaseAdapter
{
    /**
     *
     * 101 interface
     *
     *
     * @return success or fail:message
     */
    @WebMethod
    @WebResult Response shipOrder(@WebParam(name = "request") I01DTO i01DTO);
}
