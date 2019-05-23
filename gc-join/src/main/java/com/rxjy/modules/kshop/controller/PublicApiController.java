package com.rxjy.modules.kshop.controller;

import com.rxjy.modules.kshop.service.PublicApiService;
import com.rxjy.modules.kshop.common.Constant;
import com.rxjy.modules.kshop.common.R;
import com.rxjy.modules.kshop.common.ToolUtil;
import com.rxjy.modules.kshop.common.MD5Demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @创建人 岳耀栎
 * @创建时间 2019/03/25
 */
@Api(description = "家弱公用API接口")
@RestController
@RequestMapping("/kshop/Public")
@CrossOrigin
public class PublicApiController {

    private static final Logger log = LoggerFactory.getLogger("API");

    @Autowired
    private PublicApiService publicApiService;

    /**
     * @return 验证信息后跳转对应的请求
     * @创建人 岳耀栎
     * @创建时间 2018/11/09
     * @功能描述 家具筹备：登录验证
     */
    @ApiOperation(value = "登录验证", notes = "登录验证")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public R getUserInfo(@RequestBody JSONObject jsonObject) {
        Map<String,Object> params = JSONObject.fromObject(jsonObject);
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        //根据加盟商账号查询加盟商信息
        log.info("getUserInfo[登录验证]，进入方法，参数：" + jsonObject);
        //params.put("password", MD5Demo.md5(((JSONObject) params).getString("password")));
        Map<String, Object> resultMap = publicApiService.getUserInfo(params);
//        System.out.println(resultMap.isEmpty());
        log.info("getUserInfo[登录结果]，返回结果，结果：" + resultMap);
        if(null != resultMap){
            Integer cityId = 0;
            if(null != resultMap.get("cityid")){
                cityId = Integer.parseInt(resultMap.get("cityid").toString());
            }
            resultMap.put("u_diqu",cityId);
            resultMap.put("dq_name",resultMap.get("dq_name").toString());
            resultMap.put("u_kahao",resultMap.get("login_code").toString());
            resultMap.put("xinming",resultMap.get("airPeopleName").toString());
            resultMap.put("shopId",resultMap.get("shell_id").toString());
            stateCode = Constant.Success;
        }
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body",resultMap);
    }



//    /**
//     * @创建人 岳耀栎
//     * @创建时间 2019/03/25
//     * @功能描述 家弱公用：获取用户详细信息
//     * @params userCard 用户卡号
//     *         password 用户密码
//     *         roleType 登录类型 1：家具 2：弱电
//     * @return 用户信息
//     */
//    @ApiOperation(value = "获取用户详细信息", notes = "获取用户详细信息")
//    @RequestMapping(value = "/getUserInfoByRole", method = RequestMethod.GET)
//    public JSONObject getUserInfoByRole(String jwt,HttpServletResponse response) {
//        String body = HttpUtil.get("https://zaapi.rxjy.com/api/login/getUserInfo?message=" + jwt);
//        JSONObject json = JSONObject.fromObject(JSONObject.fromObject(body).getString("Body"));
//        if (json != null && json.size() > 0) {
//            String result = null;
//            try {
//                result = URLEncoder.encode(json.toString(), "UTF-8").toString();
//            } catch (UnsupportedEncodingException e) {
//                return json;
//            }
//            Cookie cook = new Cookie("userInfo", result);
//            cook.setMaxAge(1 * 60 * 30);
//            response.addCookie(cook);
//            return json;
//        } else {
//            return json;
//        }
//    }


    /**
     * @param json shopId 店铺id
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-26
     * @功能描述 家具店铺：根据店铺id更新擅长风格
     */
    @ApiOperation(value = "家具店铺：根据店铺id更新擅长风格", notes = "家具店铺：根据店铺id更新擅长风格")
    @RequestMapping(value = "/updateShopStyleById", method = RequestMethod.POST)
    @ResponseBody
    public R updateShopStyleById(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateShopStyleById[家具店铺：根据店铺id更新擅长风格]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id更新擅长风格
                stateCode =  publicApiService.updateShopStyleById(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateShopStyleById[家具店铺：根据店铺id更新擅长风格]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateShopStyleById[家具店铺：根据店铺id更新擅长风格]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }

    /**
     * @param json orgId 公司id
     *             rwdid 项目单号
     * @return 影响记录数
     * @创建人 岳耀栎
     * @创建时间 2019-03-26
     * @功能描述 家具店铺：项目接单
     */
    @ApiOperation(value = "家具店铺：项目接单", notes = "家具店铺：项目接单")
    @RequestMapping(value = "/updateOrderByOrgId", method = RequestMethod.POST)
    @ResponseBody
    public R updateOrderByOrgId(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("updateOrderByOrgId[家具店铺：根据店铺id更新擅长风格]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                //根据店铺id更新擅长风格
                stateCode =  publicApiService.updateOrderByOrgId(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("updateOrderByOrgId[家具店铺：根据店铺id更新擅长风格]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("updateOrderByOrgId[家具店铺：根据店铺id更新擅长风格]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }


    public static JSONObject main(String[] args){
        String a =  "";
        return JSONObject.fromObject("");
    }
}
