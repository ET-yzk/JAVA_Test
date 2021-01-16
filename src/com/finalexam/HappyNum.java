package com.finalexam;

import java.util.Scanner;

public class HappyNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        String input = scanner.next();
        char[] chars = input.toCharArray(); // 字符串转字符数组
        /*for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }*/

        boolean isHappy;

        isHappy=isHappyNumber(chars);
        if (isHappy) {
            System.out.printf("数%s是快乐数%n", input);
        }
        else {
            System.out.printf("数%s不是快乐数%n", input);
        }
    }

    public static boolean isHappyNumber(char[] digits) {
        boolean isHappy;
        int sum, count=1;
        String number;
        sum=sum_of_digits(digits);

        while (true) {
            if (sum == 1) {
                isHappy = true;
                break;
            } else if (count <= 100000) {
                count++;
                // System.out.println("count="+count);
                number = sum + ""; //先转为字符串
                sum = sum_of_digits(number.toCharArray());
            } else {
                isHappy = false;
                break;
            }
        }

        return isHappy;
    }

    /**
     * 计算整数各个位上数字的平方和
     * @param digits
     * @return
     */
    public static int sum_of_digits(char[] digits){
        int sum = 0;
        String number;
        int s = 0;
        for (char d : digits) { //计算每个位上数字的平方和
            sum += Math.pow(Integer.parseInt(d + ""), 2);
        }

        // System.out.println(String.format("数%s平方和为%d", digits.toString(),sum));
        return sum;
    }
}


