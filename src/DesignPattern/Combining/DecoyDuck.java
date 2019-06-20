package DesignPattern.Combining;

public class DecoyDuck extends QuackPublisher {
    @Override
    public void quack() {
        System.out.println("DecoyDuck quack");
    }
}
