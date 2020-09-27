package com.winAndCloud.utils;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamValidateUtils {

    private ParamValidateUtils(){

    }

    /**
     * 空值校验，返回校验失败字段列表
     * @param paramMap
     * @param fields
     * @return
     */
    public static List<String> blankFields(Map<String, Object> paramMap, String fields){
        List<String> result = Lists.newArrayList();
        if(StringUtils.isBlank(fields)){
            return result;
        }

        String[] fieldArr = fields.split(",");
        if(MapUtils.isEmpty(paramMap)){
            result.addAll(Arrays.asList(fieldArr));
            return result;
        }

        for(String field : fieldArr){
            if(!paramMap.containsKey(field)){
                result.add(field);
                continue;
            }
            Object value = paramMap.get(field);
            if(value instanceof String){
                if(StringUtils.isBlank((String)value)){
                    result.add(field);
                }
            }else{
                if(value == null){
                    result.add(field);
                }
            }
        }
        return result;
    }

    /**
     * 功能描述: <br>
     * 检测输入的参数并形成返回的map
     *
     * @param paramMap 参数map
     * @param fields 需要检测paramMap非空的字段,逗号隔开,如:id,name,aliase
     * @return 返回数据;如果通过检测,则返回为空,否则返回{errCode:-1;errMsg:***;success:false}
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String,Object> checkParams(Map<String, Object> paramMap, String fields) {
        Map<String, Object> resultMap = new HashMap<>();
        List<String> blankFields = ParamValidateUtils.blankFields(paramMap, fields);
        // 参数校验
        if (CollectionUtils.isNotEmpty(blankFields)) {
            resultMap.put("success", false);
            resultMap.put("errCode", "-1");
            resultMap.put("errMsg", String.format("lack for params： %s", blankFields.toString()));
            return resultMap;
        }
        return null;
    }
}