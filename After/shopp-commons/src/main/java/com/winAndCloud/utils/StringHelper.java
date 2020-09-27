package com.winAndCloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @ClassName: StringHelper.java
 * @Description: 字符串帮助工具

 */
public class StringHelper {
    private StringHelper(){

    }
    private static final Logger logger = LoggerFactory.getLogger(StringHelper.class);
    public static final String EMPTY = "";

    /**
     * @param obj
     * @return
     * @Title: IsEmptyOrNull
     * @Description: 判断当前对象是否为空
     */
    public static Boolean IsEmptyOrNull(Object obj) {
        if (obj == null) {
            return Boolean.valueOf(true);
        } else if ("".equals(obj)) {
            return Boolean.valueOf(true);
        } else {
            if (obj instanceof String) {
                if (((String) obj).length() == 0) {
                    return Boolean.valueOf(true);
                }
            } else if (obj instanceof Collection) {
                if (((Collection) obj).isEmpty()) {
                    return Boolean.valueOf(true);
                }
            } else if (obj instanceof Map && ((Map) obj).size() == 0) {
                return Boolean.valueOf(true);
            }

            return Boolean.valueOf(false);
        }
    }

    /**
     * @param obj
     * @return
     * @Title: TranString
     * @Description: 转换为字符
     */
    public static String TranString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * @param obj
     * @param defaultval
     * @return
     * @Title: TranString
     * @Description: 转换为字符，没有则转为默认值
     */
    public static String TranString(Object obj, String defaultval) {
        return obj == null ? defaultval : obj.toString();
    }

    public static String TranSeachString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            String result = obj.toString();
            return result.replace("\\", "\\\\").replace("_", "\\_").replace("%", "\\%");
        }
    }

    /**
     * @param obj
     * @return
     * @Title: TranSeachStringNew
     * @Description: 将对象中的转义字符，转换掉
     */
    public static String TranSeachStringNew(Object obj) {
        if (obj == null) {
            return "";
        } else {
            String result = obj.toString();
            return result.replace("\\", "\\\\").replace("_", "\\_").replace("%", "\\%").replace("[", "[[").replace("]",
                    "]]");
        }
    }

    public static String ByteToString(byte[] srcobj) throws Exception {
        return ByteToString(srcobj, "UTF-16LE");
    }

    /**
     * @param srcObj
     * @param charEncode
     * @return
     * @Title: ByteToString
     * @Description: 将字节流转换为指定的字符
     */
    public static String ByteToString(byte[] srcObj, String charEncode) throws Exception {
        String destObj = null;

        try {
            destObj = new String(srcObj, charEncode);
        } catch (Exception arg3) {
            logger.error("转换错误：{}",arg3.getMessage());
        }
        String des="";
        if(destObj==null){
            throw new Exception();
        }else {
            des=destObj.replace(" ", " ");
        }
            return des;
    }

    /**
     * @return
     * @Title: GetGUID
     * @Description: 获取没有“-”的UUID
     */
    public static String GetGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * @param str
     * @return
     * @throws Exception
     * @Title: compress
     * @Description: 将字符按ISO-8859-1压缩
     */
    public static String compress(String str) throws Exception {
        if (IsEmptyOrNull(str).booleanValue()) {
            return str;
        } else {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
            gzip.close();
            return out.toString("ISO-8859-1");
        }
    }

    /**
     * @param str
     * @return
     * @throws Exception
     * @Title: unCompress
     * @Description: 解压字符按ISO-8859-1解压
     */
    public static String unCompress(String str) throws Exception {
        if (IsEmptyOrNull(str).booleanValue()) {
            return str;
        } else {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(StandardCharsets.ISO_8859_1));
            GZIPInputStream gzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n1;
            while ((n1 = gzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n1);
            }

            return out.toString("GBK");
        }
    }
}
