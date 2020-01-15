package com.ruoyi.project.transfer.mapper;

import com.ruoyi.project.transfer.domain.ZjucrmPO;

import java.util.List;

public interface ZjucrmMapper
{
    public List<ZjucrmPO> getBySerialNumber(String cityCode, String serialNumber);
}
