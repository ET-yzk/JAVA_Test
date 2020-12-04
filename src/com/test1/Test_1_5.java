package com.test1;

import java.util.Scanner;

class Test_1_5 {
    static int m = 0;
    //实现移动的函数
    public static void move(int disks,char N,char M, int m)
    {
        System.out.println("move " + m +" disk " + disks + ":" + N +"->" + M);
    }
    //递归实现汉诺塔的函数
    public static void hanoi(int n, char A, char B, char C)
    {
        //hanoi(待移动的圆盘数量，初始位置，辅助位置，目标位置)；
        if (n <= 0) {
            System.out.println("请输入正确的圆盘数量！");
        }
        if (n == 1) {//圆盘只有一个时，只需将其从A塔移到C塔
            m++;
            move(1, A, C, m);//将编号为1的圆盘从A移到C
        }
        else{//否则
            hanoi(n - 1, A, C, B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            m++;
            move(n, A, C, m);//把A塔上编号为n的圆盘移到C上
            hanoi(n - 1, B, A, C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }

    public static void main(String[] args){
        System.out.print("输入圆盘个数：");
        int n = new Scanner(System.in).nextInt();
        hanoi(n, 'A', 'B', 'C');
        System.out.println(n+"个圆盘总共移动次数为"+m+"次");
    }
}
