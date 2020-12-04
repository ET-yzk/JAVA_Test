package com.test7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

//class Node{
//    String name="";
//    double pagerank;
//    ArrayList<String> adjacentNodeNames;
//}

class PagerankDemo2 {
    static double q=0.85;
    static int num=1;
    static void printNode(ArrayList<Node_t> t_node, int N){
        for(int i=0;i<N;i++){
            System.out.print(t_node.get(i).name+" : "+t_node.get(i).pagerank+"     ");
            for(int j=0;j<t_node.get(i).adjacentNodeNames.size();j++){
                System.out.println(t_node.get(i).adjacentNodeNames.get(j));
            }
            System.out.println();
        }
    }
    static void pagerank2(ArrayList<Node_t> pre_nodes, ArrayList<Node_t>nodes, int N){
        if(num==1) System.out.println("---------初始化输出---------");
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
            if(Math.abs(nodes.get(index).pagerank-pre_nodes.get(index).pagerank)>0.00001)break;
        }
        if(index<5 && num<2){
            pagerank2(nodes,pre_nodes, N);
        }
    }
}
public class Test_7_5 {
    public static void main(String[] args) throws java.io.IOException{
        ArrayList<Node_t> begin_nodes = new ArrayList<>();
        String file_name="src/com/test7/Test_7_Data/out_wiki-adjacentNodes.txt";
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
            temp_node.adjacentNodeNames= new ArrayList<>();
            temp_node.name=new String(begin_nodes.get(i).name);
            temp_node.adjacentNodeNames.addAll(begin_nodes.get(i).adjacentNodeNames);
            nodes.add(temp_node);
        }
        PagerankDemo2.pagerank2(begin_nodes, nodes, N);
    }
}
