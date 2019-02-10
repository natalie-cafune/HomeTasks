package com.Collections;

public class MyLinkedList<T> {
    private MyNode first;
    private MyNode last;
    private int size = 0;

    public static class MyNode<T> {
        T item;
        MyNode<T> next;
        MyNode<T> previous;

        public MyNode(T item) {
            this.item = item;
        }
    }

    // adds an item
    public void add(T element) {
        MyNode newNode = new MyNode(element);
        if (first == null) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    // clears the collection
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    // returns the size of the collection
    public int size() {
        return size;
    }

    // returns item by index
    public Object get(int index) {
        // If index is bigger / smaller than Linked List size throw IndexOutOfBounds
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        MyNode result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    // removes item by index
    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            MyNode node = findNodeBeforeByIndex(index);
            MyNode tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
        return false;
    }

    private MyNode findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        MyNode node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private MyNode findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        MyNode node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }
}

