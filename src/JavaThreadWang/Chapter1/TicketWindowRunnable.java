package JavaThreadWang.Chapter1;

public class TicketWindowRunnable implements Runnable {
    private int index = 1;

    private final static int max = 50;

    @Override
    public void run() {
        while (index <= max) {
            System.out.println(Thread.currentThread() + " generate number: " + index);
            index++;
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();

        Thread t1 = new Thread(task, "#1 machine");
        Thread t2 = new Thread(task, "#2 machine");
        Thread t3 = new Thread(task, "#3 machine");
        Thread t4 = new Thread(task, "#4 machine");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
