package com.test4;

import java.util.*;

class Sort {
    void sort1() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split(" ");
        Arrays.sort(str);
//        for (String i : str){
//            System.out.println(i);
//        }//直接下面函数输出
        System.out.println(Arrays.toString(str));
    }

    void sort2() {
        Scanner sc = new Scanner(System.in);
        List<String> str = new ArrayList<>();
        String input = sc.next();

        while (!input.equals("-1")){
            str.add(input);
            input = sc.next();
        }
        //排序方法一
//        Collections.sort(str);
        //排序方法二
        str.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);//升序
            }
        });
        System.out.println(str);
    }
}

public class Test_4_1 {
    public static void main(String[] args){
        Sort sort = new Sort();
        sort.sort1();
        sort.sort2();
    }
}


/*参考读入数据的方法:
JAVA读入一行空格隔开的数据
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //对读入的那一整行在作split()操作
        String ss[] = s.split(" ");

        for (String x : ss) {
            System.out.println(x);
        }
    }
}
*/