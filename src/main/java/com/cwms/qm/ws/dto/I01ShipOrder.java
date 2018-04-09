package com.cwms.qm.ws.dto;

public class I01ShipOrder
{
    private String deliveryNumber;

    private String shippingPoint;

    private String deliveryType;

    private String shipToCode;

    private String shipToNameEN;

    private String shipToNameZH;

    private String shipToAddressZH;

    private Integer quantityToShip;

    private String shipToPhone;

    private String shipToMobile;

    private String shipmentConditionCode;

    private String shipmentConditionEN;

    /**
     * formate 2018/04/06
     */
    private String shipmentDate;

    public String getDeliveryNumber()
    {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber)
    {
        this.deliveryNumber = deliveryNumber;
    }

    public String getShippingPoint()
    {
        return shippingPoint;
    }

    public void setShippingPoint(String shippingPoint)
    {
        this.shippingPoint = shippingPoint;
    }

    public String getDeliveryType()
    {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType)
    {
        this.deliveryType = deliveryType;
    }

    public String getShipToCode()
    {
        return shipToCode;
    }

    public void setShipToCode(String shipToCode)
    {
        this.shipToCode = shipToCode;
    }

    public String getShipToNameEN()
    {
        return shipToNameEN;
    }

    public void setShipToNameEN(String shipToNameEN)
    {
        this.shipToNameEN = shipToNameEN;
    }

    public String getShipToNameZH()
    {
        return shipToNameZH;
    }

    public void setShipToNameZH(String shipToNameZH)
    {
        this.shipToNameZH = shipToNameZH;
    }

    public String getShipToAddressZH()
    {
        return shipToAddressZH;
    }

    public void setShipToAddressZH(String shipToAddressZH)
    {
        this.shipToAddressZH = shipToAddressZH;
    }

    public Integer getQuantityToShip()
    {
        return quantityToShip;
    }

    public void setQuantityToShip(Integer quantityToShip)
    {
        this.quantityToShip = quantityToShip;
    }

    public String getShipToPhone()
    {
        return shipToPhone;
    }

    public void setShipToPhone(String shipToPhone)
    {
        this.shipToPhone = shipToPhone;
    }

    public String getShipToMobile()
    {
        return shipToMobile;
    }

    public void setShipToMobile(String shipToMobile)
    {
        this.shipToMobile = shipToMobile;
    }

    public String getShipmentConditionCode()
    {
        return shipmentConditionCode;
    }

    public void setShipmentConditionCode(String shipmentConditionCode)
    {
        this.shipmentConditionCode = shipmentConditionCode;
    }

    public String getShipmentConditionEN()
    {
        return shipmentConditionEN;
    }

    public void setShipmentConditionEN(String shipmentConditionEN)
    {
        this.shipmentConditionEN = shipmentConditionEN;
    }

    public String getShipmentDate()
    {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate)
    {
        this.shipmentDate = shipmentDate;
    }
}
