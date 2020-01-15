package com.ruoyi.project.transfer.controller;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.CheckUtils;
import com.ruoyi.framework.redis.RedisCache;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.transfer.service.VerificationCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification")
public class VerificationCodeController {
    private static final Logger log = LoggerFactory.getLogger(VerificationCodeController.class);
    @Autowired
    private VerificationCodeService verificationCodeService;
    @GetMapping
    public AjaxResult generateAndSendVerificationCode(@RequestParam("mobile") String mobile){
        if(!CheckUtils.checkMobile(mobile)){
            return AjaxResult.error(HttpStatus.UNSUPPORTED_TYPE,"手机号格式错误");
        }
        return verificationCodeService.generateAndSendVerificationCode(mobile);
    }

    @PutMapping
    public AjaxResult verify(@RequestParam("mobile") String mobile,
                             @RequestParam("code") String code){
        if(!CheckUtils.checkMobile(mobile)){
            return AjaxResult.error(HttpStatus.UNSUPPORTED_TYPE,"手机号格式错误");
        }
        return verificationCodeService.verify(mobile,code);
    }
}
