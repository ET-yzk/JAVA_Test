package com.test5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

class MyData {
    private final String date;
    private final double temperature;

//    void setData(String date, double temperature) {
//        this.date = date;
//        this.temperature = temperature;
//    }

    String getDate() {
        return Objects.requireNonNull(this.date).substring(0,7);
    }

    String getYMD() {
        return Objects.requireNonNull(this.date).split("-")[0]+"-"+Integer.valueOf(this.date.split("-")[1])+"-"+Integer.valueOf(this.date.split("-")[2]);
    }

    double getTemperature() {
        return this.temperature;
    }

    void dealData(ArrayList<MyData> myData, String address) {
        String[] str;
        File file = new File(address);
        MyData data;

        //从文件读取数据
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //处理来自文件的数据
        while (Objects.requireNonNull(sc).hasNextLine()){
            str = sc.nextLine().split("\\s+");
            data = new MyData(str[0], Double.parseDouble(str[2].substring(0, str[2].indexOf("c"))));
            myData.add(data);
        }
    }

    void sortData(ArrayList<MyData> myData) {
        //比较排序：日期按年月升序、温度按降序
        myData.sort(new Comparator<>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                if (o1.getDate().compareTo(o2.getDate()) == 0) {
                    if (o1.getTemperature() > o2.getTemperature()) return -1;
                    if (o1.getTemperature() < o2.getTemperature()) return 1;
                    return 0;
                }
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    void printData(ArrayList<MyData> myData) {
        //按要求格式输出结果
        for (MyData i: myData){
            System.out.println(i.getYMD()+"\t"+i.getTemperature());
        }
    }

    MyData(String date, double temperature) {
        this.date = date;
        this.temperature = temperature;
    }
    MyData() {
        this.date = null;
        this.temperature = -300;//低于绝对零度，表示未初始化温度
    }
}

public class Test_5_2 {

    public static void main(String[] args) {
        MyData md = new MyData();
        ArrayList<MyData> myData = new ArrayList<>();//存放日期&对应温度

        md.dealData(myData,"src/com/test5/weather.txt");
        md.sortData(myData);
        md.printData(myData);
    }
}
