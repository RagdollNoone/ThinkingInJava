package ConcurrencyInPratice;

import java.util.ArrayList;
import java.util.List;

public class SafeListener {
    private EventListener listener;

    private static class SafeListenerHolder {
        private static SafeListener instance = new SafeListener();
    }

    private SafeListener() {
        listener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething();
            }
        };
    }

    public static SafeListener getInstance(EventSource o) {
        o.registerListener(SafeListenerHolder.instance.listener);
        return SafeListenerHolder.instance;
    }

    private void doSomething() {
        System.out.println("SafeListener doSomething");
    }

    public static void main(String[] args) {
        SafeListenerEventSource source = new SafeListenerEventSource();
        SafeListener.getInstance(source);
        source.fire();
    }

    private static class SafeListenerEventSource implements EventSource {
        List<EventListener> listeners = new ArrayList<>();

        @Override
        public void registerListener(EventListener o) {
            listeners.add(o);
        }

        public void fire() {
            for (int i = 0; i < listeners.size(); i++) {
                Event e = new SafeListenerEvent();
                listeners.get(i).onEvent(e);
            }
        }
    }

    private static class SafeListenerEvent implements Event { }

    interface EventSource {
        void registerListener(EventListener o);
    }

    interface EventListener{
        void onEvent(Event e);
    }

    interface Event {}
}
