package com.turastory.kotlindemo.java.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Util class - @file:JvmName, @JvmStatic, @JvmField, @JvmOverloads, extension functions
 */
public class DateFormatUtil {
    public static final int DAY_IN_MILLIS = (24 * 60 * 60 * 1000);
    
    public static DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
    public static DateFormat day = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
    
    public static Date getDate(int year, int month, int date) {
        return getDate(year, month, date, 0, 0, 0);
    }
    
    public static Date getDate(int year, int month, int date, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, hour, minute, second);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    public static Date parseDay(String string) {
        Date date = null;
        try {
            date = DateFormatUtil.day.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static Date dayAfter(Date date, int day) {
        return new Date(date.getTime() + day * DAY_IN_MILLIS);
    }
    
    public static Date dayBefore(Date date, int day) {
        return new Date(date.getTime() - day * DAY_IN_MILLIS);
    }
}
