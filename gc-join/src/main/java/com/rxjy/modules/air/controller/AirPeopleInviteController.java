/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.controller;

import com.rxjy.common.utils.R;
import com.rxjy.modules.air.entity.AirPeopleInvite;
import com.rxjy.modules.air.entity.AirPeopleReview;
import com.rxjy.modules.air.service.AirPeopleInviteService;
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
@RequestMapping(value = "air/airPeopleInvite")
public class AirPeopleInviteController {

	@Autowired
	private AirPeopleInviteService peopleInviteService;

    /**
     * 获取用户邀约信息
     * @param userID
     * @return
     */
	@RequestMapping("/getPeopleInvite")
	public R getPeopleInvite(Integer userID){
	    return peopleInviteService.getPeopleInvite(userID);
    }

    /**
     * 修改用户邀约信息
     * @param peopleInvite
     * @return
     */
    @RequestMapping("/updatePeopleInvite")
    public R updatePeopleInvite(AirPeopleInvite peopleInvite){
	    return peopleInviteService.updatePeopleInvite(peopleInvite);
    }

}