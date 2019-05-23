package com.rxjy.modules.kshop.common;
import java.util.HashMap;

/**
 * @创建人 陈旭
 * @创建时间 2018/5/09 12：08
 * @功能描述 返回值封装
 * @规定要求 StatusCode 0成功  -1失败
 *              StatusMsg  返回信息（请求成功或失败）
 *              Body 返回的数据，可是数组，可是字典
 */
public class R extends HashMap<String, Object> {
	private static final String STATUS_CODE = "StatusCode";
	private static final String STATUS_MSG = "StatusMsg";

	public static final int STATUS_CODE_SUCCESS = 0;
	public static final int STATUS_CODE_ERROR = -1;

	public R(){}
	public R(int code,String msg){
		this.put(STATUS_CODE, code);
		this.put(STATUS_MSG, msg);
	}

	public static R error(){
		return new R(STATUS_CODE_ERROR, "未知的异常，联系管理员处理");
	}

	public static R error(String msg){
		return new R(STATUS_CODE_ERROR, msg);
	}

	public static R ok(){
		return new R(STATUS_CODE_SUCCESS, "成功");
	}

	public static R ok(String msg){
		return new R(STATUS_CODE_SUCCESS, msg);
	}

	public static R ok(Object value){
		return new R(STATUS_CODE_SUCCESS, "成功").put("Body", value);
	}

	@Override
	public R put(String key, Object value){
		super.put(key, value);
		return this;
	}

	public boolean isOk(){
		return (STATUS_CODE_SUCCESS+"").equals(this.get(STATUS_CODE).toString());
	}

}