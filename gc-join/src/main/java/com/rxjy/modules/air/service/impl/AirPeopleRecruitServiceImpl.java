package com.rxjy.modules.air.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.rxjy.common.utils.R;
import com.rxjy.modules.air.dao.AirPeopleRecruitDao;
import com.rxjy.modules.air.dao.AirShopDao;
import com.rxjy.modules.air.entity.*;
import com.rxjy.modules.air.service.AirPeopleRecruitService;
import com.rxjy.modules.air.service.AirShopService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition; 

import java.util.List;
import java.util.Map;

/*

 *@Description 空调店铺模板接口实现类

 *@Author yangbin
 *@Date 2019年3月12日
 */
@Service
public class AirPeopleRecruitServiceImpl extends ServiceImpl<AirPeopleRecruitDao, AirPeopleEntity> implements AirPeopleRecruitService {


    @Autowired
    private AirPeopleRecruitDao airPeopleRecruitDao;
    @Autowired
    private PlatformTransactionManager txManager;


    @Override
    public List<Map<String,Object>> listAirPeople(AirPeopleEntity airPeopleEntity) {
        return airPeopleRecruitDao.listAirPeople(airPeopleEntity);
    }
    @Override
    public Integer insertAirPeople(AirPeopleEntity airPeopleEntity) {
        return airPeopleRecruitDao.insertAirPeople(airPeopleEntity);
    }
    @Override
    public Integer insertAirPeopleDetail(AirPeopleEntity airPeopleEntity) {
        return airPeopleRecruitDao.insertAirPeopleDetail(airPeopleEntity);
    }

    @Override
    public Integer insertAirPeopleConsult(AirPeopleConsult airPeopleConsult) {
        return airPeopleRecruitDao.insertAirPeopleConsult(airPeopleConsult);
    }

    @Override
    public Integer updateAirPeopleConsult(Integer aid, String sendMsgTime) {
        return airPeopleRecruitDao.updateAirPeopleConsult(aid,sendMsgTime);
    }

    @Override
    public Integer insertAirPeopleReview(AirPeopleReview airPeopleReview) {
        return airPeopleRecruitDao.insertAirPeopleReview(airPeopleReview);
    }

    @Override
    public Integer insertAirPeopleInvite(AirPeopleInvite airPeopleInvite) {
        return airPeopleRecruitDao.insertAirPeopleInvite(airPeopleInvite);
    }

    @Override
    public Integer updateAirPeople(AirPeopleEntity airPeopleEntity) {
        return airPeopleRecruitDao.updateAirPeople(airPeopleEntity);
    }

    @Override
    public Integer insertAirPeopleAnswer(AirPeopleAnswerEntity airPeopleAnswerEntity) {
        return airPeopleRecruitDao.insertAirPeopleAnswer(airPeopleAnswerEntity);
    }

    @Override
    public List<AirPeopleAnswerEntity> listAirPeopleAnswer(Integer airPeopleStage,Integer type) {
        return airPeopleRecruitDao.listAirPeopleAnswer(airPeopleStage,type);
    }

    @Override
    public R getPeopleBasisInfo(Integer userID) {
        try {
            return R.ok().put("code",0).put("msg","成功").put("data",airPeopleRecruitDao.getPeopleBasisInfo(userID));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","失败");
        }
    }

    @Override
    public R updatePeopleBasisInfo(AirPeopleEntity airPeopleEntity) {
        try {
            airPeopleRecruitDao.updatePeopleBasisInfo(airPeopleEntity);
            return R.ok().put("code",0).put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.ok().put("code",-1).put("msg","修改失败");
        }
    }

    @Override
    public R updateUserRegion(AirPeopleEntity airPeopleEntity) {
        try {
            airPeopleRecruitDao.updateUserRegion(airPeopleEntity);
            return R.ok().put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","保存地区失败");
        }
    }

    @Override
    public R updatePeopleExp(AirPeopleEntity airPeopleEntity) {
        try {
            airPeopleRecruitDao.updatePeopleExp(airPeopleEntity);
            return R.ok().put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","保存经验失败");
        }
    }

    @Override
    public R updatePeopleStrength(AirPeopleEntity airPeopleEntity) {
        try {
            airPeopleRecruitDao.updatePeopleStrength(airPeopleEntity);
            return R.ok().put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","保存失败");
        }
    }

    @Override
    public R updatePeopleSource(AirPeopleEntity airPeopleEntity) {
        try {
            airPeopleRecruitDao.updatePeopleSource(airPeopleEntity);
            return R.ok().put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error().put("code",-1).put("msg","保存失败");
        }
    }

    @Override
    public Integer insertAirPeopleEvaluate(AirPeopleEvaluateEntity airPeopleEvaluateEntity) {
        airPeopleEvaluateEntity.setDelFlag(0);
        return airPeopleRecruitDao.insertAirPeopleEvaluate(airPeopleEvaluateEntity);
    }

    @Override
    public AirPeopleEvaluateEntity getAirPeopleEvaluate(Integer aid,Integer pid) {
        return airPeopleRecruitDao.getAirPeopleEvaluate(aid,pid);
    }


    @Override
    public Integer insertAirPeopleHandle(AirPeopleHandleEntity airPeopleHandleEntity) {
        return airPeopleRecruitDao.insertAirPeopleHandle(airPeopleHandleEntity);
    }

    @Override
    public Integer generateContract(Integer aid, Double joinFee,String uuid) {
        return airPeopleRecruitDao.generateContract(aid,joinFee,uuid);
    }

    @Override
    public Integer renewalContract(Integer aid, Double joinFee) {
        return airPeopleRecruitDao.renewalContract(aid,joinFee);
    }

    @Override
    public Map<String, Object> joinInfo(Integer aid) {
        return airPeopleRecruitDao.joinInfo(aid);
    }

    @Override
    public Integer insertUserJoinc(UserinfoJoinc userinfoJoinc) {
        return airPeopleRecruitDao.insertUserJoinc(userinfoJoinc);
    }

    @Override
    public List<Map<String, String>> selectUserJoinc(Integer aid) {
        return airPeopleRecruitDao.selectUserJoinc(aid);
    }

    @Override
    public List<Map<String, String>> getJoinPhoto(Integer aid, String uuid) {
        return airPeopleRecruitDao.getJoinPhoto(aid,uuid);
    }

    @Override
    public List<Map<String, Object>> joinInfoHis(Integer aid) {
        return airPeopleRecruitDao.joinInfoHis(aid);
    }

    @Override
    public Integer updateContractJoin(UserinfoJoin userinfoJoin) {
        return airPeopleRecruitDao.updateContractJoin(userinfoJoin);
    }

    @Override
    public int makeContractJoin(UserinfoJoin userinfoJoin) {
        return airPeopleRecruitDao.makeContractJoin(userinfoJoin);
    }

    @Override
    public int updateJoinPhoto(Integer aid, Integer attr_modelid) {
        return airPeopleRecruitDao.updateJoinPhoto(aid,attr_modelid);
    }

    @Override
    public int insertJoinPhoto(Integer uid, String serverUrl, String fileName, String operate, String operateNo, Integer attr_modelid, Integer id, String uuid) {
        return airPeopleRecruitDao.insertJoinPhoto(uid,serverUrl,fileName,operate,operateNo,attr_modelid,id,uuid);
    }

    @Override
    public int insertContractJoin(Integer aid) {
        return airPeopleRecruitDao.insertContractJoin(aid);
    }


    /**
     * 根据条件查询人员招聘阶段信息
     * @param airPeopleEntity 条件
     * @return 人员招聘阶段信息
     */
    @Override
   public   AirPeopleEntity getUserRecruitMsgByCondition(AirPeopleEntity airPeopleEntity)
    {

        return baseMapper.getUserRecruitMsgByCondition(airPeopleEntity);
    }


    /**
     * 根据条件查询空调人员上传照片信息
     * @param airPeopleInfoEntity 条件
     * @return 上传照片信息
     */
    @Override
    public  List<AirPeopleInfoEntity> getAirPeopleInfoByCondition(AirPeopleInfoEntity airPeopleInfoEntity)
    {
        return baseMapper.getAirPeopleInfoByCondition(airPeopleInfoEntity);
    }

    /**
     * 添加空调人员图片资料信息
     * @param airPeopleInfoEntities 图片资料信息
     * @return
     */
    @Override
   public int insertAirPeopleInfo(@Param("list") List<AirPeopleInfoEntity> airPeopleInfoEntities)
    {
        return baseMapper.insertAirPeopleInfo(airPeopleInfoEntities);
    }

    /**
     * 修改空调人员图片资料信息
     * @param airPeopleInfoEntity 图片资料信息
     * @return
     */
    @Override
    public int updateAirPeopleInfoByCondition(AirPeopleInfoEntity airPeopleInfoEntity)
    {
        return baseMapper.updateAirPeopleInfoByCondition(airPeopleInfoEntity);
    }
    /**
     * 修改空调人员招商信息
     * @param airPeopleEntity 空调人员招商信息
     * @return
     */
    @Override
    @Transactional
    public int updateUserRecruitMsgByCondition(AirPeopleEntity airPeopleEntity) {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        try
        {
            //更新人员招商信息

            baseMapper.updatePeopleBasisInfo(airPeopleEntity);
            baseMapper.updateUserRecruitMsgByCondition(airPeopleEntity);
            //删除之前的图片资料信息
            AirPeopleInfoEntity airPeopleInfoEntity=new AirPeopleInfoEntity();
            airPeopleInfoEntity.setAid(airPeopleEntity.getAid());
            airPeopleInfoEntity.setDelFlag(1);
            airPeopleInfoEntity.setUpdateAttrModelId("1,2,3,35");
            baseMapper.updateAirPeopleInfoByCondition(airPeopleInfoEntity);
            //添加图片信息
            if(airPeopleEntity.getAirPeopleInfoEntityList().size()>0)
            {
                baseMapper.insertAirPeopleInfo(airPeopleEntity.getAirPeopleInfoEntityList());
            }


        }catch (Exception ex)
        {
            ex.printStackTrace();
            txManager.rollback(status);
        }

        return 1;
    }

    @Override
    public Integer insertAirPeopleVisit(AirPeopleVisit airPeopleVisit) {
        return airPeopleRecruitDao.insertAirPeopleVisit(airPeopleVisit);
    }

    @Override
    public List<AirPeopleVisit> listAirPeopleVisit(Integer aid) {
        return airPeopleRecruitDao.listAirPeopleVisit(aid);
    }


    /**
     * 验证手机号是否存在
     * @param airPeopleEntity
     * @return
     */
    @Override
    public int verificationPhone(AirPeopleEntity airPeopleEntity) {
        return baseMapper.verificationPhone(airPeopleEntity);
    }

    /**
     * 根据条件获取标准及评价信息
     * @param airPeopleAnswerEntity
     * @return
     */
    @Override
    public List<AirPeopleAnswerEntity> getAirPeopleAnswerByCondition(AirPeopleAnswerEntity airPeopleAnswerEntity) {
        return baseMapper.getAirPeopleAnswerByCondition(airPeopleAnswerEntity);
    }


    @Override
    public List<Map<String,Object>> listAirLeavePeople(AirPeopleEntity airPeopleEntity) {
        return airPeopleRecruitDao.listAirLeavePeople(airPeopleEntity);
    }

    /**
     * 根据aid 和加盟费凭证添加加盟费实缴金额和缴费时间
     */
    @Override
    public List<Map<String,Object>> getReceiptsMsg(InsertJoinReceive insertJoinReceive){
        return baseMapper.getReceiptsMsg(insertJoinReceive);
    }

    /**
     * 同步空调人员加盟费
     * @param sourceCode 凭证号
     * @param joinMoney 加盟费
     * @return
     */
    @Override
    public int synchroAirPeopleJoinMoney(String sourceCode, double joinMoney,int moneyType) {
        return  baseMapper.synchroAirPeopleJoinMoney(sourceCode,joinMoney,moneyType);
    }

}
