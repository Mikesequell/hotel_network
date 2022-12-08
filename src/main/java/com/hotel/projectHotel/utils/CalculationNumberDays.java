package com.hotel.projectHotel.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class CalculationNumberDays {

        public static long getDayCount(Date arrival, Date departure) {
//    public static long getDayCount(LocalDateTime arrival, LocalDateTime departure) {
        long diff = -1;
        try {
            //time is always 00:00:00 so rounding should help to ignore the missing hour when going from winter to summer time as well as the extra hour in the other direction
            diff = Math.round((arrival.getTime() - departure.getTime()) / (double) 86400000);
        } catch (Exception e) {
            //handle the exception according to your own situation
        }
        return diff * (-1) + 1;
    }
}
