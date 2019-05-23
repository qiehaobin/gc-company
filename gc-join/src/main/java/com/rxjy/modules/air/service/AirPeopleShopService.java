package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirPeopleShopEntity;

import java.util.List;

/**
 * 空调店铺接口定义
 */
public interface AirPeopleShopService extends IService<AirPeopleShopEntity> {

    /**
     * 根据条件查询空调人员招商店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    AirPeopleShopEntity getAirUserShopRecruitMsg(AirPeopleShopEntity airPeopleShopEntity);

    /**
     * 根据条件更新空调人员培训店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    int operationAirPeopleTrainShopMsg(AirPeopleShopEntity airPeopleShopEntity);

    /**
     * 根据条件查询空调人员店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    List<AirPeopleShopEntity> getAirPeopleShopByCondition(AirPeopleShopEntity airPeopleShopEntity);

    /**
     * 根据地区id查询空调人员店铺信息
     */
    List<AirPeopleShopEntity> getAirPeopleShop(AirPeopleShopEntity airPeopleShopEntity);
    /**
     * 根据地区id更新空调人员店铺信息
     */
    Integer updateAirPeopleShop(AirPeopleShopEntity airPeopleShopEntity);

    AirPeopleShopEntity getAirUserShopRecruitMsgaid(Integer aid);
}
