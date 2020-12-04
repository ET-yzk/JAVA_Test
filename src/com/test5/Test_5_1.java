package com.test5;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

//升序
class MyComparator1 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

//降序
class MyComparator2 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

//按绝对值升序
class MyComparator3 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Math.abs(o1) - Math.abs(o2);
    }
}

public class Test_5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        //正则表达式--\s:空格  +:任意
        for (String i: sc.nextLine().split("\\s+")){
            v.add(Integer.parseInt(i));
        }
        //升序
        v.sort(new MyComparator1());
        System.out.println("按升序排列：\n" + v.toString());

        //降序
        v.sort(new MyComparator2());
        System.out.println("按降序排列：\n" + v.toString());

        //按绝对值升序
        v.sort(new MyComparator3());
        System.out.println("按绝对值升序排序：\n" + v.toString());
    }
}
//test:-233 5627 -34 121     45  -3600


//class Start implements Comparable<Start>{
//
//    private String name;
//    private int age;
//
//    public Start(String name, int age){
//        this.name=name;
//        this.age=age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "明星{"+"姓名："+name+", "+"年龄："+age+"}";
//    }
//
//    @Override
//    public int compareTo(Start o) {
//        //按年龄降序排
//        int i = o.getAge() - this.getAge();
//        //如果年龄相同按姓名的第一个字升序排
//        if (i==0){
//            i=this.getName().charAt(0)-o.getName().charAt(0);
//        }
//
//        return i;
//    }
//}