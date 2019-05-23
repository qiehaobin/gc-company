package com.rxjy.modules.kshop.service.serviceImpl;

import com.rxjy.modules.kshop.service.TrainStageService;
import com.rxjy.modules.kshop.dao.TrainStageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainStageServiceImpl implements TrainStageService {
    @Autowired
    private TrainStageDao trainStageMapper;

    /**
     * @param
     * @return 查询店铺培训业务、系统、财务
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 查询店铺培训业务、系统、财务
     */
    @Override
    public List<Map<String, Object>> list_R_TrainStage(Map<String, Object> params) {
        return trainStageMapper.list_R_TrainStage(params);
    }

    /**
     * @param
     * @return 查询店铺类型
     * @创建人 赵伟
     * @创建时间 2019-03-12
     * @功能描述 更新店铺类型
     */
    public int update_R_TrainStage(Map<String, Object> params) {
        return trainStageMapper.update_R_TrainStage(params);
    }
}
