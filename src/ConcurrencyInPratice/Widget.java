package ConcurrencyInPratice;

public class Widget {
    public Widget() { }

    public synchronized void doThis() {
        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " +  thd.getName() + " Widget calling doSomething, hascode : " + this.hashCode());

        try {
            Thread.sleep(5000);
        } catch(Exception e) {
            System.out.println("Exception in File Widget, Function doSomething, 1");
        }
    }

    public synchronized void doThat() {
        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " +  thd.getName() + " Widget calling doSomething, hascode : " + this.hashCode());
    }

    // 锁是属于线程的 而不是属于对象的
    // 如果是属于对象的 那么testCase1的t2就不该等待
    // 应为锁是可重入的
    public static void main(String[] args) {
        testCase1(args);
//        testCase2(args);
    }

    private static void testCase1(String[] args) {
        final Widget widget = new DrawWidget();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                widget.doThis();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                widget.doThis();
            }
        });

        t1.start();
        t2.start();
    }

    private static void testCase2(String[] args) {
        final Widget widget = new DrawWidget();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                widget.doThat();
            }
        });

        t1.start();
    }


}

