package com.test7;

import java.util.ArrayList;
import java.io.*;
import java.lang.Math;
import java.util.Arrays;

class Node_t {
    String name="";
    double pagerank;
    ArrayList<String> adjacentNodeNames;
}

class pagerankDemo {
    static double q=0.85;
    static int num=1;

    static void printNode(ArrayList<Node_t> t_node, int N){
        for(int i=0;i<N;i++){
            System.out.print(t_node.get(i).name+" : "+t_node.get(i).pagerank+"     ");
            for(int j=0;j<t_node.get(i).adjacentNodeNames.size();j++){
                System.out.print(t_node.get(i).adjacentNodeNames.get(j)+"  ");
            }
            System.out.println();
        }
    }

    static void pagerank(ArrayList<Node_t> pre_nodes, ArrayList<Node_t> nodes, int N){
        if(num == 1) {
            System.out.println("---------初始化输出---------");
        }
        else System.out.println("---------第"+num+"轮的节点pagerank值---------");
        printNode(pre_nodes, N);
        for(int i=0;i<N;i++){
            nodes.get(i).pagerank=(1-q)/N;
            for(int j=0;j<N;j++){
                if(j!=i&&nodes.get(j).adjacentNodeNames.contains(nodes.get(i).name)){
                    nodes.get(i).pagerank+=pre_nodes.get(j).pagerank/pre_nodes.get(j).adjacentNodeNames.size();
                }
            }
        }
        num++;
        System.out.println("---------迭代计算出的pagerank值---------");
        printNode(nodes, N);
        int index;
        for(index=0;index<N;index++){
            if(Math.abs(nodes.get(index).pagerank-pre_nodes.get(index).pagerank)>0.001)break;
        }
        if(index<5){
            pagerank(nodes,pre_nodes, N);
        }
    }
}

public class Test_7_3 {
    public static void main(String[] args) throws java.io.IOException{
        ArrayList<Node_t> begin_nodes = new ArrayList<>();
        String file_name="src/com/test7/Test_7_Data/pagerank.txt";
        FileReader fr = new FileReader(file_name);
        BufferedReader bf = new BufferedReader(fr);
        // 按行读取字符串
        String line;
        int N=0;
        while ((line = bf.readLine()) != null) {
            N++;
            String []str=line.split("\t");
            Node_t temp_node = new Node_t();
            temp_node.name=str[0];
            temp_node.adjacentNodeNames= new ArrayList<>();
            temp_node.adjacentNodeNames.addAll(Arrays.asList(str).subList(1, str.length));
            temp_node.pagerank=1.0;
            begin_nodes.add(temp_node);
        }
        bf.close();
        fr.close();
        ArrayList<Node_t> nodes = new ArrayList<>();
        for(int i=0;i<N;i++){
            Node_t temp_node = new Node_t();
            temp_node.adjacentNodeNames=new ArrayList<>();
            temp_node.name= begin_nodes.get(i).name;
            temp_node.adjacentNodeNames.addAll(begin_nodes.get(i).adjacentNodeNames);
            nodes.add(temp_node);
        }
        pagerankDemo.pagerank(begin_nodes, nodes, N);
    }
}


//class Node {
//    double pageRank;// 节点pageRank值
//    String name;// 节点名
//    String[] adjacentNodeNames;// 节点向外的邻接节点数组
//    double q = 0.85;
//
//    double calPageRank(double p) {
////        System.out.println(this.pageRank + this.name + this.adjacentNodeNames.length);
//        double t = (1 - q) / 5 + q * calPageRank(p) / (this.adjacentNodeNames.length - 1);
//        if (p - t <= 0.0001) {
//            return p;
//        }
//        return t;
//    }
//
//    Node(double pageRank, String name, String[] adjacentNodeNames) {
//        this.adjacentNodeNames = adjacentNodeNames;
//        this.name = name;
//        this.pageRank = pageRank;
//    }
//}
//
//public class Test_7_3 {
//    public static void main(String[] args) {
//        File file = new File("src/com/test7/Test_7_Data/pagerankDemo.txt");
//        Scanner sc = null;
//        try {
//            sc = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String[][] link = new String[5][];
//        String tmp;
//        ArrayList<Node> nodes = new ArrayList<>();
//
//        while (sc.hasNext()) {
//            int j = 0;
//            link[j] = sc.nextLine().split("\\s+");
//
//            nodes.add(new Node(1, link[j][0], link[j]));
//            j++;
//        }
//
//    }
//}


//public class Test_7_3 {
//    private static final double factor = 0.85;
//
//    public static void main(String[] args) {
//        int n=5;
//        double a[][] = {
//                {0,0,1.0/3,0,0},
//                {1.0/2,0,1.0/3,1.0/2,0},
//                {0,1.0,0,1.0/2,0},
//                {1.0/2,0,0,0,0},
//                {0,0,1.0/3,0,0}};
//
////        print(a);
//
//        double b[] = new double[n];
//        double[] bFactor = new double[n];
//
//        for(int i=0;i<n;i++){
//            b[i] = 1.0/n;
//        }
//
//        for(int i=0;i<n;i++){
//            bFactor[i] = b[i]*(1-factor);
//        }
//
//        for(int i=0;i<30;i++){
//            //print(matrixMulti(a, b));
//            b = matrixAdd(matrixMulti(a, b), bFactor);
//            print(b);
//        }
//    }
//
//
//    public static double[] matrixMulti(double a[][] , double b[]){
//        int n = a.length;
//        double ans[] = new double[n];
//
//        for(int i=0;i<n;i++){
//            double sum = 0;
//            for(int j=0;j<n;j++){
//                sum+=a[i][j]*b[j]*factor;
//            }
//            ans[i] = sum;
//        }
//        return ans;
//    }
//
//    public static double[] matrixAdd(double a[] ,double b[]){
//        int n = a.length;
//        double ans[] = new double[n];
//        for(int i=0;i<n;i++){
//            ans[i] = a[i]+b[i];
//        }
//        return ans;
//    }
//
//    public static void print(double a[]){
//        for(int i=0;i<a.length;i++){
//            System.out.print(a[i]+" ");
//        }
//        System.out.println();
//    }
//    public static void print(double a[][]){
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<a[i].length;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//
//        }
//        System.out.println();
//    }
//}

