package Volatile;

public class VolatileTest {
    // part 1
    public volatile int num;

    public VolatileTest() {
        num = 0;
    }

    public void increase() {
        num++;
    }

    private static void testCase1() {
        // 只有调试运行的时候才会得到预期的结果
        // 正常运行时 不会输出num的值 不知道那个线程一直在执行

        final VolatileTest vt1 = new VolatileTest();
//        System.out.println("Step A");

        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        vt1.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
//            System.out.println("Step B");
            Thread.yield();
        }

//        System.out.println("Step C");
        System.out.println("num = " + vt1.num);
    }

    // part 2
    public int a = 0;
    public boolean flag = false;

    public void write() {
        System.out.println("write");
        try {
            flag = true;
            Thread.sleep(1000);
            a = 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mutiply() {
        System.out.println("mutiply");
        if (flag) {
            System.out.println("a = " + a);
            int ret = a * a;
            System.out.println("ret = " + ret);
        }
    }


    private static void testCase2() {
        final VolatileTest vt2 = new VolatileTest();

        new Thread() {
            public void run(){
                vt2.write();
            }
        }.start();

        new Thread() {
            public void run() {
                vt2.mutiply();
            }
        }.start();
    }

    public static void main(String[] args) {
//        testCase1();
        testCase2();
    }
}
