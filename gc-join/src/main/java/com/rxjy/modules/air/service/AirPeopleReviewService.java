/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.service;

import com.rxjy.common.utils.R;
import com.rxjy.modules.air.dao.AirPeopleReviewDao;
import com.rxjy.modules.air.entity.AirPeopleReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户考察表Service
 * @author xsk
 * @version 2019-03-15
 */
@Service
public class AirPeopleReviewService{

	@Autowired
	private AirPeopleReviewDao dao;

	/**
	 * 获取用户考察信息
	 * @param userID
	 * @return
	 */
	public R getPeopleReview(Integer userID){
		try {
			return R.ok().put("code",0).put("data",dao.getPeopleReview(userID));
		} catch (Exception e) {
			e.printStackTrace();
			return R.error().put("code",-1).put("msg","获取信息失败");
		}
	}

    /**
     * 修改用户视察信息
     * @param peopleReview
     * @return
     */
    public R updatePeopleReview(AirPeopleReview peopleReview){
        try {
            dao.updatePeopleReview(peopleReview);
            return R.ok().put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","修改失败");
        }
    }
}