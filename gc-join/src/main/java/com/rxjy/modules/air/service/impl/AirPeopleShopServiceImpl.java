package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.AirPeopleShopDao;
import com.rxjy.modules.air.entity.AirPeopleShopEntity;
import com.rxjy.modules.air.service.AirPeopleShopService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe 空调人员店铺信息接口实现
 *
 * @author yangbin
 * @date 2019-3-20
 */
@Service
public class AirPeopleShopServiceImpl extends ServiceImpl<AirPeopleShopDao, AirPeopleShopEntity> implements AirPeopleShopService {

    /**
     * 根据条件查询空调人员招商店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    @Override
    public AirPeopleShopEntity getAirUserShopRecruitMsg(AirPeopleShopEntity airPeopleShopEntity) {
        return baseMapper.getAirUserShopRecruitMsg(airPeopleShopEntity);
    }

    /**
     * 根据条件更新空调人员培训店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    @Override
    public int operationAirPeopleTrainShopMsg(AirPeopleShopEntity airPeopleShopEntity) {
        return baseMapper.operationAirPeopleTrainShopMsg(airPeopleShopEntity);
    }

    /**
     * 根据条件查询空调人员店铺信息
     * @param airPeopleShopEntity
     * @return
     */
    @Override
    public List<AirPeopleShopEntity> getAirPeopleShopByCondition(AirPeopleShopEntity airPeopleShopEntity) {
        return baseMapper.getAirPeopleShopByCondition(airPeopleShopEntity);
    }

    /**
     * 根据地区id查询空调人员店铺信息
     */
    @Override
   public  List<AirPeopleShopEntity> getAirPeopleShop(AirPeopleShopEntity airPeopleShopEntity){
        return baseMapper.getAirPeopleShop(airPeopleShopEntity);
    }
    /**
     * 根据地区id更新空调人员店铺信息
     */
    @Override
   public  Integer updateAirPeopleShop(AirPeopleShopEntity airPeopleShopEntity){
        return baseMapper.updateAirPeopleShop(airPeopleShopEntity);
    }

    @Override
    public AirPeopleShopEntity getAirUserShopRecruitMsgaid(Integer aid) {
        return baseMapper.getAirUserShopRecruitMsgaid(aid);
    }
}
