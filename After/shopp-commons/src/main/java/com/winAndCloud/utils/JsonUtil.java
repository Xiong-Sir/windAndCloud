package com.winAndCloud.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
	private JsonUtil(){

	}
	/**
	 * dubbo提供者将对象转json
	 * @param object
	 * @return
	 */
	public static String toJsonString(Object object) {
		if(object == null) {
			return null;
		}
		//禁止对象引用为$ref: "$.list[0]"
		return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	}

	public static String toJsonStringHaveNullKey(Object object) {
		if(object == null) {
			return null;
		}
		//禁止对象引用为$ref: "$.list[0]"
		return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
	}


	/**
	 * 将对象转换为map(传参)
	 * @author fjwang2
	 * @date 2018-06-12
	 * @param object
	 * @return
	 */
	public static Map<String,Object> objectToMap(Object object) {
		Map<String, Object> result = new HashMap<>();
		if(object == null) {
			return result;
		}
		return JSON.parseObject(toJsonString(object));
	}
	
	/**
	 * 将Map转换为对象,如果对象包含泛型，请使用重载方法
	 * @author fjwang2
	 * @date 2018-06-12
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(Map<String,Object> map, Class<T> clazz) {
		if(map == null) {
			return null;
		}
		return JSON.parseObject(toJsonString(map), clazz);
	}
	/**
	 * 如果是包含泛型的对象，必须使用此方法
	 * eg: JsonUtil.toObject(map, new TypeReference<List<UserDTO>>() {});
	 * @author fjwang2
	 * @date 2018-06-05
	 * @param map
	 * @param type
	 * @return
	 */
	public static <T> T toObject(Map<Object,Object> map, TypeReference<T> type) {
		if(map == null) {
			return null;
		}
		return JSON.parseObject(toJsonString(map), type);
	}

	public static <T> T toObject(String result, Class<T> clazz) {
		if(result == null) {
			return null;
		}
		return JSON.parseObject(result, clazz);
	}
	
	public static <T> T toObject(String result, TypeReference<T> type) {
		if(result == null) {
			return null;
		}
		return JSON.parseObject(result, type);
	}
	
	public static Integer getInteger(Map<?,?> param,String key) {
		Number number = (Number)param.get(key);
		return number == null ? null : number.intValue();
	}
	public static String getString(Map<?,?> param,String key) {
		Object obj = param.get(key);
		if(!(obj instanceof String)) {
			return null;
		}
		return (String)obj;
	}
	/**
	 * 获取boolean类型，默认值false
	 * @author fjwang2
	 * @date 2018-08-22
	 * @param param
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Map<?,?> param,String key) {
		return getBoolean(param, key, false);
	}
	public static boolean getBoolean(Map<?,?> param, String key, boolean defValue) {
		Boolean value = (Boolean)param.get(key);
		return value == null ? defValue : value.booleanValue();
	}

	public static String[] toStringArray(String jsonString){
		JSONArray json= JSON.parseArray(jsonString);
		String[] objs = new String[json.size()];
		for (int i = 0; i < json.size(); i++) {
			objs[i] = json.get(i).toString();
		}
		return  objs;
	}
}
