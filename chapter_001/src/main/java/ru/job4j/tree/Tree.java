package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (childNode.isEmpty()) {
            parentNode.ifPresent(eNode -> eNode.children.add(new Node<>((E) child)));
            rsl = true;
        }
        return rsl;
    }

    public boolean isBinary() {
        Optional<Node<E>> rsl = findElem(el -> el.children.size() > 2);
        return rsl.isEmpty();
 }

    @Override
    public Optional<Node<E>> findBy(Object value) {
        return findElem(el -> el.value.equals(value));
    }

    public Optional<Node<E>> findElem(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}