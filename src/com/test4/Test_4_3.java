package com.test4;

import java.util.*;

class MyChoose {

    void chooseRedBall(ArrayList<Integer> redBall) {
        Random r = new Random();
        for (int i = 0; i < 6; i++){
            redBall.add(r.nextInt(33) + 1);//[1,33]
        }
        Collections.sort(redBall);
    }

    int chooseBlueBall() {
        Random r = new Random();
        return r.nextInt(16) + 1;
    }
}

public class Test_4_3 {
    public static void main(String[] args) {
        MyChoose myChoose = new MyChoose();
        ArrayList<Integer> redBall = new ArrayList<>();
        int blueBall;

        System.out.println("请输入机选注数：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++){
            myChoose.chooseRedBall(redBall);
            blueBall = myChoose.chooseBlueBall();
            System.out.print("红球:");
            for (int j: redBall){
                System.out.printf(" %02d",j);
            }
            System.out.printf(" 蓝球：%02d\n", blueBall);
            redBall.clear();
        }
    }
}


//class doubleColorBall{
//    void ChooseBall(){
//        //==============================准备变量==============================
//        int[] userRedBall = new int[6]; //用户红球
//        int[] sysRedBall = new int[6]; //系统红球
//        int sysBlueBall = 0; //系统蓝球
//        int userBlueBall = 0; //用户蓝球
//        int redCount = 0; //红球中奖数记录
//        int blueCount = 0; //蓝球中奖记录
//        int[] redBall = new int[33]; //红球总数
//        for(int i=0;i<redBall.length;i++){
//            redBall[i] = i+1;
//        }
//        //游戏开始，系统提示是机选还是手选
//        System.out.println("双色球游戏开始，good luck！");
//        System.out.println("请选择是机选还是手选：1、机选，2手选");
//        Scanner input = new Scanner(System.in);
//        Random r = new Random();//随机生成随机数
//
//        boolean flag =true;//判断是否需要重新输入
//        while(flag){
//            int isAuto = input.nextInt();
//
//            switch(isAuto){
//                case 1:{
//                    computerSelection(redBall,userRedBall);//用户机选红球
//                    userBlueBall = r.nextInt(16)+1;//用户机选蓝球
//                    flag = false;
//                    break;
//                }
//                case 2:{
//                    System.out.println("请选择6个红球号码,1-33");
//                    for(int i=0;i<userRedBall.length;i++){
//                        userRedBall[i] = input.nextInt();
//                    }
//                    System.out.println("请选择1个蓝球号码，1-16");
//                    userBlueBall = input.nextInt();
//                    flag = false;
//                    break;
//                }
//                default:{
//                    System.out.println("error input!");
//                    System.out.println("请选择是机选还是手选：1、机选，2手选");
//                    break;
//                }
//            }
//        }
//        //=========================生成系统的号码====================
//        computerSelection(redBall,sysRedBall);//系统机选红球
//        sysBlueBall = r.nextInt(16)+1;//系统机选蓝球
//        //=========================统计结果=========================
//        //统计用户红球与系统红球相等结果
//        for(int i=0; i<userRedBall.length;i++){
//            for(int j=0; j<sysRedBall.length-redCount;j++){
//                if(userRedBall[i]==sysRedBall[j]){
//                    int temp = sysRedBall[j];//相同的球后面则不再比较，减少比较次数
//                    sysRedBall[j] = sysRedBall[sysRedBall.length-1-redCount];
//                    sysRedBall[sysRedBall.length-1-redCount] = temp;
//                    redCount++;
//                    break;
//                }
//            }
//        }
//        if(userBlueBall==sysBlueBall){
//            blueCount = 1;
//        }
//        //=========================验证是否中奖=========================
//        //概率大的放前面，提升代码执行效率
//        if(redCount<4 && blueCount==0){
//            System.out.println("你离中奖只差一步，请继续努力");
//        }else if(redCount<=2 && blueCount==1){
//            System.out.println("恭喜你中了六等奖，5元");
//        }else if((redCount==3 && blueCount==1)||(redCount==4 && blueCount==0)){
//            System.out.println("恭喜你中了五等奖，10元");
//        }else if((redCount==4 && blueCount==1)||(redCount==5 && blueCount==0)){
//            System.out.println("恭喜你中了四等奖，200元");
//        }else if(redCount==5 && blueCount==1){
//            System.out.println("恭喜你中了三等奖，3000元");
//        }else if(redCount==6 && blueCount==0){
//            System.out.println("恭喜你中了二等奖，15万元");
//        }else if(redCount==6 && blueCount==1){
//            System.out.println("恭喜你中了一等奖，500万元");
//        }
//        //=========================公布系统号码=========================
//        System.out.println("本期中奖红球号码为");
//        Arrays.sort(sysRedBall);//工具类实现号码排序
//        System.out.println(Arrays.toString(sysRedBall));//工具类实现数组输出
//        System.out.println("本期中奖蓝球号码为\n"+sysBlueBall);
//        //公布用户号码
//        System.out.println("你的红球号码为");
//        Arrays.sort(userRedBall);
//        System.out.println(Arrays.toString(userRedBall));
//        System.out.println("你的蓝球号码为\n"+userBlueBall);
//    }
//
//    //用于在一组数列中，随机生成不重复数算法（自动选红球）
//    private static void computerSelection(int[] redBall,int[] userRedBall){
//        Random r = new Random();
//        int index = -1;
//        for(int i=0;i<userRedBall.length;i++){
//            index = r.nextInt(redBall.length-i);
//            userRedBall[i] = redBall[index];
//            int temp = redBall[index];
//            redBall[index] = redBall[redBall.length-i-1];
//            redBall[redBall.length-i-1] = temp;
//        }
//    }
//}
