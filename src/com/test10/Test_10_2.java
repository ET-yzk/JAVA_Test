package com.test10;

import java.io.File;

class FileInfo {
    File f1 = new File("src/com/test10/Test_10_Data/倚天屠龙记.txt");
    File f2 = new File("src/com/test10/Test_10_Data/笑傲江湖.txt");
    File f3 = new File("src/com/test10/Test_10_Data/鹿鼎记.txt");
}

// 倒叙索引
class InvertedIndex {
    File file;
    InvertedIndex(File file) {
        this.file = file;
    }
}

class IndexRunnable implements Runnable {

    @Override
    public void run() {

    }
}

public class Test_10_2 {
    public static void main(String[] args) {

    }

}
