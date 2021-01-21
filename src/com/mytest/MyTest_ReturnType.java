package com.mytest;

class Type {
    double method(byte x, double y) {
        return (short)x/y*2;
    }

    void GetSort(float x) {
        System.out.println(x);
    }

    void GetSort(int x) {
        System.out.println(x);
    }

    double GetSort(int x, int y) {
        return y + x;
    }

    double GetSort(double x, double y) {
        return x + y;
    }
}

public class MyTest_ReturnType {
    public static void main(String[] args) {
       Type type = new Type();
       type.method((byte) 3,4);

       type.GetSort(2);

       type.GetSort(1.2f);

       type.GetSort(1.2,3.2);
    }

}
