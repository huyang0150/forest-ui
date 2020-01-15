/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.guahao.cloudhis.clinic.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 饮酒状态
 */
public enum DrinkingStatusEnum {

    NOT_DRINK("1", "无"),
    DRINKING("2", "有"),
    QUIT_DRINKING("3", "已戒酒");


    private String code;

    private String name;

    /**
     * 存放所有的code和enum的转换.
     */
    private static final Map<String, DrinkingStatusEnum> DRINKING_STATUS_ENUM_MAP = new ConcurrentHashMap<String, DrinkingStatusEnum>(
        DrinkingStatusEnum.values().length);

    DrinkingStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        /**
         * 将所有的实体类放入到map中,提供查询.
         */
        for (DrinkingStatusEnum cardType : EnumSet.allOf(DrinkingStatusEnum.class)) {
            DRINKING_STATUS_ENUM_MAP.put(cardType.code, cardType);
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    //根据类型获取枚举
    public static DrinkingStatusEnum getByCode(String code) {
        return DRINKING_STATUS_ENUM_MAP.get(code);
    }


}
