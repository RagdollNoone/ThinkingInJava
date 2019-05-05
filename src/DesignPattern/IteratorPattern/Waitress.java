package DesignPattern.IteratorPattern;

import java.util.Iterator;

public class Waitress {
    private LaunchMenu launchMenu;
    private DinnerMenu dinnerMenu;
    private DrinkMenu drinkMenu;

    public Waitress() {
        launchMenu = new LaunchMenu();
        dinnerMenu = new DinnerMenu();
        drinkMenu = new DrinkMenu();
    }

    public void printMenu() {
        Iterator launchIterator = launchMenu.createIterator();
        Iterator dinnerIterator = dinnerMenu.createIterator();
        Iterator drinkIterator = drinkMenu.createIterator();

        printMenu(launchIterator);
        printMenu(dinnerIterator);
        printMenu(drinkIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print("name: " + menuItem.getName());
            System.out.println(" price: " + menuItem.getPrice());
        }
    }
}
