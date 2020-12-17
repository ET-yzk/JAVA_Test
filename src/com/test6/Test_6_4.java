package com.test6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Test_6_4 {
    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        Scanner scanner = null;
        File file;
        HashMap<String, Integer> wordCount = new HashMap<>();

        // 读取7个文件内容，并记录词频
        for (int i = 1; i < 8; i++) {

            file = fileIO.readFile(i);
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            fileIO.calWords(Objects.requireNonNull(scanner), wordCount);
        }

        fileIO.clearFile(wordCount, "src/com/test6/Test_6_4_InData/stopwords.txt");
        fileIO.writeFile(wordCount);
    }
}
