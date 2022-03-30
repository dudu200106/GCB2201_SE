package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲输出流写出数据的缓冲问题:
 *
 * 缓冲流会等待缓冲区的数组满了之后, 再一次性地进行块读写;
 * 而有时候须立即将缓冲区中的字符读写出去, 就要用到flush方法了
 *
 * flush是在OutStream超类上定义的
 */
public class BOS_FlushDemo {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos=new FileOutputStream("bos.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);

        String line="aolige";
        byte[] data=line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);
        System.out.println("Over");
        //强制将缓冲区的数据立即读写出去
        //具体使用flush要根据实际需要,
        // 若是要立刻的实时写出效果就调用, 若要追求效率就不要频繁使用flush
        bos.flush();

        bos.close();
    }
}
