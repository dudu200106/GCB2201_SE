package thread;

/**
 * 静态方法上如果使用synchronized，那么该方法一定是同步的。
 *
 * 静态方法上指定的锁对象为当前类的类对象，即Class类的实例。
 * 在JVM中每个被加载的类都有且只有一个Class的实例与之对应，它称为一个类的类对象。
 *
 */
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
   * 静态方法使用synchronized锁定的是类的类对象,即Class类的实例
   *  JVM中的每个被加载的类,都有一个Class类的实例对象与之对应--Boo.class
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