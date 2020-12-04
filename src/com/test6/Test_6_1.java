package com.test6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//字典序升序
class MyComparator1 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

//字典序降序
class MyComparator2 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

//按字符串长度降序
class MyComparator3 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}

//按字符串长度降序--字典序
class MyComparator4 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() - o2.length() != 0) { return o2.length() - o1.length(); }
        return o1.compareTo(o2);
    }
}

public class Test_6_1 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符：");
        Scanner sc = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
//        while (sc.hasNext()) {
//            str.add(sc.next());
//        }
        Collections.addAll(str, sc.nextLine().split("\\s+"));

        str.sort(new MyComparator1());
        System.out.println("按字典序排序：\n" + str.toString());

        str.sort(new MyComparator2());
        System.out.println("按字典序逆序排序：\n" + str.toString());

        str.sort(new MyComparator3());
        System.out.println("按字符串的长度降序排序：\n" + str.toString());

        str.sort(new MyComparator4());
        System.out.println("先按字符串的长度降序排序再按字典序排序：\n" + str.toString());
    }

}
