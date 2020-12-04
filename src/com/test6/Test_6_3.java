package com.test6;

import java.util.HashSet;
import java.util.Scanner;

class MyException extends Exception {
    MyException() {super();}
    MyException(int num, HashSet hs) {
        super("输入的数" + num +"与已输入的数" + hs.toString() + "有相同");
    }
}

public class Test_6_3 {
    public static void main(String[] args) {
        System.out.println("请输入10个不同的整数，一个数一行：");
        Scanner sc = new Scanner(System.in);
        HashSet hs = new HashSet();

        for (int i = 0;i < 10;) {
            int num = sc.nextInt();
            try {
                if (!hs.add(num)) {
                    throw new MyException(num, hs);
                }
                i++;
            } catch (MyException e) {
                e.printStackTrace();
                System.out.println("请重新输入:");
            }
        }

        System.out.println("输入的10个不同整数为：\n" + hs.toString());
    }
}
