package com.hotel.projectHotel.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class CurrentDateToString {
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static String execute() {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        return formatter.format(localDateTime);
        Date date = new Date();
        return formatter.format(date);
    }

}
