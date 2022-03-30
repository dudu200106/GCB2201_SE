package exception;

/**
 * finally块跟在try或者是catch后边,有点类似switch里面的default
 * finally保证了try无论是否出现异常, finally最终都必定执行
 *
 * 通常我们将释放资源这类操作放在finally中,确保运行证正确,
 * 例如: IO操作后最终都要调用close()
 */
public class FianllyDemo {
    public static void main(String[] args) {
        System.out.println("start执行");

        try{
            String line = null;
            System.out.println(line.length());
            //空指针, 直接跳过后边的语句
            System.out.println("空指针异常后的语句");
            return;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错,捕捉到异常");
        }finally {
            System.out.println("finally代码执行完毕");
        }

        System.out.println("结束");
    }
}
