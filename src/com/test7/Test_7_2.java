package com.test7;

import java.io.File;
import java.util.Scanner;

// 查找特定目录下是否特定文件
public class Test_7_2 {
    public static void main(String[] args) {
        String contents = "D:\\大二上\\JAVA实验\\JAVA_test\\src";

        System.out.println("请输入要查找的文件名：");
        String file = new Scanner(System.in).nextLine();

        File dir = new File(contents);
        if (!getFile(dir, file)) {
            System.out.println("目录src/下没有此文件");
        }
    }

    public static boolean getFile(File dir, String file){
//        System.out.println(dir);// 打印被遍历的目录
        File[] files = dir.listFiles();

        for (File f : files) {
            // 对遍历得到的File对象f进行判断，判断是否为文件夹
            if (f.isDirectory()){
                getFile(f, file);
            }else {
                if (f.getName().equals(file)) {
                    System.out.println("目录src/下要查找的文件所在路径：" + f);
                    System.exit(0);
                }
            }
        }
//        System.out.println("目录src/下没有此文件");
        return false;
    }
}
