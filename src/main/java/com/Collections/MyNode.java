package com.Collections;

public class MyNode <K, V> {

    final int hashCode;
    K key;
    V value;
    MyNode nextNode;

    public MyNode( K key, V value) {
        this.hashCode = key.hashCode();
        this.key = key;
        this.value = value;
    }
}
