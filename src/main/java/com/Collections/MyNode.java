package com.Collections;

public class MyNode <K, V> {

    final int hashCode;
    K key;
    V value;
    MyNode nextNode;

    public MyNode(int hashCode, K key, V value, MyNode nextNode) {
        this.hashCode = hashCode;
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
    }
}
