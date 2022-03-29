package io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java.io.FileInputStream和FileOutputStream是所有字节输入流和输出流的超类, 抽象类
 * InputStream定义了读取字节的相关方法,OutputStream定义了写出字节的相关方法
 * 实际开发中我们可以创建不同种类的输入和输出流来连接对应的设备进行读写操作.
 *
 * 文件流
 * Java.io.FileInputStream和FileOutputStream,
 * 他们继承自InputStream和OutputStream, 是实际用于读写文件的流
 *
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //向文件fos.dat中写入一个字节
        /*
            常用构造方法:
            FileOutputStream(File file);
            FileOutputStream(String path);
            创建输出流的时候若是文件不存在, 则会新建文件;
            若文件存在,则会清空该文件
        */
        FileOutputStream fos=new FileOutputStream("./fos.dat");

        /*
            将2的int值二进制低八位写出来(字节流每次只读写一个字节)
        */
        fos.write(-1); //输出255--低八位
        fos.write(256); //输出0--低八位
        fos.write(2);

        System.out.println("写出完毕");
        fos.close(); //不关闭流在不关闭的服务器中会存在危害
    }
}
