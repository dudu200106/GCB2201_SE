package thread;

/**
 * 守护线程
 * 守护线程是通过普通线程调用方法setDaemon(true)设置而来的。
 * 守护线程和普通线程的区别体现在一个结束时机上的不同:
 * 当进程结束时，进程会强制杀死所有正在运行的守护线程并最终停止。
 *
 * 进程的结束:
 * 当java进程中所有的普通线程都结束时，进程就会结束。
 *
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {

        Thread rose = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("let me go!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("rose: aaaaa啊啊啊啊!!");
                System.out.println("噗通");
            }
        };

        Thread jack = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        System.out.println("Jack: You jump, I jump!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("jack: Noooooooooo!!...");
            }
        };


        rose.start();
        jack.setDaemon(true); //此方法必须调用在该线程运行前
        //main方法也是个普通线程,主线程main执行完方法体内的语句后就直接死了
        jack.start();
        //主线程在线程执行前就死了,体现出线程调度器分配时间片与main无关,
        //          线程的start方法在main中只执行一次就下一句了
        System.out.println("main方法执行完毕");

    }
}