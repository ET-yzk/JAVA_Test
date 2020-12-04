package com.mytest;

import java.util.ArrayList;
import java.util.Comparator;
//import java.lang.Math;

class DemoArrayList{
    ArrayList<Integer> arrayList = new ArrayList<>();

    ArrayList<Integer> getArrayList() {
        return arrayList;
    }

}

public class MyTest_排序 {
    public static void main(String[] args) {
        DemoArrayList demoArrayList = new DemoArrayList();
        demoArrayList.arrayList.add(1);
        demoArrayList.arrayList.add(5);
        demoArrayList.arrayList.add(2);
        demoArrayList.arrayList.add(9);
        demoArrayList.arrayList.add(0);
        demoArrayList.arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o1 - (int)o2;//升序
                //o2 - o1 降序
            }
        });
        System.out.println(demoArrayList.arrayList);
    }
}
