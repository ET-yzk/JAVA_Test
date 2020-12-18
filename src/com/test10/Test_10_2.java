package com.test10;

//TODO 倒序索引

import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

class FileInfo {
    String f1 = "src/com/test10/Test_10_Data/倚天屠龙记.txt";
    String f2 = "src/com/test10/Test_10_Data/笑傲江湖.txt";
    String f3 = "src/com/test10/Test_10_Data/鹿鼎记.txt";
    String f4 = "src/com/test10/Test_10_Data/金庸武侠小说倒排索引.txt";

    void print(HashMap<String, Integer> hNum, HashMap<String, ArrayList<String>> hFile, String path) throws FileNotFoundException {
        PrintStream outFile = new PrintStream(new FileOutputStream(path));

        // 通过Map.Entry<>--【key,value】实体内部接口.getValue()取得键值
        ArrayList<Map.Entry<String, Integer>> countList = new ArrayList<>(hNum.entrySet());

        // 将输出锁定到文件路径
        System.setOut(outFile);
        for (Map.Entry<String, Integer> i : countList) {
            System.out.println(i.getKey() + "=" + hFile.get(i.getKey()) + "->" + i.getValue());
        }
    }
}

class HashMapInfo {
    HashMap<String, Integer> hNum = new HashMap<>(); // 词-词频
    HashMap<String, ArrayList<String>> hFile = new HashMap<>(); // 词-文件
}

class IndexRunnable implements Runnable {
    String inFileName;
    HashMap<String, Integer> wordCount;// 存储词与其出现次数
    HashMap<String, ArrayList<String>> wordFile;// 存储词与出现文件

    IndexRunnable(String inFileName, HashMap<String, ArrayList<String>> wordFile, HashMap<String, Integer> wordCount) {
        super();
        this.inFileName = inFileName;
        this.wordCount = wordCount;
        this.wordFile = wordFile;
    }

    @Override
    public void run() {
        File inFile = new File(inFileName);
        String filepath = inFileName.split("/")[inFileName.split("/").length - 1];
        Scanner sc = null;// 读取文件
        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String str = null;// 读取文件内容
        String[] strList;// 储存最终分词字符串数组
        String regEx = "[^\u4e00-\u9fa5]";// 非汉字 "[\\u4e00-\\u9fa5]+"; 汉字

        // 读出整篇文章，存入String类的str中，最后加空格防止最后一个单词与第一个单词连接
        while (Objects.requireNonNull(sc).hasNextLine()) {
            str += sc.nextLine() + " ";
        }

        List<Term> termWords = StandardTokenizer.segment(Objects.requireNonNull(str));
        // List<Term> termWords = StandardTokenizer.segment(String); HanLp提供的标准分词方法

        String calStr = CoreStopWordDictionary.apply(termWords).toString();
        // 调用CoreStopWordDictionary.apply（）去停用词

        calStr = calStr.replaceAll(regEx, " ");
        // 取出中文字符

        strList = calStr.split("\\s+");
        // 以空格分离字符串到数组

        for (String i: strList) {
            ArrayList<String> list = new ArrayList<>();
            if (!wordCount.containsKey(i)) {
                list.add(filepath);
                wordFile.put(i, list);
                wordCount.put(i, 1);
            }else {
                list = wordFile.get(i);
                //如果没有包含过此文件名，则把文件名放入
                if (!list.contains(filepath)) {
                    list.add(filepath);
                }
                //文件总词频数目
                wordCount.put(i, wordCount.get(i) + 1);
            }
        }
        wordCount.remove("");// 检查输出后的文件发现，不知为何空字符串也有被统计
    }
}

public class Test_10_2 {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        long startTime = System.currentTimeMillis();
        FileInfo fileInfo = new FileInfo();
        HashMapInfo hashMapInfo = new HashMapInfo();

        IndexRunnable i1 = new IndexRunnable(fileInfo.f1, hashMapInfo.hFile, hashMapInfo.hNum);
        IndexRunnable i2 = new IndexRunnable(fileInfo.f2, hashMapInfo.hFile, hashMapInfo.hNum);
        IndexRunnable i3 = new IndexRunnable(fileInfo.f3, hashMapInfo.hFile, hashMapInfo.hNum);

        Thread t1 = new Thread(i1);
        Thread t2 = new Thread(i2);
        Thread t3 = new Thread(i3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        fileInfo.print(hashMapInfo.hNum, hashMapInfo.hFile, fileInfo.f4);
//        System.setOut(System.out);// 这里是希望把sout输出锁定到控制台，这个方法不对
        System.out.println("倒序索引建立完毕，耗时：" + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
    }
}
