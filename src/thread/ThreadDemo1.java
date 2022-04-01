package thread;

/**
 * 多线程
 * 线程是一个程序的单一顺序执行流程。多个单一流程一起运行就是多线程。
 * 多线程是并发执行的。
 *
 * 创建线程有两种方式
 *  第一种: 继承Thread并重写run方法, 直接创建线程任务
 *      优点:创建方式的优点:结构简单，利于匿名内部类创建
 *      缺点:1.Java继承是单继承, 该自定义线程类只能继承Thread
 *          2.不灵活,一个线程类只能做一件事
 *  第二种: 创建线程任务重写run方法,再通过线程任务创建线程
 */
public class ThreadDemo1{

    public static void main(String[] args) {
        MyThread1 mt1=new MyThread1();
        MyThread2 mt2=new MyThread2();
        //调用start()之后, 线程就被扔进线程调度器了,
        // 由调度器分配时间片执行线程,不用等该线程执行完成出栈,直接下一条语句
        mt1.start();
        mt2.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Who are you");
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Tommy!");
        }
    }
}
