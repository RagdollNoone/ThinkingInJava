package ConcurrencyInPratice;

import java.util.Random;

public class NoVisibility {
    private static boolean ready; // this value change can't see
    private static int number;

    private static class ReadThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (ready) {
                    Thread thd = Thread.currentThread();
                    System.out.println("Thread name : " + thd.getName() + " is running(read thread)...");
                    System.out.println("Read thread, number : " + number);
                    ready = false;
                }
            }
        }
    }

    private static class WriteThread extends Thread {
        private Random random;

        public WriteThread() {
            random = new Random();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);

                    Thread thd = Thread.currentThread();
                    ready = true;
                    number = random.nextInt(100);
                    System.out.println("Thread name : " + thd.getName() + " is running(write thread)...");
                    System.out.println("Write thread, number : " + number);
                }
            } catch (Exception e) {
                System.out.println("NoVisibility error 1");
            }
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        new WriteThread().start();
    }
}
