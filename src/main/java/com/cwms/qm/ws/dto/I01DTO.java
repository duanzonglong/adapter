package com.cwms.qm.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class I01DTO
{
    private I01ShipOrder i01ShipOrder;

    private I01SHipDetails i01SHipDetails;

    public I01SHipDetails getI01SHipDetails()
    {
        return i01SHipDetails;
    }

    public void setI01SHipDetails(I01SHipDetails i01SHipDetails)
    {
        this.i01SHipDetails = i01SHipDetails;
    }

    public I01ShipOrder getI01ShipOrder()
    {
        return i01ShipOrder;
    }

    public void setI01ShipOrder(I01ShipOrder i01ShipOrder)
    {
        this.i01ShipOrder = i01ShipOrder;
    }


}
