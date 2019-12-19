package Thread.ThreadLocal;

public class MyThread extends Thread {
    MyThreadLocal.MyThreadLocalMap map = null;

    public MyThread(String name) {
        super(name);
    }

    public MyThreadLocal.MyThreadLocalMap getMap() {
        return map;
    }
}
