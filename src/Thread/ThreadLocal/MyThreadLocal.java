package Thread.ThreadLocal;

import java.lang.ref.WeakReference;

public class MyThreadLocal {

    public MyThreadLocal(MyThread t, Object v) {
        t.map = new MyThreadLocalMap(this, v);
    }

    public Object get() {
        Object ret = null;

        Thread t = Thread.currentThread();
        if (t instanceof MyThread) {
            MyThreadLocalMap m = ((MyThread) t).getMap();
            String m_addr = null == m ? "NULL" : "" + m.hashCode();
//            System.out.println("Thread name: " + t.getName() + " In MyThreadLocal get, m address is " + m_addr);

            MyThreadLocalMap.Entry e = m.getEntry(this);
            String e_addr = null == e ? "NULL" : "" + e.hashCode();
//            System.out.println("Thread name: " + t.getName() + " In MyThreadLocal get, e address is " + e_addr);

            if (null != e) {
                ret = e.value;
                System.out.println("Thread name: " + t.getName() + " In MyThreadLocal get, ret address is " + ret.hashCode());
                return ret;
            } else {
                System.out.println("Thread name: " + t.getName() + " In MyThreadLocal get, e is null");
            }

        } else {
//            System.out.println("Thread name: " + t.getName() + "In MyThreadLocal get, t class type is " + t.getClass());
        }

        return ret;
    }

    public void set(Object v) {
        Thread t = Thread.currentThread();
        if (t instanceof MyThread) {
            MyThreadLocalMap m = ((MyThread) t).getMap();
            m.set(this, v);
        }
    }

    static class MyThreadLocalMap {
        private static final int CAPACITY = 16;
        private int size;
        private Entry[] table;

        public MyThreadLocalMap(MyThreadLocal k, Object v) {
            this.table = new Entry[CAPACITY];
            Entry e = new Entry(k, v);
            this.table[0] = e;
            this.size = 1;
        }

        public Entry getEntry(MyThreadLocal k) {
            for (int i = 0; i < CAPACITY; i++) {
                Entry e = table[i];
                if (null != e && e.get() == k) {
                    return e;
                }
            }

            return null;
        }

        public void set(MyThreadLocal k, Object v) {
            for (int i = 0; i < CAPACITY; i++) {
                Entry e = table[i];
                if (null != e && e.get() == k) {
                    e.value = v;
                }
            }
        }

        private class Entry extends WeakReference<MyThreadLocal> {
            private Object value;

            Entry(MyThreadLocal k, Object v) {
                super(k);

                this.value = v;
            }
        }
    }
}
