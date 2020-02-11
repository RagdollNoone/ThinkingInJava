package ConcurrencyInPratice;

public class DrawWidget extends Widget {
    public DrawWidget() {
        super();
    }

    public synchronized void doThis() {
        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " +  thd.getName() + " DrawWidget calling doSomething, hascode : " + this.hashCode());

        super.doThis();
    }

    public synchronized void doThat() {
        super.doThat();

        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " +  thd.getName() + " DrawWidget calling doSomething, hascode : " + this.hashCode());
    }
}
