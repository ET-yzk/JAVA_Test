package com.test3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

//计算一个人出生到高考的天数
public class Test_3_3 {
    //将输入的日期按yyyy-MM-dd格式转换为Date
    static Date changeDateLine(String dateLine) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sdf.parse(dateLine);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
    //计算到高考的时间
    static long calDay(String dateLine) {
        long day;
        Date startDate = changeDateLine(dateLine);

//        Calendar startYear = Calendar.getInstance();
        //规定高考日期为18岁的6月7日
        int endYear = Integer.valueOf(dateLine.substring(0,4)) + 18;
        Date endDate = changeDateLine(endYear+"-06-07");

        day = (Objects.requireNonNull(endDate).getTime() - Objects.requireNonNull(startDate).getTime())/(60*60*24*1000);
        return day;
    }

    public static void main(String[] args) {
        System.out.println("请输入出生日期（格式：yyyy-MM-dd）：");

        Scanner input = new Scanner(System.in);
        String dateLine = input.nextLine();

        System.out.println("离高考还有" + calDay(dateLine) + "天");
    }
}
