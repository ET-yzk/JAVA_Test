package com.mytest;

public class MyTest_ThreadShareData {
    public static void main(String[] args) throws InterruptedException {
        ThreadProcess threads = new ThreadProcess();
        // Construct 2 threads
        Thread t1 = new Thread(threads, "t1");
        Thread t2 = new Thread(threads, "t2");
        // Run()!
        t1.start();
        t2.start();
        // Wait the end
        t1.join();
        t2.join();
        // Final value
        System.out.println("Final count:" + threads.count);
    }
}

class ThreadProcess implements Runnable{
    public int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {/* 加锁synchronized (this) {}后，大括号内语句交替执行 */
                count++;
                System.out.println("Thread:" + Thread.currentThread().getName()
                        + " Count:" + count);
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}