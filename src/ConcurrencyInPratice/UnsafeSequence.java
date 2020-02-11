package ConcurrencyInPratice;

public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }

    public static void main(String... args) {
        final UnsafeSequence instance = new UnsafeSequence();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread thd = Thread.currentThread();
                        System.out.println(thd.getName() + " get next value : " + instance.getNext());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("UnsafeSequence InterruptedException");
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
