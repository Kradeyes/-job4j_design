package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        return temp.getValue();
    }

    public T deleteLast() {
        T rsl;
        if (head == null) {
           throw new NoSuchElementException();
        }
        if (head.getNext() == null) {
            rsl = head.getValue();
            head.setNext(null);
        } else {
            Node<T> temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            rsl = temp.getNext().getValue();
            temp.setNext(null);
            }

        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
           private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}