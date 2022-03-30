package exception;

public class TryCatchDemo {

    public static void main(String[] args) {
        System.out.println("程序开始");

       /* try {
            String line = null;
            System.out.println(line.length());

        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("空指针");
        }*/
            /*
                1.捕获到一个异常后就直接跳过后边的所有catch语句
                2.捕捉块try语句块里面捕获到第一个异常,就直接跳过后边的语句,不再执行try语句块的其他代码, 直接catch
                3.捕获多个异常,也 可以通过了一个类似或运算的特殊方法写在一起
            */

        try{
            String[] str= {"11"};
            System.out.println(str[1]);

            int a=1/0;

        }catch (ArithmeticException | IndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("越界和方法运算");
        }catch (Exception e){
            System.out.println("通用错误的处理操作");
        }

    }
}
