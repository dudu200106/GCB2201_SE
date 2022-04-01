package thread;


public class SyncDemo1 {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                    int bean = table.getBeans();//从桌子上取一个豆子
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    int bean = table.getBeans();//从桌子上取一个豆子
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };

        t1.start();
        t2.start();


    }
}

class Table{
    private int beans=20; //二十个豆子

    public synchronized int getBeans() {
        if (beans==0)
            throw new RuntimeException("没有豆子了");
        Thread.yield(); //自动放弃本次时间片, 模拟执行到这里CPU没时间了
        return beans--;
    }
}
