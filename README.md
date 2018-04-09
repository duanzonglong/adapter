# adapter
wms adapter for Ducati.<br>
This time, I only provided an interactive way.
Please Confirm.

## I01-Shipping Notification
First modify SapAdapter to receive sap message.Then send message to wms.
SapAdapter is a webservice,Of course you can use ftp or other.

``` java
@WebMethod
@WebResult(name = "response")String business(@WebParam(name = "request")String request);
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


