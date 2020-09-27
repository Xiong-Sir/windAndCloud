package com.winAndCloud.common;

/**
 * Json返回状态码的设置
 * 1000 以上是成功的标志
 * 2000 以上是失败 的标识
 * 2100 以上是业务异常
 * 2200 以上是系统错误
 */
public enum JsonResponseStatus {

	SUCCESS(1000,"操作成功")
	
	,FAILURE(2000,"操作失败")
	
	,LoginError(2021,"验证登录失败")
	
	,NoRight(2013,"没有权限")
	
	,BusinessError(2100,"业务异常")
	
	,BlankParamsError(2101,"空参数")
	
	,ParamsFormatError(2102,"参数格式错误")
	
	,SystemError(2200,"系统错误")
	
	;
	
	private int code;
	
	private String Message;
	
	private JsonResponseStatus(int code,String message) {
		this.code=code;
		this.Message=message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return Message;
	}

}
