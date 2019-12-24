package ThreadBook;

public class ThreadDemo4 {
    public static void main(String... args) {
        class StoppedThread extends Thread {
            private boolean stopped;

            @Override
            public void run() {
                while (!this.stopped) {
                    System.out.println("running");
                }
            }

            public void setStopped(boolean stopped) {
                this.stopped = stopped;
            }
        }

        StoppedThread t = new StoppedThread();
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        t.setStopped(true);
    }

}
