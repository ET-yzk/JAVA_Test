package com.test9;

import java.io.*;
import java.nio.charset.StandardCharsets;

// 过滤.java文件中的注释

class DealFile {
    void deal(String srcFile, String destFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcFile, StandardCharsets.UTF_8)); // 规定以UTF-8编码的形式读入
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFile, StandardCharsets.UTF_8));
        String line;
        StringBuilder str = new StringBuilder();
//        char[] chars = new char[512];  // char占2字节，[512]为 1kb

//        while (br.read(chars) != -1) { // 判断回车的方法，不知道为什么用.equals('\n')不行
//            if (chars[0] == '\n') {
//                System.out.println(chars);
//            }
//        }

        while ((line = br.readLine()) != null) { //TODO br.ready()可用于判断是否为空/读完
            str.append(line).append("\n");       //TODO 用 "br.readline() != null" 而不是 "br.read(chars) != -1" 是为了防止读入并写入 "null"
        }
        str = new StringBuilder(str.toString().replaceAll("/\\*[\\s\\S]*?\\*/", "") //TODO 过滤 "/* xxx */"
                .replaceAll("//[\\s\\S]*?\n", "")      //TODO 过滤 “// xxx”
                .replaceAll("\n\\s+\n+", "\n\n"));     //TODO 过滤多余空行
        bw.write(str.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

public class Test_9_2 {
    public static void main(String[] args) throws IOException {
        DealFile f = new DealFile();
        f.deal("src/com/test9/Test_9_Data/My_Test.java", "src/com/test9/Test_9_Data/My_Dealt.txt");
    }
}
