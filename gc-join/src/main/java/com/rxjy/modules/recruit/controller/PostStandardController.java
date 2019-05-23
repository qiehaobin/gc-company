package com.rxjy.modules.recruit.controller;

import com.rxjy.common.utils.R;
import com.rxjy.common.utils.StringUtils;
import com.rxjy.modules.recruit.entity.PostStandardEntity;
import com.rxjy.modules.recruit.service.PostStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 岗位标准表
 *
 * @author kami
 * @email zhangqm@rxjy.com
 * @date 2018-11-18 11:22:54
 */
@RestController
@RequestMapping("recruit/postStandard")
public class PostStandardController {
    @Autowired
    private PostStandardService postStandardService;

    @ModelAttribute
    public PostStandardEntity get(@RequestParam(required=false) String id) {
        PostStandardEntity entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = postStandardService.selectById(id);
        }
        if (entity == null){
            entity = new PostStandardEntity();
        }
        return entity;
    }

    /**
     * 招聘-标准首页
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView corporationItem(ModelAndView modelAndView){
        modelAndView.setViewName("recruit/index.html");
        return modelAndView;
    }

    /**
     * 查询一段列表
     */
    @RequestMapping("/list")
    public R list(PostStandardEntity postStandard){
        postStandard.setDelFlag("0");
        List<PostStandardEntity> list = postStandardService.findList(postStandard);
        return R.ok().put("list", list);
    }


    /**
     * 查询单个标准信息
     * @param id 主键id
     * @return
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
        PostStandardEntity postStandard = postStandardService.selectById(id);
        return R.ok().put("postStandard", postStandard);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save")
    public R save(PostStandardEntity postStandard){
        postStandard.setDelFlag("0");
        List<PostStandardEntity> list = postStandardService.findList(postStandard);
        if(list.size()==0){
            postStandard.setCreateDate(new Date());
            postStandard.setUpdateDate(new Date());
            postStandardService.insert(postStandard);
            return R.ok();
        }else {
            return R.error("此类型招聘已经添加，请勿重复添加！");
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(PostStandardEntity postStandard){
        postStandard.setUpdateDate(new Date());
        postStandardService.updateById(postStandard);
        return R.ok();
    }


    /**
     *
     *  翻版 人事
     */





    /**
     * 根据条件得到集团工程人事人的板块列表
     * @param areaId 地区
     * @param search 查询条件
     * @param userType 人员类型 0 全部 1监理 2工程经理 3行政主管
     * @param visitType 回访类型 0 周回访 1月回访
     * @param isGroup  访问人类型  1集团 2地方 currentUser.getUserAreaID() == 39 ? 1 : 2;
     * @return List<InternalPersonnelModelView>
     */
    @RequestMapping("/getInternalUserList")
    public R getInternalUserList(Map<String, Object> params) {
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
