package DesignPattern.Combining;

import java.util.ArrayList;
import java.util.List;

abstract public class QuackPublisher implements Quackable {
    private List<QuackObserver> quackObserverList;

    public void quackNotify() {
        if (null == quackObserverList) return;

        for (int i = 0; i < quackObserverList.size(); i++) {
            quackObserverList.get(i).update(this);
        }
    }

    public void addObserver(QuackObserver observer) {
        if (null == quackObserverList) {
            quackObserverList = new ArrayList<>();
        }

        quackObserverList.add(observer);
    }

    public void removeObserver(QuackObserver observer) {
        if (null == quackObserverList) return;

        int index = quackObserverList.indexOf(observer);
        quackObserverList.remove(index);
    }
}
