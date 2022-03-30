package exception;

/**
 * 使用throw关键字主动抛出一个异常
 * 通常:
 * 1.程序出现异常时,若是不应当在当前代码中解决时,就可以主动抛出去
 * 2.程序可以运行, 但是不满足业务场景时, 可以当做异常抛出去
 */
public class ThrowDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("程序开始execute");

        Person p=new Person(0);
        //满足语法但不满足业务场景--人不可能怎么大
        try {
            /*
            * 当我们调用一个含有throws声明抛出异常的方法时,编译器要求必须处理这个异常,
            * 不然编译不通过
            *
            * 处理方式:两种
            * 1.使用try...catch主动捕获并处理这个异常
            * 2.使用throws继续讲这个异常声明抛出
            * */
            p.setAge(1003);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        System.out.println(p.getAge());

        System.out.println("程序结束");
    }
}
