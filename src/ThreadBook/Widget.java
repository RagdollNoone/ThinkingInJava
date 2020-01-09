package ThreadBook;

public class Widget {
    public Widget() { }

    public synchronized void doSomething() {
        Thread thd = Thread.currentThread();
        System.out.println("Thread name : " +  thd.getName() + " Widget calling doSomething, hascode : " + this.hashCode() );
    }
}
