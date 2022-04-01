package thread;


public class PriorityDemo {
    public static void main(String[] args) {
        Thread min =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Min");
                }
            }
        };
        Thread max =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("max");
                }
            }
        };
        Thread normol =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("normol");
                }
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        max.start();
        normol.start();
    }
}
