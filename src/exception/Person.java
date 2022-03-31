package exception;

public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }


    public void setAge(int age) throws Exception {
        if (age>100||age<0)
//            throw new RuntimeException("n年龄不合法");
            /*
            * 当我们使用throw主动对外抛出一个异常时,除了RunningTimeException之外,
            * 其他异常抛出时必须在方法上使用throws声明该异常的抛出
            * */
            throw new IllegalAgeException("年龄不合法");
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
