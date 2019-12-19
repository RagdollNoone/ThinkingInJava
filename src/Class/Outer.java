package Class;

public class Outer {
    private static String message = "Hello World";

    public Outer() {}

    private static class MessagePrinter {
        public void print() {
            System.out.println("MessagePrinter print " + message);
        }
    }

    private class Inner {
        public void display() {
            System.out.println("inner display " + message);
        }
    }

    public static void main(String[] args) {
        Outer.MessagePrinter messagePrinter = new Outer.MessagePrinter();
        messagePrinter.print();

        Outer outer = new Outer();
        Inner inner = outer.new Inner();

        inner.display();

        inner = (new Outer()).new Inner();
        inner.display();
    }

}
