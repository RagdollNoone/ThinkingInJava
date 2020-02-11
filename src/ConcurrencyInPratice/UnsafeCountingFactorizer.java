package ConcurrencyInPratice;

public class UnsafeCountingFactorizer {
    private long count = 0;

    public UnsafeCountingFactorizer() {}

    public Long getNext() {
        return ++count;
    }

    public static void main(String[] args) {
        UnsafeCountingFactorizer instance = new UnsafeCountingFactorizer();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread thd = Thread.currentThread();
                        System.out.println(thd.getName() + " count : " + instance.getNext());
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("UnsafeCountingFactorizer error 0");
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
