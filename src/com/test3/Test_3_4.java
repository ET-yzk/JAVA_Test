package com.test3;

import java.util.ArrayList;//申请动态数组

//全排列
/*4位原理
* 1 [2,3,4]（1开头[2,3,4]的全排列）=

1 2 [3,4] ==(1,2开头的[3,4]全排列)==
1 2 3 [4] =1 2 3 4(1 2 3 开头的[4]全排列)
1 2 4 [3]=1 2 3 4
1 3 [2,4]
1 3 2 [4]=1 3 2 4
1 3 4 [2]=1 3 4 2
1 4 [3,2]
1 4 3 [2]=1 4 3 2
1 4 2 [3]=1 4 2 3
2 [1,3,4]=

2 1 [3,4]
2 1 3 [4]=2 1 3 4
2 1 4 [3]=2 1 4 3
2 3 [1,4]
2 3 1 [4]=2 3 1 4
2 3 4 [1]=2 3 4 1
2 4 [3,1]
2 4 3 [1]=2 4 3 1
2 4 1 [3]=2 4 1 3
3 [2,1,4]=(略)

3 2 [1,4]
3 1 [2,4]
3 4 [3,2]
4 [2,3,1]=(略)

4 2 [3,1]
4 3 [2,1]
4 1 [3,2]*/
class Permutations {
    public static int total = 0;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void clear() {
        list.clear();
        total = 0;
    }

    public static void swap(int[] num, int i, int j) {
        int temp;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void arrange(int[] num, int st, int len) {

        if (st == len - 1) {
            for (int i = 0; i < len; i++) {
                list.add(num[i]);
//                System.out.print(num[i] + "  ");
            }
//            System.out.println();
            total++;
        } else {
            for (int i = st; i < len; i++) {
                swap(num, st, i);
                arrange(num, st + 1, len);
                swap(num, st, i);
            }
        }
    }

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        int[] num = {0, 1, 2, 3};//需要输入不同
//        arrange(num, 0, num.length);
//        System.out.println(total);
//        for (int i = 0; i < total;i++){
//            for (int j = 0; j < 4; j++){
//                System.out.print(list.get(i*4 + j) + " ");
//            }
//            System.out.println();
//        }
//    }
}

public class Test_3_4{
    static void CalVampire(int numLen) {
        int i = (int)Math.pow(10,numLen - 1);
        int[] numCount = new int[numLen];

        for (;i <= (int)Math.pow(10,numLen) - 1; i++) {
            int a = i;
            for (int count = 0; count < numLen; count++) {
                numCount[count] = a % 10;
                a /= 10;
            }
            Permutations.arrange(numCount,0, numLen);
            if (numLen == 4) {
                for (int j = 0; j < Permutations.total; j++) {
                    if ((Permutations.list.get(j * numLen) * 10 + Permutations.list.get(j * numLen + 1)) * (Permutations.list.get(j * numLen + 2) * 10 + Permutations.list.get(j * numLen + 3)) == i) {
                        System.out.println(i + " = " + (Permutations.list.get(j * numLen) * 10 + Permutations.list.get(j * numLen + 1))
                                + " * " + (Permutations.list.get(j * numLen + 2) * 10 + Permutations.list.get(j * numLen + 3)));
                        break;
                    }
                }
            }
            else if (numLen == 6) {
                for (int j = 0; j < Permutations.total; j++) {
                    if ((Permutations.list.get(j * numLen) * 100 + Permutations.list.get(j * numLen + 1) * 10 + Permutations.list.get(j * numLen + 2)) * (Permutations.list.get(j * numLen + 3) * 100 + Permutations.list.get(j * numLen + 4) * 10 + Permutations.list.get(j * numLen + 5)) == i) {
                        System.out.println(i + " = " + (Permutations.list.get(j * numLen) * 100 + Permutations.list.get(j * numLen + 1) * 10 + Permutations.list.get(j * numLen + 2))
                                + " * " + (Permutations.list.get(j * numLen + 3) * 100 + Permutations.list.get(j * numLen + 4) * 10 + Permutations.list.get(j * numLen + 5)));
                        break;
                    }
                }
            }
            else {
                System.out.println("输入未知");
            }
            Permutations.clear();
        }
    }

    public static void main(String[] args) {
        System.out.println("四位Vampire：");
        CalVampire(4);
        System.out.println("六位Vampire：");
        CalVampire(6);
    }
}



// 网上的高效率版本
//import java.util.Arrays;
//
//public class VampireNum {
//    public static void main(String[] arg) {
//        String[] ar_str1, ar_str2;
//        int sum = 0;
//        int from;
//        int to;
//        int i_val;
//        int count = 0;
//        // 对i和j的双重循环，用到剪枝
//        for (int i = 10; i < 100; i++) {
//            // j=i+1避免重复
//            from = Math.max(1000 / i, i + 1);
//            to = Math.min(10000 / i, 100);
//            for (int j = from; j < to; j++) {
//                i_val = i * j;
//                if (i_val % 100 == 0 || (i_val - i - j) % 9 != 0) {
//                    continue;
//                }
//                count++;
//                ar_str1 = String.valueOf(i_val).split("");
//                ar_str2 = (String.valueOf(i) + String.valueOf(j)).split("");
//                Arrays.sort(ar_str1);
//                Arrays.sort(ar_str2);
//                if (Arrays.equals(ar_str1, ar_str2)) {// 排序后比较,为真则找到一组
//                    sum++;
//                    System.out.println("第" + sum + "组: " + i + "*" + j + "=" + i_val);
//                }
//            }
//        }
//        System.out.println("共找到" + sum + "组吸血鬼数");
//        System.out.println(count);
//    }
//}