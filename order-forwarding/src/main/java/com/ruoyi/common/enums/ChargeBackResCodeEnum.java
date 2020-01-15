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
 * 满意度枚举
 * 0待分配，1已分配，2配送中，3携转成功、4已完成、5回退, 6新开户
 */
public enum TransferStatusEnum {
    TO_BE_ALLOCATE(0, "待分配"),
    ALLOCATED(1, "已分配"),
    DELIVERY(2, "配送中"),
    TRANSFER_SUCCESS(3, "携转成功"),
    FINISH(4, "已完成"),
    ROLLBACK(5, "回退"),
    OPEN_ACCOUNT(6, "新开户");


    private Integer code;

    private String name;

    /**
     * 存放所有的code和enum的转换.
     */
    private static final Map<Integer, TransferStatusEnum> SATISFACTION_ENUM_MAP = new ConcurrentHashMap<Integer, TransferStatusEnum>(
            TransferStatusEnum.values().length);

    TransferStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        /**
         * 将所有的实体类放入到map中,提供查询.
         */
        for (TransferStatusEnum cardType : EnumSet.allOf(TransferStatusEnum.class)) {
            SATISFACTION_ENUM_MAP.put(cardType.code, cardType);
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //根据类型获取枚举
    public static TransferStatusEnum getByCode(Integer code) {
        return SATISFACTION_ENUM_MAP.get(code);
    }


}
