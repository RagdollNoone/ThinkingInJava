package ConcurrencyInPratice;

import java.util.concurrent.atomic.AtomicLong;

public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong(0);

    public CountingFactorizer() {}

    public Long getNext() {
        return count.incrementAndGet();
    }

    public static void main(String[]  args) {
        CountingFactorizer instance = new CountingFactorizer();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread thd = Thread.currentThread();
                        System.out.println(thd.getName() + " count : " + instance.getNext());
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("CountingFactorizer error 0");
                    }
                }
            }
        };

        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");

        t1.start();
        t2.start();
    }

}
