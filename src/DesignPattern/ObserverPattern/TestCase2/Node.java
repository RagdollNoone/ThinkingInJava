package DesignPattern.ObserverPattern.TestCase2;

import java.util.List;

public class Node<T> {
    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node() {}

    public Node(T data) {
        this.data = data;
    }

    public boolean hasChildren() {
        if (null == children) {
            return false;
        }

        return !children.isEmpty();
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }
}
