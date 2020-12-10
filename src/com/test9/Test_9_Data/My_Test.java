package com.test9.Test_9_Data;

import java.util.Random;
// 用于Test_9_2.java文件的功能测试
class My {

    void test() {
        Random r=new Random(); /*生成Random对象*/
        int N=1000;
        int a[]=new int[N];
        int b[]=new int[100]; //b[i]记录整数i+1出现次数

        //常规写法
/*    for (int i = 0; i <N ; i++) {
      a[i]=r.nextInt(100)+1; //左闭右开[1,100]
    }*/


//    for (int i = 0; i < 100; i++) {
//      for (int j = 0; j <N ; j++) {
//          if (a[j]==(i+1)){
//             b[i]+=1;
//          }
//      }
//    }

        //更简单的写法
        for (int i = 0; i < 100; i++) {
            for (int j : a) {
                j=r.nextInt(100)+1; //左闭右开[1,100]
                if (j==(i+1)){
                    b[i]+=1;
                }
            }
        }

        for (int i = 0; i <100 ; i++) {
            System.out.println("整数"+(i+1)+"出现次数:"+b[i]);
        }
    }
}


public class My_Test {
    public static void main(String[] args) {
        My my = new My();
        my.test();
    }
}
