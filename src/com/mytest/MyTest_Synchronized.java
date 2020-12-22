package com.mytest;

import java.io.IOException;

class Demo1_Synchronized extends Thread{
    final Object o1;
    final Object o2;

    Demo1_Synchronized(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
                System.out.println("t1 running");
                new Demo2_Synchronized(o1, o2).start();
            } catch (InterruptedException ignored) { }
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                    System.out.println("t2 running");
                } catch (InterruptedException ignored) { }
            }
        }
    }
}

class Demo2_Synchronized extends Thread{
    final Object o1;
    final Object o2;

    Demo2_Synchronized(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {
                System.out.println("t2 running");
                new Demo1_Synchronized(o1, o2).start();
            synchronized (o1) {
                System.out.println("t1 running");
            }
        }
    }
}

public class MyTest_Synchronized {
    public static void main(String[] args) {
        int o1 = 0;
        int o2 = 0;
        Demo1_Synchronized d1 = new Demo1_Synchronized(o1, o2);
        Demo2_Synchronized d2 = new Demo2_Synchronized(o1, o2);
        d1.start();
        d2.start();
    }
}
