package Temp;

public class ThreadDemo5 {
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

        public int getCounter() {
            return counter++;
        }
    }

    private static class TestClass2 {
        private static TestClass2 instance;

        private TestClass2() {  }

        public static TestClass2 getInstance() {
            if (null == instance) {
                instance = new TestClass2();
            }

            return instance;
        }
    }

    private static void testCase0() {
        ThreadDemo5 t = new ThreadDemo5();
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

    private static void testCase1() {
        ThreadDemo5 t = new ThreadDemo5();
        final TestClass1 tc = t.new TestClass1();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        tc.write();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        tc.modifyB();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };

        Thread newThread1 = new Thread(r1);
        newThread1.start();

        Thread newThread2 = new Thread(r2);
        newThread2.start();
    }

    private static void testCase2() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();
                TestClass2 parse = TestClass2.getInstance();
                System.out.println("Thread name: " + thd.getName() + " parse : " + ((parse == null) ? "null" : "" + parse.hashCode()));
            }
        };

        for (int i = 0; i < 20; i++) {
            Thread newThread = new Thread(r);
            newThread.start();
        }
    }

    public static void main(String... args) {
        testCase0();
//        testCase1();
//        testCase2();
    }
}
