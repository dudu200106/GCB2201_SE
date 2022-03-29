package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FisDemo {
    public static void main(String[] args) throws IOException {
        //将fos.dat的文件读回来
        FileInputStream fis=new FileInputStream("./fos.dat");
        /*
        * int read()
        * 读取一个字节,int类型返回二进制低八位
        * */
        int a=fis.read();
        System.out.println(a);
        int b=fis.read();
        System.out.println(b);
        //读完输出-1
        int c=fis.read();
        System.out.println(c);
    }
}
