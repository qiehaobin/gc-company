package com.rxjy.modules.air.service;


import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopListDTO;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 空调类别型号商品信息管理服务接口
 * @author sux
 * @version 2019-3-20
 */

public interface AirShopProductService extends IService<AirShopProductEntity> {

    /**
     * 保存从客户端提交的AirShopProduct信息  并存在数据库
     * @param
     * @return
     */
    int  saveAirshopProductState(AirShopProductEntity airShopProductEntity);

    /**
     *展示空调分类型号商品有效信息
     */
    List<AirShopProductEntity> getAirShopProduct(AirShopProductEntity airShopProductEntity);

    /**
     * 将空调分类型号商品有效信息状态修改
     */
    int updateAirshopProductState(AirShopProductEntity airShopProduct);



    /**
     * 删除品牌下的类型和系列信息
     * @param airShopProduct
     */
    int deleteAirShopProduce(AirShopProductEntity airShopProduct);

}
