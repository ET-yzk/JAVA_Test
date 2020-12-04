package com.mytest;

import java.io.File;


// 查找特定目录下全部文件
public class MyTest_遍历 {
    public static void main(String[] args) {
        File file = new File("D:\\Ubuntu_Test");
        getAllFile(file);
    }
    // 定义一个方法，参数传递File类型的目录
    // 方法中对目录进行遍历
    public static void getAllFile(File dir){
        System.out.println(dir);// 打印被遍历的目录
        File[] files = dir.listFiles();
        for (File f : files) {
            // 对遍历得到的File对象f进行判断，判断是否为文件夹
            if (f.isDirectory()){
                // f是一个文件夹，则继续遍历这个文件夹
                // 发现getAllFile方法就是传递文件夹，遍历文件夹的方法
                // 所以直接调用getAllFile方法即可：递归（自己调用自己）
                getAllFile(f);
            }else {
                // 如果是一个文件，直接打印输出即可
                System.out.println(f);
            }
        }
    }
}
