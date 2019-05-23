package com.rxjy.modules.air.controller;


import com.rxjy.common.utils.R;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.service.AirPeopleRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员阶段模块
 */
@RestController
@RequestMapping("air/airStage")
public class AirStageController {
    /********************招聘板块start****************************/
    @Autowired
    private AirPeopleRecruitService peopleRecruitService;


    /**
     * 根据经理ID获取基础信息
     * @return
     * airPeopleName: 姓名
     * airPeopleStage: 阶段
     * channel: 0
     * cityCode:
     * cityName: 城市编号
     * companyStrength: 0
     * experience: 1
     * mobile: 手机号
     * operateType:
     * otherChannel:
     * otherSource: 来源
     * peopleStrength: 人员实力
     * provinceCode: 省编号
     * provinceName: 省
     * resourcesStrength: 来源实力
     * sex: 性别 1男 2女
     * source: 0
     * spareMobile: null
     * teamStrength: 团队规模
     * weChat: 微信
     * workYear:工作年限
     * venderType：厂家类型：1.厂家 2.总代
     * localStrength 当地实力
     * businessCapabilityas 经营能力
     * */
    @RequestMapping("/getPeopleBasisInfo")
    public R getPeopleBasisInfo(Integer userID){
        return peopleRecruitService.getPeopleBasisInfo(userID);
    }

    /**
     * 修改用户基础信息
     * @param peopleEntity
     * @return
     */
    @RequestMapping("/updatePeopleBasisInfo")
    public R updatePeopleBasisInfo(AirPeopleEntity peopleEntity){
        return peopleRecruitService.updatePeopleBasisInfo(peopleEntity);
    }


    /**
     * 修改用户地区信息
     * @param peopleEntity
     * @return
     */
    @RequestMapping("/updateUserRegion")
    public R updateUserRegion(AirPeopleEntity peopleEntity){
        return peopleRecruitService.updateUserRegion(peopleEntity);
    }

    /**
     * 修改用户经验
     * @param peopleEntity
     * @return
     */
    @RequestMapping("/updatePeopleExp")
    public R updatePeopleExp(AirPeopleEntity peopleEntity){
        return peopleRecruitService.updatePeopleExp(peopleEntity);
    }

    /**
     * 修改用户实力
     * @param peopleEntity
     * @return
     */
    @RequestMapping("/updatePeopleStrength")
    public R updatePeopleStrength(AirPeopleEntity peopleEntity){
        return peopleRecruitService.updatePeopleStrength(peopleEntity);
    }

    /**
     * 修改用户来源
     * @return
     */
    @RequestMapping("/updatePeopleSource")
    public R updatePeopleSource(AirPeopleEntity peopleEntity){
        return peopleRecruitService.updatePeopleSource(peopleEntity);
    }

    /**
     * 获取用户详情信息
     * @param userID
     * @return
     */
    @RequestMapping("/getPeopleDetail")
    public R getPeopleDetail(Integer userID){
        return null;
    }




}
