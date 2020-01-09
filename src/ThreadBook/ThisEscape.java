package ThreadBook;

import java.util.ArrayList;
import java.util.List;

public class ThisEscape {

    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething();
            }
        });
    }

    private void doSomething() {
        System.out.println("ThisEscape dosomething");
    }

    public static void main(String[] args) {
        EventSource source = new ThisEscapeEventSource();
        ThisEscape thisEscape = new ThisEscape(source);

        if (source instanceof ThisEscapeEventSource) {
            ((ThisEscapeEventSource)source).fire();
        }
    }

    private static class ThisEscapeEventSource implements EventSource {
        List<EventListener> listeners = new ArrayList<>();

        @Override
        public void registerListener(EventListener o) {
            listeners.add(o);
        }

        public void fire() {
            for (int i = 0; i < listeners.size(); i++) {
                Event e = new ThisEscapeEvent();
                listeners.get(i).onEvent(e);
            }
        }
    }

    private static class ThisEscapeEvent implements Event {

    }

    interface EventSource {
        void registerListener(EventListener o);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {}
}
