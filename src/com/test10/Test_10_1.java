package com.test10;

import com.test8.FileClassCopy;
import java.io.*;

class FileRunnable implements Runnable {
    File srcFile;
    File destFile;

    FileRunnable(File srcFile, File destFile) {
        this.srcFile = srcFile;
        this.destFile = destFile;
    }

    @Override
    public void run() {
        // 在split()中，"\\\\"代表'\'，"\\."代表'.'
        String destDirectory = destFile.getAbsolutePath() + "\\" + srcFile.getName();

        // 新建目录
        File newFile = new File(destDirectory);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        new FileClassCopy().allCopy(srcFile.getAbsolutePath(), newFile.getAbsolutePath());

//        System.out.println(Thread.currentThread().getName());// 检查子线程执行情况
    }

}

public class Test_10_1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        File srcFile = new File("D:\\Ubuntu_Test");
        File destFile = new File("D:\\test");
        int count = 0;// 记录调用线程数

        File[] srcList = srcFile.listFiles();
        for (File srcfile : srcList) {
            if (srcfile.isDirectory()) {
                Thread tr = new Thread(new FileRunnable(srcfile, destFile));
                tr.start();
//                tr.setName("tr");
                count++;
            } else {
                new FileClassCopy().copy(srcfile.getAbsolutePath(), destFile + "\\" + srcfile.getName());
            }
//            System.out.println(Thread.currentThread().getName());
        }

        System.out.println("子线程调用次数：" + count);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}

// 子线程调用次数：6
// 耗时：0.031s
// 单线程文件夹拷贝耗时：0.063s