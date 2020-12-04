package com.mytest;

public class MyTest_异常 {
    public static void main(String[] args){
        int test = test(3, 5);
        System.out.println(test);
        test=test(0, -5);
        System.out.println(test);
    }
    static int test(int x, int y) {
        int result;
        try {
            if (x < 0 || y < 0) {
                return 0;
            }
            result = x + y;
            return result;// 假如finally中没有return语句，则这里result的值将直接被返回，但程序依然会运行
        }
        finally {
            result = x - y;
            System.out.println(result);
//            return result; // ！！决定最后的返回值
        }
    }
}
