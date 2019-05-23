package com.rxjy.common.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2018-05-29 9:37
 */
@Component
@ConfigurationProperties(prefix="myprops") //接收application.yml中的myProps下面的属性
public class Global {
	private Map<String, String> mapprops = new HashMap<>(); //接收prop1里面的属性值

	private static Map<String,String> map;

	@PostConstruct
	public void init() {
		map=mapprops;
	}

	public Map<String, String> getMapprops() {
		return mapprops;
	}

	public void setMapprops(Map<String, String> mapprops) {
		this.mapprops = mapprops;
	}

	public static String getValue(String key){
		String value = map.get(key);
		/*String value = "";
		if (object!=null){
			value = object.toString();
		}*/
		return value;
	}
}
