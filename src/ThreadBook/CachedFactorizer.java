package ThreadBook;

import java.util.Random;

public class CachedFactorizer {
    private long lastNumber;
    private long[] lastFactor;

    private long hits;
    private long cacheHits;

    public CachedFactorizer() {
        lastNumber = 0;
        lastFactor = new long[2];
        hits = 0;
        cacheHits = 0;
    }

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public long[] getLastFactor() {
        return lastFactor;
    }

    public void setLastFactor(long[] lastFactor) {
        this.lastFactor = lastFactor;
    }

    public synchronized long getHits() {
        return hits;
    }

    public void increaseHits() {
        hits++;
    }

    public void increaseCacheHits() {
        cacheHits++;
    }

    public double getCacheHitRatio() {
        return ((double)cacheHits / (double)hits);
    }

    public void doFactorizer() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("CachedFactorizer error 2");
        }
    }

    public static void checkAndModify(CachedFactorizer o, int[] array) {
        synchronized (o) {
            o.increaseHits();
            if (o.getLastNumber() == array[0]) {
                o.increaseCacheHits();
                print(o);
                return;
            }
        }

        o.doFactorizer();
        synchronized (o) {
            o.setLastNumber(array[0]);
            long[] temp = new long[2];
            temp[0] = array[1];
            temp[1] = array[2];
            o.setLastFactor(temp);
        }
    }

    private static void print(CachedFactorizer o) {
        Thread thd = Thread.currentThread();

        System.out.println("Thread name : " + thd.getName() +
                " lastNumber : " + o.getLastNumber() +
                " lastFactor1 : " + o.getLastFactor()[0] +
                " lastFactor2 : " + o.getLastFactor()[1]);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CachedFactorizer instance = new CachedFactorizer();
        Random random = new Random();

        int[] testValue1 = {15, 5, 3};
        int[] testValue2 = {24, 6, 4};

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(instance.getHits() < 50) {
                    try {
                        int value = random.nextInt(100);

                        if (value % 2 == 0) {
                            checkAndModify(instance, testValue1);
                        } else {
                            checkAndModify(instance, testValue2);
                        }
                    } catch (Exception e) {
                        System.out.println("CachedFactorizer error 1");
                        break;
                    }
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("CachedFactorizer error 3");
        }

        long end = System.currentTimeMillis();
        System.out.println("Hit ration : " + instance.getCacheHitRatio() + " cost time : " + (end - start) / 1000);
    }
}
