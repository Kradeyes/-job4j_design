package ru.job4j.collection;

import java.util.*;

public class SimpleLinked<T> implements Iterable<T> {
    private Node<T> fstNode;
    private Node<T> lstNode;
    private int size;
    private int modCount = 0;

    public SimpleLinked() {
        lstNode = new Node<>(null, null, fstNode);
        fstNode = new Node<>(null, lstNode, null);
    }

    public void add(T model) {
       Node<T> value = new Node<>(model, null, null);
       size++;
       modCount++;
       if (fstNode == null) {
          fstNode = value;
          lstNode = fstNode;
       } else {
           value = lstNode;
           lstNode = new Node<>(model, null, value);
       }
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> target = fstNode;
        int count = 0;
        while (count != index) {
            count++;
            target = target.getNext();
        }

        return target.getModel();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private Node<T> rsl = fstNode;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return rsl != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> returnRsl = rsl;
                rsl = rsl.getNext();
                return returnRsl.getModel();
            }
        };
    }
}