package ru.job4j.collection;

public class Node<T> {
    private T model;
    private Node<T> next;
    private Node<T> prev;

        Node(T model, Node<T> next, Node<T> prev) {
        this.model = model;
        this.next = next;
        this.prev = prev;
    }

    public T getModel() {
        return model;
    }

    public Node<T> getNext() {
        return next;
    }
}
