package com.mytest;

class  Auto {
    float vm = 8;
    private int num = 4;
    private String color = "red";
    private float kg = 1800;

    void addVm() {
        vm++;
        System.out.println(vm);
    }

    void delVm() {
        vm--;
        System.out.println(vm);
    }


}
class Car extends  Auto {
    float kt = 28;
    int CD = 100;

    @Override
    void addVm() {
        vm++;
        System.out.println(vm);
    }

    @Override
    void delVm() {
        vm--;
        System.out.println(vm);
    }

}

class TestCar {

    public static void main(String[] args) {
        // write your code here

        Auto myCar = new Car();
        int i;
        for (i = 0; i < 3; i++) {
            myCar.addVm();
        }
        System.out.println(myCar.vm);
    }

}
