package com.ruoyi.project.transfer.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataSource;
import com.ruoyi.framework.aspectj.lang.enums.DataSourceType;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.transfer.domain.ZjucrmPO;
import com.ruoyi.project.transfer.mapper.ZjucrmMapper;
import com.ruoyi.project.transfer.service.MobileValidService;
import org.aspectj.weaver.loadtime.Aj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileValidServiceImpl implements MobileValidService {
    private static final Logger log = LoggerFactory.getLogger(MobileValidServiceImpl.class);

    @Autowired
    private ZjucrmMapper zjucrmMapper;

    private static String CITY_CODE = "571";

    @Override
    @DataSource(value = DataSourceType.ORACLE_MASTER)
    public AjaxResult isTransferdSucceed(String mobile) {
        List<ZjucrmPO> list = zjucrmMapper.getBySerialNumber(CITY_CODE,mobile);

        return AjaxResult.success(list);
    }

    @Override
    @DataSource(value = DataSourceType.ORACLE_MASTER)
    public Boolean isOnline(String mobile) {
        return null;
    }
}
