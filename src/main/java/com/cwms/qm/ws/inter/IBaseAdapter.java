package com.cwms.qm.ws.inter;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IBaseAdapter
{
    /**
     * 101 interface
     * @param mainOrder Delivery_no,
     *                  Sales order number,
     *                  Ship-to_CodeShip-to_Name EN,
     *                  Ship-to_Name ZH,Ship-to_Address EN,
     *                  Ship-to_Address ZH,
                        Ship-to_Contact EN,
                        Ship-to_Contact ZH,
                        Ship-to_Phone_No,
                        Ship-to_Mobile_Phone_No,
                        Shipment_Method_Code,
                        Shipment_Method EN,
                        Shipment_Method ZH,
                        Shipment_Date

     * @param details   Delivery Line N,
                        Sales Order Line,
                        Material code,
                        VIN,
                        Description EN,
                        Description ZH,
                        UoM_Code SAP,
                        Quantity to ship,
                        Package_UoM SAP,
                        NR of pieces per Package,
                        SAP Storage Location

     * @return success or fail:message
     */
    @WebMethod
    String business(String mainOrder,String[] details);
}
