package com.test1;

import java.util.Scanner;

class Test_1_4 {
    public static boolean judgeYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static int calDays(int year, int month, int day){
        int days = day;
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        switch (month){
            case 12:
                if (month == 12 && day > months[12]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[11];
            case 11:
                if (month == 11 && day > months[11]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[10];
            case 10:
                if (month == 10 && day > months[10]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[9];
            case 9:
                if (month == 9 && day > months[9]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[8];
            case 8:
                if (month == 8 && day > months[8]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[7];
            case 7:
                if (month == 7 && day > months[7]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[6];
            case 6:
                if (month == 6 && day > months[6]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[5];
            case 5:
                if (month == 5 && day > months[5]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[4];
            case 4:
                if (month == 4 && day > months[4]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[3];
            case 3:
                if (month == 3 && day > months[3]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                days += months[2];
                if (judgeYear(year)) {
                    days += 1;
                }
            case 2:
                if (judgeYear(year)) {
                    if (month == 2 && day > months[2] + 1) {
                        System.out.println("“日”输入有误！");
                        return -1;
                    }
                }
                else{
                    if (month == 2 && day > months[2]) {
                        System.out.println("“日”输入有误！");
                        return -1;
                    }
                }
                days += months[1];
            case 1:
                if (month == 1 && day > months[1]){
                    System.out.println("“日”输入有误！");
                    return -1;
                }
                break;
            default: System.out.println("“月”输入有误！"); break;
        }
        return days;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int days;
        System.out.print("年：");
        int year = sc.nextInt();
        System.out.print("月：");
        int month = sc.nextInt();
        System.out.print("日：");
        int day = sc.nextInt();
        days = calDays(year, month, day);
        if (days != -1) {
            System.out.printf("%d年%d月%d日是这一年的第%d天\n", year, month, day, days);
        }
    }
}
