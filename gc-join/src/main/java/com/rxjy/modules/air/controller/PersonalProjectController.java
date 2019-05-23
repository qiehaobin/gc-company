package com.rxjy.modules.air.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.JsonMapper;
import com.rxjy.common.utils.R;
import com.rxjy.modules.air.dao.ProjectCustomerDao;
import com.rxjy.modules.air.entity.AirPeopleShopEntity;
import com.rxjy.modules.air.entity.AirShopListDTO;
import com.rxjy.modules.air.entity.Project.ProjectCustomerEntity;
import com.rxjy.modules.air.entity.Project.ProjectInformationEntity;
import com.rxjy.modules.air.entity.Project.ProjectShellEntity;
import com.rxjy.modules.air.service.AirPeopleShopService;
import com.rxjy.modules.air.service.ProjectCustomerService;
import com.rxjy.modules.air.service.ProjectInformationService;
import com.rxjy.modules.air.service.ProjectShellService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * describe
 *
 * @author
 * @date 2019-3-29
 */
@RestController
@RequestMapping(value = "air/personalProject")
public class PersonalProjectController {

    @Autowired
    private AirPeopleShopService airPeopleShopService;
    @Autowired
    private ProjectInformationService projectInformationService;

    @Autowired
    private ProjectCustomerService projectCustomerService;
    @Autowired
    private ProjectShellService projectShellService;

    /**
     *
     * @param ProjectJosn
     * @return
     */

    @RequestMapping(value = "/synchroProjectMsg",method = RequestMethod.POST)
    @Transactional
    public R synchroProjectMsg(@RequestBody String ProjectJosn)
    {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        try{
            HashMap<String,Object> hashMap = (HashMap<String,Object>) JsonMapper.fromJsonString(ProjectJosn, HashMap.class);
            //项目分级条件
            HashMap<String, Object> condition = (HashMap<String, Object>) hashMap.get("condition");
            hashMap.getOrDefault("condition1","0");
            //项目信息
            HashMap<String, Object> project = (HashMap<String, Object>) hashMap.get("project");
            //项目一级阶段信息
            HashMap<String, Object> first = (HashMap<String, Object>) project.get("first");
            //项目二级阶段信息
            HashMap<String, Object> second = (HashMap<String, Object>) project.get("second");
           //项目买单信息表
            List< HashMap<String, Object>> pays = (List< HashMap<String, Object>>) hashMap.get("pays");
            //项目信息表
            ProjectInformationEntity projectInformationEntity=new ProjectInformationEntity();
            String detailScore=(String) condition.getOrDefault("detailScore","0");
            projectInformationEntity.setDetailScore(Integer.valueOf(detailScore));//项目分数
            projectInformationEntity.setLevelName((String)condition.getOrDefault("levelName","A级"));//项目级别
//            projectInformationEntity.setLevelMoney((double)condition.getOrDefault("levelMoney","0.00"));//项目金额
            projectInformationEntity.setLevelMoney(Double.valueOf(condition.getOrDefault("levelMoney","0.00").toString()));//项目金额
            projectInformationEntity.setCreateDate(DateTime.now());
            projectInformationEntity.setUpdateDate(DateTime.now());
            projectInformationEntity.setId((String)project.getOrDefault("id","").toString());//项目单号
            projectInformationEntity.setProjectName((String)project.getOrDefault("projectName",""));//项目名称
            projectInformationEntity.setProjectNumber((String)project.getOrDefault("projectNumber",""));//项目单号
            projectInformationEntity.setRegionId((Integer) project.getOrDefault("regionId",0));//地区
            projectInformationEntity.setProjectStageId((Integer)project.getOrDefault("projectStageId",0));//项目阶段
            projectInformationEntity.setItemAttribute((String)project.getOrDefault("itemAttribute",""));//项目属性
            projectInformationEntity.setProjectType((String)first.getOrDefault("projectType",""));//项目类型
            projectInformationEntity.setNatureOfEnterprise((String) first.getOrDefault("natureOfEnterprise",""));//企业性质
            projectInformationEntity.setAreaage(Double.valueOf(first.getOrDefault("areaage","0.00").toString()));//面积
            projectInformationEntity.setDelay(Integer.valueOf(second.getOrDefault("delay",0).toString()));//延期
            projectInformationEntity.setDurationExtension(Integer.valueOf(second.getOrDefault("durationExtension","0").toString()));//工期
            projectInformationEntity.setDelFlag(Integer.valueOf(second.getOrDefault("delFlag",0).toString()));//是否删除
            //项目客户信息表
            ProjectCustomerEntity projectCustomerEntity=new ProjectCustomerEntity();
            projectCustomerEntity.setCustomerAge((String)project.getOrDefault("initialAge",""));//年龄
            projectCustomerEntity.setCustomerName((String)project.getOrDefault("initialCustomer",""));//姓名
            projectCustomerEntity.setCustomerIdentity((String)project.getOrDefault("initialIdentity",""));//身份
            projectCustomerEntity.setCustomerPhone((String)project.getOrDefault("initialPhone",""));//电话
            projectCustomerEntity.setCustomerSex((String)project.getOrDefault("initialSex",""));//性别
            projectCustomerEntity.setCustomerEmphasize((String)first.getOrDefault("emphasize",""));//注重
            projectCustomerEntity.setHousingType((String)first.getOrDefault("houses",""));//房屋类型
            projectCustomerEntity.setHousingState((String)first.getOrDefault("housing_resources",""));//房屋状态
            projectCustomerEntity.setId((String)project.getOrDefault("id",""));//项目单号
            //项目店壳信息
            if(pays.size()>0)
            {
                for (HashMap<String, Object> pay:pays ) {
                    ProjectShellEntity projectShellEntity=new ProjectShellEntity();

                    projectShellEntity.setCreateDate(DateTime.now());
                    projectShellEntity.setUpdateDate(DateTime.now());
                    projectShellEntity.setPayState(String.valueOf(pay.getOrDefault("payState","1")));
                    projectShellEntity.setDelFlag(String.valueOf(pay.getOrDefault("delFlag","0")));
                    projectShellEntity.setId(Integer.valueOf(pay.getOrDefault("payState",1).toString()));
                    projectShellEntity.setProjectId(String.valueOf(pay.getOrDefault("projectId","")));
                    projectShellEntity.setShopShellId(String.valueOf(pay.getOrDefault("shopShellId","")));
                    // 获取人员编号
                    AirPeopleShopEntity airPeopleShopEntity=new AirPeopleShopEntity();
                    airPeopleShopEntity.setShellId(projectShellEntity.getShopShellId());
                  List<AirPeopleShopEntity> airPeopleShopEntities = airPeopleShopService.getAirPeopleShopByCondition(airPeopleShopEntity);
                  Integer aid=airPeopleShopEntities.size()>0?airPeopleShopEntities.get(0).getAid():0;
                    projectShellEntity.setUserId(aid);
                    projectShellService.insert(projectShellEntity);
                }
            }
            //保存项目信息
            projectInformationService.insert(projectInformationEntity);
            projectCustomerService.insert(projectCustomerEntity);

            responseMap.put("body", true);
            responseMap.put("statusCode", 1);
            responseMap.put("statusMsg", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("statusCode", 0);
            responseMap.put("statusMsg", "失败"); 
        }
        return R.ok();
    }

    /**
     * 根据条件查询当前人员的项目列表
     * @param projectInformationEntity 条件
     * @return
     *  id 主键
     *  projectNumber 项目单号
     *  projectName 项目名称
     *  regionId 地区编号
     *  projectStageId 阶段编号
     *  projectType 项目类型
     *  contractNumber 合同编号
     *  projectAddress 项目地址
     *
     */
    @RequestMapping("/getPersonalProjectByCondition")
    public R getPersonalProjectByCondition(ProjectInformationEntity projectInformationEntity)
    {
        List<ProjectInformationEntity> list=projectInformationService.getPersonalProjectByCondition(projectInformationEntity);
        return R.ok().put("body",list);
    }

    /**
     * 根据条件得到项目信息详情
     * @param projectInformationEntity
     * @return
     *  projectinfo: 项目信息
     *  projectNumber 项目单号
     *  projectName 项目名称
     *  regionId 地区编号
     *  regionName 地区名称
     *  projectStageId 阶段编号
     *  projectType 项目类型
     *  contractNumber 合同编号
     *  projectAddress 项目地址
     *  areaage 面积
     *  levelName 项目级别
     *  levelMoney 项目金额
     *  detailScore 项目分数
     *  payState 是否买单
     *  customer:
     *  customerName 客户名称
     *  customerPhone 客户电话
     *  customerIdentity 客户身份
     *  customerSex 客户性别
     *  customerAge 客户年龄
     *  customerEmphasize 客户注重
     *  housingState 房源状态
     *  housingType 房源类型
     *
     */
    @RequestMapping("/getPersonalProjectDetailByCondition")
    public  R getPersonalProjectDetailByCondition(ProjectInformationEntity projectInformationEntity)
    {
        //得到项目基本信息
        ProjectInformationEntity projectInformation=new ProjectInformationEntity();
        List<ProjectInformationEntity> projectInformationEntities=projectInformationService.getPersonalProjectByCondition(projectInformationEntity);
        if(projectInformationEntities.size()>0)
        {
            projectInformation=projectInformationEntities.get(0);
        }
        //得到项目单号得到项目客户信息
        ProjectCustomerEntity projectCustomerEntity=  projectCustomerService.getProjectCustomerByCondition(projectInformation.getProjectNumber());

        return R.ok().put("projectinfo",projectInformation).put("customer",projectCustomerEntity);
    }

    /**
     * 修改个人端项目买单操作
     * @return
     */
    @RequestMapping("/updatePersonalProjectBuyState")
    public R  updatePersonalProjectBuyState(ProjectShellEntity projectShellEntity)
    {
        //修改个人端项目买单操作
          int Result=projectShellService.updatePersonalProjectBuyState(projectShellEntity);
          if(Result>0)//成功后通知六师
          {
              Map<String, Object> maps = new HashMap<>();
              maps.put("projectId", projectShellEntity.getProjectId());
              maps.put("shopShellId", projectShellEntity.getShopShellId());
              JSONObject mspJson = JSONUtil.parseFromMap(maps);
              //同步数据到六师
              String urlString = Global.getValue("bottomApi") + "/dbsplit/post";
              String tsip = HttpUtil.post(urlString, "type=" + 387 + "&param=" + mspJson);
              JSONObject jsonObject = JSONUtil.parseObj(tsip);
              String statusCode = jsonObject.getStr("statusCode");
              if ("1".equals(statusCode)) {
                  return R.ok();
              } else {
               return R.error();
              }

          }
        return R.ok();
    }
}
