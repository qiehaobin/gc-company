package com.rxjy.modules.kshop.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @创建人 岳耀栎
 * @创建时间 2018/10/16
 * @功能描述 家具加盟商系统接口
 */
@Repository
public interface FurnitureBusinessApiService {

    /**
     * @return 家具加盟商项目列表
     * @创建人 岳耀栎
     * @创建时间 2019/02/13
     * @功能描述 家具加盟商：获取家具加盟商项目列表
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     */
    List<Map<String, Object>> listBusinessProjects(Map<String, Object> params);

    /**
     * @return 加盟商项目阶段信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号获取家具加盟商项目阶段信息
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     * @params rwdid 项目单号
     */
    Map<String, Object> getBusinessProjectByRwdidAndOrgId(Map<String, Object> params);

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
    @Transactional
    int updateBusinessProjectByRwdidAndOrgId(Map<String, Object> params);

    /**
     * @return 家具加盟商项目洽谈概况信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目洽谈概况信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    List<Map<String, Object>> getBusinessProjectNegotiationSurveyByRwdidAndOrgId(Map<String, Object> params);

    /**
     * @return 家具加盟商项目洽谈概况信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目洽谈概况信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    List<Map<String, Object>> getBusinessProjectProgarmByRwdidAndOrgId(Map<String, Object> params);

    /**
     * @return 家具加盟商项目洽谈概况信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目合同概况信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    List<Map<String, Object>> getBusinessProjectContractByRwdidAndOrgId(Map<String, Object> params);


    /**
     * @param rwdid 项目单号
     * @return 查询项目在工程部的资料信息
     * @创建人 岳耀栎
     * @创建时间 2019/01/08
     * @功能描述 查询项目在工程部的资料信息
     */
    Map<String, Object> getConstructionMessageByRwdid(String rwdid);

    /**
     * @return 设计师列表
     * @创建人 岳耀栎
     * @创建时间 2019/03/27
     * @功能描述 家具加盟商：根据公司Id获取设计师列表
     * @params orgId 加盟商公司id
     */
    List<Map<String, Object>> listDesignerByOrgId(Map<String, Object> params);

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
    int dispatchToDesigner(Map<String, Object> params);

    /**
     * @param params rwdid 项目单号
     *               orgId 加盟商id
     * @return 返回分派的设计师信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：检查当前订单是否已经分派给其他设计师
     */
    Map<String, Object> checkOrderIsDesignerByRwdid(Map<String, Object> params);

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
    int updateOrderByOrgIdAndRwdid(Map<String, Object> params);

    /**
     * @return 根据appId查询加盟商招过程中人事资料信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/29
     * @功能描述 家具加盟商：根据appId查询加盟商招过程中人事资料信息
     * @params appId 加盟商公司id
     * @接口说明 根据appId查询加盟商招过程中人事资料信息
     */
    Map<String, Object> getJoinBusinessMessageByAppId(Map<String, Object> params);

    /**
     * @return 根据shopId更新方案信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：根据shopId更新方案信息
     * @params shopId 加盟商公司id
     * @params programImg 方案地址
     * @接口说明 根据shopId更新方案信息
     */
    int updateShopProgramByShopId(Map<String, Object> params);

    /**
     * @return 根据项目单号及公司id查询加盟商上传方案信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/29
     * @功能描述 家具加盟商：根据项目单号及公司id查询加盟商上传方案信息
     * @params appId 加盟商公司id
     * @接口说明 根据项目单号及公司id查询加盟商上传方案信息
     */
    List<Map<String, Object>> listShopProgramByShopId(Map<String, Object> params);

    /**
     * @return 六师同步项目信息接口
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：六师同步项目信息接口
     * @params shopId 加盟商公司id
     * @params programImg 方案地址
     * @接口说明 六师同步项目信息接口
     */
    int synchronousProjectInformation(Map<String, Object> params);

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
    int addBusinessBudget(Map<String, Object> params);

    /**
     * @return 根据项目单号及公司id查询加盟商上传预算信息
     * @创建人 岳耀栎
     * @创建时间 2019/04/02
     * @功能描述 家具加盟商：根据项目单号及公司id查询加盟商上传预算信息
     * @params appId 加盟商公司id
     * @接口说明 根据项目单号及公司id查询加盟商上传预算信息
     */
    List<Map<String, Object>> listBusinessBudgetByOrgId(Map<String, Object> params);

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
    int updateBusinessContract(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/03
     * @功能描述 家具加盟商：查询加盟商合同信息
     * @params rwdid 项目单号
     * @params appId 加盟商公司id
     * @接口说明 加盟商合同信息
     * @return 查询加盟商合同信息*
     */
    Map<String, Object> getBusinessContract(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/08
     * @功能描述 家具加盟商：查询订单信息费
     * @params rwdid 项目单号
     * @接口说明 查询订单信息费
     * @return 查询订单信息费
     */
    Map<String, Object> getOrderPriceByRwdid(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：查询未签原因
     * @接口说明 查询未签原因
     * @return 查询未签原因
     */
    List<Map<String, Object>> listNsReasonSurface(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：加盟商申请未签
     * @param params rwdid 项目单号(必填)
     *               orgId 加盟商id
     * @return 返回成功或错误信息
     */
    int designerCommitNoSign(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：获取未签信息
     * @接口说明 获取未签信息
     * @return 获取未签信息
     */
    Map<String, Object> getUnsingMessage(Map<String, Object> params);
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
    int addVisitInfo(Map<String, Object> params);

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
    List<Map<String, Object>> getVisitInfo(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：空调查询店壳信息
     * @接口说明 获取加盟商回访
     * @params json
     * @return 空调查询店壳信息
     */
    List<Map<String, Object>> listShopShellByKt(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：上传加盟商合同信息
     * @接口说明 上传加盟商合同信息
     * @params json
     * @return 上传加盟商合同信息
     */
    int addJoinContract(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：删除加盟商合同信息
     * @接口说明 删除加盟商合同信息
     * @params params
     * @return 删除加盟商合同信息
     */
    int updateJoinContract(Map<String, Object> params);

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/22
     * @功能描述 空调加盟商： 项目阶段变更更新对应阶段时间
     * @接口说明 项目阶段变更更新对应阶段时间
     * @params json
     * @return 影响记录数
     */
    int updateProjectDateByRwdid(Map<String, Object> params);
}
