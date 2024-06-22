package com.xdz.orchard.utils;

import cn.hutool.core.date.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.sqrt;

public class CommonUtils {

    public static List<DateTime> getMonthList(){
        String startTimeStr = "2022-08-01 00:00:00";
        DateTime startMonth = DateUtil.parse(startTimeStr);
        DateTime currentTime = new DateTime();
        long month = DateUtil.betweenMonth(startMonth, currentTime, true);
        List<DateTime> monthList = new ArrayList<>();
        monthList.add(startMonth);
        for (long i = 0; i < month; i++) {
            DateTime time = DateUtil.offsetMonth(startMonth, (int) (i+1));
            monthList.add(time);
        }
        return monthList;
    }




    private static double EARTH_RADIUS = 6371000;//赤道半径(单位m)
    private static double PI = 3.1415926535897932384626;
    private static double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
    public static String getBaiDuPoint(String point){
        String[] ponints = point.split(",");
        double x = Double.parseDouble(ponints[0]);
        double y = Double.parseDouble(ponints[1]);
        double z = sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x *  x_PI);
        return dataDigit(6,z * Math.cos(theta) + 0.0065)+","+dataDigit(6,z * Math.sin(theta) + 0.006);
    }

    static double dataDigit(int digit,double in){
        return new BigDecimal(in).setScale(6,   BigDecimal.ROUND_HALF_UP).doubleValue();

    }
    public static Float parse(String time){
        float hours = 0f;
        String[] strs = time.split("小时");
        hours += Float.parseFloat(strs[0]);
        float minute = Float.parseFloat(strs[1].split("分钟")[0]);
        minute = minute/60f;
        BigDecimal b = new BigDecimal(minute);
        minute = b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        hours+=minute;
        return hours;
    }
    public static String format(Integer minute){
        String s = DateUtil.secondToTime(minute * 60);
        String[] split = s.split(":");
        return split[0]+"小时"+split[1]+"分钟";
    }
    public static String getStartTimeOfDay(){
        DateTime dateTime = DateUtil.beginOfDay(new Date());
        return DateUtil.format(dateTime, DatePattern.NORM_DATETIME_PATTERN);
    }
    public static String getEndTimeOfDay(){
        DateTime dateTime = DateUtil.endOfDay(new Date());
        return DateUtil.format(dateTime, DatePattern.NORM_DATETIME_PATTERN);
    }
    public static String getStartTimeOfMonth(){
        DateTime dateTime = DateUtil.beginOfMonth(new Date());
        return DateUtil.format(dateTime, DatePattern.NORM_DATETIME_PATTERN);
    }
    public static String getEndTimeOfMonth(){
        DateTime dateTime = DateUtil.endOfMonth(new Date());
        return DateUtil.format(dateTime, DatePattern.NORM_DATETIME_PATTERN);
    }
    public static long between(String startTim,String endTime,DateUnit unit){
        DateTime parse1 = DateUtil.parse(startTim);
        DateTime parse2 = DateUtil.parse(endTime);
        return DateUtil.between(parse1, parse2, unit);
    }

    public static long getMsofBetween(String startTim,String endTime){
        DateTime parse1 = DateUtil.parse(startTim);
        DateTime parse2 = DateUtil.parse(endTime);
        return DateUtil.between(parse1, parse2, DateUnit.MS);
    }
    public static String formatBetweenOfMinute(long minute){
        return formatBetweenOfMs(minute*60*1000);
    }
    public static String formatBetweenOfMs(long ms){
        return DateUtil.formatBetween(ms, BetweenFormatter.Level.SECOND);
    }
    public static String formatBetween(String startTim,String endTime){
        DateTime parse1 = DateUtil.parse(startTim);
        DateTime parse2 = DateUtil.parse(endTime);
        return DateUtil.formatBetween(parse1, parse2, BetweenFormatter.Level.SECOND);
    }



    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(String stratPoint,String
                                     endPoint) {
        String[] point1 = stratPoint.split(",");
        String[] point2 = endPoint.split(",");
        double lon1 = Double.parseDouble(point1[0]);
        double lat1 = Double.parseDouble(point1[1]);
        double lon2 = Double.parseDouble(point2[0]);
        double lat2 = Double.parseDouble(point2[1]);
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
    public static int getHour(String date){
        return DateUtil.hour(DateUtil.parse(date),true);
    }
}
