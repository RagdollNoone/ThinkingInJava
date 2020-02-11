package ConcurrencyInPratice;

public class Sequence {
    private int value;

    public synchronized int getNext() {
        return value++;
    }

    public static void main(String... args) {
        final Sequence instance = new Sequence();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread thd = Thread.currentThread();
                        System.out.println(thd.getName() + " get next value : " + instance.getNext());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Sequence InterruptedException");
                    }
                }
            }
        };

        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");

        t1.start();
        t2.start();
    }
}
