package com.test1;

import java.util.Scanner;

class Test_1_1 {

    public static int factorial(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 1;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return n*factorial(n - 1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num;i++){
            System.out.println("factorial("+i+")="+factorial(i));
            sum += factorial(i);
        }
        System.out.println("从1到"+num+"的阶乘和为："+sum);
    }
}
