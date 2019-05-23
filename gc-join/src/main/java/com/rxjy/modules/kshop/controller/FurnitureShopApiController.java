package com.rxjy.modules.kshop.controller;

import com.rxjy.modules.kshop.service.FurnitureShopApiService;
import com.rxjy.modules.kshop.common.Constant;
import com.rxjy.modules.kshop.common.R;
import com.rxjy.modules.kshop.common.ToolUtil;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
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
 * @author 岳耀栎
 * @create 2019-03-04
 * 家具新店铺模板
 */
@Controller
@RequestMapping(value = {"kshop/Api/Shop"})
@CrossOrigin
public class FurnitureShopApiController {
    @Autowired
    private FurnitureShopApiService furnitureShopApiService;

    private static final Logger log = LoggerFactory.getLogger("API");

    /**
     * @param jsonStr id 店壳编号 空调KT-001 家具JJ-001 弱电RD-001
     *                shop_name 店铺名称
     *                shopCategory 店铺类型
     *                shopStage 店铺阶段 00空壳 10招 20培 30留 40用 50离
     *                shopTypeId 店铺信息编号
     *                cityId 城市编号
     *                delFlag 删除标识 0：正常 1：删除
     *                createDate 创建时间
     *                updateDate 更新时间
     *                remarks 备注
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增店铺壳子
     */
    @ApiOperation(value = "新增店铺壳子", notes = "新增店铺壳子")
    @RequestMapping(value = "/addShopShell", method = RequestMethod.POST)
    @ResponseBody
    public R addShopShell(@RequestBody JSONObject jsonStr) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addShopShell[新增店铺壳子]，进入方法，参数：" + jsonStr);
            if (ToolUtil.strNotIsEmpty(jsonStr)) {
                String str = jsonStr.getString("jsonStr");
                List<Map<String, Object>> params = JSONArray.fromObject(str);
                //新增店铺壳子
                stateCode = furnitureShopApiService.addShopShell(params) > 0 ? Constant.Unknownerror : Constant.Success;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addShopShell[新增店铺壳子]异常信息:" + e);
        }
        if (stateCode == 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addShopShell[新增店铺壳子]End:");
        return new R(stateCode, Constant.returnResult(0));
    }

    /**
     * @param json shopId 店壳编号
     *             workAddress 办公地址
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺信息
     */
    @ApiOperation(value = "根据店铺id更新店铺信息", notes = "根据店铺id更新店铺信息")
    @RequestMapping(value = "/updateShopShellMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopShellMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopShellMessage[根据店铺id更新店铺信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //新增店铺壳子
                stateCode = furnitureShopApiService.updateShopShellMessage(params) > 0 ? Constant.Success : Constant.Unknownerror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopShellMessage[根据店铺id更新店铺信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopShellMessage[根据店铺id更新店铺信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }



    /**
     * @param json id 店壳编号 空调KT-001 家具JJ-001 弱电RD-001
     *             shop_name 店铺名称
     *             shop_type 店铺类型
     *             shop_stage 店铺阶段 00空壳 10招 20培 30留 40用 50离
     *             shop_information_id 店铺信息编号
     *             city_id 城市编号
     *             del_flag 删除标识 0：正常 1：删除
     *             create_date 创建时间
     *             create_date 更新时间
     *             remarks 备注
     * @return 店铺壳子列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：查询店铺壳子列表
     */
    @ApiOperation(value = "查询店铺壳子列表", notes = "查询店铺壳子列表")
    @RequestMapping(value = "/listShopShell", method = RequestMethod.POST)
    @ResponseBody
    public R listShopShell(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopShell[查询店铺壳子列表]，进入方法，参数：" + json.toString());
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //查询店铺壳子列表
                resultMap = furnitureShopApiService.listShopShell(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopShell[查询店铺壳子列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopShell[查询店铺壳子列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型
     * @return 店铺壳子列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：根据店铺id与店铺类型查询已选类目列表及类目信息
     */
    @ApiOperation(value = "根据店铺id与店铺类型查询已选类目列表及类目信息", notes = "根据店铺id与店铺类型查询已选类目列表及类目信息")
    @RequestMapping(value = "/listShopCategoryByShopIdAndCategoryCode", method = RequestMethod.POST)
    @ResponseBody
    public R listShopCategoryByShopIdAndCategoryCode(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopCategoryByShopIdAndCategoryCode[根据店铺id与店铺类型查询已选类目列表及类目信息]，进入方法，参数：" + json.toString());
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //查询店铺壳子列表
                resultMap = furnitureShopApiService.listShopCategoryByShopIdAndCategoryCode(params);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopCategoryByShopIdAndCategoryCode[根据店铺id与店铺类型查询已选类目列表及类目信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopCategoryByShopIdAndCategoryCode[根据店铺id与店铺类型查询已选类目列表及类目信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }


    /**
     * @param json shopType 0：店铺 1：店铺模板
     *             shopId 店铺id
     *             categoryList 类别列表
     *             createUser 操作人
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：新增或更新家具店铺包含类别与产品
     */
    @ApiOperation(value = "新增或更新家具店铺包含类别与产品", notes = "新增或更新家具店铺包含类别与产品")
    @RequestMapping(value = "/updateShopCategoryAndProduct", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopCategoryAndProduct(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopCategoryAndProduct[新增或更新家具店铺包含类别与产品]，进入方法，参数：" + json.toString());
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //新增或更新家具店铺包含类别与产品
                stateCode = furnitureShopApiService.updateShopCategoryAndProduct(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopCategoryAndProduct[新增或更新家具店铺包含类别与产品]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopCategoryAndProduct[新增或更新家具店铺包含类别与产品]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json type 0：店铺 1：店铺模板
     * @return 当次新增记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 空调店铺：新增空调店鋪模板
     */
    @ApiOperation(value = "新增空调店鋪模板", notes = "新增空调店鋪模板")
    @RequestMapping(value = "/addNewShopTemplate", method = RequestMethod.POST)
    @ResponseBody
    public R addNewShopTemplate(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        String msg = "";
        try {
            log.info("addNewShopTemplate[新增空调店鋪模板]，进入方法，参数：" + json.toString());
            if (ToolUtil.strNotIsEmpty(json)) {
                // 判断传入的店铺模板是否为新增空调店鋪模板
                if(json.getString("shopCategory").equals("1")){
                    Map<String, Object> params = JSONObject.fromObject(json);
                    //添加或修改空调店鋪模板
                    stateCode = furnitureShopApiService.addNewShopTemplate(params) > 0 ? 1 : 0;
                    msg = "更新空调店鋪模板成功";
                }else{
                    stateCode = 1;
                    msg = "不是本部门的店壳";
                }
            } else {
                stateCode = Constant.Invalidparameter;
                msg = "参数无效或缺失";
            }
        } catch (Exception e) {
            stateCode = 0;
            msg = "未知错误";
            log.info("addNewShopTemplate[新增空调店鋪模板]异常信息:" + e);
        }
        if (stateCode == 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addNewShopTemplate[新增空调店鋪模板]End:");
        return new R(stateCode, msg);
    }

    /**
     * @param json
     * @return 家具模板列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-04
     * @功能描述 家具店铺模板：获取新家具模板列表
     */
    @ApiOperation(value = "获取新家具模板列表", notes = "获取新家具模板列表")
    @RequestMapping(value = "/listShopTemplate", method = RequestMethod.POST)
    @ResponseBody
    public R listShopTemplate(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopTemplate[获取新家具模板列表]，进入方法，参数：" + json.toString());
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //添加或修改店铺模板信息
                resultMap = furnitureShopApiService.listShopTemplate(params);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;

            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopTemplate[获取新家具模板列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopTemplate[获取新家具模板列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param id 店铺模板id
     * @return 店铺模板信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-04
     * @功能描述 家具店铺模板：根据店铺模板id获取店铺模板信息
     */
    @ApiOperation(value = "根据店铺模板id获取店铺模板信息", notes = "根据店铺模板id获取店铺模板信息")
    @RequestMapping(value = "/getShopTemplate", method = RequestMethod.POST)
    @ResponseBody
    public R getShopTemplate(int id) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getShopTemplate[根据店铺模板id获取店铺模板信息]，进入方法，参数：" + id);
            if (ToolUtil.strNotIsEmpty(id)) {
                //添加或修改店铺模板信息
                resultMap = furnitureShopApiService.getShopTemplate(id);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getShopTemplate[根据店铺模板id获取店铺模板信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getShopTemplate[根据店铺模板id获取店铺模板信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json id 店铺模板id
     *             phone 手机认证
     *             identityCard 身份证认证
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-05
     * @功能描述 家具店铺模板：根据店铺模板id更新店铺模板认证设置信息
     */
    @ApiOperation(value = "根据店铺模板id更新店铺模板认证设置信息", notes = "根据店铺模板id更新店铺模板认证设置信息")
    @RequestMapping(value = "/updateAuthenticationMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateAuthenticationMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateAuthenticationMessage[根据店铺模板id更新店铺模板认证设置信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺模板id更新店铺模板认证设置信息
                stateCode = furnitureShopApiService.updateAuthenticationMessage(json) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateAuthenticationMessage[根据店铺模板id更新店铺模板认证设置信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateAuthenticationMessage[根据店铺模板id更新店铺模板认证设置信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }


    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             shopName 店铺名称
     *             shopLegalPerson 法人代表
     *             shopLegalPersonMobile 法人代表手机号
     *             shopBusinessLeader 业务代表
     *             shopBusinessLeaderMobile 业务代表手机号
     *             shopRegisteredCapital 注册资金
     *             shopQualificationsUrl 资质URL
     *             shopBusinessCard 名片URL
     *             shopBriefIntroduction 店铺简介
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id更新店铺基础信息
     */
    @ApiOperation(value = "根据店铺id更新店铺基础信息", notes = "根据店铺id更新店铺基础信息")
    @RequestMapping(value = "/updateShopBaseMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopBaseMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopBaseMessage[根据店铺id更新店铺基础信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                stateCode = furnitureShopApiService.updateShopBaseMessage(json) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopBaseMessage[根据店铺id更新店铺基础信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopBaseMessage[根据店铺id更新店铺基础信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             shopName 店铺名称
     *             publicBankName 对公账户开户行名称
     *             publicBankAccount 对公账户开户行账号
     *             privateBankName 对私账户开户行名称
     *             privateBankAccount 对私账户开户行账号
     *             shopPeopleCardFace 财务代表人身份证头像面照片URL
     *             shopPeopleCardOpposite 财务代表人身份证国徽面照片URL
     *             shopPeopleCardHold 财务代表人手持身份证正面照URL
     *             shopPublicPhotoFace 对公账户银行卡正面照片URL
     *             shopPublicPhotoOpposite 对公账户银行卡反面照片URL
     *             shopPrivatePhotoFace 对私账户银行卡正面照片URL
     *             shopPrivatePhotoOpposite 对私账户银行卡反面照片URL
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-07
     * @功能描述 家具店铺：根据店铺id更新店铺财务信息
     */
    @ApiOperation(value = "根据店铺id更新店铺财务信息", notes = "根据店铺id更新店铺财务信息")
    @RequestMapping(value = "/updateShopFinanceMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopFinanceMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopFinanceMessage[根据店铺id更新店铺财务信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺财务信息
                stateCode = furnitureShopApiService.updateShopFinanceMessage(json) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopFinanceMessage[根据店铺id更新店铺财务信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopFinanceMessage[根据店铺id更新店铺财务信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             cityId 城市id
     *             cityAnalysis 城市分析
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id更新城市分析
     */
    @ApiOperation(value = "根据店铺id更新城市分析", notes = "根据店铺id更新城市分析")
    @RequestMapping(value = "/updateShopCityMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopCityMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopCityMessage[根据店铺id更新城市分析]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                stateCode = furnitureShopApiService.updateShopCityMessage(json) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopCityMessage[根据店铺id更新城市分析]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopCityMessage[根据店铺id更新城市分析]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             cityId 城市id
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家具店铺：根据店铺id以及城市id获取城市分析
     */
    @ApiOperation(value = "根据店铺id以及城市id获取城市分析", notes = "根据店铺id以及城市id获取城市分析")
    @RequestMapping(value = "/getShopCityMessage", method = RequestMethod.POST)
    @ResponseBody
    public R getShopCityMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("getShopCityMessage[根据店铺id以及城市id获取城市分析]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                stateCode = furnitureShopApiService.getShopCityMessage(json).size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getShopCityMessage[根据店铺id以及城市id获取城市分析]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getShopCityMessage[根据店铺id以及城市id获取城市分析]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json
     * @return 影响记录条数
     * @创建人 岳耀栎
     * @创建时间 2019-03-06
     * @功能描述 家弱公用：获取城列表
     */
    @ApiOperation(value = "获取城列表", notes = "获取城列表")
    @RequestMapping(value = "/listCity", method = RequestMethod.POST)
    @ResponseBody
    public R listCity(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listCity[获取城列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listCity(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listCity[获取城列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listCity[获取城列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json cityId 城id
     * @return 家具店铺模板列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-07
     * @功能描述 家具店铺：根据城id获取该城覆盖的家具店铺模板列表
     */
    @ApiOperation(value = "根据城id获取该城覆盖的家具店铺模板列表", notes = "根据城id获取该城覆盖的家具店铺模板列表")
    @RequestMapping(value = "/listShopTemplateByCityId", method = RequestMethod.POST)
    @ResponseBody
    public R listShopTemplateByCityId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopTemplateByCityId[根据城id获取该城覆盖的家具店铺模板列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listShopTemplateByCityId(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopTemplateByCityId[根据城id获取该城覆盖的家具店铺模板列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopTemplateByCityId[根据城id获取该城覆盖的家具店铺模板列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json type 产品类型 0：家具 1：弱电
     *             shopId 店铺id
     *             cityId 城id
     * @return 产品及产品分类列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-09
     * @功能描述 家具店铺：根据店铺及店铺类型获取产品及产品分类列表
     */
    @ApiOperation(value = "根据店铺及店铺类型获取产品及产品分类列表", notes = "根据店铺及店铺类型获取产品及产品分类列表")
    @RequestMapping(value = "/listProductAndSubjectInfoByShopType", method = RequestMethod.POST)
    @ResponseBody
    public R listProductAndSubjectInfoByShop(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listProductAndSubjectInfoByShopType[根据店铺及店铺类型获取产品及产品分类列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listProductAndSubjectInfoByShopType(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listProductAndSubjectInfoByShopType[根据店铺及店铺类型获取产品及产品分类列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductAndSubjectInfoByShopType[根据店铺及店铺类型获取产品及产品分类列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json type 产品类型 0：家具 1：弱电
     *             shopId 店铺id
     *             shopType 0：店铺 1：店铺模板
     * @return 当前店铺选中的产品类别及产品信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息
     */
    @ApiOperation(value = "根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息", notes = "根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息")
    @RequestMapping(value = "/listProductAndSubjectInfoByShopIdAndShopType", method = RequestMethod.POST)
    @ResponseBody
    public R listProductAndSubjectInfoByShopIdAndShopType(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listProductAndSubjectInfoByShopIdAndShopType[根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listProductAndSubjectInfoByShopIdAndShopType(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listProductAndSubjectInfoByShopIdAndShopType[根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductAndSubjectInfoByShopIdAndShopType[根据店铺id和店铺类型获取当前店铺选中的产品类别及产品信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json type 产品类型 0：家具 1：弱电
     *             shopId 店铺id
     *             shopType 0：店铺 1：店铺模板
     *             categoryCode 类别编号
     * @return 获取当前店铺选中指定类别下的产品信息
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息
     */
    @ApiOperation(value = "根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息", notes = "根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息")
    @RequestMapping(value = "/listProductAndSubjectInfoByCategoryCode", method = RequestMethod.POST)
    @ResponseBody
    public R listProductAndSubjectInfoByCategoryCode(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listProductAndSubjectInfoByCategoryCode[根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listProductAndSubjectInfoByCategoryCode(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listProductAndSubjectInfoByCategoryCode[根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductAndSubjectInfoByCategoryCode[根据店铺id和店铺类型以及产品分类获取当前店铺选中指定类别下的产品信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }


    /**
     * @param json productCode 产品编号
     * @return 产品详情
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编码查询产品详情
     */
    @ApiOperation(value = "根据产品编码查询产品详情", notes = "根据产品编码查询产品详情")
    @RequestMapping(value = "/getProductInfo", method = RequestMethod.POST)
    @ResponseBody
    public R getProductInfo(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getProductInfo[根据产品编码查询产品详情]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.getProductInfo(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getProductInfo[根据产品编码查询产品详情]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getProductInfo[根据产品编码查询产品详情]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json productCode 产品编号
     * @return 产品详情
     * @创建人 岳耀栎
     * @创建时间 2019-03-10
     * @功能描述 家具店铺：根据产品编码查询产品详情
     */
    @ApiOperation(value = "根据产品编码查询产品详情", notes = "根据产品编码查询产品详情")
    @RequestMapping(value = "/getProductInfoFromProductFurniture", method = RequestMethod.POST)
    @ResponseBody
    public R getProductInfoFromProductFurniture(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getProductInfoFromProductFurniture[根据产品编码查询产品详情]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.getProductInfoFromProductFurniture(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getProductInfoFromProductFurniture[根据产品编码查询产品详情]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getProductInfoFromProductFurniture[根据产品编码查询产品详情]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             productCode 产品code
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-11
     * @功能描述 家具店铺：根据店铺id与店铺类型更新店铺包含产品与类别信息
     */
    @ApiOperation(value = "根据店铺id与店铺类型更新店铺包含产品与类别信息", notes = "根据店铺id与店铺类型更新店铺包含产品与类别信息")
    @RequestMapping(value = "/updateShopTypeAndProduct", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopTypeAndProduct(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("updateShopTypeAndProduct[根据店铺id与店铺类型更新店铺包含产品与类别信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                stateCode = furnitureShopApiService.updateShopTypeAndProduct(json) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopTypeAndProduct[根据店铺id与店铺类型更新店铺包含产品与类别信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopTypeAndProduct[根据店铺id与店铺类型更新店铺包含产品与类别信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 产品编号
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             productCode 产品code
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-11
     * @功能描述 家具店铺：根据产品编码、店铺id与店铺类型查询产品列表
     */
    @ApiOperation(value = "根据产品编码、店铺id与店铺类型查询产品列表", notes = "根据产品编码、店铺id与店铺类型查询产品列表")
    @RequestMapping(value = "/listShopProductByShopIdAndCategoryCode", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProductByShopIdAndCatehoryCode(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopProductByShopIdAndCategoryCode[根据产品编码、店铺id与店铺类型查询产品列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listShopProductByShopIdAndCategoryCode(json);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProductByShopIdAndCategoryCode[根据产品编码、店铺id与店铺类型查询产品列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProductByShopIdAndCategoryCode[根据产品编码、店铺id与店铺类型查询产品列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json shopId 店铺id
     *             shopType 店铺类型 0：店铺 1：店铺模板
     *             categoryCode 类别编码
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-12
     * @功能描述 家具店铺：根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表
     */
    @ApiOperation(value = "根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表", notes = "根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表")
    @RequestMapping(value = "/listCategoryByShopIdAndCategoryCode", method = RequestMethod.POST)
    @ResponseBody
    public R listCategoryByShopIdAndCategoryCode(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listCategoryByShopIdAndCategoryCode[根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.listCategoryByShopIdAndCategoryCode(params);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listCategoryByShopIdAndCategoryCode[根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listCategoryByShopIdAndCategoryCode[根据类别编码、店铺id与店铺类型查询当前店铺已选四级类别列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json categoryCode 类别编码
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码查询该分类下产品数量
     */
    @ApiOperation(value = "家具店铺：根据类别编码查询该分类下产品数量", notes = "家具店铺：根据类别编码查询该分类下产品数量")
    @RequestMapping(value = "/countProductFromCategory", method = RequestMethod.POST)
    @ResponseBody
    public R countProductFromCategory(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("countProductFromCategory[家具店铺：根据类别编码查询该分类下产品数量]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id更新店铺基础信息
                resultMap = furnitureShopApiService.countProductFromCategory(params);
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("countProductFromCategory[家具店铺：根据类别编码查询该分类下产品数量]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("countProductFromCategory[家具店铺：根据类别编码查询该分类下产品数量]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json categoryCode 类别编码
     *             shopId 店铺id
     *             technicsDesc 工艺描述
     *             technicsPrice 工艺价格
     *             technicsTag 工艺标签
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id更新该类别工艺信息
     */
    @ApiOperation(value = "家具店铺：根据类别编码及店铺id更新该类别工艺信息", notes = "家具店铺：根据类别编码及店铺id更新该类别工艺信息")
    @RequestMapping(value = "/updateCategoryTechnics", method = RequestMethod.POST)
    @ResponseBody
    public R updateCategoryTechnics(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("updateCategoryTechnics[家具店铺：根据类别编码及店铺id更新该类别工艺信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.updateCategoryTechnics(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateCategoryTechnics[家具店铺：根据类别编码及店铺id更新该类别工艺信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateCategoryTechnics[家具店铺：根据类别编码及店铺id更新该类别工艺信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json categoryCode 类别编码
     *             shopId 店铺id
     *             technicsDesc 工艺描述
     *             technicsPrice 工艺价格
     *             technicsTag 工艺标签
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id新增该类别工艺信息
     */
    @ApiOperation(value = "家具店铺：根据类别编码及店铺id新增该类别工艺信息", notes = "家具店铺：根据类别编码及店铺id新增该类别工艺信息")
    @RequestMapping(value = "/addCategoryTechnics", method = RequestMethod.POST)
    @ResponseBody
    public R addCategoryTechnics(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("addCategoryTechnics[家具店铺：根据类别编码及店铺id新增该类别工艺信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.addCategoryTechnics(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addCategoryTechnics[家具店铺：根据类别编码及店铺id新增该类别工艺信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addCategoryTechnics[家具店铺：根据类别编码及店铺id新增该类别工艺信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json categoryCode 类别编码
     *             shopId 店铺id
     * @return 当前店铺已选四级类别列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据类别编码及店铺id获取该类别工艺列表
     */
    @ApiOperation(value = "家具店铺：根据类别编码及店铺id获取该类别工艺列表", notes = "家具店铺：根据类别编码及店铺id获取该类别工艺列表")
    @RequestMapping(value = "/listCategoryTechnicsByShopIdAndCategoryCode", method = RequestMethod.POST)
    @ResponseBody
    public R listCategoryTechnicsByShopIdAndCategoryCode(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listCategoryTechnicsByShopIdAndCategoryCode[家具店铺：根据类别编码及店铺id获取该类别工艺列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureShopApiService.listCategoryTechnicsByShopIdAndCategoryCode(params);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listCategoryTechnicsByShopIdAndCategoryCode[家具店铺：根据类别编码及店铺id获取该类别工艺列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listCategoryTechnicsByShopIdAndCategoryCode[家具店铺：根据类别编码及店铺id获取该类别工艺列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json categoryCode 类别编码
     *             shopId 店铺id
     *             mealName 套餐名称
     *             mealPrice 套餐价格
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：上传套餐
     */
    @ApiOperation(value = "家具店铺：上传套餐", notes = "家具店铺：上传套餐")
    @RequestMapping(value = "/addShopMeal", method = RequestMethod.POST)
    @ResponseBody
    public R addShopMeal(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addShopMeal[家具店铺：上传套餐]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.addShopMeal(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addShopMeal[家具店铺：上传套餐]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addShopMeal[家具店铺：上传套餐]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json categoryCode 类别编码
     *             shopId 店铺id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据店铺id套餐列表
     */
    @ApiOperation(value = "家具店铺：根据店铺id套餐列表", notes = "家具店铺：根据店铺id套餐列表")
    @RequestMapping(value = "/listShopMealByShopId", method = RequestMethod.POST)
    @ResponseBody
    public R listShopMealByShopId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopMealByShopId[家具店铺：根据店铺id套餐列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureShopApiService.listShopMealByShopId(params);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopMealByShopId[家具店铺：根据店铺id套餐列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopMealByShopId[家具店铺：根据店铺id套餐列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json id 套餐id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据套餐id更新套餐
     */
    @ApiOperation(value = "家具店铺：根据套餐id更新套餐", notes = "家具店铺：根据套餐id更新套餐")
    @RequestMapping(value = "/updateShopMealByMealId", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopMealByMealId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("updateShopMealByMealId[家具店铺：根据套餐id更新套餐]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);

                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.updateShopMealByMealId(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopMealByMealId[家具店铺：根据套餐id更新套餐]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopMealByMealId[家具店铺：根据套餐id更新套餐]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }


    /**
     * @param json shopId 店铺id
     *             productCode 产品编号
     *             productPrice 产品价格
     *             productNum 产品数量
     *             userId 用户id
     * @return 根据店铺id套餐列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据shopId添加产品到购物车
     */
    @ApiOperation(value = "家具店铺：根据shopId添加产品到购物车", notes = "家具店铺：根据shopId添加产品到购物车")
    @RequestMapping(value = "/addShopCar", method = RequestMethod.POST)
    @ResponseBody
    public R addShopCar(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("addShopCar[家具店铺：根据shopId添加产品到购物车]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);

                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.addShopCar(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addShopCar[家具店铺：根据shopId添加产品到购物车]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addShopCar[家具店铺：根据shopId添加产品到购物车]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }


    /**
     * @param json shopId 店铺id
     * @return 铺id获取购物车列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据店铺id获取购物车列表
     */
    @ApiOperation(value = "家具店铺：根据店铺id获取购物车列表", notes = "家具店铺：根据店铺id获取购物车列表")
    @RequestMapping(value = "/listShopCarByShopId", method = RequestMethod.POST)
    @ResponseBody
    public R listShopCarByShopId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopCarByShopId[家具店铺：根据店铺id获取购物车列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureShopApiService.listShopCarByShopId(params);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopCarByShopId[家具店铺：根据店铺id获取购物车列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopCarByShopId[家具店铺：根据店铺id获取购物车列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json productCode 类别编码
     *             shopId 店铺id
     *             productModel 套餐名称
     *             productPrice 套餐价格
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-15
     * @功能描述 家具店铺：根据店铺id与产品型号更新产品价格
     */
    @ApiOperation(value = "家具店铺：根据店铺id与产品型号更新产品价格", notes = "家具店铺：根据店铺id与产品型号更新产品价格")
    @RequestMapping(value = "/updateProductPriceByShopIdAndProductModel", method = RequestMethod.POST)
    @ResponseBody
    public R updateProductPriceByShopIdAndProductModel(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateProductPriceByShopIdAndProductModel[家具店铺：根据店铺id与产品型号更新产品价格]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.updateProductPriceByShopIdAndProductModel(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateProductPriceByShopIdAndProductModel[家具店铺：根据店铺id与产品型号更新产品价格]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateProductPriceByShopIdAndProductModel[家具店铺：根据店铺id与产品型号更新产品价格]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }


    /**
     * @param json id 套餐id
     *             productCodes 产品编码
     * @return 铺id获取购物车列表
     * @创建人 岳耀栎
     * @创建时间 2019-03-13
     * @功能描述 家具店铺：根据套餐id或产品编码查询套餐内产品列表
     */
    @ApiOperation(value = "家具店铺：根据套餐id或产品编码查询套餐内产品列表", notes = "家具店铺：根据套餐id或产品编码查询套餐内产品列表")
    @RequestMapping(value = "/listProductByMealId", method = RequestMethod.POST)
    @ResponseBody
    public R listProductByMealId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listProductByMealId[家具店铺：根据套餐id或产品编码查询套餐内产品列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureShopApiService.listProductByMealId(params);
                //根据套餐id或产品编码查询套餐内产品列表
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listProductByMealId[家具店铺：根据套餐id或产品编码查询套餐内产品列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductByMealId[家具店铺：根据套餐id或产品编码查询套餐内产品列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json productCodes 产品编码
     *             mealId 套餐id
     *             mealName 套餐名称
     *             mealPrice 套餐价格
     *             mealDesc 套餐描述
     *             mealImg 套餐主图
     *             state 套餐状态
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-15
     * @功能描述 家具店铺：根据套餐id更新套餐信息
     */
    @ApiOperation(value = "家具店铺：根据套餐id更新套餐信息", notes = "家具店铺：根据套餐id更新套餐信息")
    @RequestMapping(value = "/updateShopMeal", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopMeal(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopMeal[家具店铺：根据套餐id更新套餐信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.updateShopMeal(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopMeal[家具店铺：根据套餐id更新套餐信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopMeal[家具店铺：根据套餐id更新套餐信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json productCode 产品编码
     *             mealId 套餐id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-16
     * @功能描述 家具店铺：根据套餐id与单品id删除套餐内指定单品
     */
    @ApiOperation(value = "家具店铺：根据套餐id更新套餐信息", notes = "家具店铺：根据套餐id更新套餐信息")
    @RequestMapping(value = "/deleteMealProduct", method = RequestMethod.POST)
    @ResponseBody
    public R deleteMealProduct(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("deleteMealProduct[家具店铺：根据套餐id更新套餐信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.deleteMealProduct(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("deleteMealProduct[家具店铺：根据套餐id更新套餐信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("deleteMealProduct[家具店铺：根据套餐id更新套餐信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             productCode 产品编码
     *             productParent 父级编码
     *             productName 产品名称
     *             productModel 产品类型
     *             productImage 产品主图
     *             productPrice 产品价格
     *             productExplain 产品特征
     *             productDesc 产品描述
     *             productPurpose 产品用途
     *             productKeys 产品关键词
     *             productNumber 产品数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-16
     * @功能描述 家具店铺：根据店铺id上传自定义产品
     */
    @ApiOperation(value = "家具店铺：根据店铺id上传自定义产品", notes = "家具店铺：根据店铺id上传自定义产品")
    @RequestMapping(value = "/addPrivateProduct", method = RequestMethod.POST)
    @ResponseBody
    public R addPrivateProduct(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addPrivateProduct[家具店铺：根据店铺id上传自定义产品]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = furnitureShopApiService.addPrivateProduct(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addPrivateProduct[家具店铺：根据店铺id上传自定义产品]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addPrivateProduct[家具店铺：根据店铺id上传自定义产品]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             productCode 产品编码
     *             productParent 父级编码
     *             productName 产品名称
     *             productModel 产品类型
     *             productImage 产品主图
     *             productPrice 产品价格
     *             productExplain 产品特征
     *             productDesc 产品描述
     *             productPurpose 产品用途
     *             productKeys 产品关键词
     *             productNumber 产品数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-16
     * @功能描述 家具店铺：根据店铺id查询自定产品列表
     */
    @ApiOperation(value = "家具店铺：根据店铺id查询自定产品列表", notes = "家具店铺：根据店铺id查询自定产品列表")
    @RequestMapping(value = "/listPrivateProduct", method = RequestMethod.POST)
    @ResponseBody
    public R listPrivateProduct(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listPrivateProduct[家具店铺：根据店铺id查询自定产品列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = furnitureShopApiService.listPrivateProduct(params);
                //根据类别编码及店铺id更新该类别工艺信息
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listPrivateProduct[家具店铺：根据店铺id查询自定产品列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listPrivateProduct[家具店铺：根据店铺id查询自定产品列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param json shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id查询店铺团队信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id查询店铺团队信息", notes = "家具店铺：根据店铺id查询店铺团队信息")
    @RequestMapping(value = "/getShopTeamMessage", method = RequestMethod.POST)
    @ResponseBody
    public R getShopTeamMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        Map<String, Object> resultMap = new HashMap<>();
        try {
            log.info("getShopTeamMessage[家具店铺：根据店铺id查询店铺团队信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id查询店铺团队信息
                resultMap = furnitureShopApiService.getShopTeamMessage(params);

                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("getShopTeamMessage[家具店铺：根据店铺id查询店铺团队信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("getShopTeamMessage[家具店铺：根据店铺id查询店铺团队信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }


    /**
     * @param json shopId 店铺id
     *             employeeId 用户id
     *             userName 用户姓名
     *             userSex 用户性别
     *             userRole 用户角色
     *             userPhone 用户手机号
     *             userAge 用户年龄
     *             headImg 用户头像
     *             HeadIDCardImg 用户身份证头像面
     *             EmblemIDCardImg 用户身份证国徽面
     *             userAddress 用户地址
     *             emergencyUserName 紧急联系人姓名
     *             emergencyUserPhone 紧急联系人手机号
     *             emergencyUserSex 紧急联系人性别
     *             emergencyUserRelationship 紧急联系人与用户关系
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id和用户id更新用户信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id和用户id更新用户信息", notes = "家具店铺：根据店铺id和用户id更新用户信息")
    @RequestMapping(value = "/updateEmployeeMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateEmployeeMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateEmployeeMessage[家具店铺：根据店铺id和用户id更新用户信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.updateEmployeeMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateEmployeeMessage[家具店铺：根据店铺id和用户id更新用户信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateEmployeeMessage[家具店铺：根据店铺id和用户id更新用户信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             employeeRole 用户角色
     *             employeeNumber 用户数量
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-19
     * @功能描述 家具店铺：根据店铺id和用户角色添加用户数量
     */
    @ApiOperation(value = "家具店铺：根据店铺id和用户角色添加用户数量", notes = "家具店铺：根据店铺id和用户角色添加用户数量")
    @RequestMapping(value = "/addEmployees", method = RequestMethod.POST)
    @ResponseBody
    public R addEmployees(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addEmployees[家具店铺：根据店铺id和用户角色添加用户数量]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.addEmployees(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addEmployees[家具店铺：根据店铺id和用户角色添加用户数量]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addEmployees[家具店铺：根据店铺id和用户角色添加用户数量]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             licenseImg 营业执照
     *             permitImg 开户许可证
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新营业执照信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id和用户角色添加用户数量", notes = "家具店铺：根据店铺id和用户角色添加用户数量")
    @RequestMapping(value = "/updateShopLicenseMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopLicenseMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopLicenseMessage[家具店铺：根据店铺id和用户角色添加用户数量]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.updateShopLicenseMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopLicenseMessage[家具店铺：根据店铺id和用户角色添加用户数量]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopLicenseMessage[家具店铺：根据店铺id和用户角色添加用户数量]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             imgPublicSeal 公章
     *             imgPrivateSeal 私章
     *             imgContractSeal 合同章
     *             imgPersonalSeal 个人章
     *             imgInvoiceSeal 发票专用章
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺印章信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id更新店铺印章信息", notes = "家具店铺：根据店铺id更新店铺印章信息")
    @RequestMapping(value = "/updateShopSealMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopSealMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopLicenseMessage[家具店铺：根据店铺id更新店铺印章信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.updateShopSealMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopSealMessage[家具店铺：根据店铺id更新店铺印章信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopSealMessage[家具店铺：根据店铺id更新店铺印章信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             messageMoney 信息费
     *             riskMoney 风险费
     *             managementMoney 管理费
     *             invoiceRate 税率
     *             privateAccount 对私账户
     *             publicAccount 对公账户
     *             finaceSeal 财务章
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺财务信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id更新店铺财务信息", notes = "家具店铺：根据店铺id更新店铺财务信息")
    @RequestMapping(value = "/updateShopFinaceMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopFinaceMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopFinaceMessage[家具店铺：根据店铺id更新店铺财务信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.updateShopFinaceMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopFinaceMessage[家具店铺：根据店铺id更新店铺财务信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopFinaceMessage[家具店铺：根据店铺id更新店铺财务信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             headImg 信息费
     *             HeadIDCardImg 风险费
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺加盟合同信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id更新店铺加盟合同信息", notes = "家具店铺：根据店铺id更新店铺加盟合同信息")
    @RequestMapping(value = "/updateShopJoinContractMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopJoinContractMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopJoinContractMessage[家具店铺：根据店铺id更新店铺加盟合同信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.updateShopJoinContractMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopJoinContractMessage[家具店铺：根据店铺id更新店铺加盟合同信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopJoinContractMessage[家具店铺：根据店铺id更新店铺加盟合同信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     *             houseImg 合同正本
     *             houseEnclosureImg 合同副本
     *             houseElseImg 合同其他
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-20
     * @功能描述 家具店铺：根据店铺id更新店铺房屋合同信息
     */
    @ApiOperation(value = "家具店铺：根据店铺id更新店铺房屋合同信息", notes = "家具店铺：根据店铺id更新店铺房屋合同信息")
    @RequestMapping(value = "/updateShopHouseContractMessage", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopHouseContractMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopHouseContractMessage[家具店铺：根据店铺id更新店铺房屋合同信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                stateCode = furnitureShopApiService.updateShopHouseContractMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopHouseContractMessage[家具店铺：根据店铺id更新店铺房屋合同信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopHouseContractMessage[家具店铺：根据店铺id更新店铺房屋合同信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-25
     * @功能描述 家具店铺：根据店铺id查询店铺擅长风格
     */
    @ApiOperation(value = "家具店铺：根据店铺id查询店铺擅长风格", notes = "家具店铺：根据店铺id查询店铺擅长风格")
    @RequestMapping(value = "/listShopStyleById", method = RequestMethod.POST)
    @ResponseBody
    public R listShopStyleById(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopStyleById[家具店铺：根据店铺id查询店铺擅长风格]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopStyleById(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopStyleById[家具店铺：根据店铺id查询店铺擅长风格]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopStyleById[家具店铺：根据店铺id查询店铺擅长风格]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 获取店铺类型下辅料分类
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下辅料分类
     */
    @ApiOperation(value = "获取店铺类型下辅料分类", notes = "获取店铺类型下辅料分类")
    @RequestMapping(value = "/listShopSubjectAuxiliary", method = RequestMethod.POST)
    @ResponseBody
    public R listShopSubjectAuxiliary(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopSubjectAuxiliary[获取店铺类型下辅料分类]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopSubjectAuxiliary(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopSubjectAuxiliary[获取店铺类型下辅料分类]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopSubjectAuxiliary[获取店铺类型下辅料分类]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺关联辅料类
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "编辑店铺关联辅料类", notes = "编辑店铺关联辅料类")
    @RequestMapping(value = "/edit_ShopSubjectAuxiliaryMapping", method = RequestMethod.POST)
    @ResponseBody
    public R edit_ShopSubjectAuxiliaryMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("edit_ShopSubjectAuxiliaryMapping[编辑店铺类型下的产品类型和类目之间的关系]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    if (i == 0) {
                        furnitureShopApiService.delete_ShopSubjectAuxiliaryMapping(params.get(i));
                    }
                    stateCode = furnitureShopApiService.edit_ShopSubjectAuxiliaryMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("edit_ShopSubjectAuxiliaryMapping[编辑店铺类型下的产品类型和类目之间的关系]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("edit_ShopSubjectAuxiliaryMapping[编辑店铺类型下的产品类型和类目之间的关系]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺下工艺类关系
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "编辑店铺下工艺类关系", notes = "编辑店铺下工艺类关系")
    @RequestMapping(value = "/edit_ShopSubjectTechnologyMapping", method = RequestMethod.POST)
    @ResponseBody
    public R edit_ShopSubjectTechnologyMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("edit_ShopSubjectTechnologyMapping[编辑店铺下工艺类关系]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    if (i == 0) {
                        furnitureShopApiService.delete_ShopSubjectTechnologyMapping(params.get(i));
                    }
                    stateCode = furnitureShopApiService.edit_ShopSubjectTechnologyMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("edit_ShopSubjectTechnologyMapping[编辑店铺下工艺类关系]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("edit_ShopSubjectTechnologyMapping[编辑店铺下工艺类关系]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型关联的产品对应的辅料
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "编辑店铺类型关联的产品对应的辅料", notes = "编辑店铺类型关联的产品对应的辅料")
    @RequestMapping(value = "/edit_ShopProductAuxiliaryMapping", method = RequestMethod.POST)
    @ResponseBody
    public R edit_ShopProductAuxiliaryMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("edit_ShopProductAuxiliaryMapping[编辑店铺类型关联的产品对应的辅料]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    stateCode = furnitureShopApiService.edit_ShopProductAuxiliaryMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("edit_ShopProductAuxiliaryMapping[编辑店铺类型关联的产品对应的辅料]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("edit_ShopProductAuxiliaryMapping[编辑店铺类型关联的产品对应的辅料]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型关联工艺关系
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "编辑店铺类型关联工艺关系", notes = "编辑店铺类型关联工艺关系")
    @RequestMapping(value = "/edit_ShopProductTechnologyMapping", method = RequestMethod.POST)
    @ResponseBody
    public R edit_ShopProductTechnologyMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("edit_ShopProductTechnologyMapping[编辑店铺类型关联工艺关系]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    stateCode = furnitureShopApiService.edit_ShopProductTechnologyMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("edit_ShopProductTechnologyMapping[编辑店铺类型关联工艺关系]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("edit_ShopProductTechnologyMapping[编辑店铺类型关联工艺关系]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 编辑店铺类型下的产品类型和类目之间的关系
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "编辑店铺类型下的产品类型和类目之间的关系", notes = "编辑店铺类型下的产品类型和类目之间的关系")
    @RequestMapping(value = "/edit_ShopSubjectMapping", method = RequestMethod.POST)
    @ResponseBody
    public R edit_ShopSubjectMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("edit_ShopSubjectMapping[编辑店铺类型下的产品类型和类目之间的关系]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    if (i == 0) {
                        furnitureShopApiService.edit_ShopSubjectMapping(params.get(i));
                    }
                    stateCode = furnitureShopApiService.edit_ShopSubjectMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("edit_ShopSubjectMapping[编辑店铺类型下的产品类型和类目之间的关系]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("edit_ShopSubjectMapping[编辑店铺类型下的产品类型和类目之间的关系]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json
     * @return 获取店铺类型下产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下产品
     */
    @ApiOperation(value = "获取店铺类型下产品", notes = "获取店铺类型下产品")
    @RequestMapping(value = "/listShopProduct", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProduct(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopProduct[获取店铺类型下产品]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopProduct(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProduct[获取店铺类型下产品]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProduct[获取店铺类型下产品]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 获取店铺类型下辅料产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下辅料产品
     */
    @ApiOperation(value = "获取店铺类型下辅料产品", notes = "获取店铺类型下辅料产品")
    @RequestMapping(value = "/listShopProductAuxiliary", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProductAuxiliary(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopProductAuxiliary[获取店铺类型下辅料产品]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopProductAuxiliary(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProductAuxiliary[获取店铺类型下辅料产品]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProductAuxiliary[获取店铺类型下辅料产品]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 获取店铺类型下产品工艺
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取店铺类型下产品工艺
     */
    @ApiOperation(value = "获取店铺类型下产品工艺", notes = "获取店铺类型下产品工艺")
    @RequestMapping(value = "/listShopProductTechnology", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProductTechnology(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopProductTechnology[获取店铺类型下产品工艺]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopProductTechnology(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProductTechnology[获取店铺类型下产品工艺]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProductTechnology[获取店铺类型下产品工艺]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 获取类型下辅料产品
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取类型下辅料产品
     */
    @ApiOperation(value = "获取类型下辅料产品", notes = "获取类型下辅料产品")
    @RequestMapping(value = "/listProductAuxiliary", method = RequestMethod.POST)
    @ResponseBody
    public R listProductAuxiliary(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listProductAuxiliary[获取类型下辅料产品]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listProductAuxiliary(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listProductAuxiliary[获取类型下辅料产品]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductAuxiliary[获取类型下辅料产品]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 获取类型下产品工艺
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 获取类型下产品工艺
     */
    @ApiOperation(value = "获取类型下产品工艺", notes = "获取类型下产品工艺")
    @RequestMapping(value = "/listProductTechnology", method = RequestMethod.POST)
    @ResponseBody
    public R listProductTechnology(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listProductTechnology[获取类型下产品工艺]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listProductTechnology(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listProductTechnology[获取类型下产品工艺]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductTechnology[获取类型下产品工艺]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺类型关联的产品对应的辅料
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "删除店铺类型关联的产品对应的辅料", notes = "删除店铺类型关联的产品对应的辅料")
    @RequestMapping(value = "/del_ShopProductAuxiliaryMapping", method = RequestMethod.POST)
    @ResponseBody
    public R del_ShopProductAuxiliaryMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("del_ShopProductAuxiliaryMapping[删除店铺类型关联的产品对应的辅料]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    if (i == 0) {
                        stateCode =  furnitureShopApiService.delete_ShopProductAuxiliaryMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                    }
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("del_ShopProductAuxiliaryMapping[删除店铺类型关联的产品对应的辅料]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("del_ShopProductAuxiliaryMapping[删除店铺类型关联的产品对应的辅料]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 删除店铺类型关联工艺关系
     * @param json
     * @return 空对象
     */
    @ApiOperation(value = "删除店铺类型关联工艺关系", notes = "删除店铺类型关联工艺关系")
    @RequestMapping(value = "/del_ShopProductTechnologyMapping", method = RequestMethod.POST)
    @ResponseBody
    public R del_ShopProductTechnologyMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("del_ShopProductTechnologyMapping[删除店铺类型关联工艺关系]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                String str = json.getString("jsonStr");
                List<Map<String,Object>> params = JSONArray.fromObject(str);
                for(int i = 0; i < params.size(); i++) {
                    if (i == 0) {
                        stateCode =  furnitureShopApiService.delete_ShopProductTechnologyMapping(params.get(i)) > 0 ? Constant.Success : Constant.Parametersformaterror;
                        break;
                    }
                }
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("del_ShopProductTechnologyMapping[删除店铺类型关联工艺关系]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("del_ShopProductTechnologyMapping[删除店铺类型关联工艺关系]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json
     * @return 店铺产品工艺类别映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品工艺类别映射关系列表
     */
    @ApiOperation(value = "店铺产品工艺类别映射关系列表", notes = "店铺产品工艺类别映射关系列表")
    @RequestMapping(value = "/listShopSubjectTechnologyMapping", method = RequestMethod.POST)
    @ResponseBody
    public R listShopSubjectTechnologyMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopSubjectTechnologyMapping[店铺产品工艺类别映射关系列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopSubjectTechnologyMapping(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopSubjectTechnologyMapping[店铺产品工艺类别映射关系列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listProductTechnology[店铺产品工艺类别映射关系列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 店铺产品辅料类别映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品辅料类别映射关系列表
     */
    @ApiOperation(value = "店铺产品辅料类别映射关系列表", notes = "店铺产品辅料类别映射关系列表")
    @RequestMapping(value = "/listShopSubjectAuxiliaryMapping", method = RequestMethod.POST)
    @ResponseBody
    public R listShopSubjectAuxiliaryMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopSubjectAuxiliaryMapping[店铺产品辅料类别映射关系列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopSubjectAuxiliaryMapping(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopSubjectAuxiliaryMapping[店铺产品辅料类别映射关系列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopSubjectAuxiliaryMapping[店铺产品辅料类别映射关系列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 店铺产品辅料产品映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品辅料产品映射关系列表
     */
    @ApiOperation(value = "店铺产品辅料产品映射关系列表", notes = "店铺产品辅料产品映射关系列表")
    @RequestMapping(value = "/listShopProductAuxiliaryMapping", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProductAuxiliaryMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopSubjectAuxiliaryMapping[店铺产品辅料产品映射关系列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopProductAuxiliaryMapping(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProductAuxiliaryMapping[店铺产品辅料产品映射关系列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProductAuxiliaryMapping[店铺产品辅料产品映射关系列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @param json
     * @return 店铺产品工艺产品映射关系列表
     * @创建人 赵伟
     * @创建时间 2019-03-25
     * @功能描述 店铺产品工艺产品映射关系列表
     */
    @ApiOperation(value = "店铺产品工艺产品映射关系列表", notes = "店铺产品工艺产品映射关系列表")
    @RequestMapping(value = "/listShopProductTechnologyMapping", method = RequestMethod.POST)
    @ResponseBody
    public R listShopProductTechnologyMapping(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String,Object>> resultMap = new ArrayList<>();
        try {
            log.info("listShopProductTechnologyMapping[店铺产品工艺产品映射关系列表]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id和用户id更新用户信息
                resultMap = furnitureShopApiService.listShopProductTechnologyMapping(params);
                stateCode =  resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listShopProductTechnologyMapping[店铺产品工艺产品映射关系列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listShopProductTechnologyMapping[店铺产品工艺产品映射关系列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019-04-16
     * @功能描述 上传加盟商加盟费及风险押金信息
     * @param json  money:缴纳金额
     *              shopShellId 店壳id
     *              orgId 公司id
     *              payTime:缴纳日期
     *              payUser:上传人
     *              payImg:缴纳凭证
     *              type:上传类型 1：加盟费 2：风险押金
     * @return 影响记录数
     */
    @ApiOperation(value = "上传加盟商加盟费及风险押金信息", notes = "上传加盟商加盟费及风险押金信息")
    @RequestMapping(value = "/addFundMessage", method = RequestMethod.POST)
    @ResponseBody
    public R addFundMessage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("addFundMessage[上传加盟商加盟费及风险押金信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String,Object> params = JSONObject.fromObject(json);
                stateCode =  furnitureShopApiService.addFundMessage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("addFundMessage[上传加盟商加盟费及风险押金信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("addFundMessage[上传加盟商加盟费及风险押金信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @创建人 岳耀栎
     * @创建时间 2019-04-16
     * @功能描述 获取加盟商加盟费及风险押金信息
     * @param json shopId 店壳id
     * @return 获取加盟商加盟费及风险押金信息
     */
    @ApiOperation(value = "获取加盟商加盟费及风险押金信息", notes = "获取加盟商加盟费及风险押金信息")
    @RequestMapping(value = "/listBusinessMoney", method = RequestMethod.POST)
    @ResponseBody
    public R listBusinessMoney(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("listBusinessMoney[获取加盟商加盟费及风险押金信息]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String,Object> params = JSONObject.fromObject(json);
                resultMap = furnitureShopApiService.listBusinessMoney(params);
                stateCode = resultMap.size() >= 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("listBusinessMoney[获取加盟商加盟费及风险押金信息]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("listBusinessMoney[获取加盟商加盟费及风险押金信息]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }
}
