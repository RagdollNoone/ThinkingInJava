package ThreadBook;

public class ThreadDemo3Modify {
    private class TestClass1 {
        public int a = 10;
        public int b = 0;

        public int counter;

        public TestClass1() {
            counter = 0;
        }

        public void write() {
            Thread thd = Thread.currentThread();
            a = 20;
            System.out.println("Thread name: " + thd.getName() + " , in write(), set a : 20");
        }

        public int modifyB() throws InterruptedException{
            Thread thd = Thread.currentThread();
            System.out.println("Thread name: " + thd.getName() + " ,enter modifyB()");

            a = 10;

            if (a == 10) {
                System.out.println("Thread name: " + thd.getName() + " enter if statement modifyB()");
                Thread.sleep(1000);
                b = a / 2;
            }

            System.out.println("Thread name: " + thd.getName() + " return modifyB() b : " + b);
            return b;
        }

        public synchronized int getCounter() {
            return counter++;
        }
    }

    private static void testCase0() {
        ThreadDemo3Modify t = new ThreadDemo3Modify();
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
