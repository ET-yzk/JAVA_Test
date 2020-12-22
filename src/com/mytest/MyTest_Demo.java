package com.mytest;

import java.util.Scanner;

class Demo_1 {
    String s;

    Demo_1() {
        Scanner sc = new Scanner(System.in);
        this.s = sc.nextLine();
    }

    void print() {
        System.out.println(s);
    }
}

public class MyTest_Demo {
    public static void main(String[] args) {
        Demo_1 d = new Demo_1();
        d.print();
        Scanner sc = new Scanner(System.in);
        String var;
        while (sc.hasNextLine()) {
            System.out.println(sc.next().getClass());
        }
    }
}
