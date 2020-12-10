package com.test9;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import net.sf.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test_9_3 {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();//检测运行时间 -part1
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/test9/Test_9_Data/weibo.txt", StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/test9/Test_9_Data/weibo_tfidf.txt", true));

        HashMap<String, Integer> bigMap = new HashMap<>();//统计用于并计算idf
        List<HashMap<String, Double>> list = new ArrayList<>();
        HashMap<String, HashMap<String, Double>> IDMap = new HashMap<>();
        List<String> IDList = new ArrayList<>();
        String string;
        int countLines = 0;//统计文件集文件数(这里是退化为wei_bo.txt的行数[单条微博"文件"数])
        while ((string = bufferedReader.readLine()) != null) {
            //System.out.println(string);

            countLines++;
            HashMap<String, HashMap<String, Double>> idMap = new HashMap<>();
            HashMap<String, Double> map = new HashMap<>();//用于统计词频 (每条微博配一个)

            int IndexOfSeparator = string.indexOf("\t");
            String IDString = string.substring(0, IndexOfSeparator);
            //IDMap.put(IDString,null);无序;
            IDList.add(IDString);
            string = string.substring(IndexOfSeparator + 1);

            List<Term> termList = HanLP.segment(string);
            int wordsNumber = 0;
            //对每条微博中的词进行词频统计(string,Double);
            for (Term x : termList) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }
            // 生成TF键值对(t,tf)
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);
            }
            list.add(map);

            // System.out.println(map);
            // 添加记录到bigMap中(统计某个词t相对于整个文件集的IDF的过程,要完整遍历所有微博,然后才能使用这个IDF(即要在这个while节输之后使用.)(key:词t,value:包含词t的文件(微博条数)
            //TODO 计算文件集中含词t的文件数目.(t,number)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);//不要写成map.get(x)了
                } else {
                    bigMap.put(x, 1);
                }
            }
            // System.out.println(map);
        }


        /*将(t,tf)更新为(t,tf-idf);
        tf-idf=tf*idf;idf=countLines/bigMap.get(x).log10
        计算出每条微博中各个词t的TF-IDF值*/

        //TODO 计算每个词在其所在的微博中的tfidf值
        int index = 0;
        String str;
        for (HashMap<String, Double> x : list) {
            str = (IDList.get(index++) + "=[");
//            System.out.print(str);
            bufferedWriter.write(str);
            for (String y : x.keySet()) {
                x.put(y, (x.get(y) * Math.log10(countLines * 1.0 / bigMap.get(y))));
                //利用json格式
                JSONObject json = new JSONObject();
                json.accumulate(y, x.get(y));//json可以视为容器
//                System.out.print(json + ",");
                bufferedWriter.write(json + ",");
            }
//            System.out.println("]");
            bufferedWriter.write("]\n");

        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("运行耗时: " + (System.currentTimeMillis() - time1) / 1000.0 + "s");
    }
}