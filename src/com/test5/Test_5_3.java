package com.test5;

import java.util.*;

//串中任意个连续的字符组成的子序列称为该串的子串
class SubStr {

    void countStr(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        String tmp;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (!map.containsKey(tmp = str.substring(i, j))) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);
                }
            }
        }

        //将HashMap-map的key转换为ArrayList-set，再由子串长度、ASCII升序排序
        ArrayList<String> set = new ArrayList<>(map.keySet());
        set.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (String x : set) {
            System.out.println(x + "=" + map.get(x));
        }
    }
}

public class Test_5_3 {
    //检索各子串出现次数
    public static void main(String[] args) {
        SubStr ss = new SubStr();
        String line = new Scanner(System.in).nextLine();

        ss.countStr(line);
    }
}
