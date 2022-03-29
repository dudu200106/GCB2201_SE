package io;

import java.io.*;

public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos=new FileOutputStream("pw.txt");
        //OutputStream -->Writer
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        PrintWriter pw=new PrintWriter(bw); //这两种构造方法
        //这两种构造方法,fos默认经过了以上个三步骤:
        //this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))
        PrintWriter pw1=new PrintWriter(fos);
    }
}
