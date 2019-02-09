package com.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        MyArrayList <String> myArrayList= new MyArrayList<String>();
        myArrayList.add("aaa");
        myArrayList.add("bbb");
        myArrayList.add("ccc");
        myArrayList.remove(1);
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.size());
        myArrayList.clear();
        System.out.println(myArrayList.size());

        MyLinkedList <Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(23);
        myLinkedList.add(50);
        myLinkedList.add(114);
        myLinkedList.size();
        System.out.println(myLinkedList.get(2));
        myLinkedList.remove(1);
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));

        System.out.println();

        MyQueue <Integer> queue = new MyQueue <Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(70);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.remove(0));
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println();

        MyStack <Integer> myStack = new MyStack <Integer>();
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());


    }
}
