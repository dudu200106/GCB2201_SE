package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("osw.txt");
        InputStreamReader isr=new InputStreamReader(fis);

        /*
        * 字符流的 read(): int
        * 读取一个字符, 将对应的char值存入返回的int值的"低16位上"
        * 00000000 00000000 11110000 01001100
        * 如果返回int值为-1, 则标识读取到了末尾
        * */
        int d;
        while((d=isr.read()) != -1){
            System.out.print((char)d);
        }
        isr.close();
    }
}
