package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 survey_coupon
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyCoupon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String coupon;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isUsed;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCoupon(String coupon) 
    {
        this.coupon = coupon;
    }

    public String getCoupon() 
    {
        return coupon;
    }
    public void setIsUsed(Integer isUsed) 
    {
        this.isUsed = isUsed;
    }

    public Integer getIsUsed() 
    {
        return isUsed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coupon", getCoupon())
            .append("isUsed", getIsUsed())
            .toString();
    }
}
