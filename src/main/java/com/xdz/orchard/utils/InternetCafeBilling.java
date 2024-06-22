package com.xdz.orchard.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class InternetCafeBilling {
    public static Double calculateInternetTime(String startTimeStr, String endTimeStr) {
        try {
            // 将字符串类型的时间转换为 LocalDateTime 类型
            LocalDateTime startTime = LocalDateTime.parse(startTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime endTime = LocalDateTime.parse(endTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // 计算时间差，并将结果转换为小时数
            Double hours = ChronoUnit.MINUTES.between(startTime, endTime) / 60.0;

            // 保留两位小数并返回
            return Math.round(hours * 100.0) / 100.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    public static double calculateInternetFee(String overnightStartTime, String overnightEndTime, String internetStartTime, String internetEndTime, double overnightCost, double internetPrice) {
        double internetFee = 0.0;
        LocalDateTime overnightStart = LocalDateTime.parse(overnightStartTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime overnightEnd = LocalDateTime.parse(overnightEndTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime internetStart = LocalDateTime.parse(internetStartTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime internetEnd = LocalDateTime.parse(internetEndTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Case 1: Internet access is within the range of overnight stay
        if (internetStart.isAfter(overnightStart) && internetEnd.isBefore(overnightEnd)) {
            internetFee = overnightCost;
        }
        // Case 2: Internet access starts before overnight stay and ends within overnight stay
        else if (internetStart.isBefore(overnightStart) && internetEnd.isBefore(overnightEnd) && internetEnd.isAfter(overnightStart)) {
            Duration duration = Duration.between(internetStart, overnightStart);
            double hours = duration.toMinutes() / 60.0;
            internetFee = hours * internetPrice + overnightCost;
        }
        // Case 3: Internet access ends after overnight stay
        else if (internetStart.isBefore(overnightStart) && internetEnd.isAfter(overnightEnd)) {
            Duration duration1 = Duration.between(internetStart, overnightStart);
            double hours1 = duration1.toMinutes() / 60.0;
            Duration duration2 = Duration.between(overnightEnd, internetEnd);
            double hours2 = duration2.toMinutes() / 60.0;
            internetFee = hours1 * internetPrice + overnightCost + hours2 * internetPrice;
        }
        else if(internetStart.isAfter(overnightStart) && internetEnd.isBefore(overnightEnd)){
            internetFee = overnightCost;
        }
        else if (internetStart.isAfter(overnightStart) && internetEnd.isAfter(overnightEnd)){
            Duration duration1 = Duration.between(overnightEnd, internetEnd);
            double hours1 = duration1.toMinutes() / 60.0;
            internetFee = overnightCost + hours1 * internetPrice;
        }
        return internetFee;
    }






}
