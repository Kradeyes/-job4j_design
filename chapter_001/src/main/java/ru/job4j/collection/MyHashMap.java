package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Objects.hash;

public class MyHashMap<K, V> implements Iterable<K> {
    private Entry[] entriesContainer;
    private int capacity;
    private int count = 0;
    private int modCount = 0;
    private double loadFactor = 0.75;

    MyHashMap() {
        this.capacity = 16;
        this.entriesContainer = new Entry[capacity];
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return hash(key);
        }
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        Entry<K, V> newNode = new Entry<>(key, value);
        int index = indexOf(key);
        if (count >= entriesContainer.length * loadFactor) {
            capacity = entriesContainer.length * 2;
            shift();
        }
        if (entriesContainer[index] == null) {
            entriesContainer[index] = newNode;
            modCount++;
            count++;
            result = true;
        }
        return result;
    }

    private Entry[] shift() {
        Entry[] temp = new Entry[capacity];
        for (Entry entry : entriesContainer) {
            if (entry != null) {
                temp[indexOf((K) entry.key)] = entry;
            }
        }
        return temp;
    }

    private int indexOf(K key) {
        return key.hashCode() & (this.capacity - 1);
    }

    public V get(K key) {
        Entry value = entriesContainer[indexOf(key)];

        return value == null ? null : (V) value.value;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = indexOf(key);

        if (entriesContainer[index] != null && Objects.equals(entriesContainer[index].key, key)) {
            entriesContainer[index] = null;
            modCount++;
            count--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int position = 0;
            private int countEntries = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return countEntries < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                countEntries++;
                return findNextValue();
            }

            private K findNextValue() {
                K value = null;
                for (int i = position; i < entriesContainer.length; i++) {
                    if (entriesContainer[i] != null) {
                        value = (K) entriesContainer[i].key;
                        position = i + 1;
                        break;
                    }
                }
                return value;
            }
        };
    }
}
