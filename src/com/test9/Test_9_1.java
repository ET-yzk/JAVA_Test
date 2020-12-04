package com.test9;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Test_9_1 {
        public static void main(String[] args) throws FileNotFoundException {
            File inFile = new File("./src/com/test8/Test_8_Data/三国演义(罗贯中).txt");
            PrintStream outFile = new PrintStream(new FileOutputStream("./src/com/test9/Test_9_Data/三国演义地名词频.txt"));
            Scanner sc = new Scanner(inFile);// 读取文件
            HashMap<String, Integer> wordCount = new HashMap<>();// 存储汉字与其出现次数
            String str = null;// 读取文件内容
            ArrayList<String> strList = new ArrayList<>();// 储存最终分词字符串数组

            // 读出整篇文章，存入String类的str中，最后加空格防止最后一个单词与第一个单词连接
            while (sc.hasNextLine()) {
                str += sc.nextLine() + " ";
            }

            //StringTokenizer st = new StringTokenizer(str," #$()/*&%_;\\,.!?:[]-\"'"); // 去除标点

            // HanLp地名分词标记方法，将标记为/nr
            Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
            List<Term> termList = segment.seg(str);

            for (Term st: termList) {
//                System.out.println(st);
                if (st.nature.startsWith("ns")) {
                    // 取出地名，原始格式："地名/ns"
                    strList.add(st.toString().split("/")[0]);
                }
            }

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
