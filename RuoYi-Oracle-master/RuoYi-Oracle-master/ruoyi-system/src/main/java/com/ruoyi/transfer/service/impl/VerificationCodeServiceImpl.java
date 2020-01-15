package com.ruoyi.project.transfer.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.transfer.service.ISMSService;
import com.ruoyi.project.transfer.service.VerificationCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    private static final Logger log = LoggerFactory.getLogger(VerificationCodeServiceImpl.class);
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISMSService ismsService;


    private static String PRE_FIX = "VERIFICATION_CODE_";

    private static Integer VERIFICATION_CODE_LENGTH = 6;
    /**
     * 1.验证mobile指定用户是否是配送专员
     * 2.生成随机码：code
     * 3.将（mobile，code）放入redis
     * 4.设置缓存失效时间
     * @param mobile
     * @return
     */
    @Override
    public AjaxResult generateAndSendVerificationCode(String mobile){
        //验证是否是配送专员
        String key = getRedisKey(mobile);
        String codeFromRedis = redisCache.getCacheObject(key);
        if(!StringUtils.isEmpty(codeFromRedis)){
            return AjaxResult.error("请稍后再获取验证码");
        }
        String code = generatorRandomNumber(VERIFICATION_CODE_LENGTH);
        redisCache.setCacheObject(key,code,1, TimeUnit.MINUTES);
        if(!ismsService.sendSMS(mobile,code)){
            redisCache.deleteObject(key);
            return AjaxResult.error("发送短信验证码失败，请重新获取！");
        }
        return AjaxResult.success(code);
    }

    @Override
    public AjaxResult verify(String mobile, String code){
        String key = getRedisKey(mobile);
        String codeFromRedis = redisCache.getCacheObject(key);
        if(StringUtils.equals(code,codeFromRedis)){
            redisCache.deleteObject(key);
            return AjaxResult.success();
        }else{
            return AjaxResult.error("验证码错误！");
        }
    }

    private String generatorRandomNumber(Integer length){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    private String getRedisKey(String mobile){
        return PRE_FIX+mobile;
    }
}
