package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 提高读写数据量, 就可以减少读写的次数, 提高读写效率
 * 单字节的读写属于随机读写形式,
 *   而一组字节的读写属于块读写形式
 *
 * 大多数的硬件块读写都比随机读写性能好, 尤其是在机械键盘上尤为明显
 *
 * InputStream和OutputStream上定义了块读写数据的相关方法
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("./test.txt");
        FileOutputStream fos=new FileOutputStream("./test3.txt");

        byte[] data=new byte[1024 * 10];
        int len; //每次实际读取到的字节量

        while ((len=fis.read(data)) != -1){
            fos.write(data,0,len); //将0~len-1下标的数组写到文件中
        }
        System.out.println("完毕");
    }
}
