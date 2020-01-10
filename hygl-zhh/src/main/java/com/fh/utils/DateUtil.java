package com.fh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import java.util.logging.SimpleFormatter;

public class DateUtil {

    public static final String Y_M_D = "yyyy-MM-dd";

    public static String convertDate2Str(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    public static Date converStr2Date(String str,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
