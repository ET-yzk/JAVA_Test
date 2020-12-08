package com.mytest;

class ThreadDemo extends Thread {
    ThreadDemo() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("ThreadDemo:" + i);
        }
    }
}

public class MyTest_SleepTest {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();

        td.start();
        try {
            td.sleep(10000);// 10s
            //TODO 这里 sleep(10000) 的其实是 main()!
            // ==Thread.sleep() 因为是静态方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Who sleeps?");
    }
}

