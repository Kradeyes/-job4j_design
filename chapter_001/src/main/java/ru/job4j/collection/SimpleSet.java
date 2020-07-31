package ru.job4j.collection;

import java.util.Objects;

public class SimpleSet<T> {
    private final SimpleArray<T> set;

    public SimpleSet() {
        set = new SimpleArray<>();
    }

    public SimpleSet(int size) {
        set = new SimpleArray<>(size);
    }

    public boolean duplicateCheck(T value) {
        boolean result = false;
        for (T t : set) {
            if (Objects.equals(t, value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(T value) {
        if (!duplicateCheck(value)) {
            set.add(value);
        }
    }
}

