package ru.job4j.collection;

public class Node<T> {
    private T model;
    private Node<T> next;

        Node(T model, Node<T> next) {
        this.model = model;
        this.next = next;
    }

    public T getModel() {
        return model;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
