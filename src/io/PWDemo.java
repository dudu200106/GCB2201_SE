package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw=new PrintWriter("pw.txt","UTF-8");
        /*
        * 高级流
        *   1.按行写出字符串(println)
        *   2.自动换行刷新
        * */
        pw.println("1111111");
        pw.println("44423122222");
        System.out.println("写出完毕");

        pw.close();
    }
}
