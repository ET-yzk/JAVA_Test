package com.mytest;

//TODO 多态

import java.lang.reflect.Array;

class Father {
    Father() {
        System.out.println("father");
    }
}

class Son extends Father{
    Son() {
//        super();
        System.out.println("son");
    }
}

class Daughter extends Father{
    Daughter() {
        System.out.println("daughter");
    }
}

class Baby extends Son {
    Son son = new Son();
    Baby() {
        System.out.println("baby");
    }
}

//class Day {
//    int day;
//
//    Day(int day) {
//        this.day = day;
//    }
//
//    Day(Day d) {
//        day = d.day;
//
//    }
//
//    void tomorrow() {
//        Day d = new Day(this);
//        System.out.println(day);
//        System.out.println(d.day);
//        d.day++;
//        System.out.println(day);
//        System.out.println(d.day);
//
//    }
//
//    void dd() {
//        Day.this.tomorrow();
//    }
//
//}


public class Polymorph {
    public static void main(String[] args) {
        Daughter daughter = new Daughter();

        Baby baby = new Baby();

//        Day day1 = new Day(2);
//        day1.tomorrow();
//
//        Day day2 = new Day(day1);
//        day1.tomorrow();
//        day2.tomorrow();

//        day1.dd();
    }

}
