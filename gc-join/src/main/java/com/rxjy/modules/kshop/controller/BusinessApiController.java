package com.rxjy.modules.kshop.controller;


import com.rxjy.modules.kshop.common.R;
import com.rxjy.modules.kshop.service.FurnitureBusinessApiService;
import com.rxjy.modules.kshop.common.Constant;

import com.rxjy.modules.kshop.common.ToolUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @创建人 岳耀栎
 * @创建时间 2018/10/16
 * @功能描述 家具业务系统控制器
 */
@Api(description = "家具业务模块")
@Controller
@RequestMapping("/kshop/businessApi")
@CrossOrigin
public class BusinessApiController {
    private static final Logger log = LoggerFactory.getLogger("API");

    @Autowired
    private FurnitureBusinessApiService furnitureBusinessApiService;

    /**
     * @return 家具加盟商项目列表
     * @创建人 岳耀栎
     * @创建时间 2019/02/13
     * @功能描述 家具加盟商：获取家具加盟商项目列表
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     */
    @ApiOperation(value = "获取家具加盟商项目列表", notes = "获取家具加盟商项目列表")
    @RequestMapping(value = "/listBusinessProjects", method = RequestMethod.POST)
    @ResponseBody
    public R
    listBusinessProjects(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            log.info("listBusinessProjects[获取家具加盟商项目列表]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultList = furnitureBusinessApiService.listBusinessProjects(params);
                stateCode = Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listBusinessProjects[获取家具加盟商项目列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listBusinessProjects[获取家具加盟商项目列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultList);
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
    @ApiOperation(value = "根据公司Id和项目单号获取家具加盟商项目阶段信息", notes = "根据公司Id和项目单号获取家具加盟商项目阶段信息")
    @RequestMapping(value = "/getBusinessProjectByRwdidAndOrgId", method = RequestMethod.POST)
    @ResponseBody
    public R getBusinessProjectByRwdidAndOrgId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getBusinessProjectByRwdidAndOrgId[根据公司Id和项目单号获取家具加盟商项目阶段信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.getBusinessProjectByRwdidAndOrgId(params);
                stateCode = Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getBusinessProjectByRwdidAndOrgId[根据公司Id和项目单号获取家具加盟商项目阶段信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getBusinessProjectByRwdidAndOrgId[根据公司Id和项目单号获取家具加盟商项目阶段信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @return 加盟商项目阶段信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号更新家具加盟商项目阶段信息
     * @params orgId 加盟商公司id
     * @params Account 加盟商公司账号
     * @params rwdid 项目单号
     * @params stage 2：接单
     * 3：方案
     * 4：预算
     * 5：合同
     * 6：已签
     * 99：未签
     * @params IsValid 是否有效 0：有效
     * 1：无效
     * @接口说明 更新项目阶段传递stage对应的参数值，弃单操作传递IsValid参数值为1
     */
    @ApiOperation(value = "根据公司Id和项目单号更新家具加盟商项目阶段信息", notes = "根据公司Id和项目单号更新家具加盟商项目阶段信息")
    @RequestMapping(value = "/updateBusinessProjectByRwdidAndOrgId", method = RequestMethod.POST)
    @ResponseBody
    public R updateBusinessProjectByRwdidAndOrgId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateBusinessProjectByRwdidAndOrgId[根据公司Id和项目单号更新家具加盟商项目阶段信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.updateBusinessProjectByRwdidAndOrgId(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateBusinessProjectByRwdidAndOrgId[根据公司Id和项目单号更新家具加盟商项目阶段信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateBusinessProjectByRwdidAndOrgId[根据公司Id和项目单号更新家具加盟商项目阶段信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @return 家具加盟商项目洽谈概况信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：根据公司Id和项目单号查询家具加盟商项目洽谈概况信息
     * @params orgId 加盟商公司id
     * @params rwdid 项目单号
     */
    @ApiOperation(value = "根据公司Id和项目单号查询家具加盟商项目洽谈概况信息", notes = "根据公司Id和项目单号查询家具加盟商项目洽谈概况信息")
    @RequestMapping(value = "/getBusinessProjectNegotiationSurveyByRwdidAndOrgId", method = RequestMethod.POST)
    @ResponseBody
    public R getBusinessProjectNegotiationSurveyByRwdidAndOrgId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getBusinessProjectNegotiationSurveyByRwdidAndOrgId[根据公司Id和项目单号查询家具加盟商项目洽谈概况信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                // 预算
                resultMap.put("budget", furnitureBusinessApiService.getBusinessProjectNegotiationSurveyByRwdidAndOrgId(params));
                // 方案
                resultMap.put("program", furnitureBusinessApiService.getBusinessProjectProgarmByRwdidAndOrgId(params));
                // 合同
                resultMap.put("contract", furnitureBusinessApiService.getBusinessProjectContractByRwdidAndOrgId(params));
                stateCode = Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getBusinessProjectNegotiationSurveyByRwdidAndOrgId[根据公司Id和项目单号查询家具加盟商项目洽谈概况信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getBusinessProjectNegotiationSurveyByRwdidAndOrgId[根据公司Id和项目单号查询家具加盟商项目洽谈概况信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @return 查询项目在工程部的资料信息
     * @创建人 岳耀栎
     * @创建时间 2019/02/15
     * @功能描述 家具加盟商：查询项目在工程部的资料信息
     * @params rwdid 项目单号
     */
    @ApiOperation(value = "查询项目在工程部的资料信息", notes = "查询项目在工程部的资料信息")
    @RequestMapping(value = "/getConstructionMessageByRwdid", method = RequestMethod.GET)
    @ResponseBody
    public R getConstructionMessageByRwdid(String rwdid) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getConstructionMessageByRwdid[查询项目在工程部的资料信息]，进入方法，参数：rwdid=" + rwdid);
            if (ToolUtil.strNotIsEmpty(rwdid)) {
                // 预算
                resultMap = furnitureBusinessApiService.getConstructionMessageByRwdid(rwdid);
                stateCode = Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getConstructionMessageByRwdid[查询项目在工程部的资料信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getConstructionMessageByRwdid[查询项目在工程部的资料信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }


    /**
     * @return 设计师列表
     * @创建人 岳耀栎
     * @创建时间 2019/03/27
     * @功能描述 家具加盟商：根据公司Id获取设计师列表
     * @params orgId 加盟商公司id
     */
    @ApiOperation(value = "根据公司Id获取设计师列表", notes = "根据公司Id获取设计师列表")
    @RequestMapping(value = "/listDesignerByOrgId", method = RequestMethod.POST)
    @ResponseBody
    public R listDesignerByOrgId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listDesignerByOrgId[根据公司Id获取设计师列表]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.listDesignerByOrgId(params);
                stateCode = Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listDesignerByOrgId[根据公司Id获取设计师列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listDesignerByOrgId[根据公司Id获取设计师列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json rwdid 项目单号
     *             orgId 加盟商id
     * @return 返回分派的设计师信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/28
     * @功能描述 家具加盟商：检查当前订单是否已经分派给其他设计师
     */
    @ApiOperation(value = "检查当前订单是否已经分派给其他设计师", notes = "检查当前订单是否已经分派给其他设计师")
    @RequestMapping(value = "/checkOrderIsDesignerByRwdid", method = RequestMethod.POST)
    @ResponseBody
    public R checkOrderIsDesignerByRwdid(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("checkOrderIsDesignerByRwdid[家具加盟商派单]，进入方法，参数：data=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.checkOrderIsDesignerByRwdid(params);
                stateCode = Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("checkOrderIsDesignerByRwdid[家具加盟商派单]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("checkOrderIsDesignerByRwdid[家具加盟商派单]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
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
    @ApiOperation(value = "根据项目单号及设计师卡号对设计师分单", notes = "根据项目单号及设计师卡号对设计师分单")
    @RequestMapping(value = "/dispatchToDesigner", method = RequestMethod.POST)
    @ResponseBody
    public R dispatchToDesigner(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("dispatchToDesigner[根据项目单号及设计师卡号对设计师分单]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.dispatchToDesigner(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("dispatchToDesigner[根据项目单号及设计师卡号对设计师分单]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("dispatchToDesigner[根据项目单号及设计师卡号对设计师分单]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
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
    @ApiOperation(value = "根据项目单号及加盟商id更新项目阶段信息", notes = "根据项目单号及加盟商id更新项目阶段信息")
    @RequestMapping(value = "/updateOrderByOrgIdAndRwdid", method = RequestMethod.POST)
    @ResponseBody
    public R updateOrderByOrgIdAndRwdid(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateOrderByOrgIdAndRwdid[根据项目单号及加盟商id更新项目阶段信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.updateOrderByOrgIdAndRwdid(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateOrderByOrgIdAndRwdid[根据项目单号及加盟商id更新项目阶段信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateOrderByOrgIdAndRwdid[根据项目单号及加盟商id更新项目阶段信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @return 根据appId查询加盟商招过程中人事资料信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/29
     * @功能描述 家具加盟商：根据appId查询加盟商招过程中人事资料信息
     * @params appId 加盟商公司id
     * @接口说明 根据appId查询加盟商招过程中人事资料信息
     */
    @ApiOperation(value = "根据appId查询加盟商招过程中人事资料信息", notes = "根据appId查询加盟商招过程中人事资料信息")
    @RequestMapping(value = "/getJoinBusinessMessageByAppId", method = RequestMethod.POST)
    @ResponseBody
    public R getJoinBusinessMessageByAppId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String,Object> resultMap = new HashMap<>();
        try {
            log.info("getJoinBusinessMessageByAppId[根据appId查询加盟商招过程中人事资料信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.getJoinBusinessMessageByAppId(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getJoinBusinessMessageByAppId[根据appId查询加盟商招过程中人事资料信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getJoinBusinessMessageByAppId[根据appId查询加盟商招过程中人事资料信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
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
    @ApiOperation(value = "根据项目单号及加盟商id更新项目阶段信息", notes = "根据项目单号及加盟商id更新项目阶段信息")
    @RequestMapping(value = "/updateShopProgramByShopId", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopProgramByShopId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopProgramByShopId[根据项目单号及加盟商id更新项目阶段信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.updateShopProgramByShopId(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopProgramByShopId[根据项目单号及加盟商id更新项目阶段信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopProgramByShopId[根据项目单号及加盟商id更新项目阶段信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @return 根据项目单号及公司id查询加盟商上传方案信息
     * @创建人 岳耀栎
     * @创建时间 2019/03/29
     * @功能描述 家具加盟商：根据项目单号及公司id查询加盟商上传方案信息
     * @params appId 加盟商公司id
     * @接口说明 根据项目单号及公司id查询加盟商上传方案信息
     */
    @ApiOperation(value = "根据项目单号及公司id查询加盟商上传方案信息", notes = "根据项目单号及公司id查询加盟商上传方案信息")
    @RequestMapping(value = "/listShopProgramByShopId", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProgramByShopId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopProgramByShopId[根据项目单号及公司id查询加盟商上传方案信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.listShopProgramByShopId(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProgramByShopId[根据项目单号及公司id查询加盟商上传方案信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProgramByShopId[根据项目单号及公司id查询加盟商上传方案信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
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
    @ApiOperation(value = "六师同步项目信息接口", notes = "六师同步项目信息接口")
    @RequestMapping(value = "/synchronousProjectInformation", method = RequestMethod.POST)
    @ResponseBody
    public R synchronousProjectInformation(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("synchronousProjectInformation[六师同步项目信息接口]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.synchronousProjectInformation(params) > 0 ? 1 : 0;
            } else {
                stateCode = 0;
            }
        } catch (Exception e) {
            stateCode = 0;
            log.info("synchronousProjectInformation[六师同步项目信息接口]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行成功:" + "六师同步项目信息成功"+json);
        }
        log.info("synchronousProjectInformation[六师同步项目信息接口]End:");
        return new R(stateCode, "同步项目信息成功");
    }


    /**
     * @param json rwdid 项目单号(必填)
     *             orgId 加盟商id
     *             programUrl   预算地址
     *             operateType  操作类型
     * @return 返回成功或错误信息
     * @创建人 岳耀栎
     * @创建时间 2019/04/02
     * @功能描述 家具加盟商：上传加盟商预算信息
     */
    @ApiOperation(value = "上传加盟商预算信息", notes = "上传加盟商预算信息")
    @RequestMapping(value = "/addBusinessBudget", method = RequestMethod.POST)
    @ResponseBody
    public R addBusinessBudget(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addBusinessBudget[上传加盟商预算信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.addBusinessBudget(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addBusinessBudget[上传加盟商预算信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addBusinessBudget[上传加盟商预算信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @return 根据项目单号及公司id查询加盟商上传预算信息
     * @创建人 岳耀栎
     * @创建时间 2019/04/02
     * @功能描述 家具加盟商：根据项目单号及公司id查询加盟商上传预算信息
     * @params appId 加盟商公司id
     * @接口说明 根据项目单号及公司id查询加盟商上传预算信息
     */
    @ApiOperation(value = "根据项目单号及公司id查询加盟商上传预算信息", notes = "根据项目单号及公司id查询加盟商上传预算信息")
    @RequestMapping(value = "/listBusinessBudgetByOrgId", method = RequestMethod.POST)
    @ResponseBody
    public R listBusinessBudgetByOrgId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listBusinessBudgetByOrgId[根据项目单号及公司id查询加盟商上传预算信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.listBusinessBudgetByOrgId(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listBusinessBudgetByOrgId[根据项目单号及公司id查询加盟商上传预算信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listBusinessBudgetByOrgId[根据项目单号及公司id查询加盟商上传预算信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/03
     * @功能描述 家具加盟商：更新加盟商合同信息
     * @param json rwdid 项目单号(必填)
     *             orgId 加盟商id
     *             jfname 甲方名称
     *             yfname 乙方名称
     *             jfresponsible 甲方负责人
     *             yfresponsible 乙方负责人
     *             jfphone 甲方电话
     *             yfphone 乙方电话
     *             SignTime 签订时间
     *             Address 签订地点
     *             Money 总价款
     *             DXMoney 价款人民币大写
     *             Prepayment1 预付款百分比
     *             PrepaymentMoney1 预付金额
     *             DXPrepaymentMoney1 预付金额大写
     *             PrepaymentMoney2 交付支付金额
     *             DXPrepaymentMoney2 交付支付金额大写
     *             Prepayment2 交付款占合同金额百分比
     *             PrepaymentMoney3 安装三日内支付金额
     *             DXPrepaymentMoney3 安装三日内支付金额大写
     *             Prepayment3 安装三日内支付金额占合同金额的百分比
     *             SKAccountName 乙方银行账户名
     *             SKAccountBank 开户行
     *             SKAccount 银行账号
     *             ProductionCycle 生产周期
     *             logisticsCycle 运输时间
     *             DetailedAddress 交付安装地点
     *             JFSpot 甲方收货联系人
     *             JFSpotPhone 甲方收货联系人电话
     *             Principal 委托代理人
     *             CardID 委托代理人身份证号
     *             PrincipalPhone 委托代理人手机号
     *             Email 委托代理人邮箱
     *             Dbdw 乙方单位及项目名
     *             designerName 设计师
     *             designerNo 设计师卡号
     * @return 返回成功或错误信息
     */
    @ApiOperation(value = "更新加盟商合同信息", notes = "更新加盟商合同信息")
    @RequestMapping(value = "/updateBusinessContract", method = RequestMethod.POST)
    @ResponseBody
    public R updateBusinessContract(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateBusinessContract[更新加盟商合同信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.updateBusinessContract(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateBusinessContract[更新加盟商合同信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateBusinessContract[更新加盟商合同信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
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
    @ApiOperation(value = "查询加盟商合同信息", notes = "查询加盟商合同信息")
    @RequestMapping(value = "/getBusinessContract", method = RequestMethod.POST)
    @ResponseBody
    public R getBusinessContract(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String,Object> resultMap = new HashMap<>();
        try {
            log.info("getBusinessContract[查询加盟商合同信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.getBusinessContract(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getBusinessContract[查询加盟商合同信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getBusinessContract[查询加盟商合同信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/08
     * @功能描述 家具加盟商：查询订单信息费
     * @params rwdid 项目单号
     * @接口说明 查询订单信息费
     * @return 查询订单信息费
     */
    @ApiOperation(value = "查询订单信息费", notes = "查询订单信息费")
    @RequestMapping(value = "/getOrderPriceByRwdid", method = RequestMethod.POST)
    @ResponseBody
    public R getOrderPriceByRwdid(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String,Object> resultMap = new HashMap<>();
        try {
                log.info("getOrderPriceByRwdid[查询订单信息费]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {

                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.getOrderPriceByRwdid(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getOrderPriceByRwdid[查询订单信息费]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getOrderPriceByRwdid[查询订单信息费]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }


    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：查询未签原因
     * @接口说明 查询未签原因
     * @return 查询未签原因
     */
    @ApiOperation(value = "查询未签原因", notes = "查询未签原因")
    @RequestMapping(value = "/listNsReasonSurface", method = RequestMethod.POST)
    @ResponseBody
    public R listNsReasonSurface(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listNsReasonSurface[查询未签原因]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.listNsReasonSurface(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listNsReasonSurface[查询未签原因]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listNsReasonSurface[查询未签原因]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：加盟商申请未签
     * @param json rwdid 项目单号(必填)
     *             orgId 加盟商id
     *
     * @return 返回成功或错误信息
     */
    @ApiOperation(value = "加盟商申请未签", notes = "加盟商申请未签")
    @RequestMapping(value = "/designerCommitNoSign", method = RequestMethod.POST)
    @ResponseBody
    public R designerCommitNoSign(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("designerCommitNoSign[加盟商申请未签]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.designerCommitNoSign(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("designerCommitNoSign[加盟商申请未签]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("designerCommitNoSign[加盟商申请未签]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }


    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/10
     * @功能描述 家具加盟商：获取未签信息
     * @接口说明 获取未签信息
     * @return 获取未签信息
     */
    @ApiOperation(value = "获取未签信息", notes = "获取未签信息")
    @RequestMapping(value = "/getUnsingMessage", method = RequestMethod.POST)
    @ResponseBody
    public R getUnsingMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String,Object> resultMap = new HashMap<>();
        try {
            log.info("getUnsingMessage[获取未签信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.getUnsingMessage(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getUnsingMessage[获取未签信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getUnsingMessage[获取未签信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/15
     * @功能描述 家具加盟商：加盟商写入回访
     * @param json rwdid 项目单号(必填)
     *             orgId 加盟商id
     *             content 回访内容
     *             role 回访人角色
     *             kahao 回访人卡号、
     *             mark 回访标记
     *             stage 项目当前阶段
     * @return 返回成功或错误信息
     */
    @ApiOperation(value = "加盟商写入回访", notes = "加盟商写入回访")
    @RequestMapping(value = "/addVisitInfo", method = RequestMethod.POST)
    @ResponseBody
    public R addVisitInfo(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addVisitInfo[加盟商写入回访]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.addVisitInfo(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addVisitInfo[加盟商写入回访]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addVisitInfo[加盟商写入回访]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/15
     * @功能描述 家具加盟商：获取加盟商回访
     * @接口说明 获取加盟商回访
     * @params json rwdid 项目单号
     *              orgId 公司id
     *              kahao 卡号
     * @return 获取加盟商回访
     */
    @ApiOperation(value = "获取加盟商回访", notes = "获取加盟商回访")
    @RequestMapping(value = "/getVisitInfo", method = RequestMethod.POST)
    @ResponseBody
    public R getVisitInfo(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("getVisitInfo[获取加盟商回访]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.getVisitInfo(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getVisitInfo[获取加盟商回访]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getVisitInfo[获取加盟商回访]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：空调查询店壳信息
     * @接口说明 获取加盟商回访
     * @params json
     * @return 空调查询店壳信息
     */
    @ApiOperation(value = "空调查询店壳信息", notes = "空调查询店壳信息")
    @RequestMapping(value = "/listShopShellByKt", method = RequestMethod.POST)
    @ResponseBody
    public R listShopShellByKt(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopShellByKt[空调查询店壳信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureBusinessApiService.listShopShellByKt(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopShellByKt[空调查询店壳信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopShellByKt[空调查询店壳信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：上传加盟商合同信息
     * @接口说明 上传加盟商合同信息
     * @params json
     * @return 上传加盟商合同信息
     */
    @ApiOperation(value = "上传加盟商图片信息", notes = "上传加盟商图片信息")
    @RequestMapping(value = "/addJoinContract", method = RequestMethod.POST)
    @ResponseBody
    public R addJoinContract(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addJoinContract[上传加盟商图片信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.addJoinContract(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addJoinContract[上传加盟商图片信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addJoinContract[上传加盟商图片信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/21
     * @功能描述 空调加盟商：删除加盟商图片信息
     * @接口说明 删除加盟商图片信息
     * @params json
     * @return 删除加盟商图片信息
     */
    @ApiOperation(value = "删除加盟商图片信息", notes = "删除加盟商图片信息")
    @RequestMapping(value = "/updateJoinContract", method = RequestMethod.POST)
    @ResponseBody
    public R updateJoinContract(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateJoinContract[删除加盟商图片信息]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.updateJoinContract(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateJoinContract[删除加盟商图片信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateJoinContract[删除加盟商图片信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }


    /**
     * @创建人 岳耀栎
     * @创建时间 2019/04/22
     * @功能描述 空调加盟商： 项目阶段变更更新对应阶段时间
     * @接口说明 项目阶段变更更新对应阶段时间
     * @params json
     * @return 影响记录数
     */
    @ApiOperation(value = "项目阶段变更更新对应阶段时间", notes = "项目阶段变更更新对应阶段时间")
    @RequestMapping(value = "/updateProjectDateByRwdid", method = RequestMethod.POST)
    @ResponseBody
    public R updatePorjectDateByRwdid(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateProjectDateByRwdid[项目阶段变更更新对应阶段时间]，进入方法，参数：json=" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = furnitureBusinessApiService.updateProjectDateByRwdid(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateProjectDateByRwdid[项目阶段变更更新对应阶段时间]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateProjectDateByRwdid[项目阶段变更更新对应阶段时间]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }



}
