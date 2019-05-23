package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicSeriesDao;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;
import com.rxjy.modules.air.service.PublicSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe 公共类别接口实现层
 *
 * @author yangbin
 * @date 2019-3-15
 */
@Service
public class PublicSeriesServiceImpl extends ServiceImpl<PublicSeriesDao, PublicSeriesEntity> implements PublicSeriesService {

    @Autowired
    private  PublicSeriesDao publicSeriesDao;
    /**
     * 根据条件查询类别信息
     * @param publicSeriesEntity 类别条件信息
     * @return 类别信息集合
     */
   public List<PublicSeriesEntity> getAirCategorySeriesByCondition (PublicSeriesEntity publicSeriesEntity){
        return baseMapper.getAirCategorySeriesByCondition(publicSeriesEntity);
    }

    /**
     * 根据条件修改公共型号信息
     * @param publicSeriesEntity 公共型号信息
     * @return
     */
    public int updatePublicSeriesByCondition(PublicSeriesEntity publicSeriesEntity)
    {
        return baseMapper.updatePublicSeriesByCondition(publicSeriesEntity);
    }

    /**
     * 通过查询指定categoryId的所有系列名称
     * categoryTypeId  类别类型
     * @return
     * 系列信息集合
     */
    public List<PublicSeriesEntity> getPublicSeriesListBycategoryTypeId (  AirShopProductEntity airShopProductEntity){
        return  publicSeriesDao.getPublicSeriesListBycategoryTypeId( airShopProductEntity);
    }
    /**
     * 根据条件查询产品下的类别的所有系列
     * @param airShopProductEntity 所有系列
     * @return
     */
    @Override
    public List<PublicSeriesEntity> getAirShopSeriesByCondition(AirShopProductEntity airShopProductEntity) {
        return baseMapper.getAirShopSeriesByCondition(airShopProductEntity);
    }

}
