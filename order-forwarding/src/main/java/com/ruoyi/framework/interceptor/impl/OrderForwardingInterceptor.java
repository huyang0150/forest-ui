package com.ruoyi.framework.interceptor.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.order.component.OrderForwardingAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class OrderForwardingLoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private OrderForwardingAuthentication orderForwardingAuthentication;

    private static final Logger log = LoggerFactory.getLogger(OrderForwardingLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(orderForwardingAuthentication.authToken(request) == false){
            AjaxResult ajaxResult = AjaxResult.error(HttpStatus.UNAUTHORIZED,"请重新登陆");
            ServletUtils.renderString(response, JSONObject.toJSONString(ajaxResult));
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
