/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.ruoyi.common.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 0000:成功
 * 5000 ：参数缺失，订单号必传
 * 5002 ：无法查到该订单的省份地市信息
 * 5004 ：订单不在调度池内,不允许退单
 * 5007 ：已经分配的订单，请先重回调度再退单
 * 5008 ：订单编号和订单类型不匹配
 */
public enum ChargeBackResCodeEnum {
    SUCCESS("0000", "成功"),
    ORDER_NO_NEED("5000", "参数缺失，订单号必传"),
    ADDRESS_NOT_FOUND("5002", "无法查到该订单的省份地市信息"),
    ORDER_NOT_FOUND("5004", "订单不在调度池内,不允许退单"),
    ORDER_DISTRIBUTED("5007", "已经分配的订单，请先重回调度再退单"),
    ORDER_NO_TYPE_MISMATCH("5008", "订单编号和订单类型不匹配");


    private String code;

    private String name;

    /**
     * 存放所有的code和enum的转换.
     */
    private static final Map<String, ChargeBackResCodeEnum> CHARGE_BACK_RES_CODE_ENUM_MAP = new ConcurrentHashMap<String, ChargeBackResCodeEnum>(
            ChargeBackResCodeEnum.values().length);

    ChargeBackResCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        /**
         * 将所有的实体类放入到map中,提供查询.
         */
        for (ChargeBackResCodeEnum cardType : EnumSet.allOf(ChargeBackResCodeEnum.class)) {
            CHARGE_BACK_RES_CODE_ENUM_MAP.put(cardType.code, cardType);
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //根据类型获取枚举
    public static ChargeBackResCodeEnum getByCode(Integer code) {
        return CHARGE_BACK_RES_CODE_ENUM_MAP.get(code);
    }


}
