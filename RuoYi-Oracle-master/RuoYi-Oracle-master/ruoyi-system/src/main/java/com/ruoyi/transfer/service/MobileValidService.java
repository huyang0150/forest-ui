package com.ruoyi.project.transfer.service;

import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 用户携转之后，根据手机号判断携转状态和在网状态
 */
public interface MobileValidService {

    public AjaxResult isTransferdSucceed(String mobile);

    public Boolean isOnline(String mobile);
}
