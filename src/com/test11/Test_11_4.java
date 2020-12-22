/*2019期末考试
* 实现一个摸奖程序，在控制台输入任意一个正整数，
* 按回车出现一个奖品，输入0退出程序。
* 假设程序中存储有500个奖品，每个奖品都有2件，
* 每次抽奖只能抽一次，取走1件奖品，奖品抽完后就不再出现。
要求：
1）输入1000个数字，奖品全部抽完；
2）单词从｛a,b,c,d,e,f….,z｝中随机产生，每个奖品名称包含10个字母，奖品名称不重复。
*/

package com.test11;

import java.util.*;

class RandomData {
    Random random = new Random(System.currentTimeMillis());

    // 随机生成由[a-z]构成的长为length的字符串
    StringBuffer createRandomStr(int length) {
        StringBuffer sb = new StringBuffer();
        int randomNum;
        for (int i = 0; i < length; i++) {
            randomNum = random.nextInt(26) + 97;// [97,123)
            sb.append((char) randomNum);
        }
        return sb;
    }

    // 随机生成[0,max]的整数
    Integer createRandomNum(int max) {
        return random.nextInt(max + 1);// [0,max]
    }
}

public class Test_11_4 {
    public static void main(String[] args) {
        RandomData rs = new RandomData();
        Scanner sc = new Scanner(System.in);
        int giftNum = 999;// 礼物编号[0,max],max为奇数，总礼物数为 max+1
        int inNum;// 输入的正整数
        int randomGiftNum;// 随机生成的礼物编号

        HashMap<StringBuffer, Integer> giftDir = new HashMap<>();
        for (int i = 0; i <= giftNum / 2; i++) {
            giftDir.put(rs.createRandomStr(10), 2);
        }

        ArrayList<Map.Entry<StringBuffer, Integer>> giftList= new ArrayList<>(giftDir.entrySet());
        System.out.println("请随机输入一个正整数进行抽奖，输入-1查看剩余奖品数：");
        while (true) {
            //TODO 判断数据是否合法
            try{
                inNum = Integer.valueOf(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("输入数据不合理，请重新输入！");
                continue;
            }
            if (inNum == 0) {
                break;
            }
            if (inNum < -1) {
                System.out.println("请正确输入！");
                continue;
            }
            if (inNum == -1) {
                System.out.println("奖品剩余数：" + (giftNum + 1));
            }
            else {
                randomGiftNum = rs.createRandomNum(giftNum--) / 2;// 随机选择gift的编号
                Map.Entry<StringBuffer, Integer> giftSet = giftList.get(randomGiftNum);
                System.out.println("恭喜你抽中了奖品：" + giftSet.getKey());
                giftSet.setValue(giftSet.getValue() - 1);
                if (giftSet.getValue() == 0) {// 若礼物被取完，则从giftList中删去该礼物
                    giftList.remove(randomGiftNum);
                }
                if (giftNum == -1) {
                    break;
                }
            }
        }
        if (inNum != 0) {
            System.out.println("奖品已经抽完啦~");
        }
        else {
            System.out.println("已退出抽奖程序");// 输入0的时候
        }
    }
}
