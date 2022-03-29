package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 字符流
 * 按照读写单位分为字节流和字符流
 *      字节流超类: Java.io. InputStream和 Java.io.OutputStream
 *      字符流超类: Java.io.Reader和 Java.io.Writer
 *      二者是平行关系
 *
 * 转换流
 * Java.io.InputStreamReader和 Java.io.OutputStreamWriter
 * 高级流,不能独立使用, 在流连接中使用
 *      --衔接其他字符流和下面的字节流,将写出的字符转换为字节
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入文本数据
        FileOutputStream fos=new FileOutputStream("osw.txt");
        //转换流时, 可以通过在第二个参数指定编码方式/字符集
        OutputStreamWriter osw=new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        String line="摩擦摩擦摩擦摩擦,打出溜滑";
        //字符流不用手动转化成字节数组,直接写入
        osw.write(line);
        System.out.println("写出完毕");
        osw.close();
    }
}
