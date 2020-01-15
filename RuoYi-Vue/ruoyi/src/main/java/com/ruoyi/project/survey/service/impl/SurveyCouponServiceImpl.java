package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.SurveyCouponMapper;
import com.ruoyi.project.system.domain.SurveyCoupon;
import com.ruoyi.project.system.service.ISurveyCouponService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SurveyCouponServiceImpl implements ISurveyCouponService 
{
    @Autowired
    private SurveyCouponMapper surveyCouponMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SurveyCoupon selectSurveyCouponById(Long id)
    {
        return surveyCouponMapper.selectSurveyCouponById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param surveyCoupon 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SurveyCoupon> selectSurveyCouponList(SurveyCoupon surveyCoupon)
    {
        return surveyCouponMapper.selectSurveyCouponList(surveyCoupon);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param surveyCoupon 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSurveyCoupon(SurveyCoupon surveyCoupon)
    {
        return surveyCouponMapper.insertSurveyCoupon(surveyCoupon);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param surveyCoupon 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSurveyCoupon(SurveyCoupon surveyCoupon)
    {
        return surveyCouponMapper.updateSurveyCoupon(surveyCoupon);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSurveyCouponByIds(Long[] ids)
    {
        return surveyCouponMapper.deleteSurveyCouponByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSurveyCouponById(Long id)
    {
        return surveyCouponMapper.deleteSurveyCouponById(id);
    }
}
