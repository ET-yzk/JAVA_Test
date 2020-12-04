package com.test8;

import java.io.File;

class Finder {
    boolean aBoolean;// 判断0级目录查找的文件类型是否存在，在每次调用findFile(fileType, dir)函数后需执行setaBoolean(false)
    boolean bBoolean;// 判断本目录下是否存在待查找文件的类型

    // 定义一个方法，参数传递File类型的目录
    // 方法中对目录进行遍历
    void findFile(String fileType, File dir){
//        System.out.println(dir);// 打印被遍历的目录
        File[] files = dir.listFiles();
        String[] fileTypeName;
        for (File f : files) {

            // 对遍历得到的File对象f进行判断，判断是否为文件夹
            if (f.isDirectory()){
                setaBoolean(false);

                // f是一个文件夹，则继续遍历这个文件夹
                findFile(fileType, f);

                if (!this.aBoolean) {
                    System.out.println(f.getAbsolutePath() + ": 没有" + fileType + "文件");
                }
            }else {
                // 如果是要找的文件类型，直接打印输出即可
                fileTypeName = f.getName().split("\\.");//todo 注意split()中"."的转义
                // 取最后一个"."后的字符进行判断  fileTypeName.length-1；可用正则表达替代
                if (fileTypeName.length > 1 &&
                        fileType.equals(fileTypeName[fileTypeName.length-1])) {
                    System.out.println(f + ": " + f.getName());
                    setaBoolean(true);
                    setbBoolean(true);
                }
            }

        }
    }

    void findTF(Finder finder, File file) {
        if (!finder.bBoolean) {
            System.out.println(file.getName() + ": 没有.jpg文件");
        }
    }

    void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
    void setbBoolean(boolean bBoolean) {
        this.bBoolean = bBoolean;
    }
}

public class Test_8_1 {
    public static void main(String[] args) {
        Finder finder = new Finder();
        File file = new File("D:\\Ubuntu_Test");

        System.out.println("查找本目录下的.java文件:");
        finder.findFile("java", file);
        finder.findTF(finder, file);

        finder.setaBoolean(false);
        System.out.println();

        System.out.println("查找本目录下的.jpg文件:");
        finder.findFile("jpg", file);
        finder.findTF(finder, file);
    }
}
