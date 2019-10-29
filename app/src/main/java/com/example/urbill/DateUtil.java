package com.example.urbill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String getFormattedTime(long timeStamp){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(timeStamp));
    }
    public static long getUnixStamp(){
        return System.currentTimeMillis();
    }
    public static String getFormatterDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
    private static Date str2Date(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            return format.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return new Date();
    }


    public static String getWeekDay(String date){
        if(date == null){
            return "未知";
        }
        String[] weekdays = {"星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str2Date(date));
        int index = calendar.get(Calendar.DAY_OF_WEEK)-1;
        return weekdays[index-1];
    }


    public static String getDateTitle(String date) {
        String[] months = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str2Date(date));
        int monthsIndex = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return months[monthsIndex] + String.valueOf(day) + "日";
    }

    //获取时间date的年份
    public static String getDateYear(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(str2Date(date)) + "年";
    }
    //获取某月第一天
    public static String getMonthFirstDay(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str2Date(date));
        int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, firstDay);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    //获取某月最后一天

    public static String getMonthLastDay(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str2Date(date));
        int firstDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, firstDay);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    //获取某年的第一天

    public static String getYearFirstDay(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.valueOf(date.split("-")[0]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    //获取某年的最后一天
    public static String getYearLastDay(String date) {
        Calendar calendar=Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,Integer.valueOf(date.split("-")[0]));
        calendar.roll(Calendar.DAY_OF_YEAR,-1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }
}
