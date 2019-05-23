/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.controller;

import com.rxjy.common.utils.R;
import com.rxjy.modules.air.entity.AirPeopleConsult;
import com.rxjy.modules.air.service.AirPeopleConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户咨询表Controller
 * @author xsk
 * @version 2019-03-15
 */
@RestController
@RequestMapping(value = "air/airPeopleConsult")
public class AirPeopleConsultController{

	@Autowired
	private AirPeopleConsultService airPeopleConsultService;


	@RequestMapping("/getPeopleConsult")
	public R getPeopleConsult(Integer userID){
        return airPeopleConsultService.getPeopleConsult(userID);
    }

    @RequestMapping("/updatePeopleConsult")
    public R updatePeopleConsult(AirPeopleConsult consult){
        return airPeopleConsultService.updatePeopleConsult(consult);
    }

	
}