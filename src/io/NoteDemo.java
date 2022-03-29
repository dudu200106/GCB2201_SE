package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NoteDemo {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        FileOutputStream fos=new FileOutputStream("./note.txt");

        while (true){
            System.out.println("请输入:");
            String line=in.nextLine();
            //最好写成:字面量.equals(line) -->line可能为null, 而null无法调用方法,会空指针异常
            if ("exit".equals(line))
                break;
            byte[] data=line.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
        }
        System.out.println("结束");
    }
}
