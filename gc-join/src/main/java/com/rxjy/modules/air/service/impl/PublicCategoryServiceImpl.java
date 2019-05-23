package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicCategoryDao;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.service.PublicCategoryService;
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
public class PublicCategoryServiceImpl extends ServiceImpl<PublicCategoryDao,PublicCategoryEntity> implements PublicCategoryService {

    @Autowired
    private  PublicCategoryDao publicCategoryDao;
    /**
     * 根据条件查询类别信息
     * @param publicCategory 类别条件信息
     * @return 类别信息集合
     */
   public List<PublicCategoryEntity> getPublicCategoryByCondition(PublicCategoryEntity publicCategory){
        return baseMapper.getPublicCategoryByCondition(publicCategory);
    }

    /**
     * 查询空调类别信息统计信息
     * @return 类别信息
     */
    public List<PublicCategoryEntity> getAirPublicCategoryStatistics()
    {
        return baseMapper.getAirPublicCategoryStatistics();
    }

    /**
     * 查询所有的分类
     * @return
     * categoryType   分类类型
     * categoryName   分类名称
     */
    public List<PublicCategoryEntity> getCatgoryList(AirShopEntity airShopEntity)
    {
        return publicCategoryDao.getCatgoryList(airShopEntity);
    }
    /**
     *  根据条件查询品牌对应的类别信息
     * @param airShopProductEntity
     * @return
     */
    @Override
    public List<PublicCategoryEntity> getAirShopCategoryByCondition(AirShopProductEntity airShopProductEntity) {
        return baseMapper.getAirShopCategoryByCondition(airShopProductEntity);
    }


}
