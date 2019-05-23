package com.rxjy.modules.air.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopListDTO;
import com.rxjy.modules.air.entity.AirShopProductEntity;

import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirShopProductDao extends BaseMapper<AirShopProductEntity> {

        //删除产品板块产品模块的商品状态
        int updateAirshopProductState(AirShopProductEntity airShopProductEntity);

        //保存产品板块产品模块的商品状态
        int saveAirshopProductState(AirShopProductEntity airShopProductEntity);

        //将flag=0的数据进行回显
        List<AirShopProductEntity>  getAirShopProductByShopId(AirShopProductEntity airShopProductEntity);


        /**
         * \删除品牌下的类型和系列信息
         * @param airShopProduct
         * @return
         */
       int deleteAirShopProduce(AirShopProductEntity airShopProduct);
}
