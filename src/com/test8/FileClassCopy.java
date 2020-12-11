package com.test8;

import java.io.*;

public class FileClassCopy {
    // 文件夹复制
    public void allCopy(String srcPath, String destPath) {
        //源目录
        File srcFile = new File(srcPath);
        //目标目录
        File destFile = new File(destPath);
        //拷贝目录
        copyDirectory(srcFile, destFile);
    }

    /**
     * @param srcFile  源目录
     * @param destFile 目标目录
     */
    public void copyDirectory(File srcFile, File destFile) {
        File[] srcList = srcFile.listFiles();

        for (File srcfile : srcList) {
//            System.out.println(srcfile);
            if (srcfile.isDirectory()) {
                // 新建对应的拷贝目录
//                String srcDirectory = srcfile.getAbsolutePath();
                // 在split()中，"\\\\"代表'\'，"\\."代表'.'
                String destDirectory = destFile.getAbsolutePath() + "\\" + srcfile.getName();//todo 取出srcFile和destFile最后不同的路径  srcfile.getName()同srcDirectory.split("\\\\")[srcDirectory.split("\\\\").length - 1]

                // 新建目录
                File newFile = new File(destDirectory);
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }

                // 递归新的目录
                copyDirectory(srcfile, newFile);

            } else {
                File destfile = new File(destFile.getAbsolutePath() + "\\" + srcfile.getAbsolutePath().split("\\\\")[srcfile.getAbsolutePath().split("\\\\").length - 1]);

                try {
                    copy(srcfile.getAbsolutePath(), destfile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 单txt文件复制
    public void copy(String srcFile, String destFile) throws IOException {
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(destFile));
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(srcFile));

        bw.write(br.readAllBytes());

        bw.flush();
        bw.close();
        br.close();
    }
}
