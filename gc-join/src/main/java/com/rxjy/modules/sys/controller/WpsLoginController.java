/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.rxjy.modules.sys.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.rxjy.common.utils.CookieUtils;
import com.rxjy.common.utils.DictUtils;
import com.rxjy.common.utils.Global;
import com.rxjy.common.utils.JedisUtils;
import com.rxjy.modules.sys.entity.UserEntity;
import com.rxjy.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * WPSC登录ontroller
 * @author zqm
 * @version 2017-04-22
 */
@Controller
@RequestMapping(value = "wps")
public class WpsLoginController extends AbstractController{

	public static final String LOGIN_REDIS_HEAD= "gchr.login.";
	public static final String LOGIN_COOKIE_NAME = "gchrLoginToken";
	public static final String CITY_FLAG = "1";

	@RequestMapping(value = {"index",""},method = RequestMethod.GET)
	public ModelAndView wpsIndex(ModelAndView modelAndView,HttpServletResponse response, HttpServletRequest request) {
		UserEntity user = UserUtils.getLoginUser(request);
		if(user == null){
			modelAndView.addObject("message","请从WPS重新登录系统，暂无权限访问！");
			modelAndView.addObject("code","无权限访问");
			modelAndView.setViewName("error/403.html");
		}else {
			modelAndView.addObject("loginUser",user);
			modelAndView.setViewName("layout/layout.html");
		}
		return modelAndView;
	}


	/**
	 * wps跳转登录
	 * @param modelAndView	mv
	 * @param cardno	账号
	 * @param pk	密码
	 * @param GM	wps校验参数
	 * @param hide	是否隐藏,默认不隐藏(false),隐藏(true)
	 * @param url	指定跳转路径
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "login1")
	public ModelAndView wpsLogin(ModelAndView modelAndView,String cardno, String pk, @RequestParam(required = false) String GM,boolean hide,String url,HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			logger.info("请求前："+System.currentTimeMillis());
			result = restTemplate.getForObject( Global.getValue("kghost")+"/api/price/GetUserInfoJson?card=" + cardno + "&password=" + pk + "&GM=" + GM, String.class);
			logger.info("请求后："+System.currentTimeMillis());
			JSONArray jsonArray = JSONArray.parseArray(result);
			logger.info("转换后："+System.currentTimeMillis());
			boolean flag = false;
			if(jsonArray.size()>0){
				flag=true;
				String fg = jsonArray.getJSONObject(0).getString("fg");
					String role = jsonArray.getJSONObject(0).getString("juese");
					//允许登录列表
					String dictValue = DictUtils.getDictValue(role,"loginRole","");
					if (dictValue==null || dictValue.equals("")){
						flag=false;
					}
			}
			if (!flag){
				modelAndView.addObject("message","此用户未授权，禁止访问系统！");
				modelAndView.addObject("code","禁止登录");
				modelAndView.setViewName("error/403.html");
			}else {
				String token = UUID.randomUUID().toString().replace("-", "");
				CookieUtils.setCookie(response,LOGIN_COOKIE_NAME,token,"/",-1);
				UserEntity user = UserUtils.userJsonToEntity(jsonArray.get(0).toString());
				user.setCardno(cardno);
				user.setPassword(pk);
				user.setHide(hide);
				JedisUtils.set(LOGIN_REDIS_HEAD+token, JSON.toJSONString(user),2L, TimeUnit.HOURS);
				if(StrUtil.isBlank(url)){
					modelAndView.addObject("loginUser",user);
					modelAndView.setViewName("layout/layout.html");
				}else {
					response.sendRedirect(request.getContextPath()+"/"+url);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			modelAndView.addObject("message","登录认证接口报错，请联系开发！");
			modelAndView.addObject("code","认证接口异常");
			modelAndView.setViewName("error/error.html");
		}
		return modelAndView;
	}

	@RequestMapping(value = "logout")
	public ModelAndView logout(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response){
		String token = CookieUtils.getCookie(request,LOGIN_COOKIE_NAME);
		JedisUtils.del(LOGIN_REDIS_HEAD+token);
		CookieUtils.getCookie(request,response,LOGIN_COOKIE_NAME,true);
		modelAndView.addObject("message","已成功退出系统！");
		modelAndView.addObject("code","退出系统");
		modelAndView.setViewName("error/logout.html");
		return modelAndView;
	}

	@RequestMapping(value = "login")
	public ModelAndView wpsLogin1(ModelAndView modelAndView,String cardno, String pk, @RequestParam(required = false) String GM,boolean hide,String url,HttpServletRequest request, HttpServletResponse response) {
		String result = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			logger.info("请求前："+System.currentTimeMillis());
			result = restTemplate.getForObject( Global.getValue("kghost")+"/api/price/GetUserInfoJson?card=" + cardno + "&password=" + pk + "&GM=" + GM, String.class);
			logger.info("请求后："+System.currentTimeMillis());
			JSONArray jsonArray = JSONArray.parseArray(result);
			logger.info("转换后："+System.currentTimeMillis());
			boolean flag = false;
			if(jsonArray.size()>0){
				flag=true;
				String fg = jsonArray.getJSONObject(0).getString("fg");
				String role = jsonArray.getJSONObject(0).getString("juese");
				//允许登录列表
				String dictValue = DictUtils.getDictValue(role,"loginRole","");
				if (dictValue==null || dictValue.equals("")){
					flag=false;
				}
			}
			if (!flag){
				modelAndView.addObject("message","此用户未授权，禁止访问系统！");
				modelAndView.addObject("code","禁止登录");
				modelAndView.setViewName("error/403.html");
			}else {
				String token = UUID.randomUUID().toString().replace("-", "");
				CookieUtils.setCookie(response,LOGIN_COOKIE_NAME,token,"/",-1);
				UserEntity user = UserUtils.userJsonToEntity(jsonArray.get(0).toString());
				user.setCardno(cardno);
				user.setPassword(pk);
				user.setHide(hide);
				JedisUtils.set(LOGIN_REDIS_HEAD+token, JSON.toJSONString(user),2L, TimeUnit.HOURS);
				if(StrUtil.isBlank(url)){
					modelAndView.addObject("loginUser",user);
					modelAndView.setViewName("layout/layout.html");
				}else {
					response.sendRedirect(request.getContextPath()+"/"+url);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			modelAndView.addObject("message","登录认证接口报错，请联系开发！");
			modelAndView.addObject("code","认证接口异常");
			modelAndView.setViewName("error/error.html");
		}
		return modelAndView;
	}
}
