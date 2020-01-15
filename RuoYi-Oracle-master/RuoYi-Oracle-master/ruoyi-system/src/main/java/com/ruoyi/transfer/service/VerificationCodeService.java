package com.ruoyi.project.transfer.service;

import com.ruoyi.framework.web.domain.AjaxResult;

public interface VerificationCodeService {

    public AjaxResult generateAndSendVerificationCode(String mobile);

    public AjaxResult verify(String mobile, String code);
}
