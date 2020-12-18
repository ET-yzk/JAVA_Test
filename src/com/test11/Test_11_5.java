/*2019期末考试
* 假设一个宠物店有1000个动物，
* 一次宠物体检，给每个宠物的体重、活跃度、灵敏度进行了打分（100分制），
* 现在要实现宠物按照上述三个指标的平均值降序排列，
* 并输出所有宠物的详细信息，
* 包括：名字、年龄、体重、活跃度、灵敏度及平均值。
额外要求：
1）必须包含2个类：宠物类Pet，宠物店类PetShop，宠物店类包含一个属性pets，包含其所有的宠物；
2）宠物信息必须包含名字、年龄、体重、活跃度、灵敏度；宠物店信息必须包含名字、所有宠物信息；
3）1000个宠物随机产生，每个宠物各指标随机产生（0-100分之间）；
4）以上属性是规定属性，其它属性根据编程需要自行添加。
*/

package com.test11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

class Pet {
    String name;    // 姓名
    int age;              // 年龄
    double weight;        // 体重
    double activity;      // 活跃度
    double sensitivity;   // 灵敏度
    double average;       // 体重、活跃度、灵敏度平均分

    Pet(String name, int age, double weight, double activity, double sensitivity) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.activity = activity;
        this.sensitivity = sensitivity;
        this.average = (weight + activity + sensitivity) / 3;
    }

    // 输出宠物信息
    void print() {
        System.out.println("姓名->" + name);
        System.out.println("年龄->" + age);
        System.out.printf("体重得分->%.2f\n", weight);
        System.out.printf("活跃度->%.2f\n", activity);
        System.out.printf("灵敏度->%.2f\n", sensitivity);
        System.out.printf("体重得分、活跃度、灵敏度平均值->%.2f\n", average);
    }
}

class PetShop {
    String shopName;     // 店名
    ArrayList<Pet> pets; // 含有的宠物

    PetShop(String shopName, ArrayList<Pet> pets) {
        this.shopName = shopName;
        this.pets = pets;
    }

    // 按宠物得分平均值降序排序
    void sort() {

        pets.sort((o1, o2) -> (int) (o2.average - o1.average));
    }

    // 输出所有宠物信息
    void printAll() {
        int num = 1;
        for (Pet pet: pets) {
            System.out.println("第" + (num++) + "只宠物信息：");
            pet.print();
            System.out.println();
        }
    }
}

public class Test_11_5 {
    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        RandomData rd = new RandomData();
        ArrayList<Pet> pets = new ArrayList<>();
        PetShop ps;
        int num = 1000; // 宠物总数

        for (int i = num; i > 0; i--) {
            // 随机生成1000个  长为3个字符的[a-z]宠物名、[1,6]的年龄、
            //[0,100]的体重分、[0,100]的活跃分、[0,100]的灵敏分的宠物
            pets.add(new Pet(String.valueOf(rd.createRandomStr(3)),
                    rd.createRandomNum(5) + 1,
                    r.nextDouble() * 100,
                    r.nextDouble() * 100,
                    r.nextDouble() * 100));
        }

        // 随机产生6个字符的店名
        ps = new PetShop(String.valueOf(rd.createRandomStr(6)), pets);
        ps.sort();
        ps.printAll();
    }
}
