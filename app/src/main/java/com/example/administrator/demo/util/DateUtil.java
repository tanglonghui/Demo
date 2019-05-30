package com.example.administrator.demo.util;

import android.text.format.DateUtils;

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
    private static final SimpleDateFormat ymdFormat2 = new SimpleDateFormat("yyyy/M/dd");

    /**
     * @Description: TODO 指定时间格式的枚举
     */
    public enum Format {
        ymdFormat1, ymdFormat2
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
// 当我发现Date方法也是比较时间戳之后，炸裂
//    /**
//     * @Description: TODO 比较时间
//     * @return: boolean
//     * @param: {@link Format}
//     */
//    public static boolean isDateBefore(String dateStr1, Format format1, String dateStr2, Format format2) {
//        Date date1=null, date2=null;
//        try {
//            date1 = getSimpleDateFormat(format1).parse(dateStr1);
//            date2 = getSimpleDateFormat(format2).parse(dateStr2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return date1.before(date2);
//    }
//    /**
//     * @Description: TODO 比较时间
//     * @return: boolean
//     * @param: {@link Format}
//     */
//    public static boolean isDateAfter(String dateStr1, Format format1, String dateStr2, Format format2) {
//        Date date1=null, date2=null;
//        try {
//            date1 = getSimpleDateFormat(format1).parse(dateStr1);
//            date2 = getSimpleDateFormat(format2).parse(dateStr2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return date1.after(date2);
//    }
//    /**
//     * @Description: TODO 比较时间
//     * @return: boolean
//     * @param: {@link Format}
//     */
//    public static boolean isDateBefore(long date1, long date2) {
//        return  new Date(date1).before(new Date(date2));
//    }
//    /**
//     * @Description: TODO 比较时间
//     * @return:boolean
//     * @param: {@link Format}
//     */
//    public static boolean isDateAfter(long date1, long date2) {
//        return  new Date(date1).after(new Date(date2));
//    }

    /**
     * @Description: TODO 将时间（字符串）转换为时间戳(long)
     * @return: 转换后的时间 String
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
