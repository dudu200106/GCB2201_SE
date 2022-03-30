package io;

import java.io.*;

public class BRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("./src/io/BRDemo.java");

        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);

        //BufferedReader提供了一个独有的方法readLine, 读取一行字符串:
        //  String readLine()
        //  该方法会将第一次遇到的换行符前所有读到的内容,以字符串的形式返回
        //  返回值null,读到了末尾
        /* 注意: 其实这也是内部操作, 当第一次调用readLine()时,
                缓冲流会将内容读到缓冲区8K个大小的char数组内(总16KB),
                然后扫到换行符时就停止,输出这一行字符串*/

        String str ;
        while((str=br.readLine()) !=null){
            System.out.println(str);

        }
    }
}
