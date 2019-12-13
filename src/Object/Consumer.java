package Object;

import java.util.Random;

public class Consumer implements Observer {
    private Thread consumeThread;
    private int cunsumerId;

    private final static int MAX = 5000;
    private final static int MIN = 100;
    private static Random random = new Random();

    public Consumer(int consumerId) {
        Buffer buffer = Buffer.getInstance();
        buffer.addConsumer(this);

        this.cunsumerId = consumerId;

        consumeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int randomValue = random.nextInt((MAX - MIN) + 1) + MIN;
                    Thread.sleep(randomValue);
                    while(!Buffer.getInstance().consume(cunsumerId)) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumeThread.start();
    }

    @Override
    public void update(Object publisher, Object args) {
        if (args instanceof Integer) {
            int id = (Integer)args;

            if (id == cunsumerId) {
                System.out.println("Consume success, consumer is " + cunsumerId);
            }
        }
    }
}
