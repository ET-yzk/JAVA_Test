/*
* 定义一个求整数阶乘的方法factorial()，输入一个数n，求出1!+2!+…+n!的和。求阶乘请用
* TODO 递归方法和迭代的方法实现。*/

package com.test1.again;

import java.util.Scanner;

class calNum {
    // 整数阶乘
    int factorial(int n) {
        if (n < 0) {
            System.out.println("请正确输入！");
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
}

public class T1_1 {
    public static void main(String[] args) {
        calNum cal = new calNum();
        int n, sum =0;
        System.out.print("请输入一个正整数:");
        Scanner sc = new Scanner(System.in);
        try {
            n = Integer.valueOf(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("请正确输入！");
            return;
        }
        for (int i = 1; i <= n; i++) {
            int j = cal.factorial(i);
            sum += j;
            System.out.println("factorial(" + i + ")=" + j);
        }
        System.out.println("从1到" + n + "的阶乘和为：" + sum);
    }
}
