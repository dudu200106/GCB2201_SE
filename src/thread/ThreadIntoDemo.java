package thread;

/**
 * 线程提供了一套获取相关信息的方法
 */
public class ThreadIntoDemo {
    public static void main(String[] args) {
        Thread main= Thread.currentThread(); //获得当前线程
        String name =main.getName(); //获取线程名字
        System.out.println("name: "+name);

        long id =main.getId(); //获得线程唯一标识
        System.out.println("id: " + id);

        //priority:优先级
        int priority = main.getPriority();
        System.out.println("priority: " +priority);

        //当前线程是否被中断
        boolean isInterrupted =main.isInterrupted();
        System.out.println("is Interrupted?: " +isInterrupted);
        //是否为守护线程
        boolean isDaemon =main.isDaemon();
        System.out.println("is Daemon?: " +isDaemon);
        //是否活着
        boolean isAlive =main.isAlive();
        System.out.println("is alive?: " +isAlive);
    }
}
