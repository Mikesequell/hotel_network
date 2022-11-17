package com.hotel.projectHotel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateToString {
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static String execute() {
        Date date = new Date();
        return formatter.format(date);
    }

}
