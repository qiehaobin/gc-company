package com.rxjy.common.config;

import com.rxjy.common.utils.Global;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * beetl公共模版参数
 *
 * @author Administrator
 * @create 2018-05-18 10:01
 */
public class GlobalExt implements WebRenderExt{
	String verStatic = Global.getValue("verStatic");
	@Override
	public void modify(Template template, GroupTemplate groupTemplate, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		template.binding("ctx",httpServletRequest.getContextPath());
		template.binding("ctxStatic",httpServletRequest.getContextPath()+ "/statics");
		template.binding("verStatic",verStatic);
	}
}
