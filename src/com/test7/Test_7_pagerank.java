package com.test7;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Node_ {
    private  double pagerank;
    private String name;
    private String[] adjacentNode;

    String getAdjacentNodes() {
        return null;
    }

    // 判定节点是否对外的链接节点
    boolean containsAdjacentNodes() {
        return getAdjacentNodes() != null && adjacentNode != null;
    }
}

class PageRank {

    void mm() throws FileNotFoundException {
        long Start = System.currentTimeMillis();
        int count = 1;// 记录迭代次数
        final double q = 0.85;
        double distance = 0.001;
        ArrayList<Node> nodes = new ArrayList<>();

        File file = new File("");
        String[] parts;
        int num_nodes = 0;

        Scanner scanner = new Scanner(file);


    }



}

public class Test_7_pagerank {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String line;
        String[] parts;

        //map 为节点和它向外链接节点的集合
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        File file1 = new File("src/com/test7/Test_7_Data/");
        File file2 = new File("src/com/test7/Test_7_Data/");

        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);

        while (sc2.hasNextLine()) {
            line = sc2.nextLine();// .trim()去除两侧空格
            parts = line.split("\\s+");
            map.put(parts[0], null);// 初始化map集合

        }

        while (sc1.hasNextLine()) {
            line = sc1.nextLine();
            parts = line.split("\\s+");

            ArrayList<String> arr = new ArrayList<>();
            // arr存放相关节点的向外链接节点
            if (map.get(parts[0]) == null) { // 节点第一次加入map
                arr.add(parts[1]); // 将链接的节点加入
                map.put(parts[0], arr);
            }
            else {
                map.get(parts[0]).add(parts[1]);
            }
        }

        System.out.println(String.format("总的节点数为%d", map.size()));

        // 输出文件
        FileWriter fw = new FileWriter("");
        BufferedWriter bw = new BufferedWriter(fw);

        for (String key: map.keySet()) {
            ArrayList<String> arrayList = map.get(key);
            bw.write(key);
            if (arrayList != null) {
                for (String s : arrayList) {
                    bw.write("\t" + s);
                }
            }
            bw.write("\n");

            bw.close();
        }
    }
}
