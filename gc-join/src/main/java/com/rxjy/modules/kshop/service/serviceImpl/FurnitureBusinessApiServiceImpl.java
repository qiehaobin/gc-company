package com.rxjy.modules.kshop.service.serviceImpl;

import com.rxjy.modules.kshop.common.Constant;
import com.rxjy.modules.kshop.common.ProjectMessage;
import com.rxjy.modules.kshop.service.FurnitureBusinessApiService;
import com.rxjy.modules.kshop.common.DateFormat;
import com.rxjy.modules.kshop.dao.FurnitureBusinessApiDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 岳耀栎
 * @创建时间 2019/02/13
 * @功能描述 家具加盟商系统业务逻辑实现类
 */
@Service("furnitureBusinessApiService")
public class FurnitureBusinessApiServiceImpl implements FurnitureBusinessApiService {

    @Resource
    private FurnitureBusinessApiDao furnitureBusinessApiMapper;

    /**
     * @return 家具加盟商项目列表
     * @创建人 岳耀栎
     * @创建时间 2019/02/13
     * @功能描述 家具加盟商：获取家具加盟商项目列表
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     */
    @Override
    public List<Map<String, Object>> listBusinessProjects(Map<String, Object> params) {
        List<Map<String, Object>> listProject = new ArrayList<>();
        listProject = furnitureBusinessApiMapper.listBusinessProjects(params);
        if(listProject.size() > 0){
            for(int i = 0; i<listProject.size();i++){
                params.put("rwdid",listProject.get(i).get("pi_Rwdid").toString());
                Map<String,Object> resultMap = furnitureBusinessApiMapper.getProjectStatusMessage(params);
                listProject.get(i).put("projectInfoMessage",resultMap);
            }
        }
        return listProject;
    }

    /**
     * @return 加盟商项目阶段信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号获取家具加盟商项目阶段信息
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     * @params rwdid 项目单号
     */
    @Override
    public Map<String, Object> getBusinessProjectByRwdidAndOrgId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getBusinessProjectByRwdidAndOrgId(params);
    }

    /**
     * @return 加盟商项目阶段信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号更新家具加盟商项目阶段信息
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     * @params rwdid 项目单号
     * @params type 2：接单
     * 3：方案
     * 4：预算
     * 5：合同
     * 6：已签
     * 99：未签
     */
    @Override
    public int updateBusinessProjectByRwdidAndOrgId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.updateBusinessProjectByRwdidAndOrgId(params);
    }

    /**
     * @return 家具加盟商项目洽谈概况信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目洽谈概况信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    @Override
    public List<Map<String, Object>> getBusinessProjectNegotiationSurveyByRwdidAndOrgId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getBusinessProjectNegotiationSurveyByRwdidAndOrgId(params);
    }

    /**
     * @return 家具加盟商项目上传方案信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目上传方案信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    @Override
    public List<Map<String, Object>> getBusinessProjectProgarmByRwdidAndOrgId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getBusinessProjectProgarmByRwdidAndOrgId(params);
    }

    /**
     * @return 家具加盟商项目上传合同信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目上传合同信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    @Override
    public List<Map<String, Object>> getBusinessProjectContractByRwdidAndOrgId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getBusinessProjectContractByRwdidAndOrgId(params);
    }

    /**
     * @param rwdid 项目单号
     * @return 查询项目在工程部的资料信息
     * @创建人 岳耀栎
     * @创建时间 2019/01/08
     * @功能描述 查询项目在工程部的资料信息
     */
    @Override
    public Map<String, Object> getConstructionMessageByRwdid(String rwdid) {
        return furnitureBusinessApiMapper.getConstructionMessageByRwdid(rwdid);
    }

    /**
     * @return 设计师列表
     * @创建人 岳耀栎
     * @创建时间 2019/03/27
     * @功能描述 家具加盟商：根据公司Id获取设计师列表
     * @params orgId 加盟商公司id
     */
    @Override
    public List<Map<String, Object>> listDesignerByOrgId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.listDesignerByOrgId(params);
    }

    /**
     * @return 根据项目单号及设计师卡号对设计师分单
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：根据项目单号及设计师卡号对设计师分单
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     * @params rwdid 项目单号
     * @params stage 3：方案
     * @接口说明 根据项目单号及设计师卡号对设计师分单
     */
    @Override
    @Transactional
    public int dispatchToDesigner(Map<String, Object> params) {
        return furnitureBusinessApiMapper.dispatchToDesigner(params);
    }

    /**
     * @param params rwdid 项目单号
     *               orgId 加盟商id
     * @return 返回分派的设计师信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：检查当前订单是否已经分派给其他设计师
     */
    @Override
    public Map<String, Object> checkOrderIsDesignerByRwdid(Map<String, Object> params) {
        return furnitureBusinessApiMapper.checkOrderIsDesignerByRwdid(params);
    }

    /**
     * @return 根据项目单号及加盟商id更新项目阶段信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：根据项目单号及加盟商id更新项目阶段信息
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     * @params rwdid 项目单号
     * @params stage 3：方案
     * @接口说明 根据项目单号及加盟商id更新项目阶段信息
     */
    @Override
    public int updateOrderByOrgIdAndRwdid(Map<String, Object> params) {
        return furnitureBusinessApiMapper.updateOrderByOrgIdAndRwdid(params);
    }

    /**
     * @return 根据appId查询加盟商招过程中人事资料信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/29
     * @功能描述 家具加盟商：根据appId查询加盟商招过程中人事资料信息
     * @params appId 加盟商公司id
     * @接口说明 根据appId查询加盟商招过程中人事资料信息
     */
    @Override
    public Map<String, Object> getJoinBusinessMessageByAppId(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getJoinBusinessMessageByAppId(params);
    }

    /**
     * @return 根据shopId更新方案信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：根据shopId更新方案信息
     * @params shopId 加盟商公司id
     * @params programImg 方案地址
     * @接口说明 根据shopId更新方案信息
     */
    @Override
    @Transactional
    public int updateShopProgramByShopId(Map<String, Object> params) {

        // 定义返回值
        int resultCount = -1;
        // 根据项目单号及公司id查询项目方案信息
        List<Map<String,Object>> resultList = furnitureBusinessApiMapper.listShopProgramByShopId(params);
        // 判断方案信息是否存在，存在即更新，不存则新增
        if(resultList.size() > 0){
            resultCount = furnitureBusinessApiMapper.updateShopProgramByShopId(params);
        } else {
            resultCount = furnitureBusinessApiMapper.addShopProgramByShopId(params);
        }
        // 修改订单状态时间
        Map<String,Object> paramsForProjectStage = new HashMap<>();
        paramsForProjectStage.put("rwdid",params.get("rwdid").toString());
        paramsForProjectStage.put("shopShellId",params.get("shopShellId").toString());
        paramsForProjectStage.put("stage",ProjectMessage.PROJECT_STAGE_PROGRAMME);
        furnitureBusinessApiMapper.updateProjectDateByRwdid(paramsForProjectStage);
        return resultCount;
    }

    /**
     * @return 根据项目单号及公司id查询加盟商上传方案信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/29
     * @功能描述 家具加盟商：根据项目单号及公司id查询加盟商上传方案信息
     * @params appId 加盟商公司id
     * @接口说明 根据项目单号及公司id查询加盟商上传方案信息
     */
    @Override
    public List<Map<String, Object>> listShopProgramByShopId(Map<String, Object> params) {


        return furnitureBusinessApiMapper.listShopProgramByShopId(params);
    }

    /**
     * @return 六师同步项目信息接口
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：六师同步项目信息接口
     * @params shopId 加盟商公司id
     * @params programImg 方案地址
     * @接口说明 六师同步项目信息接口
     */
    @Override
    @Transactional
    public int synchronousProjectInformation(Map<String, Object> params) {

        // 同步项目相关信息
        Map<String,Object> paramsRelated = (Map<String, Object>) ((Map<String, Object>) params.get("project")).get("related");
        furnitureBusinessApiMapper.synchronousProjectRelated(paramsRelated);
        // 同步项目分级信息
        Map<String,Object> paramsConditionJJ = (Map<String, Object>) params.get("condition");
        furnitureBusinessApiMapper.synchronousProjectConditionJJ(paramsConditionJJ);
        // 同步项目属性一
        Map<String,Object> paramsFirst = (Map<String, Object>) ((Map<String, Object>) params.get("project")).get("first");
        furnitureBusinessApiMapper.synchronousProjectFirst(paramsFirst);
        // 同步项目属性二
        Map<String,Object> paramsSecond = (Map<String, Object>) ((Map<String, Object>) params.get("project")).get("second");
        furnitureBusinessApiMapper.synchronousProjectSecond(paramsSecond);

        Map<String,Object> paramsProjectInformation = (Map<String, Object>) params.get("project");
        // 推送到加盟商信息同步到原分单表
        List<Map<String,Object>> resultListForJoinBusiness = (List) params.get("pays");
        for (int i=0;i<resultListForJoinBusiness.size();i++){
            // 查询订单是否已分配
            List<Map<String,Object>> potList = furnitureBusinessApiMapper.listBusList(resultListForJoinBusiness.get(i));
            if(potList.size() == 0){
                furnitureBusinessApiMapper.addProjectForJoinBusiness(resultListForJoinBusiness.get(i));
                // 修改订单状态时间
                Map<String,Object> paramsForProjectStage = new HashMap<>();
                paramsForProjectStage.put("rwdid",paramsProjectInformation.get("baseEntityId").toString());
                paramsForProjectStage.put("shopShellId",resultListForJoinBusiness.get(i).get("shopShellId").toString());
                paramsForProjectStage.put("stage",ProjectMessage.PROJECT_STAGE_BUY);
                // 查询之前是否已分派订单状态表
                Map<String,Object> resultMap = furnitureBusinessApiMapper.getProjectStatusMessage(paramsForProjectStage);
                if(null == resultMap){
                    furnitureBusinessApiMapper.updateProjectDateByRwdid(paramsForProjectStage);
                }

            }
        }

        return furnitureBusinessApiMapper.synchronousProjectInformation(paramsProjectInformation);
    }

    /**
     * @param params rwdid 项目单号(必填)
     *               orgId 加盟商id
     *               programUrl   预算地址
     *               operateType  操作类型
     * @return 返回成功或错误信息
     * @创建人 岳耀栎
     * @创建时间 2019/04/02
     * @功能描述 家具加盟商：上传加盟商预算信息
     */
    @Override
    public int addBusinessBudget(Map<String, Object> params) {
        // 定义返回值
        int resultCode = Constant.Unknownerror;
        // 根据项目单号及公司id查询当前预算是否已经上传
        List<Map<String, Object>> resultList = furnitureBusinessApiMapper.listBusinessBudgetByOrgId(params);
        // 据项目单号及公司id查询项目信息，判断当前项目所处阶段
        Map<String,Object> resultMap = furnitureBusinessApiMapper.getOrderMessageByRwdidAndOrgId(params);
        // 当前订单阶段 处于方案阶段更新，则更新为预算阶段
        Integer orderStage = Integer.parseInt(resultMap.get("pot_Stage").toString());
        if(orderStage > ProjectMessage.PROJECT_STAGE_TAKE && orderStage < ProjectMessage.PROJECT_STAGE_BUDGET){
            params.put("pi_Stage",ProjectMessage.PROJECT_STAGE_BUDGET);
            furnitureBusinessApiMapper.updateOrderByOrgIdAndRwdid(params);

            // 修改订单状态时间
            Map<String,Object> paramsForProjectStage = new HashMap<>();
            paramsForProjectStage.put("rwdid",params.get("rwdid").toString());
            paramsForProjectStage.put("shopShellId",params.get("shopShellId").toString());
            paramsForProjectStage.put("stage",ProjectMessage.PROJECT_STAGE_BUDGET);
            furnitureBusinessApiMapper.updateProjectDateByRwdid(paramsForProjectStage);
        }
        // 判断当前项目是否已上传预算存在即更新，不存在则新增
        if(resultList.size() >0){
            resultCode = furnitureBusinessApiMapper.updateBusinessBudget(params);
        } else {
            resultCode = furnitureBusinessApiMapper.addBusinessBudget(params);
        }
        return resultCode;
    }

    /**
     * @return 根据项目单号及公司id查询加盟商上传预算信息
     * @创建人 岳耀栎
     * @创建时间 2019/04/02
     * @功能描述 家具加盟商：根据项目单号及公司id查询加盟商上传预算信息
     * @params appId 加盟商公司id
     * @接口说明 根据项目单号及公司id查询加盟商上传预算信息
     */
    @Override
    public List<Map<String, Object>> listBusinessBudgetByOrgId(Map<String, Object> params) {

        return furnitureBusinessApiMapper.listBusinessBudgetByOrgId(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/03
     * @功能描述 家具加盟商：更新加盟商合同信息
     * @param params rwdid 项目单号(必填)
     *               orgId 加盟商id
     *               jfname 甲方名称
     *               yfname 乙方名称
     *               jfresponsible 甲方负责人
     *               yfresponsible 乙方负责人
     *               jfphone 甲方电话
     *               yfphone 乙方电话
     *               SignTime 签订时间
     *               Address 签订地点
     *               Money 总价款
     *               DXMoney 价款人民币大写
     *               Prepayment1 预付款百分比
     *               PrepaymentMoney1 预付金额
     *               DXPrepaymentMoney1 预付金额大写
     *               PrepaymentMoney2 交付支付金额
     *               DXPrepaymentMoney2 交付支付金额大写
     *               Prepayment2 交付款占合同金额百分比
     *               PrepaymentMoney3 安装三日内支付金额
     *               DXPrepaymentMoney3 安装三日内支付金额大写
     *               Prepayment3 安装三日内支付金额占合同金额的百分比
     *               SKAccountName 乙方银行账户名
     *               SKAccountBank 开户行
     *               SKAccount 银行账号
     *               ProductionCycle 生产周期
     *               logisticsCycle 运输时间
     *               DetailedAddress 交付安装地点
     *               JFSpot 甲方收货联系人
     *               JFSpotPhone 甲方收货联系人电话
     *               Principal 委托代理人
     *               CardID 委托代理人身份证号
     *               PrincipalPhone 委托代理人手机号
     *               Email 委托代理人邮箱
     *               Dbdw 乙方单位及项目名
     *               designerName 设计师
     *               designerNo 设计师卡号
     * @return 返回成功或错误信息
     */
    @Override
    @Transactional
    public int updateBusinessContract(Map<String, Object> params) {

        // 定义返回值
        int resultCode = Constant.Unknownerror;
        // 根据项目单号及公司id查询当前合同是否已经上传
        Map<String, Object> resultContract = furnitureBusinessApiMapper.getBusinessContract(params);
        // 据项目单号及公司id查询项目信息，判断当前项目所处阶段
        Map<String,Object> resultMap = furnitureBusinessApiMapper.getOrderMessageByRwdidAndOrgId(params);
        // 当前订单阶段 处于方案及方案阶段之后或合同阶段之前，则更新为合同阶段
        Integer orderStage = Integer.parseInt(resultMap.get("pot_Stage").toString());
        if(orderStage > ProjectMessage.PROJECT_STAGE_TAKE && orderStage < ProjectMessage.PROJECT_STAGE_CONTRACT){
            params.put("pi_Stage",ProjectMessage.PROJECT_STAGE_CONTRACT);
            furnitureBusinessApiMapper.updateOrderByOrgIdAndRwdid(params);

            // 修改订单状态时间
            Map<String,Object> paramsForProjectStage = new HashMap<>();
            paramsForProjectStage.put("rwdid",params.get("rwdid").toString());
            paramsForProjectStage.put("shopShellId",params.get("shopShellId").toString());
            paramsForProjectStage.put("stage",ProjectMessage.PROJECT_STAGE_CONTRACT);
            furnitureBusinessApiMapper.updateProjectDateByRwdid(paramsForProjectStage);
        }
        // 判断当前项目是否已上传合同存在即更新，不存在则新增
        if(null != resultContract){
            resultCode = furnitureBusinessApiMapper.updateBusinessContract(params);
        } else {
            resultCode = furnitureBusinessApiMapper.addBusinessContract(params);
        }
        return resultCode;
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/03
     * @功能描述 家具加盟商：查询加盟商合同信息
     * @params rwdid 项目单号
     * @params appId 加盟商公司id
     * @接口说明 加盟商合同信息
     * @return 查询加盟商合同信息*
     */
    @Override
    public Map<String, Object> getBusinessContract(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getBusinessContract(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/08
     * @功能描述 家具加盟商：查询订单信息费
     * @params rwdid 项目单号
     * @接口说明 查询订单信息费
     * @return 查询订单信息费
     */
    @Override
    public Map<String, Object> getOrderPriceByRwdid(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getOrderPriceByRwdid(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：查询未签原因
     * @接口说明 查询未签原因
     * @return 查询未签原因
     */
    @Override
    public List<Map<String, Object>> listNsReasonSurface(Map<String, Object> params) {
        return furnitureBusinessApiMapper.listNsReasonSurface(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：加盟商申请未签
     * @param params rwdid 项目单号(必填)
     *               orgId 加盟商id
     * @return 返回成功或错误信息
     */
    @Override
    @Transactional
    public int designerCommitNoSign(Map<String, Object> params) {
        // 定义返回值
        int resultCode = Constant.Unknownerror;
        // 据项目单号及公司id查询项目信息，获取未签信息
        Map<String,Object> resultMap = furnitureBusinessApiMapper.getUnsingMessage(params);

        // 已经未签，暂时可修改未签信息
        if(null != resultMap){
            resultCode = furnitureBusinessApiMapper.updateUnSignMessage(params);
        } else {
            // 更新项目阶段为未签
            params.put("pi_Stage",ProjectMessage.PROJECT_STAGE_UNSIGNED);
            furnitureBusinessApiMapper.updateOrderByOrgIdAndRwdid(params);
            resultCode = furnitureBusinessApiMapper.designerCommitNoSign(params);

            // 修改订单状态时间
            Map<String,Object> paramsForProjectStage = new HashMap<>();
            paramsForProjectStage.put("rwdid",params.get("rwdid").toString());
            paramsForProjectStage.put("shopShellId",params.get("shopShellId").toString());
            paramsForProjectStage.put("stage",ProjectMessage.PROJECT_STAGE_UNSIGNED);
            furnitureBusinessApiMapper.updateProjectDateByRwdid(paramsForProjectStage);
        }
        return resultCode;
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/20
     * @功能描述 空调加盟商：获取未签信息
     * @接口说明 获取未签信息
     * @return 获取未签信息
     */
    @Override
    public Map<String, Object> getUnsingMessage(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getUnsingMessage(params);
    }
    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：加盟商写入回访
     * @param params rwdid 项目单号(必填)
     *               orgId 加盟商id
     *               content 回访内容
     *               role 回访人角色
     *               kahao 回访人卡号、
     *               mark 回访标记
     *               stage 项目当前阶段
     * @return 返回成功或错误信息
     */
    @Override
    @Transactional
    public int addVisitInfo(Map<String, Object> params) {
        return furnitureBusinessApiMapper.addVisitInfo(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/15
     * @功能描述 家具加盟商：获取加盟商回访
     * @接口说明 获取加盟商回访
     * @param params rwdid 项目单号
     *               orgId 公司id
     *               kahao 卡号
     * @return 获取加盟商回访
     */
    @Override
    public List<Map<String, Object>> getVisitInfo(Map<String, Object> params) {
        return furnitureBusinessApiMapper.getVisitInfo(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：空调查询店壳信息
     * @接口说明 获取加盟商回访
     * @params json
     * @return 空调查询店壳信息
     */
    @Override
    public List<Map<String, Object>> listShopShellByKt(Map<String, Object> params) {
        List<Map<String,Object>> listShopShell = furnitureBusinessApiMapper.listShopShellByKt(params);
        if(listShopShell.size() > 0){
            for(int i = 0; i< listShopShell.size();i++){
                List<Map<String,Object>> shopPicList = furnitureBusinessApiMapper.listShopPic(listShopShell.get(i));
                listShopShell.get(i).put("shopPicList",shopPicList);
            }
        }
        return listShopShell;
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：上传加盟商合同信息
     * @接口说明 上传加盟商合同信息
     * @params params
     * @return 上传加盟商合同信息
     */
    @Override
    @Transactional
    public int addJoinContract(Map<String, Object> params) {
        return furnitureBusinessApiMapper.addJoinContract(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：删除加盟商合同信息
     * @接口说明 删除加盟商合同信息
     * @params params
     * @return 删除加盟商合同信息
     */
    @Override
    @Transactional
    public int updateJoinContract(Map<String, Object> params) {
        return furnitureBusinessApiMapper.updateJoinContract(params);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/22
     * @功能描述 空调加盟商： 项目阶段变更更新对应阶段时间
     * @接口说明 项目阶段变更更新对应阶段时间
     * @params json
     * @return 影响记录数
     */
    @Override
    @Transactional
    public int updateProjectDateByRwdid(Map<String, Object> params) {
        return furnitureBusinessApiMapper.updateProjectDateByRwdid(params);
    }
}
