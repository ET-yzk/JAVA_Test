package com.test8;


public class Test_8_2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FileClassCopy fileClassCopy = new FileClassCopy();
        fileClassCopy.allCopy("D:\\Ubuntu_Test", "D:\\test");
        System.out.println("单线程文件夹拷贝耗时：" + (System.currentTimeMillis() - start) / 1000.0 + "s");
    }
}
