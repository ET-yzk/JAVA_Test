package com.test7;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.PrintWriter;

class WikiDemo {
    String vertices_id;
    String vertices_name;
    ArrayList<String> adjacentNodeNames;
}

public class Test_7_4 {
    public static void main(String[] args) throws java.io.IOException{
        HashMap<String, WikiDemo> map = new HashMap<>();
        String file_name_v="src/com/test7/Test_7_Data/wiki-vertices.txt";
        String file_name_e="src/com/test7/Test_7_Data/wiki-edges.txt";
        FileReader fr = new FileReader(file_name_v);
        BufferedReader bf = new BufferedReader(fr);
        // 按行读取字符串
        String line;
        while ((line = bf.readLine()) != null) {
            WikiDemo temp = new WikiDemo();
            String []str = line.split("\t");
            temp.vertices_id = str[0];
            temp.vertices_name = str[1];
            temp.adjacentNodeNames= new ArrayList<>();
            if(!map.containsKey(temp.vertices_id)){map.put(temp.vertices_id, temp);}
        }
        bf.close();
        fr.close();
        fr = new FileReader(file_name_e);
        bf = new BufferedReader(fr);
        // 按行读取字符串
        while ((line = bf.readLine()) != null) {
            String []str = line.split("\t");
            String temp_id1 = new String(str[0]);
            String temp_id2 = new String(str[1]);

            if(!map.get(temp_id1).adjacentNodeNames.contains(temp_id2)){
                map.get(temp_id1).adjacentNodeNames.add(temp_id2);
            }
        }

        bf.close();
        fr.close();

        Set<Map.Entry<String, WikiDemo>> entrySet = map.entrySet();
        String result_filename="src/com/test7/Test_7_Data/out_wiki-adjacentNodes.txt";
        PrintWriter pw = new PrintWriter(result_filename);
        for(Map.Entry<String, WikiDemo> entry:entrySet){
//            System.out.print(entry.getValue().vertices_id + ":" + entry.getValue().vertices_name+"     ");
            pw.write(entry.getValue().vertices_id);
//            System.out.println(entry.getValue().adjacentNodeNames);
            for(String temp_str:entry.getValue().adjacentNodeNames){
                pw.write("\t"+temp_str);
            }
            pw.write("\n");
        }

    }
}
