package ThreadBook;

public class ThreadDemo1 {
    public static void main(String... args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();
                while(true) {
                    System.out.printf("%s is %s alive and in %s state\n",
                            thd.getName(),
                            (thd.isAlive() ? "" : "not "),
                            thd.getState());
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.setDaemon(true);

        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
