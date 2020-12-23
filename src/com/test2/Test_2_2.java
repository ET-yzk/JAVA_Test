package com.test2;

abstract class Person {
    private String name;
    private int age;
    private String sex;

    //获取名字
    public String getName() {
        return name;
    }
    //设置名字
    public void setName(String name) {
        this.name = name;
    }

    //获取年龄
    public int getAge() {
        return age;
    }
    //设置年龄
    public void setAge(int age) {
        this.age = age;
    }

    //获取性别
    public String getSex() {
        return sex;
    }
    //设置性别
    public void setSex(String sex) {
        this.sex = sex;
    }

    //输出工作状态
    public abstract void work();

    //统一输出用户信息
    public void getInfo() {
        System.out.println("name："+getName()+" age："+getAge()+" sex："+getSex());
    }

    //定义构造方法
    public Person() {
        System.out.println("执行Person类无参构造方法");
        this.name = null;
        this.age = 0;
//        this.sex = null;
    }
    public Person(String name, int age) {
        System.out.println("执行Person类有参构造方法");
        this.name = name;
        this.age = age;
//        this.sex = sex;
    }
}

class Employee extends Person {
    private int id;

    //获取id
    public int getId() {
        return id;
    }
    //设置id
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void work() {
        System.out.println(super.getName()+"在工作");
    }

    //统一输出用户信息
    @Override
    public void getInfo() {
        System.out.println("name："+getName()+" age："+getAge()+" sex："+getSex()+" id："+getId());
    }

    //定义构造方法
    public Employee() {
        super();
        System.out.println("执行Employee类无参构造方法");
    }
    public Employee(String name, int age, int id) {
        super(name, age);
        System.out.println("执行Employee类有参构造方法");
        this.id = id;
    }

    public final void discuss() {
        System.out.println(super.getName()+"在讨论");
    }
}

class Manager extends Employee {
    private final String vehicle = "奔驰车";

    //获取车型
    public String getVehicle() {
        return vehicle;
    }

    //统一输出用户信息
    @Override
    public void getInfo() {
        System.out.println("name："+getName()+" age："+getAge()+" sex："+getSex()+" id："+getId());
        System.out.println("座驾："+getVehicle());
    }

    //定义构造方法
    public Manager() {
        super();
        System.out.println("执行Manager类无参构造方法");
//        vehicle = null;
    }
    public Manager(String name, int age, int id) {
        super(name, age, id);
        System.out.println("执行Manager类有参构造方法");
//        this.vehicle = vehicle;
    }
}

class Test_2_2 {
    public static void main(String[] args) {
        Manager mgr = new Manager("韩寒",28, 7788);
//        mgr.discuss();
//        mgr.getInfo();
        Employee em = new Employee("王建新",25,5247);
        em.setAge(27);
        em.setSex("男");
        em.work();
        em.discuss();
        em.getInfo();
        mgr.setSex("男");
        mgr.discuss();
        mgr.getInfo();
    }
}
