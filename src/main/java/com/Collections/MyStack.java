package com.Collections;

import java.util.NoSuchElementException;

public class MyStack <T> {

    private int size = 0;
    private MyNode head;
    private MyNode tail;

    private static class MyNode<T> {
        T item;
        MyNode<T> next;
        MyNode<T> previous;

        public MyNode(T item) {
            this.item = item;
        }
    }

    // adds an item
    public void add (T item){
        MyNode newNode = new MyNode(item);
        if (head == null){
            newNode.next = null;
            newNode.previous = null;
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    // returns the size of the collection
    public int size (){
        return size;
    }
    // считывает
    public Object peek() {
        MyNode element;
        if (tail == null){
            throw new NoSuchElementException();
        }
        else{
            element = tail;
        }
        return element.item;
    }
    // считывает и удаляет
    public Object pop(){
        MyNode element;
        if (tail == null){
            throw new NoSuchElementException();
        }
        else{
            element = tail;
        }
        remove(size - 1 );
        return element.item;
    }

   // clears the collection
   public void clear (){
       head = null;
       tail = null;
       size = 0;
   }
   public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            MyNode node = findNodeBeforeByIndex(index);
            MyNode tmp = findByIndex(index);
            node.next = tmp.next;
            tail  = tail.previous;
        }
        size--;
        return true;
    }

    private MyNode findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head;
        }

        MyNode node = tail;
        while (node.previous != null) {
            node = node.previous;
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
        MyNode node = tail;
        while (node.previous != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.previous;
        }
        return null;
    }
}

