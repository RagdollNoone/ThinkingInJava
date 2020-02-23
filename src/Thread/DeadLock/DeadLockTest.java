package Thread.DeadLock;

public class DeadLockTest {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + " get resource 1");
                    Thread.sleep(1000);

                    System.out.println(Thread.currentThread() + "waiting for resource 2");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread() + "get resource 2");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource 2");
                    Thread.sleep(1000);

                    System.out.println(Thread.currentThread() + "waiting for resource 1");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread() + "get resource 1");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
