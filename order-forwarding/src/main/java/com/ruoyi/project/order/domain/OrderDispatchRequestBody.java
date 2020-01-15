package com.ruoyi.project.order.domain;

public class OrderRequestBody extends OrderBasicRequestBody{
    //获取订单列表时body入参
    private String remark;
    //调用回执接口body入参
    private String msgIds;
    //调用派单时参数
    private String orderNo;

    private String type;

    private String dispatchName;

    private String phoneNo;

    private String addressId;

    private String linkInstallResTag;

    private String linkInstallAddr;

    private String reason;

    private String secondDispatchType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDispatchName() {
        return dispatchName;
    }

    public void setDispatchName(String dispatchName) {
        this.dispatchName = dispatchName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getLinkInstallResTag() {
        return linkInstallResTag;
    }

    public void setLinkInstallResTag(String linkInstallResTag) {
        this.linkInstallResTag = linkInstallResTag;
    }

    public String getLinkInstallAddr() {
        return linkInstallAddr;
    }

    public void setLinkInstallAddr(String linkInstallAddr) {
        this.linkInstallAddr = linkInstallAddr;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSecondDispatchType() {
        return secondDispatchType;
    }

    public void setSecondDispatchType(String secondDispatchType) {
        this.secondDispatchType = secondDispatchType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(String msgIds) {
        this.msgIds = msgIds;
    }

}
