package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseableDemo {
    public static void main(String[] args) {

        try ( //1.7之后的特性,关闭流的简略写法

              /*
              *  只要实现了java.io.AutoClosable接口的类才可以在这里定义并初始化
              *  编译器在编译代码时, 最终会将这里定义的类在finally中调用close()关闭
              * 注意: 最终编译完还是跟标准写法一致(参考FinallyDemo2.java中的样子)
              * */
            FileOutputStream fos = new FileOutputStream("fos.dat");
            ){
                fos.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
