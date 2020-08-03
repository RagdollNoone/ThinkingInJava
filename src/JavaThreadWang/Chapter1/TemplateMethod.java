package JavaThreadWang.Chapter1;

public class TemplateMethod {
    public final void print(String message) {
        System.out.println("##########");
        wrapPrint(message);
        System.out.println("##########");
        System.out.println();
    }

    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod o1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };

        TemplateMethod o2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };

        String message = "Hello Thread";

        o1.print(message);
        o2.print(message);
    }
}
