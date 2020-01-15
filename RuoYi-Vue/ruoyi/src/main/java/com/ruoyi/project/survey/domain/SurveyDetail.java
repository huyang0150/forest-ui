package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 survey_detail
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
public class SurveyDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long surveyUserId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer satisfication;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer transfer;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer consideration;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String context;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSurveyUserId(Long surveyUserId) 
    {
        this.surveyUserId = surveyUserId;
    }

    public Long getSurveyUserId() 
    {
        return surveyUserId;
    }
    public void setSatisfication(Integer satisfication) 
    {
        this.satisfication = satisfication;
    }

    public Integer getSatisfication() 
    {
        return satisfication;
    }
    public void setTransfer(Integer transfer) 
    {
        this.transfer = transfer;
    }

    public Integer getTransfer() 
    {
        return transfer;
    }
    public void setConsideration(Integer consideration) 
    {
        this.consideration = consideration;
    }

    public Integer getConsideration() 
    {
        return consideration;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setContext(String context) 
    {
        this.context = context;
    }

    public String getContext() 
    {
        return context;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("surveyUserId", getSurveyUserId())
            .append("satisfication", getSatisfication())
            .append("transfer", getTransfer())
            .append("consideration", getConsideration())
            .append("status", getStatus())
            .append("context", getContext())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
