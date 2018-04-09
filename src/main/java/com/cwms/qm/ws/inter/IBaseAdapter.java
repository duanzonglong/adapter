package com.cwms.qm.ws.inter;

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
     * @param header  interface type 101
     * @param body body
     *
     * @return success or fail:message
     */
    @WebMethod
    @WebResult(name = "response")String business(@WebParam(name = "header")String header,@WebParam(name = "body")String body);
}
