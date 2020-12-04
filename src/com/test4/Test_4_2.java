package com.test4;

import java.util.Random;

class Cal {
    //m表示生成的个数，n表示范围[0,n)
    void myRandom(int[] intList, int m, int n) {
        Random r = new Random();
        for (int i = 0; i < m; i++){
            intList[i] = r.nextInt(n);//左闭右开[0,n)
        }
    }

    int[] sortCount(int[] intList, int n) {
        int[] count = new int[n];
        for (int j : intList) {
            count[j]++;
        }
        return count;
    }

    void mySum(int[] count) {
        int sum = 0;
        for (int j : count) {
            sum += j;
        }
        System.out.println("计数总数为：" + sum);
    }
}

public class Test_4_2 {
    public static void main(String[] args) {
        Cal cal = new Cal();
        int m = 1000, n = 100;//m表示生成的个数，n表示范围[0,n)
        int[] intList = new int[m];
        int[] count;

        cal.myRandom(intList, m, n);
        count = cal.sortCount(intList, n);
        cal.mySum(count);
        for (int i = 0; i < n; i++){
            System.out.println("整数" + i + "出现的次数：" + count[i]);
        }
    }
}
