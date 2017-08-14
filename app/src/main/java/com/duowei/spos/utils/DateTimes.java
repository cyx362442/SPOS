package com.duowei.spos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-12-19.
 */

public class DateTimes {
    private DateTimes() {
    }

    private static DateTimes singleton = null;

    public static DateTimes getInstance() {
        if (singleton == null) {
            singleton = new DateTimes();
        }
        return singleton;
    }

    public  String getWeek(){
        String z = "";
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        String week = dateFm.format(date);
        if (week.equals("星期一")) {
            z = "Z1";
        } else if (week.equals("星期二")) {
            z = "Z2";
        } else if (week.equals("星期三")) {
            z = "Z3";
        } else if (week.equals("星期四")) {
            z = "Z4";
        } else if (week.equals("星期五")) {
            z = "Z5";
        } else if (week.equals("星期六")) {
            z = "Z6";
        } else if (week.equals("星期日")) {
            z = "Z7";
        }
        return z;
    }
    public  String getTime(){
        Date curDate = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dtime=format.format(curDate);
        return dtime;
    }
    public  String getTime2(){
        Date curDate = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dtime=format.format(curDate);
        return dtime;
    }
}
