/*
* Hanoi塔
  有三个杆：A、B、C，将n个圆盘（编号1、2、…、n，圆盘按从小到大编号）
  * 从A杆移动到C杆，要求移动中不能把大盘放在小盘上，只能小盘放在大盘上。
  * 移动的次数要求最少。
*/

package com.test1.again;

import java.util.Scanner;

//TODO 算法的核心在于将上层的n-1个圆盘当成一个整体，将问题递归拆分
class Hanoi {
    // 移动次数
    int m = 0;

    // disks表示圆盘编号，N,M : N->M 从 N 移到 M 柱子
    void move(int disks, char N, char M) {
        System.out.println("Move " + m + " disk" + disks + ":" + N + "->" + M);
    }

    // 递归实现汉诺塔的最少移动
    void hanoi(int n, char a, char b, char c) {
        if (n == 1) {// 圆盘只有一个时，只需将其从A塔移到C塔
            m++;
            move(n, a, c);
        }
        else {// 递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            hanoi(n - 1, a, c, b);
            m++;
            move(n, a, c);// 把A塔上编号为n的圆盘移到C上
            hanoi(n -1, b, a, c);// 递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }

    void print(int n) {
        System.out.println(n + "个圆盘至少移动"+m+"次");
    }
}

public class T1_5 {
    public static void main(String[] args){
        Hanoi hn = new Hanoi();
        int n;
        System.out.print("(Hanoi)请输入圆盘数:");
        n = new Scanner(System.in).nextInt();
        hn.hanoi(n, 'A', 'B', 'C');
        hn.print(n);
    }
}
