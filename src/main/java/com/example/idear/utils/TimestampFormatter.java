package com.example.idear.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimestampFormatter {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static String format(Timestamp timestamp) {
        return simpleDateFormat.format(timestamp);
    }
}
