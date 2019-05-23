package com.rxjy.modules.air.service;


import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;

import java.util.List;

/*

 *@Description TODO 公共类别接口

 *@Author yangbin
 *@Date   2019-03-15
*/
public interface PublicSeriesService extends IService<PublicSeriesEntity> {

    /**
     * 根据条件查询空调系列信息
     * @param publicSeriesEntity 系列信息
     * @return 空调系列信息
     */
    List<PublicSeriesEntity> getAirCategorySeriesByCondition(PublicSeriesEntity publicSeriesEntity);

    /**
     * 根据条件修改型号信息
     * @param publicSeriesEntity 公共类别或者型号信息
     * @return
     */
    int updatePublicSeriesByCondition(PublicSeriesEntity publicSeriesEntity);

    /**
     * 通过查询指定categoryId的所有系列名称
     * categoryTypeId  类别类型
     * @return
     * categoryTypeId 对应的分类类型
     * seriesName   系列名称
     * seriesType  系列类型
     */
    List<PublicSeriesEntity> getPublicSeriesListBycategoryTypeId (  AirShopProductEntity airShopProductEntity);

    /**
     * 根据条件查询产品下的类别的所有系列
     * @param airShopProductEntity 所有系列
     * @return
     */
    List<PublicSeriesEntity> getAirShopSeriesByCondition(AirShopProductEntity airShopProductEntity);
}
