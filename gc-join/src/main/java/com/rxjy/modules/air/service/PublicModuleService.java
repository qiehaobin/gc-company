package com.rxjy.modules.air.service;

import com.baomidou.mybatisplus.service.IService;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;

import java.util.List;

/*

*@Description 公共板块模块结果接口

*@Author yangbin
*@Date  2019年3月12日
*/
public interface PublicModuleService extends IService<PublicModuleEntity> {

    /**
     * 根据条件查询公共板块模块信息
     * @param publicModuleEntity 条件
     * @return 公共板块模块信息
     */
    List<PublicModuleEntity> getPublicModuleByCondition(PublicModuleEntity publicModuleEntity);
}
