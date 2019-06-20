package DesignPattern.Combining;

import java.util.ArrayList;
import java.util.List;

public class QuackableCollection implements Iterator<Quackable> {
    private List<Quackable> quackableList;
    private int index;

    public QuackableCollection() {
        index = 0;
    }

    public void add(Quackable quackable) {
        if (null == quackableList) {
            quackableList = new ArrayList<>();
        }

        quackableList.add(quackable);
    }

    @Override
    public boolean hasNext() {
        if (index < quackableList.size())
            return true;

        return false;
    }

    @Override
    public Quackable next() {
        Quackable quackable = quackableList.get(index);
        index++;
        return quackable;
    }

    public void travelRefresh() {
        index = 0;
    }
}
