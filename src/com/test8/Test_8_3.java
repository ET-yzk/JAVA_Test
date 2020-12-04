package com.test8;

import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.*;
import java.util.*;

public class Test_8_3 {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("./src/com/test8/Test_8_Data/三国演义(罗贯中).txt");
        PrintStream outFile = new PrintStream(new FileOutputStream("./src/com/test8/Test_8_Data/三国演义词频.txt"));
        Scanner sc = new Scanner(inFile);// 读取文件
        HashMap<String, Integer> wordCount = new HashMap<>();// 存储汉字与其出现次数
        String str = null;// 读取文件内容
        String[] strList;// 储存最终分词字符串数组
        String regEx = "[^\u4e00-\u9fa5]";// 非汉字 "[\\u4e00-\\u9fa5]+"; 汉字

        // 读出整篇文章，存入String类的str中，最后加空格防止最后一个单词与第一个单词连接
        while (sc.hasNextLine()) {
            str += sc.nextLine() + " ";
        }

        //StringTokenizer st = new StringTokenizer(str," #$()/*&%_;\\,.!?:[]-\"'"); // 去除标点

        List<Term> termWords = StandardTokenizer.segment(str);
        // List<Term> termWords = StandardTokenizer.segment(String); HanLp提供的标准分词方法

        String calStr = CoreStopWordDictionary.apply(termWords).toString();
        // 调用CoreStopWordDictionary.apply（）去停用词

        calStr = calStr.replaceAll(regEx, " ");
        // 取出中文字符

        strList = calStr.split("\\s+");
        // 以空格分离字符串到数组

        for (String st : strList) {
            wordCount.merge(st, 1, Integer::sum);// 记录词频
        }
        wordCount.remove("");// 检查输出后的文件发现，不知为何空字符串也有被统计

        // 通过Map.Entry<>--【key,value】实体内部接口.getValue()取得键值，调用Collections.sort(List, new Comparator<>)排序
        ArrayList<Map.Entry<String, Integer>> countList = new ArrayList<>(wordCount.entrySet());
        countList.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return o2.getValue() - o1.getValue();
            }
        });

        // 将输出锁定到文件路径
        System.setOut(outFile);
        for (Map.Entry<String, Integer> i : countList) {
            System.out.println(i.getKey() + "\t\t" + i.getValue());
        }
    }
}