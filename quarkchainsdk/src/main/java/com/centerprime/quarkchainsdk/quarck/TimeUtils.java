//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.centerprime.quarkchainsdk.quarck;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class TimeUtils {
    //    y        年号，如 1996
//    M        月份，如 July 或者 07
//    d        月中第几天，如 12
//    H        小时(24制)，如 0、17
//    m        分钟,如 32
//    s        钞钟，如55
//    S        微钞，如978
//    E        星期几，如 Tuesday
//    D        一年中的第几天，如 189
//    w        week in year            (Number)            27
//    W        week in month          (Number)            2
//    a        am/pm marker            (Text)              PM
//    k        hour in day (1~24)      (Number)            24
//    K        hour in am/pm (0~11)    (Number)            0
//    z        time zone              (Text)   
    public static final String DATE_FORMAT_MIL = "yyyyMMdd-HH:mm:ss.SSS";
    public static final String DATE_FORMAT_SEC = "yyyyMMdd-HH:mm:ss";
    public static final String DATE_FORMAT_SEC_HYPHEN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_MIN = "yyyyMMdd-HH:mm";
    public static final String DATE_FORMAT_DAY = "yyyyMMdd";
    public static final String DATE_FORMAT_MDY = "MM/dd/yyyy HH:mm:ss";
    public static final String DATE_FORMAT_YMD = "yyyy/MM/dd HH:mm:ss";

    //    Wed, 26 Jun 2019 09:48:05 +0100
    public static final String DATE_FORMAT_EN = "EEE, dd MMM yyyy HH:mm:ss Z";

    private TimeUtils() {
    }

    public static String getStringDate(long time, String format) {
        DateFormat sdf = getDateFormat(format);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(time));
    }

    public static String getStringDate(long time, DateFormat dateFormat) {
        return dateFormat.format(new Date(time));
    }

    public static DateFormat getDateFormat(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf;
    }

    public static long getTimeStamp(String timeStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        try {
            sdf.setTimeZone(TimeZone.getDefault());
            Date e = sdf.parse(timeStr);
            return e.getTime();
        } catch (ParseException var6) {
            return 0L;
        }
    }

    public static Date getData(String timeString, String format) {
        if (timeString != null && !"".equals(timeString.trim())) {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);

            try {
                return sdf.parse(timeString);
            } catch (ParseException var4) {
                return null;
            }
        } else {
            return null;
        }
    }
}
