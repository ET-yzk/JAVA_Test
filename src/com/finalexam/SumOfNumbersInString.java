package com.finalexam;

import java.math.BigInteger;
import java.util.Scanner;

public class SumOfNumbersInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个字符串（包含数字）：");
        String[] strings = new String[2];

        for (int i = 0; i <2 ; i++) {
            strings[i] = scanner.next();
        }

        /*int i=0;
        for (String string : strings) {
            i=i+1;
            System.out.println(String.format("第%d个字符串："+string, i));
        }*/

        // 第1个字符串：00a0a0a0a0a0a9999999999as9999d9a99s9d9
        // 第2个字符串：00basdfasd99988887773943434234234234234234234

        System.out.printf("从第一个字符串%s提取的整数为：" + getNumber(strings[0].toCharArray()) + "%n",strings[0]);
        System.out.printf("从第二个字符串%s提取的整数为：" + getNumber(strings[1].toCharArray()) + "%n",strings[1]);
        // 从第一个字符串00a0a0a0a0a0a9999999999as9999d9a99s9d9提取的整数为：9999999999999999999
        // 从第二个字符串00basdfasd99988887773943434234234234234234234提取的整数为：99988887773943434234234234234234234

        // 注意：提取的整数会很大用long类型不能表示，需要用更大的类型BigInteger
        BigInteger bigNmuber1= new BigInteger(getNumber(strings[0].toCharArray()));
        BigInteger bigNmuber2= new BigInteger(getNumber(strings[1].toCharArray()));
        BigInteger sum = bigNmuber1.add(bigNmuber2);
        System.out.printf("从两个字符串%s，%s提取的两个整数的和等于：" + sum + "%n",strings[0],strings[1]);
        // 从两个字符串00a0a0a0a0a0a9999999999as9999d9a99s9d9，00basdfasd99988887773943434234234234234234234提取的两个整数的和等于：99988887773943444234234234234234233
    }

    /**
     * 从字符数组中提取数字字符串，并去除数字前面的0
     * @param chars 字符数组
     * @return
     */
    public static String getNumber(char[] chars){
        int sum = 0;
        StringBuffer number = new StringBuffer();
        for (char c : chars) {
            //String str=c+""; //转为字符串
            if (c>=48 & c<=57) { //0的ASC码为48，9的ASC码为57
                number.append(c);
            }
        }

        int index=0;
        // 将number前面的0去除
        if (number.charAt(0)=='0'){
            for (int j = 1; j < number.length() ; j++) {
                if (number.charAt(j)=='0'){
                    index=index+1;
                }else {
                    break;
                }
            }
        }

        return number.substring(index +1);
    }
}
