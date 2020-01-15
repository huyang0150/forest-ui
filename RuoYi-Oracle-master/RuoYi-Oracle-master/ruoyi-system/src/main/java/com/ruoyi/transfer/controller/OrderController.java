package com.ruoyi.project.transfer.controller;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.transfer.service.MobileValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MobileValidService mobileValidService;
    /**
     * 获取配送专员订单列表
     * 需要确定分页，全量查还是只查时间最找未处理的几条订单
     * 可能需要根据状态查询订单
     * @return
     */
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("mobile") String mobile,
                           @RequestParam(value = "status",required = false) Integer status){

        return null;
    }

    /**
     * 获取某个订单的详情
     * @param orderId
     * @return
     */
    @GetMapping("/get")
    public AjaxResult get(@RequestParam("orderId") Long orderId){

        return null;
    }

    /**
     * 配送专员在机器上帮用户携转成功之后，
     * 在系统前端点击“完成”，
     * 后端做三件事：
     * 1.确认是否协转成功，去数据分析部门的服务（最好问领导应该找谁确认找谁）查看协转结果
     * 2.如果携转成功，则调用快联通接口通知协转成功，
     * 3.返回协转结果给前端，前端展示给配送专员
     *
     * @param orderId
     * @return
     */
    @PutMapping("/submit")
    public AjaxResult submit(@RequestParam("orderId") Long orderId ){

        return null;
    }

    /**
     * 配送专员上门协转，但是用户又不愿意协转之后，
     * 在系统前端点击“回退”
     * 通过调用快联通接口将订单信息和回退原因传递给快联通
     * 并返回处理是否成功的标志给前端
     * @return
     */
    @PutMapping("/rollback")
    public AjaxResult rollBack(){

        return null;
    }

    /**
     * 扫码后填写相关信息，并将申请携号转网
     * 注意设置不能重复申请，我们这边不会对申请序列化
     * 应该是快联通那边进行校验
     *
     * 我们这边可以用redis做一个基本的校验
     * @return
     */
    @PostMapping("/apply")
    public AjaxResult apply() {

        return null;
    }

    @GetMapping("/test")
    public AjaxResult test(@RequestParam("mobile") String mobile){
        return mobileValidService.isTransferdSucceed(mobile);
    }

}
