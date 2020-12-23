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

/*
    1:把泛型定义在类上
    2:类型变量定义在类上,方法中也可以使用
 */
class ObjectTool<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    void run() {
        //创建对象并指定元素类型
        ObjectTool<String> tool = new ObjectTool<>();

        tool.setObj(new String("123"));
        String s = tool.getObj();
        System.out.println(s);


        //创建对象并指定元素类型
        ObjectTool<Integer> objectTool = new ObjectTool<>();
        /*
          如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
         */
        objectTool.setObj(10);
        int i = objectTool.getObj();
        System.out.println(i);
    }
}

public class MyTest_泛型 {
    public static void main(String[] args) {
//        //不写泛型，默认位Object类型
//        DemoGenericClass gc = new DemoGenericClass();
//        gc.setName("Object");
//
//        Object name = gc.getName();//gc.getName.var快捷键
//
//        DemoGenericClass<String> gc2 = new DemoGenericClass<>();
//        gc2.setName("String");
//
//        String name1 = gc2.getName();
//
//        DemoGenericClass<Integer> gc3= new DemoGenericClass<>();
//        gc3.setName(123);
//
//        Integer name2 = gc3.getName();
//
//        System.out.println(name);
//        System.out.println(name1);
//        System.out.println(name2);
//        ////////////////////////////////////
//        //泛型接口类
//        DemoGenericImpl1 cg1 = new DemoGenericImpl1();
//        DemoGenericImpl2 cg2 = new DemoGenericImpl2();
//
//        cg1.method("hello");
//        cg2.method(123);
//        cg2.method("hello");

        ObjectTool<Object> objectObjectTool = new ObjectTool<>();
        objectObjectTool.run();
    }
}
