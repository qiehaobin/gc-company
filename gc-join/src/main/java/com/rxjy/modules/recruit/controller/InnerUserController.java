package com.rxjy.modules.recruit.controller;

import com.rxjy.common.utils.R;
import com.rxjy.modules.recruit.service.PostStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /*
 * 作者 chengpunan
 * //TODO $
 * 2018年12月25日18:33:09$ $
 * $
 * $
 **/
@RestController
@RequestMapping("/innerUser")
@Api(tags="内部人事用户")
public class InnerUserController {
    @Autowired
    private PostStandardService postStandardService;
    /**
     * 根据条件得到集团工程人事人的板块列表
     * @param areaId 地区
     * @param search 查询条件
     * @param userType 人员类型 0 全部 1监理 2工程经理 3行政主管
     * @param visitType 回访类型 0 周回访 1月回访
     * @param isGroup  访问人类型  1集团 2地方 currentUser.getUserAreaID() == 39 ? 1 : 2;
     * @return List<InternalPersonnelModelView>
     */

    @ResponseBody
    @PostMapping("/getInternalUserList")
    @ApiOperation(value="获取用户信息",tags={"获取用户信息copy"},notes="注意问题点")
    public R getInternalUserList(@ApiParam(name="areaId",value="地区id") String areaId,
                                 @ApiParam(name="userType",value="人员类型 0 全部 1监理 2工程经理 3行政主管") String userType,
                                 @ApiParam(name="visitType",value="回访类型 0 周回访 1月回访") String visitType,
                                 @ApiParam(name="isGroup",value="访问人类型  1集团 2地方 currentUser.getUserAreaID() == 39 ? 1 : 2;",defaultValue = "") String isGroup,
                                 @ApiParam(name="search",value="查询条件") String search) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("areaId",areaId);
        params.put("search",search);
        params.put("userType",userType);
        params.put("visitType",visitType);
        params.put("isGroup",isGroup);
        System.out.println(params);
        List<Map<String,String>> userList =  postStandardService.getInternalUserList(params);
        return R.ok().put("userList",userList);
    }
    /**
     *  内部人事一段导航列表 新sql
     * @return
     */
    @RequestMapping("/getInternalUserListByCityId")
    public R getInternalUserListByCityId() {
        List<Map<String,String>> userList = postStandardService.getInternalUserListByCityId();
        return R.ok().put("userList",userList);
    }
}
