package DesignPattern.IteratorPattern;

import java.util.Iterator;

public class LaunchMenu extends Menu {
    MenuItem[] menuItems;
    static int MAX_MENU_ITEMS = 5;

    public LaunchMenu() {
        menuItems = new MenuItem[MAX_MENU_ITEMS];

        menuItems[0] = new MenuItem("launch1", 1);
        menuItems[1] = new MenuItem("launch2", 2);
        menuItems[2] = new MenuItem("launch3", 3);
        menuItems[3] = new MenuItem("launch4", 4);
        menuItems[4] = new MenuItem("launch5", 5);
    }

    @Override
    public Iterator createIterator() {
        return new LaunchMenuIterator(menuItems);
    }
}
