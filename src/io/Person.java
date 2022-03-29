package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类实例测试对象的序列化操作
 */
public class Person implements Serializable {
    /*
    * 实现了序列化接口后, 最好主动定义一个序列化版本号的常量,
    *   (版本号标识了类是否改变过,不同序列号的类不能反序列化)
    * 这样一来对象序列化时, 就不会根据类的结构生成另外的版本号, 而是使用该固定值.
    * 那么反序列化时,只要还原的对象和当前类的版本号一致, 就可进行还原
    * */
    public static final long serialVersionUID=1L;

    private String name;
    private int age;
    private String gender;
    /*
    * transien关键字
    * -- 如果序列化对象时要忽略某个不必要的属性,
    *   那么就用transient关键字修饰, 达到对象瘦身的目的, 减小开销
    * */
    private transient String[] otherInfo;  //其他信息


    public Person() {
    }

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}
