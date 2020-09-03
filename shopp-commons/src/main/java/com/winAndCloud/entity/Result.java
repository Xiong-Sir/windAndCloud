
package com.winAndCloud.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 返回结果类型
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private static Logger log = LoggerFactory.getLogger(Result.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**返回的状态值 0 成功 , 2失败*/
    private Integer status = -1;

    /**返回的信息*/
    private String msg;


    /**返回值*/
    private T result;

    /**是否成功*/
    private boolean success;


    @Override
    public String toString() {
        try {
            return 	MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("convert ResResultDto to Json String error!");
            return null;
        }
    }

    /**
     * 带返回值和错误码,和核心返回值
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    /**
     * 错误返回值
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static Result error(Integer errorCode, String errorMsg) {
        return new Result(errorCode, errorMsg);
    }

    /**
     * 错误的构造方法
     * @param status
     * @param msg
     */
    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
        this.success = false;

    }

    /**
     * 正确的返回值
     * @param data
     * @return
     */
    public static Result ok(Object data) {
        return new Result(data);
    }


    /**
     * 正确的构造方法
     * @param result
     */
    public Result(T result) {
        this.status = 0;
        this.msg = "ok";
        this.result = result;
        this.success = true;
    }


    /**
     * 正常传值构造方法
     * @param status
     * @param msg
     * @param data
     */
    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.result =  data;
        if (status == 200) {
            this.success = true;
        }
    }


    /**
     * 将json结果集转化为TaotaoResult对象
     *
     * @param jsonData json数据
     * @param clazz TaotaoResult中的object类型
     * @return
     */
    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("result");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }




    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("result");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }



}