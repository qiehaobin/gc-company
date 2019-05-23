package com.rxjy.modules.air.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.rxjy.modules.air.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*

*@Description 空调店铺模板接口

*@Author yangbin
*@Date 2019年3月12日
*/
@Repository
public interface AirPeopleRecruitDao extends BaseMapper<AirPeopleEntity> {


    /**
     * 查询空调人招列表
     * @param airPeopleEntity 空调人招实体类
     * @return 空调人招列表
     */
    List<Map<String,Object>> listAirPeople(AirPeopleEntity airPeopleEntity);
    /**
     * 新增空调经理
     * @param airPeopleEntity 空调人招实体类
     * @return 影响行数
     */
    Integer insertAirPeople(AirPeopleEntity airPeopleEntity);
    /**
     * 新增空调经理(详细表)
     * @param airPeopleEntity 空调人招实体类
     * @return 影响行数
     */
    Integer insertAirPeopleDetail(AirPeopleEntity airPeopleEntity);
    /**
     * 新增空调经理咨询表
     * @param airPeopleConsult 空调经理咨询表实体类
     * @return 影响行数
     */
    Integer insertAirPeopleConsult(AirPeopleConsult airPeopleConsult);
    /**
     * 修改空调经理咨询表
     * @param aid 空调经理id
     * @param sendMsgTime 发短信时间
     * @return 影响行数
     */
    Integer updateAirPeopleConsult(@Param("aid") Integer aid,@Param("sendMsgTime") String sendMsgTime);
    /**
     * 新增空调经理考察表
     * @param airPeopleReview 空调经理考察表实体类
     * @return 影响行数
     */
    Integer insertAirPeopleReview(AirPeopleReview airPeopleReview);
    /**
     * 新增空调经理邀约表
     * @param airPeopleInvite 空调经理邀约表实体类
     * @return 影响行数
     */
    Integer insertAirPeopleInvite(AirPeopleInvite airPeopleInvite);
    /**
     * 修改空调经理信息
     * @param airPeopleEntity 空调人招实体类
     * @return 影响行数
     */
    Integer updateAirPeople(AirPeopleEntity airPeopleEntity);
    /**
     * 新增阶段问答
     * @param airPeopleAnswerEntity 阶段问答实体类
     * @return 影响行数
     */
    Integer insertAirPeopleAnswer(AirPeopleAnswerEntity airPeopleAnswerEntity);
    /**
     * 查询阶段问答
     * @param airPeopleStage 阶段 1招聘 2咨询 3考察 4邀约 5集团 6签约
     * @param type 1解答 2标准
     * @return  阶段问答实列表
     */
    List<AirPeopleAnswerEntity> listAirPeopleAnswer(@Param("airPeopleStage") Integer airPeopleStage,@Param("type") Integer type);
    /**
     * 新增空调经理评价
     * @param airPeopleEvaluateEntity 空调经理评价实体类
     * @return 影响行数
     */
    Integer insertAirPeopleEvaluate(AirPeopleEvaluateEntity airPeopleEvaluateEntity);
    /**
     * 查询空调经理评价
     * @param aid 空调经理id
     * @return 空调经理评价实体类
     */
    AirPeopleEvaluateEntity getAirPeopleEvaluate(@Param("aid") Integer aid,@Param("pid") Integer pid);

    /**
     *
     * 功能描述: 根据经理ID获取基础信息
     * 位置：
     * @param: 经理ID
     * @auther: XUSK
     * @date: 2019/3/14 10:30
     */
    Map<String,Object> getPeopleBasisInfo(Integer userID);
    /**
     * 新增空调经理处理记录
     * @param airPeopleHandleEntity 空调经理处理记录实体类
     * @return 影响行数
     */
    Integer insertAirPeopleHandle(AirPeopleHandleEntity airPeopleHandleEntity);
    /**
     *
     * 功能描述:修改人员基础信息
     * 位置：
     * @param:
     * @auther: XUSK
     * @date: 2019/3/14 13:33
     */
    void updatePeopleBasisInfo(AirPeopleEntity airPeopleEntity);
    /**
     *
     * 功能描述:修改人员地区信息
     * 位置：
     * @param:
     * @auther: XUSK
     * @date: 2019/3/14 13:33
     */
    void updateUserRegion(AirPeopleEntity airPeopleEntity);

    /**
     * 修改用户实力
     * @param airPeopleEntity
     */
    void updatePeopleStrength(AirPeopleEntity airPeopleEntity);

    /**
     * 修改用户来源
     * @param airPeopleEntity
     */
    void updatePeopleSource(AirPeopleEntity airPeopleEntity);

    /**
     * 修改用户经验
     * @param airPeopleEntity
     */
    void updatePeopleExp(AirPeopleEntity airPeopleEntity);

    /**
     * 新增一条合同信息
     * @param aid  人员id
     * @param joinFee  加盟费
     * @return
     */
    Integer generateContract(@Param("aid") Integer aid,@Param("joinFee") Double joinFee,@Param("uuid") String uuid);
    /**
     * 续签合同
     * @param aid  人员id
     * @param joinFee  加盟费
     * @return
     */
    Integer renewalContract(@Param("aid") Integer aid,@Param("joinFee") Double joinFee);
    /**
     * 获取加盟信息
     * @param aid 人员id
     * @return
     */
    Map<String, Object> joinInfo(@Param("aid") Integer aid);
    /**
     * 新增材料商缴加盟费记录
     * @param userinfoJoinc 凭证单号
     * @return 影响行数
     */
    Integer insertUserJoinc(UserinfoJoinc userinfoJoinc);
    /**
     * 查询材料商加盟费凭证单号和状态
     * @param aid 人员id
     * @return 加盟信息列表
     */
    List<Map<String, String>> selectUserJoinc(@Param("aid") Integer aid);
    /**
     * 获取加盟合同图片信息
     * @param aid 人员id
     * @return
     */
    List<Map<String, String>> getJoinPhoto(@Param("aid") Integer aid,@Param("uuid") String uuid);
    /**
     * 获取加盟信息(历史)
     * @param aid 人员id
     * @return
     */
    List<Map<String, Object>> joinInfoHis(@Param("aid") Integer aid);
    /**
     * 修改加盟时间
     * @param aid 人员id
     * @return
     */
    Integer updateContractJoin(UserinfoJoin userinfoJoin);
    /**
     * 签约   修改签约信息
     * @param aid 人员id
     * @param joinFee 加盟费
     * @param operate 登录人姓名
     * @param operateNo  登录人卡号
     * @param start 合同开始时间
     * @param stop 合同结束时间
     * @return
     */
    int makeContractJoin(UserinfoJoin userinfoJoin);
    /**
     * 修改加盟合同图片状态
     * @param aid 人员id
     * @return
     */
    int updateJoinPhoto(@Param("aid") Integer aid,@Param("attr_modelid") Integer attr_modelid);
    /**
     * 保存加盟合同图片
     * @param uid 人员id
     * @param serverUrl 图片url
     * @param fileName 图片名
     * @param operate 登录人
     * @param operateNo  登录人卡号
     * @return
     */
    int insertJoinPhoto(@Param("aid") Integer aid, @Param("serverUrl") String serverUrl, @Param("fileName") String fileName, @Param("operate") String operate, @Param("operateNo") String operateNo,@Param("attr_modelid") Integer attr_modelid,@Param("id") Integer id,@Param("uuid") String uuid);
    /**
     * 修改签约信息为失效状态
     * @param aid  人员id
     * @return
     */
    int insertContractJoin(@Param("aid") Integer aid);

    /**
     * 根据条件查询人员招聘阶段信息
     * @param airPeopleEntity 条件
     * @return 人员招聘阶段信息
     */
    AirPeopleEntity getUserRecruitMsgByCondition(AirPeopleEntity airPeopleEntity);

    /**
     * 根据条件查询空调人员上传照片信息
     * @param airPeopleInfoEntity 条件
     * @return 上传照片信息
     */
    List<AirPeopleInfoEntity> getAirPeopleInfoByCondition(AirPeopleInfoEntity airPeopleInfoEntity);

    /**
     * 添加空调人员图片资料信息
     * @param airPeopleInfoEntities 图片资料信息
     * @return
     */
    int insertAirPeopleInfo(@Param("list") List<AirPeopleInfoEntity> airPeopleInfoEntities);

    /**
     * 修改空调人员图片资料信息
     * @param airPeopleInfoEntity 图片资料信息
     * @return
     */
    int updateAirPeopleInfoByCondition(AirPeopleInfoEntity airPeopleInfoEntity);

    /**
     * 修改空调人员招商信息
     * @param airPeopleEntity 空调人员招商信息
     * @return
     */
    int updateUserRecruitMsgByCondition(AirPeopleEntity airPeopleEntity);

    /**
     * 新增空调经理回访
     * @param airPeopleVisit 空调经理回访实体类
     * @return 影响行数
     */
    Integer insertAirPeopleVisit(AirPeopleVisit airPeopleVisit);
    /**
     * 查询空调经理回访
     * @param aid 人员id
     * @return
     */
    List<AirPeopleVisit> listAirPeopleVisit(@Param("aid") Integer aid);

    /**
     * 验证手机号是否存在
     * @param airPeopleEntity
     * @return
     */
    int verificationPhone(AirPeopleEntity airPeopleEntity);

    /**
     * 根据条件获取标准及评价信息
     * @param airPeopleAnswerEntity
     * @return
     */
    List<AirPeopleAnswerEntity> getAirPeopleAnswerByCondition(AirPeopleAnswerEntity airPeopleAnswerEntity);

    /**
     * 查询空调人招列表
     * @param airPeopleEntity 空调人招实体类
     * @return 空调人招列表
     */
    List<Map<String,Object>> listAirLeavePeople(AirPeopleEntity airPeopleEntity);

    /**
     * 根据aid 和加盟费凭证添加加盟费实缴金额和缴费时间
     */
    List<Map<String,Object>> getReceiptsMsg(InsertJoinReceive insertJoinReceive);

    /**
     * 同步空调人员加盟费
     * @param sourceCode 凭证号
     * @param joinMoney 加盟费
     * @return
     */
    int synchroAirPeopleJoinMoney(@Param("sourceCode") String sourceCode,@Param("joinMoney") double joinMoney,@Param("moneyType") int moneyType);
}
