package DesignPattern.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class DinnerMenu extends Menu {
    private ArrayList<MenuItem> menuItems;

    public DinnerMenu() {
        menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("dinner1", 1));
        menuItems.add(new MenuItem("dinner2", 2));
        menuItems.add(new MenuItem("dinner3", 3));
        menuItems.add(new MenuItem("dinner4", 4));
        menuItems.add(new MenuItem("dinner5", 5));
    }

    @Override
    public Iterator createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}
