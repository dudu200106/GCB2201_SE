package thread;

/**
 * sleep阻塞
 * 线程提供了一个静态方法sleep，可以使运行该方法的线程阻塞指定毫秒。超时后线程会自动回到
 * RUNNABLE状态继续并发运行
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        System.out.println("倒计时五秒");
        /*倒计时五秒*/
        try {
            //Thread.sleep(5000);
            int time=5;
            while(time>0) {
                System.out.println(time--);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
