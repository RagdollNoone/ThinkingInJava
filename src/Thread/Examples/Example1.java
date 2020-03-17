package Thread.Examples;


import java.util.concurrent.atomic.AtomicReference;

/*
    这个例子展示了atomic修饰的变量和普通变量之间在多线程的情况下的区别
    普通变量由于指令重排序和race condition 最终的结果是不可预期的
    而atomic修饰的变量尤其是person对象 不管最终指定的人是谁 但是人名和
    年龄总是匹配的
*/
public class Example1 {
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

        t2.start();
        t1.start();

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
            String threadName = Thread.currentThread().getName();

            arMessage.compareAndSet(message, threadName);
            message = message.concat(" @" + threadName);
            person.setAge(person.getAge() + 1);
            person.setName(threadName);
            arPerson.getAndSet(new Person(threadName, 1));

            System.out.println("\n" + threadName +" Values "
                    + message + " - " + person.toString());

            System.out.println("\n" + threadName +" Atomic References "
                    + arMessage.get() + " - " + arPerson.get().toString());
        }
    }

    private static class Run2 implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();

            message = message.concat(" @" + threadName);
            person.setAge(person.getAge() + 2);
            person.setName(threadName);
            arMessage.lazySet(threadName);
            arPerson.set(new Person(threadName, 2));

            System.out.println("\n" + threadName +" Values "
                    + message + " - " + person.toString());

            System.out.println("\n" + threadName +" Atomic References "
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
