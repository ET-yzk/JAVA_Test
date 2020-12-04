package com.test3;

class Animal {
    void beat() {
        System.out.println("心脏跳动...");
    }

    void breath() {
        System.out.println("呼吸中...");
    }
}

class Bird extends Animal{
    void fly() {
        System.out.println("在天空中自在地飞翔...");
    }
}

class Horse extends Animal{
    void run() {
        System.out.println("在陆地上快速地奔跑...");
    }
}

public class Test3_2 {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Horse horse = new Horse();

        bird.beat();
        bird.breath();
        bird.fly();

        horse.beat();
        horse.breath();
        horse.run();
    }
}
