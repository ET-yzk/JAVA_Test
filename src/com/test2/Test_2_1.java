package com.test2;

    //定义PCI接口
interface PCI {
        //启动设备
        void bootUp();

        //关闭设备
        void shutDown();
    }

    //定义显卡类，实现PCI接口
class VideoCard implements PCI {
        public void send() {
            System.out.println("播放视频");
        }

        @Override
        public void bootUp() {
            System.out.println("使用显卡");
        }

        @Override
        public void shutDown() {
            System.out.println("关闭显卡");
        }
}

    //定义声卡类，实现PCI接口
class AudioCard implements PCI {
        public void send() {
            System.out.println("播放音频");
        }

        @Override
        public void bootUp() {
            System.out.println("使用声卡");
        }

        @Override
        public void shutDown() {
            System.out.println("关闭声卡");
        }
}
    //定义计算机类
class Computer {

        public void bootUp() {
            System.out.println("电脑开机");
        }

        public void shutDown() {
            System.out.println("电脑关机");
        }

        public void insertPic(PCI devicePic) {
            //通过PCI调用PCI子类
            devicePic.bootUp();

            if (devicePic instanceof VideoCard) {
                ((VideoCard) devicePic).send();
            }
            else if (devicePic instanceof AudioCard) {
                ((AudioCard) devicePic).send();
            }

            devicePic.shutDown();
        }
}

public class Test_2_1 {
    //主函数
    public static void main(String[] args) {
        //调用计算机、声卡、显卡类
        Computer c1 = new Computer();
        PCI v1 = new VideoCard();
        PCI a1 = new AudioCard();
        c1.bootUp();
        c1.insertPic(v1);
        c1.insertPic(a1);
        c1.shutDown();
    }
}
