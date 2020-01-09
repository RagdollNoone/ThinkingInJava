package ThreadBook;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class SynchronizedFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactor = new AtomicReference<>();

    private long hits;
    private long cacheHists;

    public SynchronizedFactorizer() {
        hits = 0;
        cacheHists = 0;
    }

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return ((double)cacheHists / (double)hits);
    }

    public void increaseHits() {
        hits++;
    }

    public void increaseCacheHits() {
        cacheHists++;
    }

    public void setLastNumber(BigInteger integer) {
        lastNumber.set(integer);
    }

    public void setLastFactor(BigInteger integer1, BigInteger integer2) {
        BigInteger[] temp = new BigInteger[2];
        temp[0] = integer1;
        temp[1] = integer2;

        lastFactor.set(temp);
    }

    public AtomicReference<BigInteger> getLastNumber() {
        return lastNumber;
    }

    public AtomicReference<BigInteger[]> getLastFactor() {
        return lastFactor;
    }

    // in fact we need time to get the factorizer result
    public void doFactorizer() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("SynchronizedFactorizer error 2");
        }
    }

    private static synchronized void checkAndModify(SynchronizedFactorizer o, int[] array) {
        o.increaseHits();
        if (null != o.getLastNumber().get() && o.getLastNumber().get().equals(BigInteger.valueOf(array[0]))) {
            o.increaseCacheHits();
            print(o);
        } else {
            o.doFactorizer();
            o.setLastNumber(BigInteger.valueOf(array[0]));
            o.setLastFactor(BigInteger.valueOf(array[1]), BigInteger.valueOf(array[2]));
            print(o);
        }
    }

    private static void print(SynchronizedFactorizer o) {
        Thread thd = Thread.currentThread();

        System.out.println("Thread name : " + thd.getName() +
                " lastNumber : " + o.getLastNumber() +
                " lastFactor1 : " + o.getLastFactor().get()[0] +
                " lastFactor2 : " + o.getLastFactor().get()[1]);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        SynchronizedFactorizer instance = new SynchronizedFactorizer();
        Random random = new Random();

        int[] testValue1 = {15, 5, 3};
        int[] testValue2 = {24, 4, 6};

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (instance.getHits() < 50) {
                    try {
                        int value = random.nextInt(100);

                        if (value % 2 == 0) {
                            checkAndModify(instance, testValue1);
                        } else {
                            checkAndModify(instance, testValue2);
                        }
                    } catch (Exception e) {
                        System.out.println("SynchronizedFactorizer error 1");
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
            System.out.println("SynchronizedFactorizer error 3");
        }

        long end = System.currentTimeMillis();
        System.out.println("Hit ration : " + instance.getCacheHitRatio() + " cost time : " + (end - start) / 1000);
    }
}
