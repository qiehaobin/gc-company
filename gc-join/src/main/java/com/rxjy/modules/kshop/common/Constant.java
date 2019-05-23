package com.rxjy.modules.kshop.common;

/**
 * @创建人 陈旭
 * @创建时间 2018/5/09 12：08
 * @功能描述 结果常量类
 */
public class Constant {

	public static final int Success = 0;

	public static final int Unknownerror = 1;

	public static final int Servicetemporarilyunavailable = 2;

	public static final int Unsupportedopenapimethod = 3;

	public static final int Openapirequestlimitreached = 4;

	public static final int NoFile = 6;

	public static final int Invalidparameter = 101;

	public static final int InvalidAPIkey = 102;

	public static final int Invalidtimestampparameter = 103;

	public static final int Incorrectsignature = 104;

	public static final int InvalidEquement = 107;

	public static final int Parametersformaterror = 12001;

	public static final int Poststrtoolongorshort = 12004;

	public static final int Invaliduser = 12100;

	public static final int DataError = 12101;

	public static final int ElectValueError = 12102;
	/**
	 * @创建人 陈旭
	 * @创建时间 2018/5/14 11 ：30
	 * @功能描述 返回结果类型描述信息
	 * **/
	public static String returnResult(int type){
		String result;
		switch (type){
			case 0:
				result="成功";
				break;
			case 1:
				result="未知错误";
				break;
			case 2:
				result="后端服务暂时不可用";
				break;
			case 3:
				result="Open api接口不被支持";
				break;
			case 4:
				result="应用对open api接口的调用请求数达到上限";
				break;
			case 6:
				result="图片未上传";
				break;
			case 101:
				result="参数无效或缺失";
				break;
			case 102:
				result="Api key无效";
				break;
			case 103:
				result="timestamp参数无效或已被使用过";
				break;
			case 104:
				result="签名无效";
				break;
			case 107:
				result="此设备无效";
				break;
			case 12001:
				result="必选参数格式错误";
				break;
			case 12004:
				result="提交字符串长度不合法";
				break;
			case 12100:
				result="无效的用户信息";
				break;
			case 12101:
				result="数据错误";
				break;
			case 12102:
				result="电量值不符合";
				break;
			default: result="未知类型错误";
				break;
		}
		return result;
	}
}
