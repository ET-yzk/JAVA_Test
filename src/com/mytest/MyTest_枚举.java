package com.mytest;

// 枚举类对象的属性不应被修改，应用private final修饰

enum ColorEnum {
    BLACK(0, 0, 0) {
        @Override
        String meaning() {
            return "黑色";
        }
    },
    BLUE(0, 0, 255) {
        @Override
        String meaning() {
            return "蓝色";
        }
    },
    GREEN(0, 255, 0) {
        @Override
        String meaning() {
            return "绿色";
        }
    },
    RED(255, 0, 0) {
        @Override
        String meaning() {
            return "红色";
        }
    },
    YELLOW(255, 255, 0) {
        @Override
        String meaning() {
            return "黄色";
        }
    };

    private final int redValue;
    private final int greenValue;
    private final int blueValue;


    ColorEnum(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    int getRedValue() {
        return this.redValue;
    }

    int getGreenValue() {
        return this.greenValue;
    }

    int getBlueValue() {
        return this.blueValue;
    }

    abstract String meaning();
}

public class MyTest_枚举 {
    public static void main(String[] args) {
        ColorEnum RED = ColorEnum.RED;
        System.out.println(RED.getRedValue());
    }
}
