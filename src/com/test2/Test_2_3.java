package com.test2;

//账户类
class Account {
    private double balance; //余额
    private int amount;     //数量
//    private String name;    //姓名
//    private String passwd;  //密码
//    private String account_number; //账号

    //存钱
    public void deposited(double money) {
        balance += money;
        System.out.printf("账户存入%.1f元\n", money);
    }
    //取钱
    public void withdrawal(double money) {
        if (money <= balance)
        {
            balance -= money;
            show_balance();
        }
        else
        {
            System.out.printf("您的取款金额为%.1f元，但是账户余额仅为%.1f元，操作不合法！\n", money, balance);
        }

    }
    //显示余额
    public void show_balance() {
        System.out.printf("当前账户余额为：%.1f元\n", balance);
    }

    //定义构造方法
    public Account(double money, int amount) {
        this.balance = money;
        this.amount = amount;
//        this.name = name;
//        this.passwd = passwd;
//        this.account_number = account_number;
    }
}

public class Test_2_3 {
    public static void main(String[] args) {
        int amount = 0;
        Account ac = new Account(10000, ++amount);
        ac.deposited(1000);
        ac.withdrawal(12000);
        ac.deposited(50000);
        ac.show_balance();
    }
}
