package thread;

/**
 * 互斥锁
 * 当使用多个synchronize锁定多个代码片段, 并且指定对象相同时, 这些代码片段也是互斥的
 * 互斥的---即:多个线程不能同时执行它们。
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Foo foo1=new Foo();
        Foo foo2=new Foo();

        Thread t1 = new Thread(){
            public void run(){
                foo1.methodB();//从桌子上取一个豆子
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                foo2.methodB();//从桌子上取一个豆子
            }
        };

        t1.start();
        t2.start();
    }

}

class Foo{
    public synchronized void methodA(){
        try {
            Thread t=Thread.currentThread();
            System.out.println(t.getName() + "执行方法A");
            Thread.sleep(5000);
            System.out.println(t.getName() + "A执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB(){
        synchronized (this){
            try {
                Thread t=Thread.currentThread();
                System.out.println(t.getName() + "执行方法B");
                Thread.sleep(5000);
                System.out.println(t.getName() + "B执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
