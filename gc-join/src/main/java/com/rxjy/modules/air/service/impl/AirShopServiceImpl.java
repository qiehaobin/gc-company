package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.AirShopDao;
import com.rxjy.modules.air.entity.AirPeopleInfoEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopPictureEntity;
import com.rxjy.modules.air.entity.PersonnelcertificationEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicCategoryEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicSeriesEntity;
import com.rxjy.modules.air.service.AirShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*

 *@Description 空调店铺模板接口实现类

 *@Author yangbin
 *@Date 2019年3月12日
 */
@Service
public class AirShopServiceImpl extends ServiceImpl<AirShopDao, AirShopEntity> implements AirShopService {

    //    extends ServiceImpl<AirShopDao,AirShopEntity>
    @Autowired
    private AirShopDao airShopDao;



    /**
     * 根据条件查询空调店铺模板信息
     *
     * @param airShopEntity 搜索内容
     * @return 空调店铺模板集合
     */
    @Override
    public List<AirShopEntity> getAirShopByCondition(AirShopEntity airShopEntity) {
        return airShopDao.getAirShopByCondition(airShopEntity);

    }

    /**
     * 查询最大的空调店铺模板Id
     *
     * @return
     */
    @Override
    public String getMaxAriShopId() {
        return airShopDao.getMaxAriShopId();
    }


    /**
     * 添加空调模板数据
     * @param airShopEntity 空调模板数据
     * @return
     */
    @Override
    public Integer insertAirShop(AirShopEntity airShopEntity) {
        return baseMapper.insertAirShop(airShopEntity);
    }

    /**
     * 获取所有的空调信息
     */
   public List<AirShopEntity> getAllAirShop(){
     return  airShopDao.getAllAirShop();
   }

    @Override
    public int saveair_shop_picture(AirShopPictureEntity airShopPictureEntity) {
        List<Map> mapList=airShopDao.selectairShopPicture(airShopPictureEntity);
        int deta=0;
        if (mapList.size()==0){
             deta=airShopDao.saveairShopPicture(airShopPictureEntity);
        }else {
             deta=airShopDao.updateairShopPicture(airShopPictureEntity);
        }

        return deta;
    }

    @Override
    public Map selectPersonnelcertification(String aid) {
        HashMap<Object, Object> map = new HashMap<>();
        Map map1=airShopDao.selectPersonnelcertification(aid);
        List<LinkedHashMap> mapList=airShopDao.selectair_people_info(aid);
        map.put("data1",map1);
        map.put("data2",mapList);
        return map;
    }

    @Override
    public int updatePersonnelcertification(PersonnelcertificationEntity personnelcertificationEntity) {
       int data=0;
       try {
           List<AirPeopleInfoEntity> airPeopleInfolist = personnelcertificationEntity.getAirPeopleInfolist();
           data=airShopDao.updatePersonnelcertification1(personnelcertificationEntity);
           if (airPeopleInfolist.size()>0){
               data=airShopDao.insertPersonnelcertification1(airPeopleInfolist);
           }
       }catch (Exception e){

       }
        return data;
    }

    @Override
    public List<Map> selectair_shop_picture(String aid) {
        return airShopDao.selectair_shop_picture(aid);
    }

    @Override
    public int updateair_people_infostage(String attr_file_url) {
        return airShopDao.updateair_people_infostage(attr_file_url);
    }
}
