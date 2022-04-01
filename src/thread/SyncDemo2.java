package thread;

/**
 * 同步块
 * 同步块可以更准确地锁定需要同步执行的代码片段, 有效地缩小需要排队的范围,
 * 可以在保证安全的前提下尽可能的提高并发效率。
 *  语法:
 *  synchronized(同步监视器对象){
 *      需要多个线程同步执行的代码片段
 *  }
 *
 *同步执行:多个线程执行时有先后顺序
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop =new Shop();
        Thread t1 = new Thread(){
            public void run(){
                shop.buy();//从桌子上取一个豆子

            }
        };
        Thread t2 = new Thread(){
            public void run(){
                shop.buy();//从桌子上取一个豆子
            }
        };

        t1.start();
        t2.start();
    }
}

class Shop{
    public void buy(){
        try {
            Thread t =Thread.currentThread();
            System.out.println(t.getName() + " 正在挑选...");
            Thread.sleep(5000);

            synchronized (this) { //括号里指定了需要线程保护的引用变量的实例对象
                System.out.println(t.getName() + " 正在试衣服...");
                Thread.sleep(5000);
            }

            System.out.println(t.getName() + "结账离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
