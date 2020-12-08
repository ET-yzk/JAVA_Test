package com.mytest;

class MyThread extends Thread{
    MyThread() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("run: " + i);
        }
    }
}

//TODO 优势：这不是一个线程类，还是一个可运行类，还不是进程；因此还可以继承其它类(extends)
// 代码复用性强，多个线程可执行该代码
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++) {
            System.out.println("分支进程：" + i);
        }
    }
}

// Thread类多线程
public class MyTest_Thread {
    //TODO 用于测试上面2个类
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();

//        MyRunnable r = new MyRunnable();//TODO 推荐该方法
//        Thread t = new Thread(r);

//        t.start();
//        myThread.start();// 与下面的语句同步运行，谁先抢到时间片，谁就先运行

//        for (int i = 0; i < 5; i++) {
//            System.out.println("main: " + i);
//        }
//    }

    //TODO 用于测试下面2个类
    public static void main(String[] args) {
        Runnable_ji ji = new Runnable_ji();
        Runnable_ou ou = new Runnable_ou();
        Thread t_ji = new Thread(ji);
        Thread t_ou = new Thread(ou);

//        t_ji.start();
//        t_ou.start();
        //TODO 仅用run()而不通过start()，t将以单线程形式运行，而不是并行的多线程
        t_ji.run();
        t_ou.run();
    }
}

class Runnable_ji implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println("ji: " + i);
            }
        }
    }
}

class Runnable_ou implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println("ou: " + i);
            }
        }
    }
}