package com.example.administrator.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author TangLongHui
 * @data created on 2019/5/30.
 * @describe TODO 时间工具类
 */
public class DateUtil {
    //按需求增加静态实例
    private static final SimpleDateFormat ymdFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat ymdFormat2 = new SimpleDateFormat("yyyy/M/d");
    private static final SimpleDateFormat ymdFormat3 = new SimpleDateFormat("yyyy年MM月dd日");
    private static final SimpleDateFormat ymdFormat4 = new SimpleDateFormat("yyyy年M月d日");
    private static final SimpleDateFormat hmFormat1 = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat mdFormat1 = new SimpleDateFormat("MM-dd");
    private static final SimpleDateFormat mdFormat2 = new SimpleDateFormat("M月d日");
    private static final SimpleDateFormat yMdHmsFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat hmsFormat1 = new SimpleDateFormat("HH:mm:ss");
    /**
     * @Description: TODO 指定时间格式的枚举
     */
    public enum Format {
        ymdFormat1, ymdFormat2,ymdFormat3,hmFormat1,mdFormat1,yMdHmsFormat1,ymdFormat4,mdFormat2,hmsFormat1
    }

    /**
     * @Description: TODO 通过枚举获得对应格式的时间对象
     * @return: {@link SimpleDateFormat}
     * @param: {@link Format}
     */
    private static SimpleDateFormat getSimpleDateFormat(Format format) {
        switch (format) {
            case ymdFormat1:
                return ymdFormat1;
            case ymdFormat2:
                return ymdFormat2;
            case ymdFormat3:
                return ymdFormat3;
            case hmFormat1:
                return hmFormat1;
            case mdFormat1:
                return mdFormat1;
            case yMdHmsFormat1:
                return yMdHmsFormat1;
            case ymdFormat4:
                return ymdFormat4;
            case mdFormat2:
                return mdFormat2;
            case hmsFormat1:
                return hmsFormat1;
        }
        return null;
    }

    /**
     * @Description: TODO 转换时间格式
     * @return: 转换后的时间 String
     * @param: {@link Format}
     */
    public static String dateTransform(String date, Format formatBefore, Format formatAfter) {
        String result = "";
        try {
            result = getSimpleDateFormat(formatAfter).format(getSimpleDateFormat(formatBefore).parse(date));
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Description: TODO 将时间戳(字符串)按指定格式转换为时间
     * @return: 转换后的时间 String
     * @param: {@link Format}
     */
    public static String stampTransform(String dateStamp, Format formatAfter) {
        return getSimpleDateFormat(formatAfter).format(new Date(new Long(dateStamp)));
    }

    /**
     * @Description: TODO 将时间戳(long)按指定格式转换为时间
     * @return: 转换后的时间 String
     * @param: {@link Format}
     */
    public static String stampTransform(long dateStamp, Format formatAfter) {
        return getSimpleDateFormat(formatAfter).format(new Date(dateStamp));
    }

    /**
     * @Description: TODO 将时间（字符串）转换为时间戳(long)
     * @return: 转换后的时间 long
     * @param: {@link Format}
     */
    public static long getStamp(String date, Format formatAfter) {
        long result = 0;
        try {
            result = getSimpleDateFormat(formatAfter).parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }




}
