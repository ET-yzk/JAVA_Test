/*
* 从键盘分别输入年、月、日，判断这一天是当年的第几天。*/

package com.test1.again;

import java.util.Scanner;

class DateDemo {
    // 判断是否为闰年
    boolean judgeYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    int calDate(int year, int month, int day) {
        int date = day;
        // 非润年月
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        switch (month) {
            case 12:
                if (day > months[12]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[11];
            case 11:
                if (day > months[11]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[10];
            case 10:
                if (day > months[10]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[9];
            case 9:
                if (day > months[9]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[8];
            case 8:
                if (day > months[8]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[7];
            case 7:
                if (day > months[7]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[6];
            case 6:
                if (day > months[6]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[5];
            case 5:
                if (day > months[5]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[4];
            case 4:
                if (day > months[4]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[3];
            case 3:
                if (day > months[3]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                date += months[2];
            case 2:
                if (judgeYear(year)) {
                    if (day > months[2] + 1) {
                        System.out.println("”日“输入有误");
                        return -1;
                    }
                }
                else {
                    if (day > months[2]) {
                        System.out.println("”日“输入有误");
                        return -1;
                    }
                }
                date += months[1];
            case 1:
                if (day > months[1]) {
                    System.out.println("”日“输入有误");
                    return -1;
                }
                break;
            default:
                System.out.println("”月“输入有误");
                break;
        }
        return date;
    }
}

public class T1_4 {
    public static void main(String[] args) {
        int day, month, year, date;
        DateDemo dd = new DateDemo();
        Scanner sc = new Scanner(System.in);
        System.out.print("年：");
        year = sc.nextInt();
        System.out.print("月：");
        month = sc.nextInt();
        System.out.print("日：");
        day = sc.nextInt();
        if ((date = dd.calDate(year, month, day)) != -1) {
            System.out.printf("%d年%d月%d日是这一年的第%d天\n", year, month, day, date);
        }
    }
}
