package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.AirShopDao;
import com.rxjy.modules.air.dao.AirShopProductDao;
import com.rxjy.modules.air.entity.AirPeopleInfoEntity;
import com.rxjy.modules.air.entity.AirShopEntity;
import com.rxjy.modules.air.entity.AirShopListDTO;
import com.rxjy.modules.air.entity.AirShopProductEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicProductEntity;
import com.rxjy.modules.air.service.AirShopProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * 空调类别型号商品信息管理服务
 * @author sux
 * @version 2019-3-20
 *
 */
@Service
public class AirShopProductServiceImpl extends ServiceImpl<AirShopProductDao, AirShopProductEntity> implements AirShopProductService {
    @Autowired
    private AirShopProductDao airShopProductDao;
    @Autowired
    private PlatformTransactionManager txManager;


    /**
     * 同步数据库与从客户端提交的AirShopProduct信息  并存在数据库
     * @param airShopProductEntity
     * @return
     */
    @Transactional
    public  int saveAirshopProductState(AirShopProductEntity airShopProductEntity){
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        try {

            //添加相应id的现有记录
            airShopProductDao.saveAirshopProductState(airShopProductEntity);
        } catch (Exception ex) {
        ex.printStackTrace();
        txManager.rollback(status);
         }
        return 1;
    }
    /**
     * 展示空调分类型号商品有效信息
     */
    public List<AirShopProductEntity> getAirShopProduct(AirShopProductEntity airShopProductEntity){
        List<AirShopProductEntity> airShopProductEntitis=airShopProductDao.getAirShopProductByShopId(airShopProductEntity);
        return airShopProductEntitis;
    }
    /**
     * 将空调分类型号商品有效信息状态修改
     */
    public int updateAirshopProductState(AirShopProductEntity AirShopProduct) {
        return baseMapper.updateAirshopProductState(AirShopProduct);
    }


    /**
     * 删除品牌下的类型和系列信息
     * @param airShopProduct
     */
    @Override
    public int deleteAirShopProduce(AirShopProductEntity airShopProduct) {
        return baseMapper.deleteAirShopProduce(airShopProduct);
    }
}
