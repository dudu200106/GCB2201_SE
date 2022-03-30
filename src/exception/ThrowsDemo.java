package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 子类重写父类含有throws声明异常抛出的方法时, 对throws的重写规则
 */
public class ThrowsDemo {
    //超类方法抛出的异常
    public  void demo() throws IOException, AWTException{

    }
}

class SubClass extends ThrowsDemo{
//    //允许抛出所有异常
//    public void demo() throws IOException, AWTException{
//    }
//
//    //允许抛出部分异常
//    public void demo() throws IOException{
//    }
//
//    //允许不抛出异常
//    public void demo() throws {
//    }

    //允许抛出超类方法抛出异常的子类型
    public void demo() throws FileNotFoundException { //继承自IOException
    }

//    //不允许抛出超类没有抛出的,没有继承关系的异常
//    public void demo() throws SQLException {
//    }

//    //不允许抛出超类没有抛出异常的父类
//    public void demo() throws Exception {
//    }
}
