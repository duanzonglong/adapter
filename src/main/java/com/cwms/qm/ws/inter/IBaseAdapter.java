package com.cwms.qm.ws.inter;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IBaseAdapter
{
    @WebMethod
    String business(String message);
}
