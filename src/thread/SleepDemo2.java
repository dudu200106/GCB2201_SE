package thread;

/**
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中其interrupt()方法被掉用，那么这时会中断
 * 该睡眠阻塞，并且sleep方法会抛出中断异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println("lin: sleep~");
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    System.out.println("lin: 干嘛呢?干嘛呢!?");
                }
                System.out.println("wake up.");
            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("黄: 80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("黄: 咣当");
                System.out.println("黄: 大哥,搞定!");
                t.interrupt();
            }
        };

        t.start();
        t2.start();
    }
}
