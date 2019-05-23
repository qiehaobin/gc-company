package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.AirPeopleInfoEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopPictureEntity;
import com.rxjy.modules.air.entity.PersonnelcertificationEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*

*@Description 空调店铺模板接口

*@Author yangbin
*@Date 2019年3月12日
*/
@Repository
public interface AirShopDao extends BaseMapper<AirShopEntity> {


    /**
     * 根据搜索内容查询空调店铺模板
     * @return
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

    List<Map> selectairShopPicture ( AirShopPictureEntity airShopPictureEntity);

    int saveairShopPicture (AirShopPictureEntity airShopPictureEntity);

    int updateairShopPicture (AirShopPictureEntity airShopPictureEntity);

    Map selectPersonnelcertification (@Param("aid") String aid);

    List<LinkedHashMap> selectair_people_info (@Param("aid") String aid);

    int updatePersonnelcertification1 (PersonnelcertificationEntity personnelcertificationEntity);

    int insertPersonnelcertification1 (List<AirPeopleInfoEntity> airPeopleInfolist);

    List<Map> selectair_shop_picture (@Param("aid") String aid);

    int updateair_people_infostage (@Param("attr_file_url") String attr_file_url);
}
