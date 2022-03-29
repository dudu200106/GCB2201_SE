package io;

import java.io.*;

/**
 *  java将流分为两类:节点流和处理流
 *  节点流: 又称低级流, 是实际连接我们程序与另一端的"管道", 负责实际读写数据
 *      记住: 读写一定是建立在低级流的基础上进行的!
 *  处理流: 又称高级流, 过滤流.不能独立存在, 必须连接在其他流上,
 *          目的是当数据流经它的时候, 对数据进行某种加工处理, 简化我们相应的操作
 *
 *  在实际的开发中, 我们总是串联一组高级流到低级流上, 完成一个复杂的数据读写操作,
 *  这个过程也称为流的连接, 这是IO的精髓
 *
 *  缓冲流:
 *  Java.io.BufferedInput和BufferedOutputStream
 *  缓冲流在流连接中的作用是--加快读写效率
 *  缓冲流的本质形式也是块读写
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis=new FileInputStream("test.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream("./test2.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);

        int d ;
        while ((d= bis.read()) != -1){
            bos.write(d);
        }
        System.out.println("复制完毕");
        fis.close();
        fos.close();

    }
}
