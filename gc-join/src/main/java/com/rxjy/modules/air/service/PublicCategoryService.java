package com.rxjy.modules.air.service;


import com.baomidou.mybatisplus.service.IService;
import com.rxjy.common.utils.R;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*

 *@Description TODO 公共类别接口

 *@Author yangbin
 *@Date   2019-03-15
*/
public interface PublicCategoryService extends IService<PublicCategoryEntity> {

    /**
     * 根据条件查询类别信息
     * @param publicCategory 类别条件信息
     * @return 类别信息集合
     */
    List<PublicCategoryEntity> getPublicCategoryByCondition(PublicCategoryEntity publicCategory);

    /**
     * 查询空调类别信息统计信息
     * @return 类别信息
     */
    List<PublicCategoryEntity> getAirPublicCategoryStatistics();



    /**
     * 查询所有的分类
     * @return
     * categoryType   分类类型
     * categoryName   分类名称
     */
        List<PublicCategoryEntity> getCatgoryList(AirShopEntity airShopEntity);

    /**
     *  根据条件查询品牌对应的类别信息
     * @param airShopProductEntity
     * @return
     */
    List<PublicCategoryEntity> getAirShopCategoryByCondition(AirShopProductEntity airShopProductEntity);
}
