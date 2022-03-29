package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("test.txt");
        FileOutputStream fos=new FileOutputStream("./test2.txt");

        int d ;
        while ((d= fis.read()) != -1){
            fos.write(d);
        }
        System.out.println("复制完毕");
        fis.close();
        fos.close();
    }
}
