package com.rxjy.modules.air.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.JsonMapper;
import com.rxjy.common.utils.R;
import com.rxjy.modules.air.dao.PublicModuleDao;
import com.rxjy.modules.air.entity.*;
import com.rxjy.modules.air.entity.PublicEntity.PublicChildModuleEntity;
import com.rxjy.modules.air.entity.PublicEntity.PublicModuleEntity;
import com.rxjy.modules.air.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;


@RestController
@RequestMapping("air/airPeopleRecruit")
/*

 *@Description 空调人招控制器

 *@Author 任何
 *@Date 2019年3月13日
 */
public class AirPeopleRecruitController {

    @Autowired
    private AirPeopleRecruitService airPeopleRecruitService;
    @Autowired
    private AirPeopleShopService airPeopleShopService;

    @Autowired
    private PublicModuleService publicModuleService;

    @Autowired
    private  PublicChildModuleService publicChildModuleService;

    /**
     * 查询空调人招列表
     * @param airPeopleEntity 空调人招实体类
     * @return 空调人招列表
     */
    @RequestMapping(value = "/listAirPeople",method= RequestMethod.GET)
    public R listAirPeople(AirPeopleEntity airPeopleEntity) {
        try {
            List<Map<String,Object>> list = airPeopleRecruitService.listAirPeople(airPeopleEntity);
            return R.ok().put("code",1).put("msg","成功").put("data", list);
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }

    /**
     * 查询空调人招淘汰列表
     * @param airPeopleEntity 空调人招实体类
     * @return 空调人招淘汰列表
     */
    @RequestMapping(value = "/listAirLeavePeople",method= RequestMethod.GET)
    public R listAirLeavePeople(AirPeopleEntity airPeopleEntity) {
        try {
            List<Map<String,Object>> list = airPeopleRecruitService.listAirLeavePeople(airPeopleEntity);
            return R.ok().put("code",1).put("msg","成功").put("data", list);
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 新增空调经理
     * @param airPeopleEntity 空调人招实体类
     * @return 影响行数
     */
    @RequestMapping(value = "/insertAirPeople",method= RequestMethod.POST)
    @Transactional
    public R insertAirPeople(AirPeopleEntity airPeopleEntity) {
        try {
            airPeopleEntity.setDelFlag(0);
            airPeopleEntity.setAirPeopleState(0);
            Integer result = airPeopleRecruitService.insertAirPeople(airPeopleEntity);
            Integer aid=airPeopleEntity.getAid();
            //airPeopleEntity.setId(id);
            Integer resultDetail = airPeopleRecruitService.insertAirPeopleDetail(airPeopleEntity);

            AirPeopleConsult airPeopleConsult=new AirPeopleConsult();
            airPeopleConsult.setAid(aid);
            Integer resultDetail2 = airPeopleRecruitService.insertAirPeopleConsult(airPeopleConsult);

            AirPeopleReview airPeopleReview=new AirPeopleReview();
            airPeopleReview.setAid(aid);
            Integer resultDetail3 = airPeopleRecruitService.insertAirPeopleReview(airPeopleReview);

            AirPeopleInvite airPeopleInvite=new AirPeopleInvite();
            airPeopleInvite.setAid(aid);
            Integer resultDetail4 = airPeopleRecruitService.insertAirPeopleInvite(airPeopleInvite);
            if(
                result!=null&&result==1
                &&resultDetail!=null&&resultDetail==1
                &&resultDetail2!=null&&resultDetail2==1
                &&resultDetail3!=null&&resultDetail3==1
                &&resultDetail4!=null&&resultDetail4==1
            ){
                return R.ok().put("code",1).put("msg","成功").put("aid",aid);
            }else{
                throw new Exception("失败");
            }
        }catch (Exception e){
            String cause="com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '"+airPeopleEntity.getMobile()+"' for key 'airPeopleMobile'";
            /*System.out.println(e.getCause().toString());
            System.out.println("AAAAAAAAAAA");
            System.out.println(cause.equals(e.getCause().toString()));
            System.out.println("BBBBBBBBBBB");*/
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            if(cause.equals(e.getCause().toString())){
                return R.error().put("code",600).put("msg","手机号已存在");
            }else{
                return R.error().put("code",500).put("msg","失败");
            }
        }
    }

    /**
     * 验证手机号是否存在
     * @param airPeopleEntity
     * @return
     * aid 0不存在 大于0存在
     */
    @RequestMapping("/verificationPhone")
    public R verificationPhone(AirPeopleEntity airPeopleEntity)
    {
      int aid = airPeopleRecruitService.verificationPhone(airPeopleEntity);
        return R.ok().put("aid",aid);
    }

    /**
     * 修改空调经理信息
     * @param airPeopleEntity 空调人招实体类
     * @return 影响行数
     */
    @RequestMapping(value = "/updateAirPeople",method= RequestMethod.GET)
    @Transactional
    public R updateAirPeople(AirPeopleEntity airPeopleEntity,String content) {
        try {
            Integer result = airPeopleRecruitService.updateAirPeople(airPeopleEntity);
            if(result!=null&&result==1){
                return R.ok().put("code",1).put("msg","成功");
            }else{
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 新增空调经理处理记录
     * @param airPeopleEntity 空调人招实体类
     * @return 影响行数
     */
    @RequestMapping(value = "/insertAirPeopleHandle",method= RequestMethod.GET)
    @Transactional
    public R insertAirPeopleHandle(AirPeopleEntity airPeopleEntity,String content) {
        try {
            System.out.println("airPeopleEntity1:"+airPeopleEntity.getAirPeopleStage());
            Integer result = airPeopleRecruitService.updateAirPeople(airPeopleEntity);
            AirPeopleHandleEntity airPeopleHandleEntity=new AirPeopleHandleEntity();
            airPeopleHandleEntity.setAid(airPeopleEntity.getAid());
            airPeopleHandleEntity.setContent(content);
            airPeopleHandleEntity.setAirPeopleStage(airPeopleEntity.getAirPeopleStage());
            airPeopleHandleEntity.setDelFlag(0);
            airPeopleHandleEntity.setCreateNo(airPeopleEntity.getCreateNo());
            airPeopleHandleEntity.setCreateUser(airPeopleEntity.getCreateUser());
            Integer result2=airPeopleRecruitService.insertAirPeopleHandle(airPeopleHandleEntity);
            //如果跳阶段到培训，则默认添加培训数据数据
            System.out.println("airPeopleEntity2:"+airPeopleEntity.getAirPeopleStage());
            if(airPeopleEntity.getAirPeopleStage()==7)
            {
                AirPeopleShopEntity recruitMsg = airPeopleShopService.getAirUserShopRecruitMsgaid(airPeopleEntity.getAid());
                synchronousPeoplePlateModuleMsg(airPeopleEntity.getAid(),1);
                //1   同步数据到六师
                Map<String, Object> maps = new HashMap<>();
                maps.put("functionType",0);
                maps.put("shopStage",20);
                maps.put("id",recruitMsg.getShellId());
                maps.put("shopName",airPeopleEntity.getAirName());
                maps.put("shopInformationId",airPeopleEntity.getShopId());
                JSONObject mspJson = JSONUtil.parseFromMap(maps);
                JSONObject object = JSONUtil.parseObj(maps);
                String urlString = Global.getValue("sixdivisionApi") + "/api/updateTcpShopShellStage";
                String tsip = HttpRequest.post(urlString)
                        .body(object)
                        .execute().body();
                JSONObject jsonObject = JSONUtil.parseObj(tsip);
                String statusCode = jsonObject.getStr("statusCode");
                if ("1".equals(statusCode)) {
                    return R.ok();
                } else {
                    return R.error();
                }

            }
            Integer hid=airPeopleHandleEntity.getId();
            AirPeopleVisit airPeopleVisit=new AirPeopleVisit();
            airPeopleVisit.setAid(airPeopleEntity.getAid());
            airPeopleVisit.setHid(hid);
            airPeopleVisit.setType(1);
            airPeopleVisit.setOperatType(1);
            airPeopleVisit.setMark(airPeopleEntity.getMarkState());
            airPeopleVisit.setContent(content);
            airPeopleVisit.setCreateNo(airPeopleEntity.getCreateNo());
            airPeopleVisit.setCreateUser(airPeopleEntity.getCreateUser());
            Integer result3=airPeopleRecruitService.insertAirPeopleVisit(airPeopleVisit);
            if(result!=null&&result==1&&result2!=null&&result2==1&&result3!=null&&result3==1){
                return R.ok().put("code",1).put("msg","成功");
            }else{
                throw new Exception("失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 新增阶段问答
     * @param airPeopleAnswerEntity 阶段问答实体类
     * @return 影响行数
     */
    @RequestMapping(value = "/insertAirPeopleAnswer",method= RequestMethod.GET)
    public R insertAirPeopleAnswer(AirPeopleAnswerEntity airPeopleAnswerEntity) {
        try {
            airPeopleAnswerEntity.setDelFlag(0);
            Integer result = airPeopleRecruitService.insertAirPeopleAnswer(airPeopleAnswerEntity);
            if(result!=null&&result==1){
                return R.ok().put("code",1).put("msg","成功");
            }else{
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 查询阶段问答
     * @param airPeopleStage 阶段 1招聘 2咨询 3考察 4邀约 5集团 6签约
     * @param type 1解答 2标准
     * @return  阶段问答实列表
     */
    @RequestMapping(value = "/listAirPeopleAnswer",method= RequestMethod.GET)
    public R listAirPeopleAnswer(Integer airPeopleStage,Integer type) {
        try {
            List<AirPeopleAnswerEntity> list = airPeopleRecruitService.listAirPeopleAnswer(airPeopleStage,type);
            return R.ok().put("code",1).put("msg","成功").put("data", list);
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 新增空调经理评价
     * @param airPeopleEvaluateEntity 空调经理评价实体类
     * @return 影响行数
     */
    @RequestMapping(value = "/insertAirPeopleEvaluate",method= RequestMethod.GET)
    public R insertAirPeopleEvaluate(AirPeopleEvaluateEntity airPeopleEvaluateEntity) {
        try {
            Integer result = airPeopleRecruitService.insertAirPeopleEvaluate(airPeopleEvaluateEntity);
            if(result!=null&&result==1){
                return R.ok().put("code",1).put("msg","成功");
            }else{
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 查询空调经理评价
     * @param aid 空调经理id
     * @return 空调经理评价实体类
     */
    @RequestMapping(value = "/getAirPeopleEvaluate",method= RequestMethod.GET)
    public R getAirPeopleEvaluate(Integer aid,Integer pid) {
        try {
            AirPeopleEvaluateEntity airPeopleEvaluateEntity = airPeopleRecruitService.getAirPeopleEvaluate(aid,pid);
            if(airPeopleEvaluateEntity==null){
                return R.ok().put("code",500).put("msg","失败");
            }else{
                return R.ok().put("code",1).put("msg","成功").put("data", airPeopleEvaluateEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    @RequestMapping(value="insertJoinReceive",method= RequestMethod.POST)
    @ApiOperation(value="通知财务",notes = "")
    @ResponseBody
    @Transactional
    public R insertJoinReceive(@RequestBody InsertJoinReceive insertJoinReceive) {
        try {
            insertJoinReceive.setReceiptsTime(new Date());
            Map<String, Object> map=airPeopleRecruitService.joinInfo(insertJoinReceive.getAid());
            //System.out.println(pmjJoinFee.compareTo(BigDecimal.ZERO)!=1);

            if(map==null){//不存在合同新增一条合同信息
                String uuid=UUID.randomUUID().toString();
                Integer resultCon=airPeopleRecruitService.generateContract(insertJoinReceive.getAid(),insertJoinReceive.getShouldAmount(),uuid);
            }else{//存在合同根据aid 和加盟费凭证添加加盟费实缴金额和缴费时间
                //Integer resultCon=airPeopleRecruitService.renewalContract(insertJoinReceive.getAid(),insertJoinReceive.getShouldAmount());

            }
            /*if(map==null||map.get("pmj_JoinFee")==null||pmjJoinFee.compareTo(BigDecimal.ZERO)!=1){
                if(resultCon==null||resultCon<=0){//没有加盟费或者小于等于0判断生成合同信息结果
                    throw new Exception("生成合同信息失败");
                }
            }*/
            //System.out.println("resultCon:"+resultCon);
            String joinUrl= Global.getValue("pfUrl")+"HG/GoodsReceive/InsertJoinReceive14";
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("Province",insertJoinReceive.getProvince());
            hashMap.put("Region",insertJoinReceive.getRegion());
            hashMap.put("CompanyName",insertJoinReceive.getCompanyName());
            hashMap.put("CompanyCode",insertJoinReceive.getCompanyCode());
            hashMap.put("Level",insertJoinReceive.getLevel());
            hashMap.put("ShouldAmount",insertJoinReceive.getShouldAmount());
            hashMap.put("SourceBy",insertJoinReceive.getSourceBy());
            hashMap.put("Money",insertJoinReceive.getMoney());
            hashMap.put("OrderMoney",insertJoinReceive.getOrderMoney());
            hashMap.put("CompanyId",insertJoinReceive.getCompanyId());
            Object jsonPara = com.alibaba.fastjson.JSONObject.toJSON(hashMap);
            String result=HttpUtil.post(joinUrl,hashMap);
            HashMap<String,Object> resultMap = (HashMap<String,Object>) JsonMapper.fromJsonString(result, HashMap.class);
            String statusCode=  resultMap.get("statusCode").toString();
            String statusMsg=  resultMap.get("statusMsg").toString();

            if("1".equals(statusCode)){
                UserinfoJoinc u=new UserinfoJoinc();
                u.setAid(insertJoinReceive.getAid());
                u.setCertificateNo(statusMsg);
                u.setShouldAmount(insertJoinReceive.getShouldAmount());
                u.setOrderMoney(insertJoinReceive.getOrderMoney());
                u.setMoney(insertJoinReceive.getMoney());
                u.setArrivalAccount(0);
                try {
                    airPeopleRecruitService.insertUserJoinc(u);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                throw new Exception("通知财务失败");
            }
            //System.out.println("通知财务:"+result);
            return R.ok().put("code",1);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 查询材料商加盟费凭证单号和状态
     * @param aid 人员id
     * @return 加盟信息列表
     */
    @RequestMapping(value="selectUserJoinc",method= RequestMethod.GET)
    @ApiOperation(value="查询材料商加盟费凭证单号和状态",notes="" +
            "参数:</br>" +
            "uid:材料商id</br>" +
            "</br>" +
            "结果:</br>" +
            "statusCode:1 成功  -1失败</br>" +
            "statusMsg:返回信息</br>" +
            "")
    @ResponseBody
    public R selectUserJoinc(@RequestBody@RequestParam(value="aid" ,required=true)Integer aid) {
        try {
            List<Map<String, String>> list=airPeopleRecruitService.selectUserJoinc(aid);
            return R.ok().put("code",1).put("msg","成功").put("data", list);
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 获取加盟信息
     * @param aid 人员id
     * @return
     */
    @RequestMapping(value="getJoinPhotoAndInfo",method= RequestMethod.GET)
    @ApiOperation(value="获取加盟信息",notes = "")
    @ResponseBody
    public R getJoinPhoto(@ApiParam(value = "人员id") @RequestParam(value = "aid", required = false) Integer aid) {
        try {
            Map<String,Object> joinInfo = airPeopleRecruitService.joinInfo(aid);
            if(joinInfo!=null){
                String uuid = joinInfo.get("UUID").toString();
                List<Map<String, String>> joinPhoto = airPeopleRecruitService.getJoinPhoto(aid, uuid);

                Map<String, Object> map = new HashMap<>();
                map.put("joinPhoto", joinPhoto);
                map.put("joinInfo", joinInfo);
                return R.ok().put("code", 1).put("msg", "成功").put("data", map);
            }else{
                return R.ok().put("code",1).put("msg","查询结果为空").put("data","");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    @RequestMapping(value="getJoinPhotoAndInfoHis",method= RequestMethod.GET)
    @ApiOperation(value="获取加盟信息",notes = "")
    @ResponseBody
    public R getJoinPhotoHis(@ApiParam(value = "人员id") @RequestParam(value = "aid", required = false) Integer aid) {
        try {
            List<Map<String, Object>> list = airPeopleRecruitService.joinInfoHis(aid);
            return R.ok().put("code",1).put("msg","成功").put("data", list);
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }


    @RequestMapping(value="makeContract",method= RequestMethod.POST)
    @ApiOperation(value="签约",notes = "方式 POST  参数 (aid:人员id)")
    @ResponseBody
    @Transactional
    public R makeContract(@ApiParam(value = "人员id") @RequestParam(value = "aid", required = true) Integer aid,
                                 @ApiParam(value = "加盟费") @RequestParam(value = "joinFee", required = true) Double joinFee,
                                 @ApiParam(value = "登录人") @RequestParam(value = "operate", required = true) String operate,
                                 @ApiParam(value = "登录人卡号") @RequestParam(value = "operateNo", required = true) String operateNo,
                                 @ApiParam(value = "图片服务器地址(入驻资料)") @RequestParam(value = "serverUrl", required = true) String serverUrl,
                                 @ApiParam(value = "图片名字(入驻资料)") @RequestParam(value = "fileName", required = true) String fileName,
                                 @RequestParam(value="serverUrlDeposit", required=false) String serverUrlDeposit,//图片服务器地址(押金条扫描)
                                 @RequestParam(value="fileNameDeposit", required=false) String fileNameDeposit,//图片名字(押金条扫描)
                                 @ApiParam(value = "开始时间") @RequestParam(value = "startTime", required = true) String startTime,
                                 @ApiParam(value = "结束时间") @RequestParam(value = "stopTime", required = true) String stopTime,
                                 @ApiParam(value = "加盟凭证") @RequestParam(value = "voucher", required = true) String voucher
                                    ) {
        try {
            String uuid= "";
            Map<String,Object> joinInfo = airPeopleRecruitService.joinInfo(aid);
            if(joinInfo!=null&&joinInfo.get("UUID")!=null&&!"".equals(joinInfo.get("UUID").toString())){
                uuid=joinInfo.get("UUID").toString();
            }else{
                uuid= UUID.randomUUID().toString();
            }

            String[] serverUrls = serverUrl.split(";");
            String[] fileNames = fileName.split(";");

            joinFee=joinFee;
            UserinfoJoin userinfoJoin=new UserinfoJoin();
            userinfoJoin.setAid(aid);
            userinfoJoin.setJoinFee(joinFee);
            userinfoJoin.setOperate(operate);
            userinfoJoin.setOperateNo(operateNo);
            userinfoJoin.setStart(startTime);
            userinfoJoin.setStop(stopTime);
            userinfoJoin.setUuid(uuid);
            userinfoJoin.setVoucher(voucher);
            Integer joinStateUp = airPeopleRecruitService.updateContractJoin(userinfoJoin);
            Integer joinState=0;
            if(joinStateUp==null||joinStateUp==0){
                joinState = airPeopleRecruitService.makeContractJoin(userinfoJoin);
            }else{
                joinState=joinStateUp;
            }

            //int id=userinfoJoin.getId();
            if(serverUrls.length>0){
                airPeopleRecruitService.updateJoinPhoto(aid,35);
                for (int i = 0; i < serverUrls.length; i++) {
                    //插入加盟合同图片
                    int joinPhoto = airPeopleRecruitService.insertJoinPhoto(aid,serverUrls[i],fileNames[i],operate,operateNo,35,null,uuid);//入驻资料
                }
            }

            if(serverUrlDeposit!=null){
                String[] serverDepositUrls = serverUrlDeposit.split(";");
                String[] fileNamesDeposit = fileNameDeposit.split(";");
                airPeopleRecruitService.updateJoinPhoto(aid,12);
                for (int i = 0; i < serverDepositUrls.length; i++) {
                    //插入押金条扫描
                    int joinPhoto = airPeopleRecruitService.insertJoinPhoto(aid,serverDepositUrls[i],fileNamesDeposit[i],operate,operateNo,12,null,uuid);//押金条扫描
                }
            }
            AirPeopleShopEntity airPeople=new AirPeopleShopEntity();
            airPeople.setAid(aid);
            AirPeopleShopEntity recruitMsg = airPeopleShopService.getAirUserShopRecruitMsg(airPeople);
            //同步加盟费到六师
            Map<String, Object> maps = new HashMap<>();
            maps.put("money",joinFee);
            maps.put("payment",1);
            maps.put("paymentType", 1);
            maps.put("processingResult", 1);
            maps.put("shopShellId",recruitMsg.getShellId());
            maps.put("projectId","-");
            maps.put("operationCardNum",operateNo);
            maps.put("operationName",operate);
            maps.put("remarks","空调-"+recruitMsg.getShellId()+"-加盟费-收入："+joinFee+"元，操作人 ："+operateNo+"-"+operate+"");
            maps.put("certificate",voucher);
            JSONObject mspJson = JSONUtil.parseFromMap(maps);
            String urlString = Global.getValue("sixdivisionApi") + "/api/iuShopFinance";
            String tsip = HttpUtil.post(urlString,mspJson);
            JSONObject jsonObject = JSONUtil.parseObj(tsip);
            String statusCode = jsonObject.getStr("statusCode");

            if(joinState!=null&&joinState==1){
                return R.ok().put("code",1).put("msg","成功");
            }else {
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    @RequestMapping(value="makeContractRenewal",method= RequestMethod.POST)
    @ApiOperation(value="续签",notes = "方式 POST  参数 (aid:人员id)")
    @ResponseBody
    @Transactional
    public R makeContractRenewal(@ApiParam(value = "人员id") @RequestParam(value = "aid", required = true) Integer aid,
                                        @ApiParam(value = "加盟费") @RequestParam(value = "joinFee", required = true) Double joinFee,
                                        @ApiParam(value = "登录人") @RequestParam(value = "operate", required = true) String operate,
                                        @ApiParam(value = "登录人卡号") @RequestParam(value = "operateNo", required = true) String operateNo,
                                        @ApiParam(value = "图片服务器地址(入驻资料)") @RequestParam(value = "serverUrl", required = true) String serverUrl,
                                        @ApiParam(value = "图片名字(入驻资料)") @RequestParam(value = "fileName", required = true) String fileName,
                                        @RequestParam(value="serverUrlDeposit", required=false) String serverUrlDeposit,//图片服务器地址(押金条扫描)
                                        @RequestParam(value="fileNameDeposit", required=false) String fileNameDeposit,//图片名字(押金条扫描)
                                        @ApiParam(value = "开始时间") @RequestParam(value = "startTime", required = true) String startTime,
                                        @ApiParam(value = "结束时间") @RequestParam(value = "stopTime", required = true) String stopTime) {
        try {
            String uuid=UUID.randomUUID().toString();
            String[] serverUrls = serverUrl.split(";");
            String[] fileNames = fileName.split(";");

            joinFee=joinFee;
            UserinfoJoin userinfoJoin=new UserinfoJoin();
            userinfoJoin.setAid(aid);
            userinfoJoin.setJoinFee(joinFee);
            userinfoJoin.setOperate(operate);
            userinfoJoin.setOperateNo(operateNo);
            userinfoJoin.setStart(startTime);
            userinfoJoin.setStop(stopTime);
            userinfoJoin.setUuid(uuid);

            //int id=userinfoJoin.getId();
            if(serverUrls.length>0){
                airPeopleRecruitService.updateJoinPhoto(aid,35);
                for (int i = 0; i < serverUrls.length; i++) {
                    //插入加盟合同图片
                    int joinPhoto = airPeopleRecruitService.insertJoinPhoto(aid,serverUrls[i],fileNames[i],operate,operateNo,35,null,uuid);//入驻资料
                }
            }

            if(serverUrlDeposit!=null){
                String[] serverDepositUrls = serverUrlDeposit.split(";");
                String[] fileNamesDeposit = fileNameDeposit.split(";");
                airPeopleRecruitService.updateJoinPhoto(aid,12);
                for (int i = 0; i < serverDepositUrls.length; i++) {
                    //插入押金条扫描
                    int joinPhoto = airPeopleRecruitService.insertJoinPhoto(aid,serverDepositUrls[i],fileNamesDeposit[i],operate,operateNo,12,null,uuid);//押金条扫描
                }
            }

            int join = airPeopleRecruitService.insertContractJoin(aid);

            int joinState=0;
            if(join>0){
                joinState = airPeopleRecruitService.makeContractJoin(userinfoJoin);
            }
            System.out.println("SS:"+joinState+"/"+join);
            if(join==1&&joinState==1){
                return R.ok().put("code",1).put("msg","成功");
            }else {
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 根据条件得到空调招商人员招信息
     *
     * @param airPeopleEntity 条件
     * @return 招商人员招信息
     */
    @RequestMapping("getAirUserRecruitMsgByCondition")
    public R getAirUserRecruitMsgByCondition(AirPeopleEntity airPeopleEntity) {
        //招商人员信息
        AirPeopleEntity airPeople = airPeopleRecruitService.getUserRecruitMsgByCondition(airPeopleEntity);

        //招商人员图片资料信息
        AirPeopleInfoEntity airPeopleInfoEntity = new AirPeopleInfoEntity();
        airPeopleInfoEntity.setAid(airPeopleEntity.getAid());
        List<AirPeopleInfoEntity> airPeopleInfoEntities = airPeopleRecruitService.getAirPeopleInfoByCondition(airPeopleInfoEntity);
        airPeople.setAirPeopleInfoEntityList(airPeopleInfoEntities);
        return R.ok().put("body", airPeople);
    }

    /**
     * 更新空调招商人员信息`
     *
     * @param airPeopleEntity 人员基本信息和图片信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("operationAirUserRecruitMsg")
    public R operationAirUserRecruitMsg(@RequestBody AirPeopleEntity airPeopleEntity) {
        //空调人员信息
        int Resule = airPeopleRecruitService.updateUserRecruitMsgByCondition(airPeopleEntity);
        return R.ok();
    }

    /**
     * 根据条件查询空调人员
     * @param airPeopleShopEntity
     * @return
     * shopId 店铺模板编号
     * shellId 类型编号
     * companyName 公司名称
     * legalName 法人/股东姓名
     * officeSpace 办公住址
     * createDate 创建时间
     * aid 人员编号
     * airName 空调名称
     */

    @CrossOrigin
    @RequestMapping("getAirUserShopRecruitMsg")
    public R getAirUserShopRecruitMsg(AirPeopleShopEntity airPeopleShopEntity)
    {
        AirPeopleShopEntity recruitMsg = airPeopleShopService.getAirUserShopRecruitMsg(airPeopleShopEntity);
        return R.ok().put("body",recruitMsg);
    }

    /**
     * 对店板块招模块里空调人员与店壳信息进行操作
     * @param airPeopleShopEntity
     * @return
     */
    @RequestMapping("operationAirUserShopRecruitMsg")
    public R  operationAirUserShopRecruitMsg(@RequestBody  AirPeopleShopEntity airPeopleShopEntity)
    {
        //通过地区id查找空调人员商铺信息
        List<AirPeopleShopEntity> isExist=airPeopleShopService.getAirPeopleShop(airPeopleShopEntity);
        if(isExist.size()==0){
            //查询不存在的情况下添加
            airPeopleShopEntity.setCreateDate(DateTime.now());
            boolean insert = airPeopleShopService.insert(airPeopleShopEntity);
            return R.ok();
        }else{
            //查询存在的情况下进行更新
            airPeopleShopService.updateAirPeopleShop(airPeopleShopEntity);
            return R.ok();
        }

    }
    /**
     * 对空调人员与店壳信息进行操作
     * @param airPeopleShopEntity
     * @return
     */
    @RequestMapping("operationAirUserShopRecruitStoreMsg")
    public R  operationAirUserShopRecruitStoreMsg(@RequestBody  AirPeopleShopEntity airPeopleShopEntity)
    {
        //通过地区id查找空调人员商铺信息
        List<AirPeopleShopEntity> isExist=airPeopleShopService.getAirPeopleShop(airPeopleShopEntity);
        if(isExist.size()==0){
            //查询不存在的情况下进行添加
            airPeopleShopEntity.setCreateDate(DateTime.now());
            boolean insert = airPeopleShopService.insert(airPeopleShopEntity);

           // return R.ok();
        }else{
            //查询存在的情况下进行更新
            Integer state=airPeopleShopService.updateAirPeopleShop(airPeopleShopEntity);

        }
        //1   同步数据到六师
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("functionType",1);
        maps.put("id",airPeopleShopEntity.getShellId());
        maps.put("useState", 0);
        JSONObject object = JSONUtil.parseObj(maps);
        String urlString = Global.getValue("sixdivisionApi") + "/api/updateTcpShopShellStage";
        String tsip = HttpRequest.post(urlString)
                .body(object)
                .execute().body();
        //String tsip = HttpUtil.post(urlString,object);
        JSONObject jsonObject = JSONUtil.parseObj(tsip);
        String statusCode = jsonObject.getStr("statusCode");
        if ("1".equals(statusCode)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    /**
     * 查询空调经理回访
     * @param aid 人员id
     * @return
     */
    @RequestMapping(value = "/listAirPeopleVisit",method= RequestMethod.GET)
    public R listAirPeopleVisit(Integer aid) {
        try {
            List<AirPeopleVisit> list = airPeopleRecruitService.listAirPeopleVisit(aid);
            return R.ok().put("code",1).put("msg","成功").put("data", list);
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }
    /**
     * 新增空调经理回访记录
     * @param airPeopleVisit 空调人招回访实体类
     * @return 影响行数
     */
    @RequestMapping(value = "/insertAirPeopleVisit",method= RequestMethod.GET)
    @Transactional
    public R insertAirPeopleVisit(AirPeopleVisit airPeopleVisit) {
        try {
            airPeopleVisit.setHid(0);
            airPeopleVisit.setType(1);
            airPeopleVisit.setOperatType(1);
            Integer result=airPeopleRecruitService.insertAirPeopleVisit(airPeopleVisit);
            if(result!=null&&result==1){
                return R.ok().put("code",1).put("msg","成功");
            }else{
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.ok().put("code",500).put("msg","失败");
        }
    }

    /**
     * 同步人员板块模块数据
     * @param aid 人员主键
     * @param  userType 人员类型 1、空调人员
     */
    public  void  synchronousPeoplePlateModuleMsg(int aid,int userType)
    {
        PublicModuleEntity publicModuleEntity=new PublicModuleEntity();
        publicModuleEntity.setAid(aid);
        publicModuleEntity.setUserType(userType);

        List<PublicModuleEntity> publicModuleEntities= publicModuleService.getPublicModuleByCondition(publicModuleEntity);

        //板块模块数据
        ArrayList<PublicChildModuleEntity> moduleEntities=new ArrayList<>();

        for (PublicModuleEntity a:publicModuleEntities)
        {
            PublicChildModuleEntity  publicChildModuleEntity=new PublicChildModuleEntity();
            publicChildModuleEntity.setAid(aid);
            publicChildModuleEntity.setCreateDate(DateTime.now());
            publicChildModuleEntity.setDelFlag(0);
            publicChildModuleEntity.setModuleId(a.getId());
            publicChildModuleEntity.setUpdateDate(DateTime.now());
            publicChildModuleEntity.setUserType(userType);

            publicChildModuleService.insert(publicChildModuleEntity);
        }

    }
    /**
     * 修改空调经理咨询表
     * @param aid 空调经理id
     * @param sendMsgTime 发短信时间
     * @return 影响行数
     */
    @RequestMapping(value = "/updateAirPeopleConsult",method= RequestMethod.GET)
    public R updateAirPeopleConsult(Integer aid,String sendMsgTime) {
        try {
            Integer result=airPeopleRecruitService.updateAirPeopleConsult(aid,sendMsgTime);
            if(result!=null&&result==1){
                return R.ok().put("code",1).put("msg","成功");
            }else{
                throw new Exception("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.ok().put("code",500).put("msg","失败");
        }
    }

    /**
     * 根据条件获取标准及评价信息
     * @param airPeopleAnswerEntity 条件
     * @return
     *
     *  id 标准主键
     *  problem 标准标题
     *  answer 标准内容
     *  evaluate 标准评语,
     *  standard 标准评价 1优 2良 3中 4差
     */
    @RequestMapping("/getAirPeopleAnswerByCondition")
    public R getAirPeopleAnswerByCondition(AirPeopleAnswerEntity airPeopleAnswerEntity)
    {
       List<AirPeopleAnswerEntity> airPeopleAnswerEntities= airPeopleRecruitService.getAirPeopleAnswerByCondition(airPeopleAnswerEntity);
        return R.ok().put("body",airPeopleAnswerEntities);
    }

    /**
     * 根据aid 和签约资质查找对应的加盟费  实缴加盟费和缴费时间
     * @param insertJoinReceive
     * @return
     */
    @RequestMapping(value="getReceiptsMsg")
    public R getReceiptsMsg( InsertJoinReceive insertJoinReceive) {
        List<Map<String,Object>> listMap= airPeopleRecruitService.getReceiptsMsg(insertJoinReceive);
        return R.ok().put("data",listMap);
    }

    /**
     * 同步空调人员加盟费
     * 参数：
     * sourceCode 凭证号
     * JoinMoney 加盟费
     * moneyType 金额类型 1加盟费 2风险金
     * @param airShopListDTO
     * @return
     */
    @RequestMapping(value="synchroAirPeopleJoinMoney")
    @Transactional
    public Map<String, Object> synchroAirPeopleJoinMoney(@RequestBody AirShopListDTO airShopListDTO)
    {

        Map<String, Object> responseMap = new HashMap<String, Object>();
        try {
            //如果金额类型为空 默认为加盟费
            if(airShopListDTO.getMoneyType()==null)
            {
                airShopListDTO.setMoneyType(1);
            }
            if(airShopListDTO.getMoneyType()==1)
            {
                //1   同步数据到六师
                Map<String, Object> maps = new HashMap<>();
                maps.put("id",airShopListDTO.getSourceCode());
                maps.put("processingResult",0);
                JSONObject mspJson = JSONUtil.parseFromMap(maps);
                String urlString = Global.getValue("sixdivisionApi") + "/api/updateShopFinanceResult";
                String tsip = HttpUtil.post(urlString,mspJson);
                JSONObject jsonObject = JSONUtil.parseObj(tsip);
                String statusCode = jsonObject.getStr("statusCode");

            }
            airPeopleRecruitService.synchroAirPeopleJoinMoney(airShopListDTO.getSourceCode(),airShopListDTO.getJoinMoney(),airShopListDTO.getMoneyType());
        responseMap.put("body", true);
        responseMap.put("statusCode", 1);
        responseMap.put("statusMsg", "成功");
    } catch (Exception e) {
            e.printStackTrace();
        responseMap.put("statusCode", 0);
        responseMap.put("statusMsg", "失败");
    }

        return responseMap;
    }

}
