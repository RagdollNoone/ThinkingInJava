package Temp;

public class ThreadDemo5Modify {
    private class TestClass1 {
        public boolean a = false;
        public int b = 0;

        public int counter;

        public TestClass1() {
            counter = 0;
        }

        public void write() throws InterruptedException {
            Thread thd = Thread.currentThread();
            a = true;
            System.out.println("Thread name: " + thd.getName() + " , in write(), set a : true");
            Thread.sleep(1000);
            b = 2;
            System.out.println("Thread name: " + thd.getName() + " , in write(), set b : 2");
        }

        public int modifyB() {
            Thread thd = Thread.currentThread();
            System.out.println("Thread name: " + thd.getName() + " ,enter modifyB()");

            if (a) {
                System.out.println("Thread name: " + thd.getName() + " enter if statement modifyB()");

                b = b * b;
                a = false;
            }

            System.out.println("Thread name: " + thd.getName() + " return modifyB() b : " + b);
            return b;
        }

        public synchronized int getCounter() {
            return counter++;
        }
    }

    private static void testCase0() {
        ThreadDemo5Modify t = new ThreadDemo5Modify();
        final TestClass1 tc = t.new TestClass1();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();
                System.out.println("Thread name: " + thd.getName() + " counter : " + tc.getCounter());
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread newThread = new Thread(r, "" + i);
            newThread.start();
        }
    }

    public static void main(String... args) {
        testCase0();
    }
}
