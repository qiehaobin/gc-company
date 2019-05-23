package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopPictureEntity;
import com.rxjy.modules.air.entity.PersonnelcertificationEntity;

import java.util.List;
import java.util.Map;

/*

*@Description 空调店铺接口

*@Author yangbin
*@Date  2019年3月12日
*/
public interface AirShopService extends IService<AirShopEntity> {

    /**
     * 根据搜索内容查询空调店铺模板
     * @param airShopEntity 搜索内容
     * @return 空调店铺模板集合
     */
    List<AirShopEntity> getAirShopByCondition(AirShopEntity airShopEntity);

    /**
     * 查询最大的空调店铺模板Id
     * @return
     */
    String getMaxAriShopId();

    /**
     * 添加空调模板数据
     * @param airShopEntity 空调模板数据
     * @return
     */
    Integer insertAirShop(AirShopEntity airShopEntity);

    /**
     * 获取所有的空调信息
     */
    List<AirShopEntity> getAllAirShop();

    int saveair_shop_picture(AirShopPictureEntity airShopPictureEntity);

    Map selectPersonnelcertification(String aid);

    int updatePersonnelcertification(PersonnelcertificationEntity personnelcertificationEntity);

    List<Map> selectair_shop_picture(String aid);

    int updateair_people_infostage(String attr_file_url);
}
