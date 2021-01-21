package com.mytest;

class XZT {
    void t4() {
        // byte,short,char之间不可互相转换，一旦进行运算，默认提升一个int类变量相加，应改为b=(byte)(b1+b2)
        byte b1 = 3, b2 = 4, b;
//        b = b1 + b2;
        b = (byte) (b1 + b2);
        b = 3 + 4;
        int a = b1 + 1;
    }

    void t5() {
        byte a =127;
        a+=5;
        System.out.println(a);
        //-124
    }

    //t6 Arrays不能派生子类
    //t7 OutputStream不能创建对象-抽象类不能创建对象

    void t8() {
        //length求字符串数组中有多少个字符串，length()求字符串有多少个字符
        String str = "abc";
    }

    //t9 重载 返回值的类型也可以不一样

    void t11() {
        String a = "1";
        for (int i = 2; i < 4; i++) {
            System.out.println(a.hashCode());
            a += i;
        }
        System.out.println(a.hashCode());
        System.out.println(a);
//        System.out.println(a.length());
    }

    //t12 【true小写】【选择语句 judge?true:false】

    void t13() {
//        int[] arr = new int[3]{2,1,3};// X
//        int[] arr = {1,2,3};          // v
//        int[] arr = null; arr[0] = 1;// NullPointerException
    }

    void t19() {
        int a = 3, b = 2;
        System.out.println(3 >> 2 > 0 ? ++b : (a-- & 1));
        // x>>y 相当于 x/2^y
    }

    //t22 private修饰的方法在该类中可以调用
    private void t22(){
        System.out.println("private");
    }

    //t26 构造方法可以重载不可以重写

    //t30 内部类
    int q = 0;
    class t30 {
        void k() {
            int q = 1;
            t22();//内部类可以直接调用外部类private方法
            System.out.println(XZT.this.q);//内部类调用重名外部类变量：XZT.this.q
        }
    }

    void myt1() {
        int b;
        int a = b = 2;
        System.out.println(a *- b);// 这里的-代表单目运算符负号
    }

    void myt2() {
        System.out.println(5 % 3);
        System.out.println(-5 % 3);// 取余，向0取，余数符号余被除数一致
    }
}

abstract class t25 {
    void aa() {}

//    abstract static void aVoid();
//abstract和final、static、private不能共存
//abstract方法需要写在abstract类中

    abstract void bb();
    t25() {}
}

//TODO main
public class Exam {
    static int q = 1;
    int qq = 0;
    public static void main(String[] args) {
        XZT xzt = new XZT();
//        new Zi("");//调用子类无参构造方法进行初始化，会优先调用直接父类(即调用最亲的一个)的无参构造方法，且父类中需要无参构造器
        Fu zi = new Zi();// 多态
        ((Zi) zi).fu("");// 不能用zi.fu()因为多态方式在编译时看左边的定义类，运行时才优先右侧类查找
        zi.fu();
        ((Zi) zi).zi();
        zi.fu2();

//        //t31
//        System.out.println(q);
//        System.out.println(new Exam().qq);// static修饰的方法要通过new一个实例类来访问
//        System.out.println((int)'0');

        xzt.t11();
    }
}

//父类中的私有成员可以被继承，不能被访问
//java.lang.*默认导入的包
//接口interface  {常量、静态方法}不需要特意写出，会默认带上static和abstract
//面向对象三大特征：封装、多态、继承、（抽象）
// 'A'=65 'a'=97 '0'=48
//String、StringBuffer、StringBuild
//this代表当前对象，super代表父对象
//int的包装；Integer
//Throwable有2个子类：Error和Exception
//Java为了类的对象支持序列化，该类需要实现  Serializable接口
//TCP特点：面向连接的传输协议
//static final修饰的常量必须在初始化时赋初值

class Fu {
    void fu() {
        System.out.println("fu");
    }

    Fu() {
//        this("");
        System.out.println("fu无参构造方法");
    }

    void fu2() {
        System.out.println("fu特有方法");
    }

    Fu(String str) {
        System.out.println("fu有参构造方法");
    }
}

class Zi extends Fu {
    @Override
    void fu() {
        System.out.println("zi重写");
    }

    void fu(String str) {
        super.fu();
        System.out.println("zi重载");
    }

    void zi() {
        System.out.println("zi特有方法");
    }

    Zi() {
//        this("");
        System.out.println("zi无参构造方法");
    }

    Zi(String str) {
        this();
        System.out.println("zi有参构造方法");
    }
    //调用子类无参构造方法进行初始化，会优先调用直接父类的无参构造方法，且父类中需要无参构造器
}