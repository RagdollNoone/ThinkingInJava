package Thread.ThreadLocal;

public class MyThread extends Thread {
    private MyThreadLocal.MyThreadLocalMap map;

    public MyThread(String name) {
        super(name);
    }

    public MyThreadLocal.MyThreadLocalMap getMap() {
        return map;
    }

    public void setMap(MyThreadLocal.MyThreadLocalMap map) {
        this.map = map;
    }
}
