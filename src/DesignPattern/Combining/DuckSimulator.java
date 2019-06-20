package DesignPattern.Combining;

public class DuckSimulator {
    public static void main(String[] args) {
        abstractDuckFactory quackCountDuckFactory = new QuackCountDuckFactory();

        Quackable redheadDuck = quackCountDuckFactory.createRedheadDuck();
        Quackable decoyDuck = quackCountDuckFactory.createDecoyDuck();
        Quackable goose = quackCountDuckFactory.createGoose();

        QuackableCollection quackableCollection = new QuackableCollection();
        quackableCollection.add(redheadDuck);
        quackableCollection.add(decoyDuck);
        quackableCollection.add(goose);

        while (quackableCollection.hasNext()) {
            simulatorQuack(quackableCollection.next());
        }

        quackableCollection.travelRefresh();

        while (quackableCollection.hasNext()) {
            simulatorQuack(quackableCollection.next());
        }

        System.out.println("Quack count is: " + QuackCountDuck.getQuackCount());
    }

    private static void simulatorQuack(Quackable quackable) {
        quackable.quack();
    }
}
