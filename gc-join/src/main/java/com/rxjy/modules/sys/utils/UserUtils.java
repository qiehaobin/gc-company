package com.rxjy.modules.sys.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.CookieUtils;
import com.rxjy.common.utils.JedisUtils;
import com.rxjy.modules.sys.entity.UserEntity;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @create 2018-05-22 17:26
 */

public class UserUtils {

	public static final String LOGIN_REDIS_HEAD= Global.getValue("loginRedisHead");
	public static final String LOGIN_COOKIE_NAME = Global.getValue("loginCookieName");

	public static UserEntity getLoginUser(HttpServletRequest request){
		String token = CookieUtils.getCookie(request,LOGIN_COOKIE_NAME);
		if (StringUtils.isBlank(token)){
			return null;
		}else {
			String result = JedisUtils.get(LOGIN_REDIS_HEAD+token);
			return JSON.parseObject(result,UserEntity.class);
		}
	}

	public static UserEntity userJsonToEntity(String json){
		UserEntity user = new UserEntity();
		try {
			if (StringUtils.isBlank(json)){
				user=null;
			}else {
				JSONObject object = JSON.parseObject(json);
				user.setDeptId(object.getString("bumenId"));
				user.setDeptName(object.getString("bumenName"));
				user.setFlag(object.getString("flag"));
				user.setHeadPortrait(object.getString("touxiang"));
				user.setJobId(object.getString("zhiwuId"));
				user.setJobName(object.getString("zhiwuName"));
				user.setRegionId(object.getString("u_diqu"));
				user.setRegionName(object.getString("dq_name"));
				user.setRoleId(object.getString("juese"));
				user.setRoleName(object.getString("juesename"));
				user.setName(object.getString("xinming"));
				user.setCityId(object.getString("ct"));
			}
		}catch (Exception e){
			user = null;
		}
		return user;
	}
}
