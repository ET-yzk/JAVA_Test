package com.mytest;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyTest_Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class blankPage = Class.forName("com.mytest.BlankPage");
        Method[] methods = blankPage.getDeclaredMethods();
        //遍历方法
        for (Method method: methods) {
            //获取修饰符
            System.out.println(Modifier.toString(method.getModifiers()));
            //获取方法返回值
            System.out.println(method.getReturnType().getSimpleName());
            //获取方法名
            System.out.println(method.getName());
            //获取方法参数
            Class[] parameterType = method.getParameterTypes();
            for (Class pType: parameterType) {

            }
        }

    }
}
