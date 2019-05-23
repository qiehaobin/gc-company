package com.rxjy.modules.sys.interceptor;

import com.rxjy.modules.sys.entity.UserEntity;
import com.rxjy.modules.sys.utils.UserUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @create 2018-05-23 9:36
 */

public class LoginUserInterceptor implements HandlerInterceptor {

	private static final String MANAGERURL = "manager";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestURI = request.getRequestURI();
		if(	requestURI.indexOf(MANAGERURL)<0){
			UserEntity user = UserUtils.getLoginUser(request);
			if (user==null){
				response.sendRedirect(request.getContextPath()+"/wps");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		String requestURI = request.getRequestURI();
		if(requestURI.indexOf(MANAGERURL)<0){
			UserEntity user = UserUtils.getLoginUser(request);
			if (user!=null && modelAndView!=null){
				modelAndView.addObject("loginUser",user);
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

	}
}
