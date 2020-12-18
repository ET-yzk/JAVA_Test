/* 2019期末考试
* 输入一个100000位的数字，
* 请计算这个数中各位数出现的次数。
* 如输入1223，则各位数出现的次数为1：1次；2：2次；3：1次。*/

package com.test11;

import java.util.*;

public class Test_11_2 {
    public static void main(String[] args) {
        System.out.println("请输入一个数:");
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        HashMap<String,Integer> hs = new HashMap<>();
        for (int i = 0; i < num.length(); i ++) {
            hs.merge(String.valueOf(num.charAt(i)), 1, Integer::sum);
        }

        ArrayList<Map.Entry<String, Integer>> countList = new ArrayList<>(hs.entrySet());
        countList.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, Integer> i: countList) {
            System.out.println(i.getKey() + ":" + i.getValue() + "次");
        }
    }
}
