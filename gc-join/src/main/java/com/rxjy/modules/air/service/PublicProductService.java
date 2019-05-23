package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;

import java.util.List;

public interface PublicProductService extends IService<PublicProductEntity> {

    /**
     * 根据条件查询空调产品信息
     * @param publicProductEntity  空调产品信息
     * @return 空调产品信息
     */
    List<PublicProductEntity> getAirProductByCondition(PublicProductEntity publicProductEntity);

    /**
     * 根据条件更新产品信息
     * @param publicProductEntity 条件
     * @return
     */
    int updateAirProductByCondition(PublicProductEntity publicProductEntity);

    /**
     * 根据条件查询空调人员的产品信息
     * @param airPeopleEntity
     */
    List<PublicProductEntity>  getAirPeopleProduceByCondition(AirPeopleEntity airPeopleEntity);



    /**
     * 通过seriesId,category_id查询对应的商品信息
     * seriesId    型号类型
     * @return
     * productId  商品类型
     * productName  商品名称
     *
     */
    List<PublicProductEntity> getPublicProductListBySeriesIdsCategoryIdShopId( AirShopProductEntity airShopProductEntity);

    /**
     * 根据条件得到空调品牌下的产品信息
     * @param airShopEntity
     * @return
     */
    List<PublicProductEntity> getAirShopProductByCondition(AirShopEntity airShopEntity);

    /**
     * 根据条件获取空调店铺类别型号信息
     * @param airShopEntity
     * @return
     */
    List<PublicProductEntity> getAirShopSeriesByCondition(AirShopEntity airShopEntity);
}
