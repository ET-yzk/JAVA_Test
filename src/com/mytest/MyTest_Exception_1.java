package com.mytest;

import java.util.Scanner;

class MyException extends Exception {
    MyException(String msg) {
        super(msg);
    }
}

class ExceptionTest {
    void testOut1(int[] arr, int num, int index) throws MyException {
        if (index < 0) {
            throw new MyException("数组下标越界");
        }
        else if (index >= arr.length) {
            throw new MyException("数组上标越界");
        }
        arr[index] = num;
    }

    String testOut2(String in) throws MyException{
        int strMaxLen = 3;
        if (in.length() > strMaxLen) {
            throw new MyException("输入的字符串过长");
        }
        return in;
    }
}

class Test {

    void test1() {
        int[] sh = new int[2];
        try {
            new ExceptionTest().testOut1(sh, 5, 3);
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.toString());
//            e.printStackTrace();
        }
    }

    void test2() {
        Scanner sc = new Scanner(System.in);
        String str = null;
        System.out.println("输入长度<=3的字符串：");
        while (sc.hasNextLine()) {
            try {
                str = new ExceptionTest().testOut2(sc.nextLine());
                System.out.println("输入的：" + str + "有效，输入成功");
                break;
            }
            catch (MyException e) {
                e.printStackTrace();
                System.out.println("请重新输入！");
            }
        }
    }
}

public class MyTest_Exception_1 {
    public static void main(String[] args) {
        Test test = new Test();

        test.test1();
        test.test2();
    }
}
