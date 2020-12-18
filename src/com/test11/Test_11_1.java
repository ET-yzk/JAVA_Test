package com.test11;

import com.test8.FileClassCopy;

import java.io.File;
import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

class CopyScaleRunnable implements Runnable{
    String fileName;// 需要检查复制进度的文件夹
    BigDecimal fileClassSize;

    CopyScaleRunnable(String fileName) {
        super();
        this.fileName = fileName;
    }

    void setFileClassSize(BigDecimal fileClassSize) {
        this.fileClassSize = fileClassSize;
    }

    @Override
    public void run() {
        FileClassCopy fcc = new FileClassCopy();
        BigDecimal size = fcc.directorySize(new File(fileName));

        while (size.compareTo(fileClassSize) != 0) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当前文件(夹)复制进度：" + size.multiply(new BigDecimal("100")).divide(fileClassSize, 2, HALF_UP) + "%...");
            size = fcc.directorySize(new File(fileName));

        }
        System.out.println("当前文件(夹)复制进度：" + size.multiply(new BigDecimal("100")).divide(fileClassSize, 2, HALF_UP) + "%...");
        System.out.print("文件(夹)复制完毕！");
    }
}

public class Test_11_1 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        FileClassCopy fcc = new FileClassCopy();
        BigDecimal size;// 目标文件（夹）字节大小,因为long的上限太小，在文件接近2GB后就溢出了
        String copyFilePath = "D:\\OpenCV";
        String copiedFilePath = "D:\\test";

        CopyScaleRunnable csr = new CopyScaleRunnable(copiedFilePath);
        Thread tr = new Thread(csr);// 创建子线程用于计算复制进度
//        大二上\JAVA实验\JAVA_test\src

        System.out.println("正在计算目标文件(夹)大小...");
        size = fcc.directorySize(new File(copyFilePath));// 递归计算得到文件大小,单位-字节
        csr.setFileClassSize(size);// 告知目标文件大小
        System.out.printf("目标文件大小->%.2fMB\n", size.divide(new BigDecimal("1048576"), HALF_UP));
        System.out.println("开始复制...");

        tr.start();
        fcc.allCopy(copyFilePath, copiedFilePath);
        tr.join();
        System.out.println("复制耗时：" + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
    }
}
