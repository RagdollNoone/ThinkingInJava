package ThreadBook;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class UnsafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactor = new AtomicReference<>();

    public UnsafeCachingFactorizer() { }

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

    private static void checkAndModify(UnsafeCachingFactorizer o, int[] array) {
        if (o.getLastNumber().get() == BigInteger.valueOf(array[0])) {
            print(o);
        } else {
            o.setLastNumber(BigInteger.valueOf(array[0]));
            o.setLastFactor(BigInteger.valueOf(array[1]), BigInteger.valueOf(array[2]));
            print(o);
        }
    }

    private static void print(UnsafeCachingFactorizer o) {
        Thread thd = Thread.currentThread();

        System.out.println("Thread name : " + thd.getName() +
                " lastNumber : " + o.getLastNumber() +
                " lastFactor1 : " + o.getLastFactor().get()[0] +
                " lastFactor2 : " + o.getLastFactor().get()[1]);
    }

    public static void main(String[] args) {
        UnsafeCachingFactorizer instance = new UnsafeCachingFactorizer();
        Random random = new Random();

        int[] testValue1 = {15, 5, 3};
        int[] testValue2 = {24, 4, 6};

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int value = random.nextInt(100);

                        if (value % 2 == 0) {
                            checkAndModify(instance, testValue1);
                            Thread.sleep(500);
                        } else {
                            checkAndModify(instance, testValue2);
                        }

                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("UnsafeCachingFactorizer error 1");
                    }
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
