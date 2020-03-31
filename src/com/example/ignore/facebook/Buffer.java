package com.example.ignore.facebook;

import java.util.Arrays;

class Buffer {
    public static void main(String[] args) {
        Buffer buf = new Buffer(5); // [. . . . .]
        System.out.println(buf.write( new char[] {'a','b','c'})); // => 3 [abc . .]
        System.out.println(buf.write(new char[] {'d','e','f'})); // => 2 because the buffer is full, you can only //write two chars [abcde]
        System.out.println(buf.read(3)); // => [abc] [. . . de]
        buf.write(new char[]{'x','y','z','a','b','c'}); // => 3 [xyzde]
        System.out.println(buf.read(8)); // returns [dexyz] becuase 'de' was written first [. . . . .]
    }

    private char[] buffer;
    private int tail;
    private int head;
    private int capacity;
    private boolean empty;


    public Buffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new char[capacity];
        this.tail = 0;
        this.head = 0;
        this.empty = true;
    }

    /**
     * Transfers the content of the given source char array into this buffer.
     * Returns the the number of chars that were written into the buffer.
     */
    public int write(char[] src) {
        int writtenChars = 0;
        int srcIdx = 0;
        while (!isFull() && srcIdx < src.length) {
            if (isEmpty()) empty = false; // check if tail == head and buffer was not full
            buffer[tail] = src[srcIdx++];
            tail = (tail + 1) % capacity;
            writtenChars++;
        }
        System.out.println("Buffer after write: " + Arrays.toString(buffer));
        return writtenChars;
    }

    public char[] read(int n) {
        int readChars = 0;
        StringBuilder sb = new StringBuilder();
        while (!isEmpty() && readChars < n) {
            sb.append(buffer[head]);
            head = (head + 1) % capacity;
            readChars++;
            if (isFull()) empty = true;
        }
        char[] result = new char[sb.length()];
        sb.getChars(0, sb.length(), result, 0);
        return result;
    }

    private boolean isEmpty() {
        return tail == head && empty;
    }

    private boolean isFull() {
        return tail == head && !empty;
    }
}
