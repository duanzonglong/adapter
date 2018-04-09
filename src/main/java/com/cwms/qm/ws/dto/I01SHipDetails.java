package com.cwms.qm.ws.dto;

import java.util.ArrayList;
import java.util.List;

public class I01SHipDetails
{
    private List<I01ShipDetail> details = new ArrayList<>();

    public List<I01ShipDetail> getDetails()
    {
        return details;
    }

    public void setDetails(List<I01ShipDetail> details)
    {
        this.details = details;
    }
}
