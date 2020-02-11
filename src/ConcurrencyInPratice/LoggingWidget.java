package ConcurrencyInPratice;

public class LoggingWidget extends Widget {
    public LoggingWidget() { }

    public synchronized void doThis() {
        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " +  thd.getName() + " LoggingWidget calling doSomething");
        super.doThis();
    }

    public static void main(String[] args) {
        LoggingWidget loggingWidget = new LoggingWidget();
        Widget widget = new Widget();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    loggingWidget.doThis();
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println("LoggingWidget error 1");
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                widget.doThis();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
