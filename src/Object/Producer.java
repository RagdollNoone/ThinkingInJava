package Object;

public class Producer implements Observer, Runnable {
    private int producerId;

    public Producer(int producerId) {
        Buffer instance = Buffer.getInstance();
        instance.addProducer(this);

        this.producerId = producerId;
    }

    @Override
    public void run() {
        try {
            while(Buffer.getInstance().produce(producerId)) {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object publisher, Object args) {
        if (args instanceof Integer) {
            int id = (Integer)args;

            if (id == producerId) {
                System.out.println("Produce success");
//                System.out.println("Produce success, producer is " + producerId);
            }
        }
    }
}
