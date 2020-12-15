package com.test10;

import com.test8.FileClassCopy;
import java.io.*;

// 实现多线程拷贝目录，主线程拷贝文件
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
        try {
            new MulCopy().copyDir(srcFile, newFile);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Test_10_1.count++;
        new FileClassCopy().allCopy(srcFile.getAbsolutePath(), newFile.getAbsolutePath());// 直接递归拷贝该文件夹

//        System.out.println(Thread.currentThread().getName());// 检查子线程执行情况
    }

}

class MulCopy {
//    static int count = 0;
    void copyDir(File srcFile, File destFile) throws IOException, InterruptedException {
        File[] srcList = srcFile.listFiles();
        for (File srcfile : srcList) {
            if (srcfile.isDirectory()) {
                Thread tr = new Thread(new FileRunnable(srcfile, destFile));
                tr.start();
//                tr.setName("tr");
                tr.join();
            } else {
                new FileClassCopy().singleCopy(srcfile.getAbsolutePath(), destFile + "\\" + srcfile.getName());
            }
//            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class Test_10_1 {
    static int count = 0;// 记录调用线程数
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        File srcFile = new File("D:\\OpenCV\\opencv\\sources");
        File destFile = new File("D:\\test");

        MulCopy mulCopy = new MulCopy();
        mulCopy.copyDir(srcFile, destFile);

        System.out.println("子线程调用次数：" + count);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
// D:\大二上\JAVA实验\JAVA_test\src
// 子线程调用次数：1390
// 耗时：5.2s
// 单线程文件夹拷贝耗时：2.334s



// 原来的一层多线程
/*TODO way1
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
                new Thread(new FileRunnable(srcfile, destFile)).start();
                count++;
            } else {
                new FileClassCopy().copy(srcfile.getAbsolutePath(), destFile + "\\" + srcfile.getName());
            }
        }

        System.out.println("子线程调用次数：" + count);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
*/


/*TODO way2
import com.test8.FileClassCopy;
import java.io.*;

// 实现多线程拷贝目录，主线程拷贝文件
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
//        try {
//            new MulCopy().copyDir(srcFile, newFile);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }

//        new FileClassCopy().allCopy(srcFile.getAbsolutePath(), newFile.getAbsolutePath());// 直接递归拷贝该文件夹

//        System.out.println(Thread.currentThread().getName());// 检查子线程执行情况
    }

}

class MulCopy {
    static int count = 0;
    void copyDir(File srcFile, File destFile) throws IOException, InterruptedException {
        File[] srcList = srcFile.listFiles();
        for (File srcfile : srcList) {
            if (srcfile.isDirectory()) {
                Thread tr = new Thread(new FileRunnable(srcfile, destFile));
                tr.start();
//                tr.setName("tr");
                tr.join();//TODO 需要等待对应的tr线程结束才能递归执行copyDir();
                copyDir(srcfile, new File(destFile.getAbsolutePath() + "\\" + srcfile.getName()));

                count++;
            } else {
                new FileClassCopy().singleCopy(srcfile.getAbsolutePath(), destFile + "\\" + srcfile.getName());
            }
//            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class Test_10_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        File srcFile = new File("D:\\OpenCV\\opencv\\sources");
        File destFile = new File("D:\\test");
//        int count = 0;// 记录调用线程数

        MulCopy mulCopy = new MulCopy();
        mulCopy.copyDir(srcFile, destFile);


        System.out.println("子线程调用次数：" + MulCopy.count);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
*/