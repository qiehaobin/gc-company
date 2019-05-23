package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.AirShopEntity;

import com.rxjy.modules.air.entity.AirShopShellEntity;

import java.util.List;
import java.util.Map;

/*

*@Description 空调店铺店面接口

*@Author yangbin
*@Date  2019年3月12日
*/
public interface AirShopShellService extends IService<AirShopShellEntity> {

    /**
     * 根据搜索内容查询空调店铺店面信息
     * @param airShopShellEntity 搜索内容
     * @return 空调店铺店面集合
     */
    List<AirShopShellEntity> getAirShopShellByCondition(AirShopShellEntity airShopShellEntity);


    /**
     * 根据地区查询空调店铺店面数量信息
     * @return
     */
    List<AirShopShellEntity> getAirShopShellCountByCityId(AirShopShellEntity airShopShellEntity);

    /**
     * 添加空调模板店面数据
     * @param airShopShellEntity 空调模板店面数据
     * @return
     */
    int insertAirShopShell(List<AirShopShellEntity> airShopShellEntity);


    /**
     * 查询所有地区的店铺店面总计、已开、未开数量
     * @return 所有地区的店铺店面总计、已开、未开数量
     */
    List<AirShopShellEntity> getAirCityShellCount();

    /**
     * 查询店铺店铺信息
     * @return 店铺店铺信息
     */

    List<Map> getPersonalshopleftlist(String aid);

    List<Map> getPersonalshopManagementlist(String aid);
    /**
     * 查询所有店铺店面人员信息
     */
    List<AirShopShellEntity>getAirCityShellPeopleMsg();
    /**
     * 查询店铺位信息
     * @return
     */
    List<AirShopShellEntity> getAirCityShellMsg();

    Map getPersonalshopmaincamplist(String aid);

    Map getPersonalshoppeoplelist(String aid);

    int updatePersonnelmatterscitystandard(int areaId, int cityid, String address,String aid);
}
