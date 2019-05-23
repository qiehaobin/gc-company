/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.air.dao;

import com.rxjy.modules.air.entity.AirPeopleConsult;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.AirPeopleRsglDiquEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 用户咨询表DAO接口
 * @author xsk
 * @version 2019-03-15
 */
@Repository
public interface AirPeopleRsglDiquDao {

    public AirPeopleEntity  getPeopleInfoById(Integer userID);

    public AirPeopleRsglDiquEntity getPeopleRsglDiquById(Integer userID);
}
