package Thread;

import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException{
        // 3 ways to construct thread
        long startTime = System.currentTimeMillis();

        Thread th1 = new MyThread1();
        th1.start();

        Thread th2 = new Thread(new MyThread2());
        th2.start();

        MyThread3 th3 = new MyThread3();
        FutureTask<Integer> ft = new FutureTask<>(th3);
        new Thread(ft).start();

        Thread.sleep(1000);
        System.out.println("Main thread is over, take time " + (System.currentTimeMillis() - startTime));
    }

}
