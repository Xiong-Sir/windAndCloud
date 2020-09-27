package com.winAndCloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
    private MD5(){

    }
    private static final Logger LOGGER = LoggerFactory.getLogger(MD5.class);

    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }
}
