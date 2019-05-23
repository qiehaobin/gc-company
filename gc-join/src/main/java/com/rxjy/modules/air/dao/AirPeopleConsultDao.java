/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.dao;

import com.rxjy.modules.air.entity.AirPeopleConsult;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 用户咨询表DAO接口
 * @author xsk
 * @version 2019-03-15
 */
@Repository
public interface AirPeopleConsultDao {
    /**
     * 获取用户咨询信息
     * @param userID
     * @return
     */
	Map<String,Object> getPeopleConsult(Integer userID);

    /**
     * 修改用户咨询模块
     * @param consult
     */
	void updatePeopleConsult(AirPeopleConsult consult);
}
