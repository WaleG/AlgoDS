package com.example.datastructures;

import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {
    private T[] pq;
    int N = 0;

    public Heap(int capacity) {
        this.pq = (T[]) new Object[capacity + 1];
    }

    public void add(T item) {
        if (N == pq.length - 1) throw new ArrayIndexOutOfBoundsException();
        pq[++N] = item;
        swim(N);
    }

    private T remove() {
        if (N == 0) throw new NoSuchElementException();
        T max = pq[1];
        swap(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
