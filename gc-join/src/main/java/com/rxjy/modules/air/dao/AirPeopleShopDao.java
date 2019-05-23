package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.AirPeopleShopEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface AirPeopleShopDao extends BaseMapper<AirPeopleShopEntity> {
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

    AirPeopleShopEntity getAirUserShopRecruitMsgaid (@Param("aid") Integer aid);
}
