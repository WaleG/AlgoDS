package com.example.datastructures;

import java.util.NoSuchElementException;

public class ResizableArray<T> {
    private T[] array;
    private int n;

    public ResizableArray() {
        array = (T[]) new Object[2];
        n = 0;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void add(T item) {
        if (n == array.length) {
            resize(n * 2);
        }
        array[n++] = item;
    }

    public T remove() {
        if (isEmpty()) throw new NoSuchElementException();
        T item = array[n - 1];
        array[n - 1] = null;
        n--;
        if (n > 0 && n == array.length / 4) resize(n / 2);
        return item;
    }

    public T get(int i) {
        return array[n];
    }

    public void set(int i, T item) {
        array[n] = item;
    }
}
