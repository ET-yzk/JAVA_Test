package com.test6;

import java.util.Scanner;

class OddException extends Exception{
    OddException() {
        super();
    }
    OddException(double b, double c) {
        super(String.format("%.2f/%.2f=", b,c)+"中除数不能为奇数");
    }
}

class MathDivide {
    // 检查分数合法性的方法  如果定义的是运行时异常就不用抛异常
    void divide(double b, double c) throws OddException{// 抛出自己的异常类
        if (c % 2 != 0) {
            // 分母为奇数，不合法抛出异常
            throw new OddException(b, c);
        } else {
            System.out.printf("%.2f/%.2f=%.2f\n", b, c, b / c);
        }
    }
}

public class Test_6_2 {
    public static void main(String[] args) {
        System.out.println("请输入被除数和除数并用逗号隔开，输入两组：");
        String[] num;

        for (int i = 0; i < 2; i++) {
            num = new Scanner(System.in).nextLine().split(",");
            try {
                new MathDivide().divide(Double.parseDouble(num[0]), Double.parseDouble(num[1]));
            } catch (OddException e) {// 用自己的异常类来捕获异常
                e.printStackTrace();
            }
        }
    }
}
