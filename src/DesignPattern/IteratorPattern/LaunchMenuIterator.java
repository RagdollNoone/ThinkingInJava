package DesignPattern.IteratorPattern;

import java.util.Iterator;

public class LaunchMenuIterator implements Iterator {
    private MenuItem[] menuItems;
    private int position = 0;

    public LaunchMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.length - 1;
    }

    @Override
    public Object next() {
        if (position + 1 < menuItems.length) {
            MenuItem result = menuItems[position];
            position = position + 1;
            return result;

        } else {
            return null;
        }
    }

    @Override
    public void remove() {

    }
}
