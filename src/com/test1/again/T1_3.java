/*
* 随机⽣成3个0~9的数，如果其中三个数相同，
* 或两个数相同，则输出“Win”，否则输出“Lost”，
* 并输出三个数的组合。该过程重复进⾏，
* 只到三个数都为0时停⽌，输出GameOver。*/

package com.test1.again;

import java.util.Random;

public class T1_3 {
    public static void main(String[] args) {
        int a,b,c;
        Random r = new Random(System.currentTimeMillis());

        while (true) {
            a = r.nextInt(10);
            b = r.nextInt(10);
            c = r.nextInt(10);
            System.out.println("num1=" + a + "  num2="
                    + b + "  num3=" + c);
            // 逻辑短路特性
            if (a == b || a == c || b == c) {
                System.out.println("Win");
                if (a == 0 && b == 0 && c == 0) {
                    break;
                }
            }
            else {
                System.out.println("Lost");
            }
        }

        System.out.println("GameOver");
    }
}
