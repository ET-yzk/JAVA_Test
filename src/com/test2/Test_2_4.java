package com.test2;

abstract class Product {
    String name;    //商品名
    String data;    //日期
    String sale;    //销售价
    double price;   //标价

    //打印商品销售时间
    public abstract void sell();
    //打印商品信息
    public abstract void output();

    //定义构造方法
    public Product(String data, String sale, String name, double price) {
        this.data = data;
        this.name = name;
        this.price = price;
        this.sale = sale;
    }
}

class Pad extends Product {
    @Override
    public void sell() {
        System.out.printf("销售的日期和时间：%s ", data);
    }

    @Override
    public void output() {
        System.out.printf("%s，%.0f元 ", name, price);
        sell();
        System.out.printf("sales:%s￥", sale);
    }

    //定义构造方法
    public Pad(String data, String sale, String name, double price) {
        super(data, sale, name, price);
    }
}

class Mobile extends Product {
    @Override
    public void sell() {
        System.out.printf("销售的日期和时间：%s ", data);
    }

    @Override
    public void output() {
        System.out.printf("%s，%.0f元 ", name, price);
        sell();
        System.out.printf("sales:%s￥", sale);
    }

    //定义构造方法
    public Mobile(String data, String sale, String name, double price) {
        super(data, sale, name, price);
    }
}

public class Test_2_4 {
    public static void main(String[] args) {
        Mobile mobile1 = new Mobile("2019-09-14 22:03:41.054", "106800", "iphone 11 pro max", 107780);
        Mobile mobile2 = new Mobile("2019-09-14 22:03:41.054", "6000", "huawei p30", 5450);
        Mobile mobile3 = new Mobile("2019-09-14 22:03:41.054", "9500", "iphone pro", 9500);
        Pad pad1 = new Pad("2019-09-14 22:03:41.054", "7980", "huawei pad", 6999);
        Pad pad2 = new Pad("2019-09-14 22:03:41.054", "1400", "xiaomi pad", 1380);
        Product [] products = {mobile1, mobile2, pad1, pad2, mobile3};
        for (Product i: products)
        {
            i.output();
            System.out.println();
        }
    }
}
