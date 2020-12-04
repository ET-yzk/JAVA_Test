package com.mytest;

//泛型普通类示例
class DemoGenericClass<E> {
    private E name;

    E getName() {
        return name;
    }
    void setName(E name) {
        this.name = name;
    }
}

//泛型接口类
interface DemoGenericInterface<I> {
    void method(I i);
}

class DemoGenericImpl1<I> implements DemoGenericInterface<String> {
    @Override
    public void method(String i) {//**
        System.out.println(i);
    }
}

class DemoGenericImpl2<I> implements DemoGenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}

public class MyTest_泛型 {
    public static void main(String[] args) {
        //不写泛型，默认位Object类型
        DemoGenericClass gc = new DemoGenericClass();
        gc.setName("Object");

        Object name = gc.getName();//gc.getName.var快捷键

        DemoGenericClass<String> gc2 = new DemoGenericClass<>();
        gc2.setName("String");

        String name1 = gc2.getName();

        DemoGenericClass<Integer> gc3= new DemoGenericClass<>();
        gc3.setName(123);

        Integer name2 = gc3.getName();

        System.out.println(name);
        System.out.println(name1);
        System.out.println(name2);
        ////////////////////////////////////
        //泛型接口类
        DemoGenericImpl1 cg1 = new DemoGenericImpl1();
        DemoGenericImpl2 cg2 = new DemoGenericImpl2();

        cg1.method("hello");
        cg2.method(123);
        cg2.method("hello");
    }
}
