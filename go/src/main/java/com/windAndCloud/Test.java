package com.windAndCloud;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author 代号：9527
 * @email fj0120@yeah.net
 * @date 2020/9/19 0019 18:01
 */
@Slf4j
public class Test {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //将时间换为获取试题的时间，转为LocalDateTime,获取当前时间
        LocalDateTime startDate = LocalDateTime.now() ;
        LocalDateTime endDate =LocalDateTime.parse("2020-09-21 09:14:59", formatter);
        System.out.println(startDate);
        System.out.println(endDate);
        //调用Java8提供的工具类
       log.info("{}",daysBetweenDates(startDate,endDate));
    }

    /**
     * 根据当前时间求出相差多少分钟
     * @email fj0120@yeah.net
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static long hours(Date endDate) throws ParseException {
        Date now = new Date();
        Date date = endDate;
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        log.info("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
        return min;
    }


    public static long daysBetweenDates(LocalDateTime localDate1, LocalDateTime localDate2) {
        return Math.abs(ChronoUnit.MINUTES.between(localDate1, localDate2));
    }
}
