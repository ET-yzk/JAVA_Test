package com.test1;

import static java.lang.Math.random;

class Test_1_3 {
    public static void main(String[] args){
        int n1, n2, n3;
        n1 = (int)(random()*10);
        n2 = (int)(random()*10);
        n3 = (int)(random()*10);
        while (n1 != 0 || n2 != 0 || n3 != 0){
            System.out.println("num1=" + n1 + " num2=" + n2 +" num3=" + n3);
            if (n1 == n2 || n1 == n3 || n2 == n3){
                System.out.println("win");
            }
            else{
                System.out.println("lost");
            }
            n1 = (int)(random()*10);
            n2 = (int)(random()*10);
            n3 = (int)(random()*10);
        }
        System.out.println("num1=" + n1 + " num2=" + n2 +" num3=" + n3);
        System.out.println("win");
        System.out.println("game over");
    }
}
