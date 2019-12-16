package Thread.ThreadLocal;
import java.util.Random;

public class ThreadLocalSimple implements Runnable {
    private static final ThreadLocal<Person> person = ThreadLocal.withInitial(() -> new Person("unknown", -1));
    private static Random random = new Random();

    @Override
    public void run() {
        print();

        person.get().name = "Dendy";
        person.get().age = random.nextInt(100);

        print();
    }

    private void print() {
        System.out.println("Thread name: " + Thread.currentThread().getName() +
                           ", Person name: " + person.get().name +
                           ", Person age: " + person.get().age);
    }
}
