package ThreadBook;

import Common.RandomGenerator;

public class ThreadDemo2 {
    public static void main(String... args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();
                int count = 0;

                while(!thd.isInterrupted()) {
                    count++;
                    System.out.printf("%s : %d\n", thd.getName(), count);
                }

                System.out.println("thd state is " + thd.getState());
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();

        while(true) {
            double n = Math.random();
            if (n >= 0.4999999 && n <= 0.5000001) {
                break;
            }
        }

        t1.interrupt();

        try {
            t1.join();
            t2.start();

            Thread.sleep(20);

            t2.interrupt();
        } catch (InterruptedException e) {

        }

        System.out.println("t1 state is " + t1.getState());
        t1.start();
    }
}
