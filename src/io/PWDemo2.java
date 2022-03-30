package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //创建文件流可以指定追加模式
        FileOutputStream fos=new FileOutputStream("pw.txt",true);
        //OutputStream -->Writer
        //创建转换流时指定编码字符集
        OutputStreamWriter osw=new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw=new BufferedWriter(osw);
        PrintWriter pw=new PrintWriter(bw); //这两种构造方法
        //这两种构造方法,fos默认经过了以上个三步骤:
        //this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))
        PrintWriter pw1=new PrintWriter(fos,true); //自动刷新

        Scanner in=new Scanner(System.in);
        while(true){
            String line =in.nextLine();
            if ("exit".equalsIgnoreCase(line)){
                break;
            }
            pw.println(line);
//            pw.flush();
        }

        System.out.println("bybe");
        pw.close();
    }
}
