/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.service;

import com.rxjy.common.utils.R;
import com.rxjy.modules.air.dao.AirPeopleInviteDao;
import com.rxjy.modules.air.entity.AirPeopleInvite;
import com.rxjy.modules.air.entity.AirPeopleReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户邀约表Service
 * @author xsk
 * @version 2019-03-15
 */
@Service
public class AirPeopleInviteService {

	@Autowired
	private AirPeopleInviteDao dao;

	/**
	 * 获取用户考察信息
	 * @param userID
	 * @return
	 */
	public R getPeopleInvite(Integer userID){
		try {
			return R.ok().put("code",0).put("data",dao.getPeopleInvite(userID));
		} catch (Exception e) {
			e.printStackTrace();
			return R.error().put("code",-1).put("msg","获取信息失败");
		}
	}

    /**
     * 修改用户邀约信息
     * @param peopleInvite
     * @return
     */
    public R updatePeopleInvite(AirPeopleInvite peopleInvite){
        try {
            dao.updatePeopleInvite(peopleInvite);
            return R.ok().put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","修改失败");
        }
    }
}