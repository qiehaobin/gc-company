package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.PublicTeamDao;
import com.rxjy.modules.air.entity.PublicEntity.PublicTeamEntity;
import com.rxjy.modules.air.service.PublicTeamService;
import org.springframework.stereotype.Service;

import java.util.List;

/*

 *@Description 公共团队信息接口实现类

 *@Author yangbin
 *@Date 2019年3月12日
 */
@Service
public class PublicTeamServiceImpl extends ServiceImpl<PublicTeamDao, PublicTeamEntity> implements PublicTeamService {

    /**
     * 根据条件查询空调人员团队信息
     * @param publicTeamEntity 条件
     * @return 团队信息
     */
    @Override
    public List<PublicTeamEntity> getAirPeopleTeamMsgByCondition(PublicTeamEntity publicTeamEntity) {
        return baseMapper.getAirPeopleTeamMsgByCondition(publicTeamEntity);
    }
}
