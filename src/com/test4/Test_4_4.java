package com.test4;

import java.util.ArrayList;
import java.util.List;

class Point {
    double x,y,z,d;

    //计算(x,y,z)到原点的距离
    double distance() {
        this.d = Math.pow((Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)), 0.5);
        return this.d;
    }
    //构造方法
    Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Test_4_4 {
    public static void main(String[] args) {
        List<Point> lst = new ArrayList<>();
        Point p1 = new Point(10, 5, 7);
        Point p2 = new Point(6, 15, 12);
        Point p3 = new Point(3, 7, 6);
        Point p4 = new Point(24, 15, 16);
        Point p5 = new Point(31, 17, 26);
        lst.add(p1);
        lst.add(p2);
        lst.add(p3);
        lst.add(p4);
        lst.add(p5);

        lst.sort((o1, o2) -> {
            if (o1.distance() - o2.distance() > 0) return 1;
            else if (o1.distance() - o2.distance() < 0) return -1;
            else return 0;
        });
        for (Point i:lst){
            System.out.println(i.d);
        }
    }
}
