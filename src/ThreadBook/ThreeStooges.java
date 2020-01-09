package ThreadBook;

import java.util.HashSet;
import java.util.Set;

public final class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

    public static void main(String[] args) {
        ThreeStooges instance = new ThreeStooges();

        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}
