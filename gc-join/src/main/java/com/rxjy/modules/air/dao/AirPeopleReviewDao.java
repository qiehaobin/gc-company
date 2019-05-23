/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.dao;

import com.rxjy.modules.air.entity.AirPeopleReview;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 客户考察表DAO接口
 * @author xsk
 * @version 2019-03-15
 */
@Repository
public interface AirPeopleReviewDao{
    /**
     * 获取用户考察信息
     * @param userID
     * @return
     */
	Map<String,Object> getPeopleReview(Integer userID);

    /**
     * 修改用户视察信息
     * @param peopleReview
     */
	void updatePeopleReview(AirPeopleReview peopleReview);
}