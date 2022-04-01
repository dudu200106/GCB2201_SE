package thread;

public class SyncDemo3 {
    public static void main(String[] args) {
        Boo b1=new Boo();
        Boo b2=new Boo();
        Thread t1 = new Thread(){
            public void run(){
                b1.dosome();//从桌子上取一个豆子

            }
        };
        Thread t2 = new Thread(){
            public void run(){
                b2.dosome();//从桌子上取一个豆子
            }
        };

        t1.start();
        t2.start();
    }
}

class Boo{
   /*
   * 静态方法使用synchronized锁定的是类的类对象, 每个类都只有一个class类对象--Boo.class
   * */
//    public synchronized static void dosome(){
    public static void dosome(){
        synchronized (Boo.class) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + " 正在执行dosome方法");

                Thread.sleep(5000);
                System.out.println(t.getName() + " 执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}