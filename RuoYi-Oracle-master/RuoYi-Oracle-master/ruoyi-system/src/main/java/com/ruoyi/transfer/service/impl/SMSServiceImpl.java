package com.ruoyi.project.transfer.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.http.HttpClientUtil;
import com.ruoyi.common.utils.md5.Md5Util;
import com.ruoyi.project.transfer.service.ISMSService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SMSServiceImpl implements ISMSService
{
    private static final Logger log = LoggerFactory.getLogger(SMSServiceImpl.class);

    private static final String submitUser = "xyxz";

    private static final String secretKey = "ab4ad75b1854b899891e";

    private static final String smsUrl = "http://132.129.5.97:8080/SMSSend/sendMsg";

    private static final String ipAddr = "132.129.5.96";

    @Override
    public Boolean sendSMS(String mobile, String code){
        log.info("-----send SMS -----");
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(code)){
            return false;
        }

        String smsContent = buildSMSContent(code);
        return doPost(mobile, smsContent);
    }

    private Boolean doPost(String mobile,String smsContent){
        String json = toJsonPara(mobile, smsContent);
        String result = "";
        if(!StringUtils.isEmpty(json)){
            log.info("访问短信平台参数：{}",json);
            result = HttpClientUtil.post(smsUrl,json,"UTF-8");
        }else{
            log.error("发送短信失败，");
        }
        return StringUtils.isEmpty(result) ? Boolean.FALSE : Boolean.TRUE;
    }

    private String buildMD5(String mobile,Long timestamp){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mobile);
        stringBuilder.append(ipAddr);
        stringBuilder.append(timestamp);
        stringBuilder.append(submitUser);
        stringBuilder.append(secretKey);

        return Md5Util.getMD5(stringBuilder.toString()).toString();
    }

    /**
     * {
     *     "timestamp": "{{timestamp}}",
     *     "submitUser": "zdgz",
     *     "mobile": "15657178206",
     *     "token":"{{sign}}",
     *     "smsContent": "你有一项编号为9999999999999999999的事务需要处理。"
     * }
     * @return
     */
    private String toJsonPara(String mobile,String smsContent){
        Long timestamp = System.currentTimeMillis();
        String md5 = buildMD5(mobile, timestamp);
        Map map = new HashMap<String, String>();
        map.put("timestamp",timestamp);
        map.put("submitUser",submitUser);
        map.put("mobile",mobile);
        map.put("token",md5);
        map.put("smsContent",smsContent);

        return JSON.toJSONString(map);
    }

    private String buildSMSContent(String code){
        return "您的验证码："+ code+"，该验证码1分钟内有效";
    }

    public static void main(String[] args){
        SMSServiceImpl smsService = new SMSServiceImpl();
        System.out.println(smsService.toJsonPara("15657176308","发短信"));
    }
}
