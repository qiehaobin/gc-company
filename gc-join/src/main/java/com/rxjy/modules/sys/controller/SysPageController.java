/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.rxjy.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统页面视图
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {

	@RequestMapping(value = {"/","/login","/index"})
	public ModelAndView loginRx(){
		ModelAndView modelAndView = new ModelAndView("/layout/layout.html");
		return modelAndView;
	}
	
	@RequestMapping("/manager/modules/{module}/{url}.html")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url){
		return "modules/" + module + "/" + url;
	}

	@RequestMapping(value = {"manager/index.html"})
	public String index(){
		return "index";
	}

	@RequestMapping("manager/index1.html")
	public String index1(){
		return "index1";
	}

	@RequestMapping(value = {"manager/login.html","manager","manager/"})
	public String login(){
		return "login";
	}

	@RequestMapping("manager/main.html")
	public String main(){
		return "main";
	}

	@RequestMapping("manager/404.html")
	public String notFound(){
		return "404";
	}

}
