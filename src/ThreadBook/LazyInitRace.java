package ThreadBook;

public class LazyInitRace {
    private static LazyInitRace instance;

    private LazyInitRace() {
        try {
            Thread.sleep(300L);
        } catch (Exception e) {
            System.out.println("LazyInitRace error 0");
        }
    }

    public static LazyInitRace getInstance() {
        if (null == instance) {
            instance = new LazyInitRace();
        }

        return instance;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();

                LazyInitRace target = LazyInitRace.getInstance();
                System.out.println(thd.getName() + " get instance hashCode : " + target.hashCode());
            }
        };

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(r, "" + i);
            t.start();
        }
    }
}
