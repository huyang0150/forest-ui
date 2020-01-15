package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.SurveyCoupon;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public interface ISurveyCouponService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SurveyCoupon selectSurveyCouponById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param surveyCoupon 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SurveyCoupon> selectSurveyCouponList(SurveyCoupon surveyCoupon);

    /**
     * 新增【请填写功能名称】
     * 
     * @param surveyCoupon 【请填写功能名称】
     * @return 结果
     */
    public int insertSurveyCoupon(SurveyCoupon surveyCoupon);

    /**
     * 修改【请填写功能名称】
     * 
     * @param surveyCoupon 【请填写功能名称】
     * @return 结果
     */
    public int updateSurveyCoupon(SurveyCoupon surveyCoupon);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyCouponByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSurveyCouponById(Long id);
}
