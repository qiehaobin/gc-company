package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicEmergencyUserDao;
import com.rxjy.modules.air.entity.PublicEntity.PublicEmergencyUserEntity;
import com.rxjy.modules.air.service.PublicEmergencyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*

 *@Description 紧急联系人信息接口实现类

 *@Author yangbin
 *@Date 2019年3月12日
 */
@Service
public class PublicEmergencyUserServiceImpl extends ServiceImpl<PublicEmergencyUserDao, PublicEmergencyUserEntity> implements PublicEmergencyUserService {
    /**
     * 根据条件查询紧急联系人信息
     * @param publicEmergencyUserEntity 条件
     * @return 紧急联系人信息
     */

    @Override
    public List<PublicEmergencyUserEntity> getPublicEmergencyUserByCondition(PublicEmergencyUserEntity publicEmergencyUserEntity) {
        return baseMapper.getPublicEmergencyUserByCondition(publicEmergencyUserEntity);
    }
}
