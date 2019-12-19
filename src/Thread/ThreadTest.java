package Thread;

import Thread.ProducerAndConsumer.Consumer;
import Thread.ProducerAndConsumer.Producer;
import Thread.ThreadCreate.MyThread1;
import Thread.ThreadCreate.MyThread2;
import Thread.ThreadCreate.MyThread3;
import Thread.ThreadLocal.ThreadLocalImplement;
import Thread.ThreadLocal.ThreadLocalSimple;
import Utility.SystemInfo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    private static void testCase1() throws InterruptedException {
        print();

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

        print();
        System.out.println("Main thread is over, take time " + (System.currentTimeMillis() - startTime));
    }

    private static void testCase2() {
        Producer producer = new Producer(1);
        Thread p = new Thread(producer);
        p.start();

        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(i);
            Thread c = new Thread(consumer);
            c.start();
        }
    }

    private static void testCase3() {
        ThreadLocalSimple simple = new ThreadLocalSimple();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(simple, "" + i);
            t.start();
        }
    }

    private static void testCase4() {
        for (int i = 0; i < 10; i++) {
            ThreadLocalImplement t = new ThreadLocalImplement("" + i);
            t.start();
        }
    }

    public static void main(String[] args) throws InterruptedException{
//        testCase1();

//        testCase2();

//        testCase3();

        testCase4();

//        System.out.println(SystemInfo.Info());
    }


    private static void print() {
        // [1]main 主线程 程序入口
        // [2]Reference Handler 清除reference线程
        // [3]Finalizer 调用对象finalize方法的线程
        // [4]Signal Dispatcher 分发处理给JVM的线程
        // [5]Attach Listener 添加事件
        // 说明java程序本生是一个main和其他几个线程同时运行

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }

}
