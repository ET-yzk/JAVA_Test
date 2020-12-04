package com.test1;

import java.util.Scanner;

class Test_1_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        System.out.println("请输入基本运费p元/公里·吨(p<100)");
        double p = sc.nextDouble();
        System.out.println("请输入距离s公里(s<4000)");
        double s = sc.nextDouble();
        System.out.println("请输入货物重量w吨(w<1000)");
        double w = sc.nextDouble();
        if (s < 0 || w < 0 || p < 0){
            System.out.println("输入出错！");
            return;
        }
        if (s >= 3000){
            sum += 0.85 * (s - 3000) * p * w;
            s = 3000;
        }
        if (s >= 2000){
            sum += 0.9 * (s - 2000) * p * w;
            s = 2000;
        }
        if (s >= 1000){
            sum += 0.92 * (s - 1000) * p * w;
            s = 1000;
        }
        if (s >= 500){
            sum += 0.95 * (s - 500) * p * w;
            s = 500;
        }
        if (s >= 250){
            sum += 0.98 * (s - 250) * p * w;
            s = 250;
        }
        sum += s * p * w;
        if (sum % 10 < 5){
            sum = (int)sum / 10 * 10;
        }
        else{
            sum = (int)sum / 10 * 10 + 10;
        }
        System.out.printf("运费为：%.0f元\n",sum);
    }
}
