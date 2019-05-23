/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.service;

import com.rxjy.common.utils.R;
import com.rxjy.modules.air.dao.AirPeopleConsultDao;
import com.rxjy.modules.air.entity.AirPeopleConsult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户咨询表Service
 * @author xsk
 * @version 2019-03-15
 */
@Service
public class AirPeopleConsultService{

	@Autowired
	private AirPeopleConsultDao dao;

	/**
	 * 根据用户ID获取用户咨询信息
	 * @param userID
	 * @return
	 */
	public R getPeopleConsult(Integer userID){
        try {
            return R.ok().put("code","0").put("data",dao.getPeopleConsult(userID));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code","1").put("msg","获取用户信息失败");
        }
    }

    /**
     * 修改用户咨询模块
     * @param consult
     * @return
     */
    public R updatePeopleConsult(AirPeopleConsult consult){
        try {
            dao.updatePeopleConsult(consult);
            return R.error().put("code","0");
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code","1").put("msg","修改失败");
        }
    }
}