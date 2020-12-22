package com.mytest;

import java.util.Scanner;

public class BlankPage {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in= new Scanner(System.in);

        MyRectangle rect = new MyRectangle();//new构造函数时，一个函数可以有多个构造函数，选择参数和那个构造函数相同的调动
        System.out.println("矩形的宽度");
        System.out.println(rect.getW());
        System.out.println("矩形的高度");
        System.out.println(rect.getH());
        System.out.println("矩形的面积");
        System.out.println(rect.area());
        System.out.println("输出他们共同组成的字符串：");
        System.out.println(rect.toString());
    }
}

class MyRectangle{//在除了主函数之外的外面定义一个外面的类
    private int xUp;//不可以在那个构造函数中输入值，虽好采用this，这种操作
    private int yUp;
    private int xDown;
    private int yDown;
    MyRectangle() {//无参数构造函数
        Scanner in= new Scanner(System.in);
        System.out.println("输入一个上坐标:");
        xUp=in.nextInt();
        System.out.println("输入一个y的上坐标:");
        yUp=in.nextInt();
        System.out.println("输入一个x的下坐标:");
        xDown=in.nextInt();
        System.out.println("输入一个Y的下坐标:");
        yDown=in.nextInt();

    }
    MyRectangle(int a,int b,int c,int d) {//有参数构造函数
        this.xUp=a;
        this.yUp=b;
        this.xDown=c;
        this.yDown=d;
    }
    public int getW(){
        return this.xUp-this.xDown;
    }
    public int getH() {
        return this.yUp-this.yDown;
    }
    public int area() {
        return getW()*getH();
    }
    public String toString() {//将所有的结果转换为一个字符串输出
        return "矩形的宽"+getW()+"矩形的高"+getH()+"矩形的面积"+area();
    }
}
