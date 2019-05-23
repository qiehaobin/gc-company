package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.PublicEntity.PublicChildModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;

import java.util.List;

/*

*@Description 公共子模块结果接口

*@Author yangbin
*@Date  2019年3月12日
*/
public interface PublicChildModuleService extends IService<PublicChildModuleEntity> {


    /**
     * 根据条件查询人员模块状态
     * @param publicChildModuleEntity 条件
     * @return 人员模块状态
     */
    List<PublicChildModuleEntity> getAirPeopleModuleStateByCondition(PublicChildModuleEntity publicChildModuleEntity);
}
