package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.modules.air.dao.AirPeopleTrainDao;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.UserinfoJoinc;
import com.rxjy.modules.air.service.AirPeopleTrainService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * describe
 *
 * @author
 * @date 2019-3-21
 */
@Repository
public class AirPeopleTrainServiceImpl extends ServiceImpl<AirPeopleTrainDao, AirPeopleEntity> implements AirPeopleTrainService {

    /**
     * 根据条件查询空调人员培训阶段一段列表信息
     * @param airPeopleEntity 条件
     * @return 空调人员培训阶段一段列表信息
     */
    @Override
    public List<AirPeopleEntity> getAirPeopleTrainList(AirPeopleEntity airPeopleEntity) {
        return baseMapper.getAirPeopleTrainList(airPeopleEntity);
    }

    /**
     * 修改空调人员登录状态
     * @param airPeopleEntity
     * @return
     */
    @Override
    public int updateAirPeopleLoginState(AirPeopleEntity airPeopleEntity) {
        return baseMapper.updateAirPeopleLoginState(airPeopleEntity);
    }

    /**
     * 添加培训阶段人员的加盟费或风险金
     * @param airPeopleEntity 人员的加盟费或风险金
     * @return
     */
    @Override
    public int operationAirPeopleMoney(AirPeopleEntity airPeopleEntity) {
        return baseMapper.operationAirPeopleMoney(airPeopleEntity);
    }

    /**
     * 根据aid查询所有的缴费记录
     * @param aid 主键
     * @return
     */
    @Override
    public List<UserinfoJoinc> getAirPeopleMoneyByAId(int aid) {
        return baseMapper.getAirPeopleMoneyByAId(aid);
    }


}
