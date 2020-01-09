package DesignPattern.ObserverPattern.TestCase1;

import DesignPattern.ObserverPattern.TestCase2.Node;

import java.util.ArrayList;

public interface DisplayElement {
    void display();

    class Tree<T> {
        private Node<T> root;

        public Tree(T rootData) {
            root = new Node<T>();
            root.setData(rootData);
            root.setChildren(new ArrayList<Node<T>>());
        }

        public Node<T> getRoot() {
            return root;
        }
    }
}
