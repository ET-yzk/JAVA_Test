package com.test5;

import org.jetbrains.annotations.NotNull;
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private float grade;

    //构造方法
    Student(String name, float grade) {
        super();//!!不能漏
        this.grade = grade;
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setGrade(float grade) {
        this.grade = grade;
    }

    float getGrade() {
        return this.grade;
    }

    //TreeSet自然排序
    @Override
    public int compareTo(@NotNull Student o) {
        return (int)(o.getGrade() - this.getGrade());
    }

    @Override
    public String toString() {
        return name + "--->" + grade;
    }
}

public class Test_5_4 {
    public static void main(String[] args) {
        System.out.println("请输入学生的姓名和成绩，当输入为负数时结束输入");
        Set<Student> student = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        String name;
        float grade;
        int i = 2;

        System.out.println("请输入第1位学生的姓名：");
        name = sc.next();
        System.out.println("请输入第1位学生的成绩：（输入负数，结束录入）");
        grade = sc.nextFloat();
        while (grade >= 0) {

            if (!student.add(new Student(name, grade))) {
                // 因为没有学号，这里默认【成绩】为唯一标识符，
                // 可通过重写Student类的equals()等方法改写规则
                System.out.println("请勿输入同一名学生的成绩！");
                System.out.println("请输入第" + i + "位学生的姓名：");
                name = sc.next();
                System.out.println("请输入第" + i + "位学生的成绩：（输入负数，结束录入）");
                grade = sc.nextFloat();
                continue;
        }
            System.out.println("请输入第" + i + "位学生的姓名：");
            name = sc.next();
            System.out.println("请输入第" + i + "位学生的成绩：（输入负数，结束录入）");
            grade = sc.nextFloat();
            i++;
        }

        if (i == 2) {
            System.out.println("您未录入学生成绩！");
            return;
        }

        System.out.println("您输入的成绩生成成绩单结果：");
        for (Student j: student) {
            System.out.println(j);//.getName() + "--->" + j.getGrade());
        }
        if (student.size() < 3) {//若输入的学生少于3人，成绩单结果很明显，规定直接退出
            return;
        }

        System.out.println("前三名学生的详情为：");
        Iterator<Student> iterator = student.iterator();
        for (int j = 0; j < 3; j ++) {
            System.out.println(iterator.next());
        }
    }
}
