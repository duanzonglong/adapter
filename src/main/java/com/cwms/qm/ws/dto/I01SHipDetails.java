package com.cwms.qm.ws.dto;

import java.util.ArrayList;
import java.util.List;

public class I01SHipDetails
{
    private List<I01ShipDetail> detail = new ArrayList<>();

    public List<I01ShipDetail> getDetail()
    {
        return detail;
    }

    public void setDetail(List<I01ShipDetail> detail)
    {
        this.detail = detail;
    }
}
