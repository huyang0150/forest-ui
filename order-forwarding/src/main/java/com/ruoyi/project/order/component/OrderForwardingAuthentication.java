package com.ruoyi.project.transfer.component;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.lang.UUID;
import com.ruoyi.common.utils.CheckUtils;
import com.ruoyi.common.utils.md5.Md5Util;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.framework.redis.RedisCache;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Component
public class TransferAuthentication {
    private static final Logger log = LoggerFactory.getLogger(TransferAuthentication.class);

    private static final String TOKEN_OF_TRANSFER_PRE_FIX = "TOKEN_OF_TRANSFER_PRE_FIX_";

    private static final String WOFENTUAN_TOKEN_VALUE = "WOFENTUAN_TOKEN_VALUE";

    private static final String[] WOFENTUAN_SERVICE = {"finishList","transferedAndOnline"};
    @Autowired
    private RedisCache redisCache;

    /**
     * 即要检验token是否存在，又要检验接口参数的mobile和登陆时候的mobile是否相等
     * 前端蒋token放入请求参数中，后端对token和mobile进行校验，校验成功正在入参的mobile和token能匹配上
     * 如果用requestBody这里是获取不到token和mobile参数的
     * @param request
     * @return
     */
    public Boolean authToken(HttpServletRequest request){
        String mobile = request.getParameter(Constants.TRANSFER_MOBILE);
        String token = request.getParameter(Constants.TOKEN);
        String servicePath = request.getServletPath();
        String redisValue = redisCache.getCacheObject(getRedisKey(token));
        if(!StringUtils.isEmpty(redisValue)){
            if(StringUtils.equals(redisValue,WOFENTUAN_TOKEN_VALUE)){//如果token是沃粉团的token
                if(wofentuanRequest(servicePath)){
                    return true;
                }else{
                    return false;
                }
            }

            if(StringUtils.isEmpty(mobile)){
                return true;
            }

            if(StringUtils.equals(redisValue, mobile)){
                return true;
            }
        }

        return false;
    }

    public String getAuthenticationToken(String tokenValue){
        if(StringUtils.isEmpty(tokenValue)){
            tokenValue = WOFENTUAN_TOKEN_VALUE;
        }
        String token = UUID.fastUUID().toString();
        redisCache.setCacheObject(getRedisKey(token),tokenValue,10, TimeUnit.DAYS);
        return token;
    }

    private String getRedisKey(String token){
        return TOKEN_OF_TRANSFER_PRE_FIX + token;
    }

    private Boolean wofentuanRequest(String path){
        for(String p : WOFENTUAN_SERVICE){
            if(path.contains(p)){
                return true;
            }
        }
        return false;
    }
}
