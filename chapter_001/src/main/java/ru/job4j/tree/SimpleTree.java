package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SimpleTree<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    class Node<E> {
         E value;
         List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}