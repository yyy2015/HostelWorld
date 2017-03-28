package edu.nju.hostelworld.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by yyy on 2017/3/27.
 */
public class DateTrans {

    public static Timestamp string2time(String dateStr){

        return Timestamp.valueOf(dateStr);
    }

    public static String time2String(Timestamp ts){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(ts);
    }
}
