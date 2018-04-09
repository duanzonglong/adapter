package com.cwms.qm.ws.dto;

public class I01ShipDetail
{
    private String deliveryLineNo;

    private String salesOrderNumber;

    private String salesOrderLine;

    private String materialCode;

    private String vin;

    private String descriptionEN;

    private String descriptionZH;

    /**
     * UoM_Code SAP
     */
    private String unit;

    private Integer quantity;

    /**
     * Delivery unit
     */
    private Integer minPackagingQuantity;

    private String storageLocaiton;

    public String getDeliveryLineNo()
    {
        return deliveryLineNo;
    }

    public void setDeliveryLineNo(String deliveryLineNo)
    {
        this.deliveryLineNo = deliveryLineNo;
    }

    public String getSalesOrderNumber()
    {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber)
    {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getSalesOrderLine()
    {
        return salesOrderLine;
    }

    public void setSalesOrderLine(String salesOrderLine)
    {
        this.salesOrderLine = salesOrderLine;
    }

    public String getMaterialCode()
    {
        return materialCode;
    }

    public void setMaterialCode(String materialCode)
    {
        this.materialCode = materialCode;
    }

    public String getVin()
    {
        return vin;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getDescriptionEN()
    {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN)
    {
        this.descriptionEN = descriptionEN;
    }

    public String getDescriptionZH()
    {
        return descriptionZH;
    }

    public void setDescriptionZH(String descriptionZH)
    {
        this.descriptionZH = descriptionZH;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Integer getMinPackagingQuantity()
    {
        return minPackagingQuantity;
    }

    public void setMinPackagingQuantity(Integer minPackagingQuantity)
    {
        this.minPackagingQuantity = minPackagingQuantity;
    }

    public String getStorageLocaiton()
    {
        return storageLocaiton;
    }

    public void setStorageLocaiton(String storageLocaiton)
    {
        this.storageLocaiton = storageLocaiton;
    }
}
