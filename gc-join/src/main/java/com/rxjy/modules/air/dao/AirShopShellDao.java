package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopShellEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*

*@Description 空调店铺店面接口

*@Author yangbin
*@Date 2019年3月12日
*/
@Repository
public interface AirShopShellDao extends BaseMapper<AirShopShellEntity> {


    /**
     * 根据搜索内容查询空调店铺店面信息
     * @return
     */
    List<AirShopShellEntity> getAirShopShellByCondition(AirShopShellEntity airShopShellEntity);

    /**
     * 根据地区查询空调店铺店面数量信息
     * @return
     */
    List<AirShopShellEntity> getAirShopShellCountByCityId(AirShopShellEntity airShopShellEntity);

    /**
     * 添加空调模板店面数据
     * @param airShopShellEntitys 空调模板店面数据
     * @return
     */
    int insertAirShopShell(@Param("list") List<AirShopShellEntity> airShopShellEntitys);

    /**
     * 查询所有地区的店铺店面总计、已开、未开数量
     * @return 所有地区的店铺店面总计、已开、未开数量
     */
    List<AirShopShellEntity> getAirCityShellCount();

    /**
     * 查询店铺店铺信息
     * @return 店铺店铺信息
     */
    List<AirShopShellEntity>getAirCityShellMsg();

    List<Map> getPersonalshopleftlist (@Param("aid") String aid);

    List<Map> getPersonalshopManagementlist (@Param("aid") String aid);
    /**
     * 查询店铺店壳人员信息
     */
    List<AirShopShellEntity> getAirCityShellPeopleMsg();

    Map getPersonalshopmaincamplist (@Param("aid") String aid);

    Map getPersonalshoppeoplelist (@Param("aid") String aid);

    int updatePersonnelmatterscitystandard (@Param("address") String address, @Param("areaId") int areaId, @Param("cityid") int cityid,@Param("aid") String aid);

    List<Map> selectPersonnelmatterscitystandard (@Param("aid") String aid);

    List<Map> selectPersonnelmatterscitystandard1 (@Param("aid") String aid);

    List<Map> selectPersonnelmatterscitystandard2 (@Param("aid") String aid);
}
