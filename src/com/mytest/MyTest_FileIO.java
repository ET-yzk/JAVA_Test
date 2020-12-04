package com.mytest;

import java.io.*;

public class MyTest_FileIO {
    public static void main(String[] args) {
        FileInputIODemo fileInputIODemo = new FileInputIODemo();

//        fileInputIODemo.read1();
//        fileInputIODemo.read2();
//        fileInputIODemo.copy();

    }
}

class FileInputIODemo {

    //todo attention
    //1、英文和数字占一个字节；
    //
    //2、中文占一个字符，也就是两个字节；
    //
    //3、字符不等于字节。
    //
    //字符（char）是 Java 中的一种基本数据类型，由 2 个字节组成，范围从 0 开始，到 2^16-1。
    //
    //字节是一种数据量的单位，一个字节等于 8 位。所有的数据所占空间都可以用字节数来衡量。例如一个字符占 2 个字节，一个 int 占 4 个字节，一个 double 占 8 个字节 等等。
    //
    //1字符=2字节；
    //
    //1Byte=8bit；1k = 2^10 = 1024；b：位；B：字节1kb= 1024 位；1kB= 1024 字节。
    //
    //Byte数据类型（字节型）用一个字节（Byte）储存，可区别256个数字，取值范围：0到255。 Byte是从0-255的无符号类型，所以不能表示负数。

    //todo 字节流
    void read1() {
        try {
            //todo 1.创建FileInputStream类作为读取文件的输入数据流对象，构造方法绑定要读取的数据位置
            FileInputStream fis = new FileInputStream("src/com/mytest/FileIO.txt");
            //todo 2.read()方法读取文件的一个字节返回，当返回-1时读取结束
            //todo 不知道文件有多少字节，用while循环
            //todo 要求一次读取一段字符，长度可自定；byte[] bytes = new byte[1024*1024];

            int len = 0;
            byte[] bytes = new byte[1024 * 1024]; // 一次读取1Mb
            while (true) {
                try {
                    if ((len = fis.read(bytes)) == -1) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print(new String(bytes, 0, len));
                // 字符数组chars，起始位置，终止位置；
                //todo 该方法可避免读取的字符数组未读满的问题
//                System.out.println(bytes.toString());// 该方法就有问题
            }

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //todo 字符流
    void read2() {
        try {
            //todo 1.创建FileReader类作为读取文件的输入数据流对象，构造方法绑定要读取的数据位置
            FileReader fr = new FileReader("src/com/mytest/FileIO.txt");
            //todo 2.read()方法读取文件的一个字节返回，当返回-1时读取结束
            //todo 不知道文件有多少字节，用while循环
            //todo 要求一次读取一段字符，长度可自定；char[] chars = new char[1024*1024];

            int len = 0;
            char[] chars = new char[1024]; // 一次读取1Mb
            while (true) {
                try {
                    if ((len = fr.read(chars)) == -1) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print(new String(chars, 0, len));// 字符数组chars，起始位置，终止位置
            }

            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //todo 单txt文件复制
    void copy() {

        try {
            FileOutputStream fw = new FileOutputStream("src/com/mytest/FileIO_copy.txt");
            FileInputStream fr = new FileInputStream("src/com/mytest/FileIO.txt");
            int len = 0;
            byte[] bytes = new byte[1024];
            while (true) {
                try {
                    if ((len = fr.read(bytes)) == -1) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    fw.write(bytes, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //todo 文件夹复制
//    void allCopy(String path1, String path2) {
//        //源目录
//        File srcFile = new File(path1);
//        //目标目录
//        File destFile = new File(path2);
//
//        //拷贝目录
//        copyDirectory(srcFile, destFile);
//    }

    /**
     *
     * @param srcFile 源目录
     * @param destFile 目标目录
     */
//    void copyDirectory(File srcFile, File destFile) {
//        File[] srcList = srcFile.listFiles();
//
//        for (File srcfile : srcList) {
////            System.out.println(srcfile);
//            if (srcfile.isDirectory()) {
//                //新建对应的拷贝目录
//                String srcDirectory = srcfile.getAbsolutePath();
//                String destDirectory = destFile.getAbsolutePath() + srcDirectory.split("\\\\", 1)[1];//todo 未完成
//                // 在split()中，"\\\\"代表'\'，"\\."代表'.'
//                File newFile = new File(destDirectory);
//                if (!newFile.exists()) {
//                    newFile.mkdirs();
//                }
//            }
//        }
//    }
}