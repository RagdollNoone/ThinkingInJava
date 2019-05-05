package DesignPattern.IteratorPattern;

import java.util.Hashtable;
import java.util.Iterator;

public class DrinkMenu extends Menu {
    private Hashtable menuItems;

    public DrinkMenu() {
        menuItems = new Hashtable();

        menuItems.put(0, new MenuItem("drink1", 1));
        menuItems.put(1, new MenuItem("drink2", 2));
        menuItems.put(2, new MenuItem("drink3", 3));
        menuItems.put(3, new MenuItem("drink4", 4));
    }

    @Override
    Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
