package com.ruoyi.project.transfer.domain;

import java.util.Date;

public class ZjucrmPO {
    private Integer partitionId;

    private String cityCode;

    private String  serialNumber;

    private String serviceType;

    private Date acceptDate;

    private String portOutNetId;

    private String portInNetId;

    private String homeNetId;

    private String NpState;

    private Date endDate;

    private Date startDate;

    private Date updateTime;

    private String remark;

    public Integer getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Integer partitionId) {
        this.partitionId = partitionId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getPortOutNetId() {
        return portOutNetId;
    }

    public void setPortOutNetId(String portOutNetId) {
        this.portOutNetId = portOutNetId;
    }

    public String getPortInNetId() {
        return portInNetId;
    }

    public void setPortInNetId(String portInNetId) {
        this.portInNetId = portInNetId;
    }

    public String getHomeNetId() {
        return homeNetId;
    }

    public void setHomeNetId(String homeNetId) {
        this.homeNetId = homeNetId;
    }

    public String getNpState() {
        return NpState;
    }

    public void setNpState(String npState) {
        NpState = npState;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
