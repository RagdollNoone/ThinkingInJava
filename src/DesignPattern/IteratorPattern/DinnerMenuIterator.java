package DesignPattern.IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

public class DinnerMenuIterator implements Iterator {
    private ArrayList<MenuItem> menuItems;
    private int position = 0;

    public DinnerMenuIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size() - 1;
    }

    @Override
    public Object next() {
        if (position + 1 < menuItems.size()) {
            MenuItem result =  menuItems.get(position);
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
