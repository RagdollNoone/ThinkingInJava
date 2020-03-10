package Thread;

import java.beans.PersistenceDelegate;
import java.util.concurrent.atomic.AtomicReference;

public class example1 {
    private static Person person;
    private static String message;

    private static AtomicReference<String> arMessage;
    private static AtomicReference<Person> arPerson;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Run1());
        Thread t2 = new Thread(new Run2());

        message = "Hello";
        person = new Person("Dendy", 29);

        arMessage = new AtomicReference<>(message);
        arPerson = new AtomicReference<>(person);

        System.out.println("Message is: " + message
                + "\nPerson is " + person.toString());
        System.out.println("Atomic Reference of Message is: " + arMessage.get()
                + "\nAtomic Reference of Person is " + arPerson.get().toString());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Message is: " + message
                + "\nPerson is " + person.toString());
        System.out.println("Atomic Reference of Message is: " + arMessage.get()
                + "\nAtomic Reference of Person is " + arPerson.get().toString());
    }

    private static class Run1 implements Runnable {
        @Override
        public void run() {
            arMessage.compareAndSet(message, "thread 0");
            message = message.concat(" @thread 0");
            person.setAge(person.getAge() + 1);
            person.setName("thread 0");
            arPerson.getAndSet(new Person("thead 0", 1));

            System.out.println("\n" + Thread.currentThread().getName() +" Values "
                    + message + " - " + person.toString());

            System.out.println("\n" + Thread.currentThread().getName() +" Atomic References "
                    + arMessage.get() + " - " + arPerson.get().toString());
        }
    }

    private static class Run2 implements Runnable {
        @Override
        public void run() {
            message = message.concat(" @thread 1");
            person.setAge(person.getAge() + 2);
            person.setName("thread1");
            arMessage.lazySet("thread1");
            arPerson.set(new Person("thread1", 2));

            System.out.println("\n" + Thread.currentThread().getName() +" Values "
                    + message + " - " + person.toString());

            System.out.println("\n" + Thread.currentThread().getName() +" Atomic References "
                    + arMessage.get() + " - " + arPerson.get().toString());
        }
    }



    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
