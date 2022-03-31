package thread;

/**
 * 使用匿名内部类的创建方式完成线程的两种创建形式。
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1=new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Who are you");
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("FBI!!!");
                }
            }
        };
        Thread t2=new Thread(r2);

        t1.start();
        t2.start();
    }
}
