package thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //1.创建线程任务
        MyRunnable1 m1 =new MyRunnable1();
        MyRunnable2 m2 =new MyRunnable2();

        //2.创建两条线程,分别执行任务
        Thread t1=new Thread(m1);
        Thread t2=new Thread(m2);

        //3.线程启动
        t1.start();
        t2.start();
    }

}

class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Who are you");
        }
    }
}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("FBI!!!");
        }
    }
}
