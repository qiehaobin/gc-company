package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.PublicEntity.PublicEmergencyUserEntity;

import java.util.List;

/*

*@Description 紧急联系人信息接口

*@Author yangbin
*@Date  2019年3月12日
*/
public interface PublicEmergencyUserService extends IService<PublicEmergencyUserEntity> {

    /**
     * 根据条件查询紧急联系人信息
     * @param publicEmergencyUserEntity 条件
     * @return 紧急联系人信息
     */
    List<PublicEmergencyUserEntity> getPublicEmergencyUserByCondition(PublicEmergencyUserEntity publicEmergencyUserEntity);
}
