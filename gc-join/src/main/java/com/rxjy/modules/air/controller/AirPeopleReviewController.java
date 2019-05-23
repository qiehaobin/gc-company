/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.controller;

import com.rxjy.common.utils.R;
import com.rxjy.modules.air.entity.AirPeopleReview;
import com.rxjy.modules.air.service.AirPeopleReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户考察表Controller
 * @author xsk
 * @version 2019-03-15
 */
@RestController
@RequestMapping(value = "air/airPeopleReview")
public class AirPeopleReviewController{

	@Autowired
	private AirPeopleReviewService getPeopleReview;

    /**
     * 获取用户考察信息
     * @param userID
     * @return
     */
	@RequestMapping("/getPeopleReview")
	public R getPeopleReview(Integer userID){
	    return getPeopleReview.getPeopleReview(userID);
    }

    /**
     * 修改用户视察信息
     * @param peopleReview
     * @return
     */
    @RequestMapping("/updatePeopleReview")
    public R updatePeopleReview(AirPeopleReview peopleReview){
	    return getPeopleReview.updatePeopleReview(peopleReview);
    }

}