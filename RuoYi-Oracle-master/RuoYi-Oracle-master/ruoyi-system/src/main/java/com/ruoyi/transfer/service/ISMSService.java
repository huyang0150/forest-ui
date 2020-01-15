package com.ruoyi.project.transfer.service;

/**
 * 发送短信服务
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISMSService
{
    public Boolean sendSMS(String mobile, String coupon);
}
