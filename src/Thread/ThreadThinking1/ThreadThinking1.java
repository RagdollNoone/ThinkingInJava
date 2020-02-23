package Thread.ThreadThinking1;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadThinking1 {
    public static void main(String[] args) {
//        testCase1(args);
//        testCase2(args);
//        testCase3(args);
        testCase4(args);
    }

    private static void testCase1(String[] args) {
        final ThreadTargetObject object = new ThreadTargetObject();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.getBothNextCount();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadTargetObject.getStaticNextCount();
                object.getNextCount();
            }
        });

        t1.start();

        try {
            Thread.sleep(500);
            t2.start();
        } catch (InterruptedException e) {

        }
    }

    private static void testCase2(String[] args) {
        final ThreadTargetObject object = new ThreadTargetObject();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.getNextCount();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.getNextCountDirectly();
            }
        });

        t1.start();
        t2.start();
    }

    private static void testCase3(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadTargetObject.getLockStaticNextCount();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadTargetObject.getLockStaticCurrentCount();
            }
        });

        t1.start();
        t2.start();
    }

    private static void testCase4(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadTargetObject.testStaticNestLock();
            }
        });

        t1.start();
    }
}
