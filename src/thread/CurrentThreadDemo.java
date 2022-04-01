package thread;

/**
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中其interrupt()方法被掉用，那么这时会中断
 * 该睡眠阻塞，并且sleep方法会抛出中断异常
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main =Thread.currentThread();
        System.out.println("主线程: " +main);
        dosome();
    }

    public static void dosome(){

        Thread t=Thread.currentThread();
        System.out.println("执行dosome方法的线程是: "+ t);
    }
}
