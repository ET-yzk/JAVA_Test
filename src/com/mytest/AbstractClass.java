package com.mytest;

class Point {
    static int varr = 10;
}

abstract class Shape {
    final int num = 1;
    abstract void draw();
    Point position;
    Shape(Point p) {
        position = p;
    }
}

abstract class Round extends Shape {
    final double pi = 3.1415926;

    Round(Point p) {
        super(p);
    }

    abstract void draw();
    abstract double area();

}

class Circle extends Round {
    int radius;
    void draw() {
//        drawCircle(position);
    }

    double area() {
        return pi*radius*radius;
    }

    Circle(Point p, int radius) {
        super(p);
        this.radius = radius;
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Point p = null;
        int r = 2;
        Shape shape = new Circle(p, r);

        System.out.println(((Circle) shape).area());
        System.out.println(shape.position.varr);
        shape.draw();
    }
}
