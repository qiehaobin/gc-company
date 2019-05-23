package com.rxjy.modules.kshop.controller;

import com.rxjy.modules.kshop.service.TrainStageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.rxjy.modules.kshop.common.Constant;
import com.rxjy.modules.kshop.common.R;
import com.rxjy.modules.kshop.common.ToolUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵伟
 * @create 2019-03-01 15：:1
 * 注解简介：
 * 1：@CrossOrigin 允许跨域访问 springMVC的版本要在4.2及以上
 * 2：@RestController  注解相当于@ResponseBody ＋ @Controller合在一起的作用，
 * 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
 * 配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 */
@Api(description = "店铺培训模版")
@RestController
@RequestMapping("/api/WeakCurrentModel")
@CrossOrigin
public class TrainCotroller {
    @Autowired
    private TrainStageService trainStageService;

    private static final Logger log = LoggerFactory.getLogger("API");

    /**
     * @param json T_ID
     *             ParentID
     * @return 当前店铺应该生成的培训项
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 查询店铺培训业务、系统、财务
     */
    @ApiOperation(value = "店铺培训阶段列表", notes = "店铺培训阶段列表")
    @RequestMapping(value = "/list_R_TrainStage", method = RequestMethod.POST)
    @ResponseBody
    public R list_R_TrainStage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        List<Map<String, Object>> resultMap = new ArrayList<>();
        try {
            log.info("list_R_TrainStage[店铺培训阶段列表]，进入方法，参数："+json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                resultMap = trainStageService.list_R_TrainStage(params);
                for (int i = 0; i < resultMap.size(); i++) {
                    Map<String, Object> params1 = new HashMap<>();
                    params1.put("T_ParentID1", resultMap.get(i).get("T_ID1"));
                    params1.put("T_StoreCode", resultMap.get(i).get("T_StoreCode"));
                    resultMap.get(i).put("train", trainStageService.list_R_TrainStage(params1));
                }
                stateCode = resultMap.size() > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("list_R_TrainStage[店铺培训阶段列表]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("list_R_TrainStage[店铺培训阶段列表]End:");
        return new R(stateCode, Constant.returnResult(stateCode)).put("Body", resultMap);
    }

    /**
     * @param
     * @return 空对象
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 更新店铺培训阶段
     */
    @ApiOperation(value = "更新店铺培训阶段", notes = "更新店铺培训阶段")
    @RequestMapping(value = "/update_R_TrainStage", method = RequestMethod.POST)
    @ResponseBody
    public R update_R_TrainStage(@RequestBody JSONObject json) {
        //默认请求失败
        int stateCode = Constant.Unknownerror;
        try {
            log.info("create_R_Store[更新店铺培训阶段]，进入方法，参数：" + json);
            if (ToolUtil.strNotIsEmpty(json)) {
                Map<String, Object> params = JSONObject.fromObject(json);
                stateCode = trainStageService.update_R_TrainStage(params) > 0 ? Constant.Success : Constant.Parametersformaterror;
            } else {
                stateCode = Constant.Invalidparameter;
            }
        } catch (Exception e) {
            stateCode = Constant.Unknownerror;
            log.info("create_R_Store[更新店铺培训阶段]异常信息:" + e);
        }
        if (stateCode > 0) {
            log.info("执行失败:" + Constant.returnResult(stateCode));
        }
        log.info("create_R_Store[更新店铺培训阶段]End:");
        return new R(stateCode, Constant.returnResult(stateCode));
    }
}
