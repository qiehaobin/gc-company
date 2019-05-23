package com.rxjy.modules.air.dao;

import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*

*@Description TODO 公共系列接口

*@Author yangbin
*@Date   2019-03-15
*/
@Repository
public interface PublicSeriesDao extends BaseMapper<PublicSeriesEntity> {

    /**
     * 根据条件查询空调系列信息
     * @param publicSeriesEntity 系列条件信息
     * @return 空调类别信息集合
     */
      List<PublicSeriesEntity> getAirCategorySeriesByCondition(PublicSeriesEntity publicSeriesEntity);

    /**
     * 根据条件修改公共型号信息
     * @param publicSeriesEntity 公共类型号信息
     * @return
     */
    int updatePublicSeriesByCondition(PublicSeriesEntity publicSeriesEntity);

    /**
     * 通过查询指定categoryId的所有系列名称
     * categoryTypeId  类别类型
     * @return
     * 系列信息集合
     */
    List<PublicSeriesEntity> getPublicSeriesListBycategoryTypeId( AirShopProductEntity airShopProductEntity);

    /**
     * 根据条件查询产品下的类别的所有系列
     * @param airShopProductEntity 所有系列
     * @return
     */
    List<PublicSeriesEntity> getAirShopSeriesByCondition(AirShopProductEntity airShopProductEntity);
}
