package com.mytest;

import java.io.*;

public class MyTest_DataOutputStreamDemo {
    public static void main(String[] args) {
        try {
            dataWrite();
            dataRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void dataWrite() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/com/mytest/DataOutputStreamDemo"));
        //写数据
        byte b = 100;
        short s = 200;
        int i = 300;
        long j = 400;
        float k = 500;
        boolean l = true;
        char c = '6';

        //按顺序写入文件
        dataOutputStream.writeByte(b);
        dataOutputStream.writeShort(s);
        dataOutputStream.writeInt(i);
        dataOutputStream.writeLong(j);
        dataOutputStream.writeFloat(k);
        dataOutputStream.writeBoolean(l);
        dataOutputStream.writeChar(c);


        dataOutputStream.flush();
        dataOutputStream.close();
    }

    static void dataRead() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/com/mytest/DataOutputStreamDemo"));
        //TODO 读数据，需与写入时顺序一致才能正确读取，存在一定安全性
        byte b = dataInputStream.readByte();
        short s = dataInputStream.readShort();
        int i = dataInputStream.readInt();
        long j = dataInputStream.readLong();
        float k = dataInputStream.readFloat();
        boolean l = dataInputStream.readBoolean();
        char c = dataInputStream.readChar();

        System.out.println("b="+b);
        System.out.println("s="+s);
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
        System.out.println("l="+l);
        System.out.println("c=" + c);
    }
}
