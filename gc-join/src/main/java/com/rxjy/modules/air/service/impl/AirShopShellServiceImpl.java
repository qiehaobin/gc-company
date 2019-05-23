package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.AirShopShellDao;
import com.rxjy.modules.air.entity.AirShopShellEntity;
import com.rxjy.modules.air.service.AirShopShellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*

*@Description 空调店铺店面接口实现类

*@Author yangbin
*@Date 2019年3月12日
*/
@Service
public class AirShopShellServiceImpl extends ServiceImpl<AirShopShellDao, AirShopShellEntity> implements AirShopShellService {

//    extends ServiceImpl<AirShopDao,AirShopEntity>
    @Autowired
    private AirShopShellDao airShopShellDao;


    /**
     * 根据条件查询空调店铺店面信息
     * @param airShopShellEntity 搜索内容
     * @return 空调店铺店面集合
     */
    @Override
    public List<AirShopShellEntity> getAirShopShellByCondition(AirShopShellEntity airShopShellEntity) {
        return airShopShellDao.getAirShopShellByCondition(airShopShellEntity);

    }

    /**
     * 根据地区查询空调店铺店面数量信息
     * @param airShopShellEntity 搜索内容
     * @return 空调店铺店面数量集合
     */
    @Override
    public List<AirShopShellEntity> getAirShopShellCountByCityId(AirShopShellEntity airShopShellEntity) {
        return airShopShellDao.getAirShopShellCountByCityId(airShopShellEntity);

    }

    /**
     * 添加空调模板数据
     * @param airShopShellEntity 空调模板数据
     * @return
     */
    @Override
    public int insertAirShopShell(List<AirShopShellEntity> airShopShellEntity){
        return  baseMapper.insertAirShopShell(airShopShellEntity);
    }

    /**
     * 店铺模板店面地区开店数量
     * @return 店铺模板店面开店数量集合
     */
    @Override
    public List<AirShopShellEntity> getAirCityShellCount(){
        return  baseMapper.getAirCityShellCount();
    }

    /**
     * 查询店铺店铺信息
     * @return 店铺店铺信息
     */
    @Override
    public   List<AirShopShellEntity>getAirCityShellMsg(){
        return baseMapper.getAirCityShellMsg();
    }

    @Override
    public Map getPersonalshopmaincamplist(String aid) {
        return baseMapper.getPersonalshopmaincamplist(aid);
    }

    @Override
    public Map getPersonalshoppeoplelist(String aid) {
        return baseMapper.getPersonalshoppeoplelist(aid);
    }

    @Override
    public int updatePersonnelmatterscitystandard(int areaId, int cityid, String address,String aid) {
//        List<Map> mapList=baseMapper.selectPersonnelmatterscitystandard(aid); //查询表：air_people中是否存在这个值
//        if (mapList.size()>0){
//
//        }else {
//
//        }
//        List<Map> mapList1=baseMapper.selectPersonnelmatterscitystandard1(aid); //查询表：air_people_detail中是否存在这个值
//        List<Map> mapList2=baseMapper.selectPersonnelmatterscitystandard2(aid); //查询表：air_people_shop中是否存在这个值

        return baseMapper.updatePersonnelmatterscitystandard (address,areaId,cityid,aid);
    }

    @Override
    public List<Map> getPersonalshopleftlist(String aid) {
        return airShopShellDao.getPersonalshopleftlist(aid);
    }

    @Override
    public List<Map> getPersonalshopManagementlist(String aid) {
        return airShopShellDao.getPersonalshopManagementlist(aid);
    }

    /**
     * 查询店铺店面人员信息
     */
    @Override
    public   List<AirShopShellEntity>getAirCityShellPeopleMsg(){
        return baseMapper.getAirCityShellPeopleMsg();
    }
}
