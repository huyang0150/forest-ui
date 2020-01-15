package com.ruoyi.project.survey.service.impl;

import com.ruoyi.project.survey.domain.SurveyDetail;
import com.ruoyi.project.survey.domain.SurveyUser;
import com.ruoyi.project.survey.domain.SurveyVO;
import com.ruoyi.project.survey.service.ISurveyDetailService;
import com.ruoyi.project.survey.service.ISurveyService;
import com.ruoyi.project.survey.service.ISurveyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 
 * @author ruoyi
 * @date 2019-12-11
 */
@Service
public class SurveyServiceImpl implements ISurveyService
{
    private static final Logger log = LoggerFactory.getLogger(SurveyServiceImpl.class);

    @Autowired
    private ISurveyUserService surveyUserService;

    @Autowired
    private ISurveyDetailService surveyDetailService;

    @Override
    public int survey(SurveyVO surveyVO){
        //校验
        SurveyUser existSurveyUserFirstly = surveyUserService.selectSurveyUserByMobile(surveyVO.getMobile());
        if(existSurveyUserFirstly == null){
            SurveyUser surveyUser = new SurveyUser();
            surveyUser.setMobile(surveyVO.getMobile());
            surveyUser.setIsSend(false);
            surveyUser.setIsDeleted(false);
            surveyUserService.insertSurveyUser(surveyUser);
        }
        SurveyUser existSurveyUserSecondly = surveyUserService.selectSurveyUserByMobile(surveyVO.getMobile());
        SurveyDetail existSurveyDetail = surveyDetailService.selectSurveyDetailByUserId(existSurveyUserSecondly.getId());
        if(existSurveyDetail == null){
            SurveyDetail surveyDetail = new SurveyDetail();
            surveyDetail.setSatisfication(surveyVO.getSatisfication());
            surveyDetail.setConsideration(surveyVO.getConsideration());
            surveyDetail.setTransfer(surveyVO.getTransfer());
            surveyDetail.setContext(surveyVO.getContext());
            surveyDetail.setSurveyUserId(existSurveyUserSecondly.getId());
            surveyDetail.setStatus(1);
            surveyDetail.setIsDeleted(false);
            surveyDetailService.insertSurveyDetail(surveyDetail);
        }else{
            existSurveyDetail.setConsideration(surveyVO.getConsideration());
            existSurveyDetail.setSatisfication(surveyVO.getSatisfication());
            existSurveyDetail.setTransfer(surveyVO.getTransfer());
            surveyDetailService.updateSurveyDetail(existSurveyDetail);
        }

        return 1;
    }
}
