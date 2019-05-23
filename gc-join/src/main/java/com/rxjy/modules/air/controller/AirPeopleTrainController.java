package com.rxjy.modules.air.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.R;
import com.rxjy.modules.air.entity.*;
import com.rxjy.modules.air.entity.PublicEntity.PublicChildModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicEmergencyUserEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicTeamEntity;
import com.rxjy.modules.air.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe  空调人员培训阶段信息控制器
 *
 * @author yangbin
 * @date 2019-3-21
 */
@RequestMapping("air/airPeopleTrain")
@RestController
public class AirPeopleTrainController {

    @Autowired
    private AirPeopleTrainService airPeopleTrainService;
    @Autowired
    private PublicChildModuleService publicChildModuleService;
    @Autowired
    private PublicTeamService publicTeamService;
    @Autowired
    private PublicEmergencyUserService publicEmergencyUserService;
    @Autowired
    private AirPeopleRecruitService airPeopleRecruitService;

    @Autowired
    private AirPeopleShopService airPeopleShopService;


    /**
     * 根据条件查询空调人员培训阶段一段列表信息
     *
     * @param airPeopleEntity 条件
     * @return 空调人员培训阶段一段列表信息
     * 人员编号  aid,
     * 人员名称  airPeopleName,
     * 地区名称  cityName,
     * 人员阶段  airPeopleStage,
     * 空调名称  airName,
     * 地区编号  cityid,
     * 空调编号  shop_id
     * App状态 appState
     * PC状态 pcState
     * 业务状态 businessState
     */

    @RequestMapping("/getAirPeopleTrainList")
    public R getAirPeopleTrainList(AirPeopleEntity airPeopleEntity) {
        List<AirPeopleEntity> airPeopleEntities = airPeopleTrainService.getAirPeopleTrainList(airPeopleEntity);
        return R.ok().put("body", airPeopleEntities);
    }

    /**
     * 根据条件得到模块信息
     *
     * @param publicChildModuleEntity
     * @return 主键 id
     * 子模块名称 childModuleName
     * 子模块编号 moduleId
     * 板块类型 plateType
     * 模块类型 moduleType
     * 模块名称 moduleName
     * 结果 result
     */
    @RequestMapping("/getAirPeopleChildModule")
    public R getAirPeopleChildModule(PublicChildModuleEntity publicChildModuleEntity) {
        List<PublicChildModuleEntity> publicChildModuleEntities = publicChildModuleService.getAirPeopleModuleStateByCondition(publicChildModuleEntity);
        return R.ok().put("body", publicChildModuleEntities);
    }

    /**
     * 修改模块状态
     *
     * @param airShopListDTO 模块集合
     * @return
     */
    @RequestMapping("/updateAirPeopleModuleMsg")
    public R updateAirPeopleModuleMsg(@RequestBody AirShopListDTO airShopListDTO) {
        List<PublicChildModuleEntity> childModuleEntities = airShopListDTO.getPublicChildModuleEntities();
        if (childModuleEntities.size() > 0) {
            for (PublicChildModuleEntity a : childModuleEntities) {
                a.setUpdateDate(DateTime.now());
                publicChildModuleService.updateById(a);
            }
        }
        return R.ok();

    }

    /**
     * 根据条件查询空调人员团队信息
     *
     * @param publicTeamEntity 条件
     * @return id 主键
     * teamType 团队人员类型：1、店长 2、业务
     * teamName 团队人员名称
     * teamImg  团队人员照片
     * userType 人员类型：1、空调人员团队
     * aid 人员类型
     */
    @RequestMapping("/getAirPeopleTeamMsgByCondition")
    public R getAirPeopleTeamMsgByCondition(PublicTeamEntity publicTeamEntity) {
        List<PublicTeamEntity> publicTeamEntities = publicTeamService.getAirPeopleTeamMsgByCondition(publicTeamEntity);
        return R.ok().put("body", publicTeamEntities);
    }

    /**
     * 添加或者修改团队信息
     *
     * @param airShopListDTO 团队信息
     * @return
     */
    @RequestMapping("operationPublicTeam")
    public R operationPublicTeam(@RequestBody AirShopListDTO airShopListDTO) {
        List<PublicTeamEntity> publicTeamEntities = airShopListDTO.getPublicTeamEntities();
        if (publicTeamEntities.size() > 0) {
            for (PublicTeamEntity p : publicTeamEntities) {
                if (p.getId() > 0) {
                    p.setUpdateDate(DateTime.now());
                    publicTeamService.updateById(p);
                } else {
                    p.setCreateDate(DateTime.now());
                    p.setUpdateDate(DateTime.now());
                    p.setDelFlag(0);
                    publicTeamService.insert(p);
                }
            }
        }
        return R.ok();
    }

    /**
     * 根据条件查询紧急联系人信息
     *
     * @param publicEmergencyUserEntity 条件
     * @return id 主键
     * userName 紧急联系人姓名
     * mobile 紧急联系人电话
     * address  住址
     * aid 主键
     */
    @RequestMapping("/getPublicEmergencyUserByCondition")
    public R getPublicEmergencyUserByCondition(PublicEmergencyUserEntity publicEmergencyUserEntity) {
        List<PublicEmergencyUserEntity> publicEmergencyUserEntities = publicEmergencyUserService.getPublicEmergencyUserByCondition(publicEmergencyUserEntity);

        AirPeopleInfoEntity airPeopleInfoEntity = new AirPeopleInfoEntity();
        airPeopleInfoEntity.setAid(publicEmergencyUserEntity.getAid());
        airPeopleInfoEntity.setUpdateAttrModelId("4,5,6");
        List<AirPeopleInfoEntity> airPeopleInfoEntities = airPeopleRecruitService.getAirPeopleInfoByCondition(airPeopleInfoEntity);
        return R.ok().put("body", publicEmergencyUserEntities).put("info", airPeopleInfoEntities);
    }

    /**
     * 添加或者修改紧急联系人信息
     *
     * @param publicEmergencyUserEntity 紧急联系人信息
     * @return
     */
    @RequestMapping("/operationPublicEmergencyUser")
    public R operationPublicEmergencyUser(@RequestBody PublicEmergencyUserEntity publicEmergencyUserEntity) {
        if (publicEmergencyUserEntity.getId() > 0) {
            publicEmergencyUserEntity.setUpdateDate(DateTime.now());
            publicEmergencyUserEntity.setDelFlag(0);
            publicEmergencyUserService.updateById(publicEmergencyUserEntity);
        } else {
            publicEmergencyUserEntity.setCreateDate(DateTime.now());
            publicEmergencyUserEntity.setUpdateDate(DateTime.now());
            publicEmergencyUserEntity.setDelFlag(0);
            publicEmergencyUserService.insert(publicEmergencyUserEntity);

        }
        List<AirPeopleInfoEntity> airPeopleInfoEntities = publicEmergencyUserEntity.getPeopleInfoEntityList();
        if (airPeopleInfoEntities.size() > 0) {
            //删除之前的图片资料信息
            AirPeopleInfoEntity airPeopleInfoEntity = new AirPeopleInfoEntity();
            airPeopleInfoEntity.setAid(publicEmergencyUserEntity.getAid());
            airPeopleInfoEntity.setDelFlag(1);
            airPeopleInfoEntity.setUpdateAttrModelId("4,5,6");
            airPeopleRecruitService.updateAirPeopleInfoByCondition(airPeopleInfoEntity);
            airPeopleRecruitService.insertAirPeopleInfo(airPeopleInfoEntities);
        }
        return R.ok();
    }

    /**
     * 修改空调人员登录状态
     *
     * @param airPeopleEntity 人员信息
     * @return
     */
    @RequestMapping("/updateAirPeopleLoginState")
    public R updateAirPeopleLoginState(AirPeopleEntity airPeopleEntity) {
        airPeopleTrainService.updateAirPeopleLoginState(airPeopleEntity);
        return R.ok();
    }

    /**
     * 根据条件得到空调培训店铺信息
     *
     * @param airPeopleShopEntity
     * @return
     * provinceId 省编号
     * provinceName 省名称
     * cityId 市编号
     * cityName 市名称
     * areaName 区名称
     * street 街道
     *address 地址
     */
    @RequestMapping("/getAirPeopleTrainShopMsg")
    public R getAirPeopleTrainShopMsg(AirPeopleShopEntity airPeopleShopEntity) {
        AirPeopleShopEntity airPeopleShop = airPeopleShopService.getAirUserShopRecruitMsg(airPeopleShopEntity);
        AirPeopleInfoEntity airPeopleInfoEntity = new AirPeopleInfoEntity();
        airPeopleInfoEntity.setAid(airPeopleShopEntity.getAid());
        airPeopleInfoEntity.setUpdateAttrModelId(("7,8,9,10,11,12,13"));
        List<AirPeopleInfoEntity> airPeopleInfoEntities = airPeopleRecruitService.getAirPeopleInfoByCondition(airPeopleInfoEntity);
        return R.ok().put("body", airPeopleShop).put("info",airPeopleInfoEntities);
    }

    /**
     * 根据条件更新空调人员培训店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    @RequestMapping("/operationAirPeopleTrainShopMsg")
    public R operationAirPeopleTrainShopMsg(@RequestBody  AirPeopleShopEntity airPeopleShopEntity)
    {

        airPeopleShopService.operationAirPeopleTrainShopMsg(airPeopleShopEntity);

        List<AirPeopleInfoEntity> airPeopleInfoEntities = airPeopleShopEntity.getAirPeopleInfoEntityList();
        if (airPeopleInfoEntities.size() > 0) {
            //删除之前的图片资料信息
            AirPeopleInfoEntity airPeopleInfoEntity = new AirPeopleInfoEntity();
            airPeopleInfoEntity.setAid(airPeopleShopEntity.getAid());
            airPeopleInfoEntity.setDelFlag(1);
            airPeopleInfoEntity.setUpdateAttrModelId("7,8,9,10,11,12,13");
            airPeopleRecruitService.updateAirPeopleInfoByCondition(airPeopleInfoEntity);
            airPeopleRecruitService.insertAirPeopleInfo(airPeopleInfoEntities);
        }
        return R.ok();
    }

    /**
     * 添加培训阶段人员的加盟费或风险金
     * @param airPeopleEntity  人员的加盟费或风险金信息
     * @return
     */
    @RequestMapping("/operationAirPeopleMoney")
    public  R operationAirPeopleMoney(@RequestBody AirPeopleEntity airPeopleEntity)
    {
        try
        {


        AirPeopleShopEntity airPeople=new AirPeopleShopEntity();
        airPeople.setAid(airPeopleEntity.getAid());
        AirPeopleShopEntity recruitMsg = airPeopleShopService.getAirUserShopRecruitMsg(airPeople);

        int paymentType=0;//科目1.店铺加盟费 2.店铺充值 3.店铺买单 4 风险押金缴纳 5 风险押金扣除
        String remarks="";//备注
        if(airPeopleEntity.getMoneyType()==1)
        {
            paymentType=1;
            remarks="空调-"+recruitMsg.getShellId()+"-加盟费-收入："+airPeopleEntity.getRiskDeposit()+"元，操作人 ："+airPeopleEntity.getCreateNo()+"-"+airPeopleEntity.getCreateUser();
        }
        else {
            paymentType=4;
            remarks="空调-"+recruitMsg.getShellId()+"-风险金-收入："+airPeopleEntity.getRiskDeposit()+"元，操作人 ："+airPeopleEntity.getCreateNo()+"-"+airPeopleEntity.getCreateUser();
        }
        //同步加盟费到六师
        Map<String, Object> maps = new HashMap<>();
        maps.put("money",airPeopleEntity.getRiskDeposit());
        maps.put("payment",1);
        maps.put("paymentType", paymentType);
        maps.put("processingResult", 1);
        maps.put("shopShellId",recruitMsg.getShellId());
        maps.put("projectId","-");
        maps.put("operationCardNum",airPeopleEntity.getCreateNo());
        maps.put("operationName",airPeopleEntity.getCreateUser());
        maps.put("remarks",remarks);
        maps.put("certificate",airPeopleEntity.getVoucher());
        JSONObject mspJson = JSONUtil.parseFromMap(maps);
        String urlString = Global.getValue("sixdivisionApi") + "/api/iuShopFinance";
        String tsip = HttpUtil.post(urlString,mspJson);
        JSONObject jsonObject = JSONUtil.parseObj(tsip);
        String statusCode = jsonObject.getStr("body");
        if(airPeopleEntity.getMoneyType()==2){
            JSONObject bodyObject= JSONUtil.parseObj(jsonObject.getStr("body"));
            airPeopleEntity.setVoucher(bodyObject.getStr("certificate"));
        }
            airPeopleEntity.setCreateDate( airPeopleEntity.getCreateDate());
        airPeopleTrainService.operationAirPeopleMoney(airPeopleEntity);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return R.ok();
    }

    /**
     * 根据aid查询所有的缴费记录
     * @param aid  项目经理编号
     * @return
     */
    @RequestMapping("getAirPeopleMoneyByAId")
    public  R getAirPeopleMoneyByAId(int aid)
    {
      List<UserinfoJoinc> userinfoJoincs=  airPeopleTrainService.getAirPeopleMoneyByAId(aid);
        return R.ok().put("body",userinfoJoincs);
    }
}
