package Thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException{
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