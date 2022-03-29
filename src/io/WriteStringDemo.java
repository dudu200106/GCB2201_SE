package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        //数据输出流
        //FileOutputStream fos =new FileOutputStream("fos.txt");
        // 追加模式, 括号里的参数append为true, 不用删除已有文件的数据, 而是追加在后边
        FileOutputStream fos =new FileOutputStream("fos.txt",true);

        String line= "super idol的笑容都没你的甜, 八月正午的阳光都没你耀眼.";
        byte[] data=line.getBytes(StandardCharsets.UTF_8); //获得一个指定编码格式的字节数组

        fos.write(data);
        System.out.println("输出完毕");
        fos.close();
    }
}
