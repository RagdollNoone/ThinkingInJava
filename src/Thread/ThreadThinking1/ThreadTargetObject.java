package Thread.ThreadThinking1;


// TODO: static synchronized 会获得class对象的lock, 多个这样的函数的race condition
// TODO: synchronized function调用一个static synchronized
// TODO: 静态函数的对象锁 是不是需要是一个静态的对象
// TODO: 如果有两个个get函数 一个是同步的另一个不是 在多线程的情况下轮流调用会怎么样

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTargetObject {
    private int data;
    private static int static_data = 0;

    private static Lock lock = new ReentrantLock();

    public ThreadTargetObject() {
        data = 0;
    }

    public synchronized static int getStaticNextCount() {
        System.out.println(Thread.currentThread() + " do getStaticNextCount");

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println("getNextCount Exception");
        }
        return static_data++;
    }

    public synchronized static int getStaticCurrentCount() {
        System.out.println(Thread.currentThread() + " do getStaticCurrentCount");

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println("getCurrentCount Exception");
        }
        return static_data;
    }

    public static int getLockStaticNextCount() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + " do getLockStaticNextCount");
            Thread.sleep(3500);
            static_data++;
        } catch (InterruptedException e) {
            System.out.println("getLockNextCount Exception");
        }
        finally {
            lock.unlock();
            return static_data;
        }
    }

    public static int getLockStaticCurrentCount() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + " do getLockStaticCurrentCount");
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println("getLockCurrentCount Exception");
        } finally {
            lock.unlock();
            return static_data;
        }
    }

    public synchronized int getNextCount() {
        System.out.println(Thread.currentThread() + " do getNextCount");

        try {
            Thread.sleep(3500);
            data++;
        } catch (InterruptedException e) {
            System.out.println("getNextCount Exception");
        } finally {
            return data;
        }
    }

    public synchronized int getCurrentCount() {
        System.out.println(Thread.currentThread() + " do getCurrentCount");

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            System.out.println("getCurrentCount Exception");
        } finally {
            return data;
        }
    }

    public int getNextCountDirectly() {
        System.out.println(Thread.currentThread() + " do getNextCountDirectly");

        return data++;
    }

    public synchronized void getBothNextCount() {
        System.out.println(Thread.currentThread() + " do getBothNextCount");

        try {
            data++;
            getStaticNextCount();
            Thread.sleep(3500);
        } catch(InterruptedException e) {
            System.out.println("getBothNextCount Exception");
        } finally {
            System.out.println("getBothNextCount over");
        }
    }

    public synchronized static void testStaticNestLock() {
        getStaticNextCount();
        getStaticCurrentCount();
    }
}
