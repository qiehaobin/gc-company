/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.dao;

import com.rxjy.modules.air.entity.AirPeopleInvite;
import com.rxjy.modules.air.entity.AirPeopleReview;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 客户邀约表DAO接口
 * @author xsk
 * @version 2019-03-15
 */
@Repository
public interface AirPeopleInviteDao {
    /**
     * 获取用户邀约信息
     * @param userID
     * @return
     */
	Map<String,Object> getPeopleInvite(Integer userID);

    /**
     * 修改用户邀约信息
     * @param peopleReview
     */
	void updatePeopleInvite(AirPeopleInvite peopleReview);
}