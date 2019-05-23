package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicProductDao;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;
import com.rxjy.modules.air.service.PublicProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe
 *
 * @author
 * @date 2019-3-16
 */
@Service
public class PublicProductServiceImpl extends ServiceImpl<PublicProductDao, PublicProductEntity> implements PublicProductService {


    /**
     * 根据条件查询空调产品信息
     * @param publicProductEntity  空调产品信息
     * @return 空调产品信息
     */
   public   List<PublicProductEntity> getAirProductByCondition(PublicProductEntity publicProductEntity)
    {
        return baseMapper.getAirProductByCondition(publicProductEntity);
    }

    /**
     * 根据条件更新产品信息
     * @param publicProductEntity 条件
     * @return
     */
    public int updateAirProductByCondition(PublicProductEntity publicProductEntity)
    {
        return baseMapper.updateAirProductByCondition(publicProductEntity);
    }

    /**
     * 根据条件查询空调人员的产品信息
     * @param airPeopleEntity
     * @return
     */
    @Override
    public List<PublicProductEntity> getAirPeopleProduceByCondition(AirPeopleEntity airPeopleEntity) {
        return baseMapper.getAirPeopleProduceByCondition(airPeopleEntity);
    }
        /**
         * 通过seriesId,category_id查询对应的商品信息
         * seriesId    型号类型
         * @return
         * productId  商品类型
         * productName  商品名称
         *
         */
        public  List<PublicProductEntity> getPublicProductListBySeriesIdsCategoryIdShopId( AirShopProductEntity airShopProductEntity)
        {
            return baseMapper.getPublicProductListBySeriesIdsCategoryIdShopId(airShopProductEntity);
        }

    /**
     * 根据条件得到品牌下的产品信息
     * @param airShopEntity
     * @return
     */
    @Override
    public List<PublicProductEntity> getAirShopProductByCondition(AirShopEntity airShopEntity) {

        return baseMapper.getAirShopProductByCondition(airShopEntity);
    }

    /**
     * 根据条件获取空调店铺类别型号信息
     * @param airShopEntity
     * @return
     */
    @Override
    public List<PublicProductEntity> getAirShopSeriesByCondition(AirShopEntity airShopEntity) {
        return baseMapper.getAirShopSeriesByCondition(airShopEntity);
    }

}
