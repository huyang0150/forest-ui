package com.ruoyi.project.transfer.service;

import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 与快联通交互的接口
 */
public interface FastLTService {
    /**
     * 申请创建携转订单
     * @return
     */
    public AjaxResult apply();

    /**
     * 配送专员点击“携转完成”之后通知快联通
     * @return
     */
    public AjaxResult orderFinish();

    /**
     * 配送专员点击“携转回退”之后通知快联通，将回退原因携带出去
     *
     * @return
     */
    public AjaxResult orderRollback();

    /**
     * 如果用户选择“新开户”，调用快联通接口，并携带新号码出去
     *
     * @return
     */
    public AjaxResult openAccount();

    /**
     * 新开户回退，携带回退原因出去
     */
    public AjaxResult openAccountRollback();
}
