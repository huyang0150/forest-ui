package com.ruoyi.project.order.domain;

import java.util.List;

public class OrderListBody {
    private List<OrderDetail> dataList;
    public List<OrderDetail> getDataList() {
        return dataList;
    }

    public void setDataList(List<OrderDetail> dataList) {
        this.dataList = dataList;
    }


}
