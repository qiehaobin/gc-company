package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.PublicEntity.PublicEmergencyUserEntity;

import java.util.List;

/**
 * describe 公共紧急联系人信息接口
 *
 * @author yangbin
 * @date 2019-3-22
 */
public interface PublicEmergencyUserDao extends BaseMapper<PublicEmergencyUserEntity> {

    /**
     * 根据条件查询紧急联系人信息
     * @param publicEmergencyUserEntity 条件
     * @return 紧急联系人信息
     */
    List<PublicEmergencyUserEntity> getPublicEmergencyUserByCondition(PublicEmergencyUserEntity publicEmergencyUserEntity);
}

