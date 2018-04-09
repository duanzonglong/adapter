# adapter
wms adapter for Ducati.<br>
This time, I only provided an interactive way.
Please Confirm.

## I01-Shipping Notification
First modify SapAdapter to receive sap message.Then send message to wms.
SapAdapter is a webservice,Of course you can use ftp or other.

``` java
/**
 *
 * 101 interface
 *
 * @param requestType  interface type, 101 now,you can enter other the future.
 *
 * @param mainOrder Delivery_no,
 *                  Sales order number,
 *                  Ship-to_CodeShip-to_Name EN,
 *                  Ship-to_Name ZH,
                    Ship-to_Address EN,
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
@WebResult(name = "response")String business(@WebParam(name = "requestType")String requestType,@WebParam(name = "mainOrder")String mainOrder,@WebParam(name = "details")String[] details);
```

## I01 java2wsdl
``` shell
cd build/classes/java/main
java2ws -o adapter.wsdl -wsdl com.cwms.qm.ws.inter.IBaseAdapter
```


## I02 - Goods Shipment
First modify QmController
``` java
//102 confirm
else if (method.equals("taobao.qimen.deliveryorder.confirm"))
{
    DeliveryOrderConfirm responseDto = (DeliveryOrderConfirm) DtoXmlUtils.xmlToDto(requestData, DeliveryOrderConfirm.class);

    //TODO send message to sap
}
```


## I03 - Goods Receipt
First modify QmController
``` java
//103 confirm
if (method.equals("taobao.qimen.entryorder.confirm"))
{
    QmInboundFeekBackDto responseDto = (QmInboundFeekBackDto) DtoXmlUtils.xmlToDto(requestData, QmInboundFeekBackDto.class);

    //TODO send message to sap
}
```


