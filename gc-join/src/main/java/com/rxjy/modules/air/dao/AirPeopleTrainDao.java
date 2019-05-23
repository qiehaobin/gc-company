package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.UserinfoJoinc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirPeopleTrainDao extends BaseMapper<AirPeopleEntity> {

    /**
     * 根据条件查询空调人员培训阶段一段列表信息
     * @param airPeopleEntity 条件
     * @return 空调人员培训阶段一段列表信息
     */
    List<AirPeopleEntity> getAirPeopleTrainList(AirPeopleEntity airPeopleEntity);

    /**
     * 修改空调人员登录状态
     * @param airPeopleEntity
     * @return
     */
    int updateAirPeopleLoginState(AirPeopleEntity airPeopleEntity);

    /**
     * 添加培训阶段人员的加盟费或风险金
     * @param airPeopleEntity
     * @return
     */
    int operationAirPeopleMoney(AirPeopleEntity airPeopleEntity);

    /**
     * 根据aid查询所有的缴费记录
     * @param aid 主键
     * @return
     */
    List<UserinfoJoinc> getAirPeopleMoneyByAId(@Param("aid") int aid);
}
