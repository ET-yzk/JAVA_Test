/*2019期末考试
* 编程求由｛a,b,c,d｝构成的所有“回文字符串”，
* 字符串长度固定为4。
* 回文字符串是该字符串数顺着来与倒着来一样，
* 譬如：aaaa就是一个回文数，因为顺着是aaaa，倒着也是aaaa；
* abba也是回文数，因为顺着是abba，倒着也是abba。
* 请输出上述长度为4的所有回文字符串。*/

package com.test11;

public class Test_11_3 {
    public static void main(String[] args) {
        String[] str = {"a","b","c","d"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4; j++) {
                System.out.println(str[i] + str[j] + str[j] + str[i]);
            }
        }
    }
}

//实现类似python字符串的乘法：a * 2 -> aa
//System.out.println(new String(new char[4]).replace("\0", str[i]));