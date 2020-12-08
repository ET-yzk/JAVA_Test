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
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        MyRunnable r = new MyRunnable();//TODO 推荐该方法
        Thread t = new Thread(r);

        t.start();
        myThread.start();// 与下面的语句同步运行，谁先抢到时间片，谁就先运行

        for (int i = 0; i < 5; i++) {
            System.out.println("main: " + i);
        }
    }
}
