package com.rxjy.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rxjy.modules.sys.entity.SysDictEntity;
import com.rxjy.modules.sys.service.SysDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 字典工具类
 *
 * @author Administrator
 * @create 2018-05-24 14:35
 */
@Component
public class DictUtils {

	@Autowired
	private SysDictService dictService;
	private static SysDictService sysDictService;

	public static final String CACHE_DICT_MAP = "gcHrDictMap";

	@PostConstruct
	public void init(){
		sysDictService = dictService;
	}


	public static String getDictValue(String code, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(code)){
			for (SysDictEntity dict : getDictList(type)){
				if (type.equals(dict.getType()) && code.equals(dict.getCode())){
					return dict.getValue();
				}
			}
		}
		return defaultValue;
	}

	public static String getDictValues(String codes, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(codes)){
			List<String> codeList = Lists.newArrayList();
			for (String code : StringUtils.split(codes, ",")){
				codeList.add(getDictValue(code, type, defaultValue));
			}
			return StringUtils.join(codeList, ",");
		}
		return defaultValue;
	}

	public static String getDictCode(String value, String type, String defaultCode){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (SysDictEntity dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getCode();
				}
			}
		}
		return defaultCode;
	}

	public static List<SysDictEntity> getDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<SysDictEntity>> dictMap = (Map<String, List<SysDictEntity>>)JSONObject.parse(JedisUtils.get(CACHE_DICT_MAP));
		if (dictMap==null){
			dictMap = Maps.newHashMap();
			List<SysDictEntity> sysDictEntities = sysDictService.selectList(null);
			for (SysDictEntity dict : sysDictEntities) {
				List<SysDictEntity> list = dictMap.get(dict.getType());
				if(list != null){
					list.add(dict);
				}else {
					dictMap.put(dict.getType(),Lists.newArrayList(dict));
				}
			}
			JedisUtils.set(CACHE_DICT_MAP, JSONObject.toJSONString(dictMap),1L * 30, TimeUnit.DAYS);
		}
		List<SysDictEntity> dictList = JSONArray.parseArray(dictMap.get(type).toString(), SysDictEntity.class);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}

	/**
	 * 返回字典列表（JSON）
	 * @param type
	 * @return
	 */
	public static String getDictListJson(String type){
		return JSONObject.toJSONString(getDictList(type));
	}

	/**
	 * 清空缓存
	 */
	public static void clean(){
		JedisUtils.del(CACHE_DICT_MAP);
	}

	/**
	 * Object转成JSON数据
	 */
	private static String toJson(Object object){
		if(object instanceof Integer || object instanceof Long || object instanceof Float ||
				object instanceof Double || object instanceof Boolean || object instanceof String){
			return String.valueOf(object);
		}
		return JSON.toJSONString(object);
	}

	/**
	 * JSON数据，转成Object
	 */
	private static <T> T fromJson(String json, Class<T> clazz){
		return JSON.parseObject(json, clazz);
	}




}
