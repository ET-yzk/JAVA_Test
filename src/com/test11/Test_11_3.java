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
        findUnHuiNum();
    }

    public static void findUnHuiNum() {
        // 生成回文数:它与自己的翻转数相加,200以内的数字中，都可以在30步以内变成回文数，
        //除了一个数字很特殊，就算迭代了1000次，它还是顽固地拒绝回文，请找出该数。
        for(int i=1;i<=200;i++)
        {
            int j=1;
            //long保证数字不超出范围
            long sum=i;
            while(j<=30)
            {
                //转字符串类型便于循环
                String str = String.valueOf(sum);
                boolean flag=false;
                for(int a = 0, b = str.length()-1; a < str.length(); a++, b--)
                {
                    //判断对应位是否相等
                    if(str.charAt(a)!=str.charAt(b))
                    {
                        //不是回文数
                        flag =true;
                    }
                }
                if(flag)
                {
                    //反转
                    long k = sum, tmp = 0;
                    while (k != 0) {
                        tmp = tmp * 10 + k % 10;
                        k/=10;
                    }
                    //反转之和
                    sum += tmp;
                }
                else
                {
                    //是回文数
                    break;
                }
                j++;
            }
            if(j>30)
            {
                //输出循环30次还不是回文数
                System.out.println(i);
            }
        }
    }

}

//实现类似python字符串的乘法：a * 2 -> aa
//System.out.println(new String(new char[4]).replace("\0", str[i]));