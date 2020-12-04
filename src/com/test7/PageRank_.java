package com.test7;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

class Node {

    private double pageRank;
    private String name; //节点名
    //private HashMap<String,Double> vertex;
    private String[] adjacentNodeNames; //节点Node的邻接矩阵
    // private ArrayList<String> adjacentNodeNames2;

    //    public  static final char separator='\t';
    public  static final String separator="\t";

    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
        this.pageRank = pageRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAdjacentNodeNames() {
        return adjacentNodeNames;
    }

    public Node setAdjacentNodeNames(String[] adjacentNodeNames){
        this.adjacentNodeNames=adjacentNodeNames;
        return this;
    }

//    public HashMap<String, Double> getVertex() {
//        return vertex;
//    }

//    public void setVertex(HashMap<String, Double> vertex) {
//        this.vertex = vertex;
//    }

    //判定节点是否有邻接节点
    public boolean containsAdjacentNodes(){
        return adjacentNodeNames!=null && adjacentNodeNames.length>0;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(name).append(":").append(pageRank);
        //sb.append(pageRank);

        if (getAdjacentNodeNames()!=null){
//        sb.append(separator).append(StringUtils.join(getAdjacentNodeNames(),separator));
            sb.append(separator).append(String.join(separator,getAdjacentNodeNames()));
            // String.join()将数组或集合以某拼接符拼接到一起形成新的字符串
        }
        return sb.toString();
    }

    //输出到文件
//    public void output(){
//        try {
//            PrintWriter pw = new PrintWriter("src/com/google/作业七/pagerank_of_node.txt");
//            pw.write(name+":");
//            if (getAdjacentNodeNames()!=null) {
//                for (String nodeName : getAdjacentNodeNames()) {
//                    pw.write("\t"+nodeName);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    //从字符串 A:1.0	B	D 封装成Node对象,A后面的:1.0是调用toString()方法产生的
    public static Node buildAdjacentNodes(int count,String page) throws IOException {
//         String[] parts=StringUtils.splitPreserveAllTokens(value,separator); //切分后的空格会保留
        String[] parts=page.split("\t{1}",2); //按第一个\t分割成2部分
        if (parts.length<1){
            throw  new IOException("Expected 1 or more parts but received "+ parts.length);
        }

        Node node=new Node(); //创建一个Node
        if (count==1) node.pageRank=1.0; // count==1表示是第一轮运行，pageRank赋初值1.0
        // HashMap<String, Double> vertex = new HashMap<>();
        node.name=parts[0];
        //vertex.put(node.name,Double.valueOf(node.pageRank));

        if (parts.length>1){
            // parts[1].replaceAll("\t",""); //去掉["B","\t","D"]中间的"\t"
            String[] adjacent=parts[1].split("\t"); //变为["B","D"]
            node.setAdjacentNodeNames(adjacent);
        }
        return node;
    }
}

class Transformer {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        String line;
        String line2;
        String[] parts;
        HashMap<String, ArrayList<String>> map= new HashMap<>();
        //map为顶点和其邻接顶点集的二元组集合

        File file=new File("src/com/google/作业七/wiki-edges.txt");
        File file2=new File("src/com/google/作业七/wiki-vertices.txt");

        try {
            Scanner scanner = new Scanner(file); // 读取边集和
            Scanner scanner2= new Scanner(file2); // 读取节点集合

            while (scanner2.hasNext()){
                line= scanner2.nextLine().trim();
                parts=line.split("\t");
                map.put(parts[0],null); //初始化map集合
            }

            while (scanner.hasNext()){ //将所有节点编号加载至node中
                line2=scanner.nextLine().trim();
                parts=line2.split("\t");
                // Node node = new Node();
                // node.setName(parts[0]); //读取的节点号加载到node中为node的name
                ArrayList<String> strArr = new ArrayList<>(); // strArr存放节点的链接节点数组

               /* if (!map.containsKey(parts[0])){ //节点第一次加入map中
                    strArr.add(parts[1]); //将邻接节点加入
                    map.put(parts[0],strArr);
                }else{
                    map.get(parts[0]).add(parts[1]);
                }*/

                if (map.get(parts[0])==null){ //节点第一次加入map中
                    strArr.add(parts[1]); //将邻接节点加入
                    map.put(parts[0],strArr);
                }else{
                    map.get(parts[0]).add(parts[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.printf("总的节点数为%d%n", map.size());
        // 总的节点数为22424

        //输出到控制台
       /* for (String key : map.keySet()){
            ArrayList<String> arr=map.get(key);
            System.out.print(key+"\t");
            for (String s : arr) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }*/


        //输出到文件
        try {
            // PrintWriter pw = new PrintWriter("src/com/google/作业七/wiki-adjacentNodes3.txt");
            FileWriter fw = new FileWriter("src/com/test7/Test_7_Data/wiki-adjacentNodes.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            int count=0;
            for (String key: map.keySet()) {
                count++;
                ArrayList<String> arr = map.get(key);
                bw.write(key);
                if (arr != null) {
                    //pw.write(key + "\t");
                    for (String s : arr) {
                        bw.write( "\t"+s);
                    }
                    //fw.write("\n");
                }
                bw.write("\n");
            }
            bw.close(); //务必关闭，否则输出不正确
            System.out.println("count= "+count); // count= 22424  22105
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        System.out.printf("程序执行时间 %d 毫秒%n", end-start);

    }
}


public class PageRank_ {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 1; //count记录程序的运行次数
        final double q = 0.85;
        double error = 0.001;
//        int N = 5;
//        int N=22424;
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<String, Double> vertex; //用于计算节点的pagerank
        File file = new File("src/com/test7/Test_7_Data/pagerank.txt");
        // File file = new File("src/com/google/作业七/wiki-adjacentNodes.txt");

        String page;  //pagerank.txt中的一行
        int num_nodes=0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                page = scanner.nextLine().trim();
                //parts=page.split("\t{1}",2); //按第一个\t分割成2部分
                Node node;
                node = Node.buildAdjacentNodes(count, page);
                nodes.add(node);
                num_nodes++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("节点数：%d%n", num_nodes);

        System.out.println("---------初始化输出---------");
        for (Node node : nodes) {
            System.out.println(node);
        }


        while (true) {
            count++;

            //迭代计算每个节点的pagerank值
            vertex = new HashMap<>();
            init_vertexes(vertex, nodes); //初始化
            // System.out.println(vertex); //{A=0.0, B=0.0, C=0.0, D=0.0}

            for (Node node : nodes) {
                if (node.containsAdjacentNodes()) {
                    //System.out.println("node.getName()= "+node.getName());
                    // node.getName()= 4289168012538570878
                    // 4289168012538570878	4315052278831489964	8830299306937918434
                    double outPageRank = node.getPageRank() / node.getAdjacentNodeNames().length;
                    for (int i = 0; i < node.getAdjacentNodeNames().length; i++) {
                        String outPageName = node.getAdjacentNodeNames()[i]; //第i个邻接的节点
                        // vertex.put(outPageName, (1 - q) /num_nodes + q * (vertex.get(outPageName) + outPageRank));
                        vertex.put(outPageName, vertex.get(outPageName) + outPageRank); //每个节点的pageRank更新
                        // 这个是只算和，不加 (1 - q) /num_nodes+q*()
                        //每个节点的pageRank更新，其中vertex.get(outPageName)是outPageName旧的pagerank值
                        //System.out.println("vetex= "+vertex);
                        //vertex.put(outPageName, vertex.get(outPageName) + outPageRank);//每个节点的pageRank更新
                    }
                }
            }

            // 计算节点最终的pagerank值
            System.out.println("求和部分：");
            for(String key: vertex.keySet()){
                System.out.println("vertex.get("+key+")= "+vertex.get(key));
                vertex.put(key, (1 - q) /num_nodes + q *vertex.get(key)); //节点最终的pagerank值
            }

            boolean b = true;
            for (Node node : nodes) {
                b = b & (Math.abs(node.getPageRank() - vertex.get(node.getName())) <= error);
            }

            if (b) {
                break;
            }

            System.out.println();
            System.out.println("---------迭代计算出的pagerank值---------");
            System.out.println(vertex);

            //将vertex所有节点的pagerank值保存至node中
            for (Node node : nodes) {
                //node.setPageRank(vertex.get(node.getName()));
                node.setPageRank(vertex.get(node.getName())); //修正后的pagerank值
            }

            System.out.println();
            System.out.printf("---------第%d轮的节点pagerank值---------%n", count);
            // ---------第30轮的节点pagerank值---------

            //输出到控制台
            /* for (Node node : nodes) {
                 System.out.println(node);
            }*/
        }

        //输出到文件
        try {
            // PrintWriter pw = new PrintWriter("src/com/google/作业七/pagerank_of_node.txt");
            // FileWriter fw = new FileWriter("src/com/google/作业七/pagerank_of_node.txt");
            FileWriter fw = new FileWriter("src/com/test7/Test_7_Data/pagerank_of_5node2.txt");
//            BufferedWriter bw = new BufferedWriter(fw);
            for (Node node : nodes) {
                fw.write(node.getName() + ":"+node.getPageRank());
                if (node.getAdjacentNodeNames() != null) {
                    for (String nodeName : node.getAdjacentNodeNames()) {
                        fw.write("\t" + nodeName);
                    }
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.printf("程序执行时间为%d毫秒%n",end-start);
        // 程序执行时间为1742毫秒
}

    // 初始化vertex
    public static void init_vertexes(HashMap<String,Double> vertex, ArrayList<Node> nodes){
        for (Node node : nodes) {
            vertex.put(node.getName(), 0.0);
        }
    }
}
