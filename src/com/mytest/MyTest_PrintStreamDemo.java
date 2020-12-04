package com.mytest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MyTest_PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World!");


        //
        PrintStream ps = new PrintStream(new FileOutputStream("src/com/mytest/log"));
        //将输出锁定到 ps 输出流
        System.setOut(ps);
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");

        ps.flush();
        ps.close();
    }
}
