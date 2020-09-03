package com.winAndCloud.utils;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * 计算文件MD5码
 * created by zcsun2*/


public class MD5Helper {

    private MD5Helper(){

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Helper.class);

    public static String getMD5(File file){
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length=fileInputStream.read(buffer))!=-1) {
                messageDigest.update(buffer,0,length);
            }
            return new String(Hex.encodeHex(messageDigest.digest()));
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            return  null;
        }finally {
            try {
                if (fileInputStream!=null)
                    fileInputStream.close();
            }catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

}
