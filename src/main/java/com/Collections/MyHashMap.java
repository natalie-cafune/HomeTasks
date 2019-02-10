package com.Collections;

public class MyHashMap <K,V>{
    private final int SIZE = 16;
    private final float LOAD_FACTOR = 0.75f;


    MyNode newMyNode;
    MyNode last;
    MyNode array [];
    private int sizeArray = 0;

    public MyHashMap() {
        this.array = new MyNode[SIZE];
    }

    public K put (K key, V value){
        newMyNode = new MyNode(key, value);
        int index = newMyNode.hashCode % (array.length -1);
        if (array[index] == null) {
            array[index] = newMyNode;
            sizeArray++;
        }
            else {
                last = array[index];
                K oldValue = (K) last.value;

                if (newMyNode.hashCode == last.hashCode && (newMyNode.key == last.key || newMyNode.key.equals(last.key)) &&
                        last.nextNode == null) {
                    last.value = newMyNode.value;
                    return oldValue;
                } else {
                    while (last.nextNode != null) {
                        last = last.nextNode;
                        if (newMyNode.hashCode == last.hashCode && (newMyNode.key == last.key || newMyNode.key.equals(last.key))) {
                            last.value = newMyNode.value;
                            return oldValue;
                        }
                    }
                    if (last.nextNode ==null) {
                        last.nextNode = newMyNode;
                    }
                }
            }

        return (K)key;
    }

    // returns item by key
    public Object get (K key){
        for (int i = 0; i <= sizeArray; i++) {
            if (array[i] != null) {
                if (array[i].key == key && array[i].nextNode == null) {
                    return array[i].value;
                }
            }
        }
        return null;
    }

    // removes item by key
    public void remove (K key){
        for (int i = 0; i <= array.length -1; i++) {
            if (array[i] != null) {
                if (array[i].key == key && array[i].nextNode == null) {
                    array[i] = null;
                    sizeArray--;
                }
            }
        }
    }


    // clears the collection
    public void clear(){
        sizeArray = 0;
        array = null;
        last = null;

    }
    // returns the size of the collection
    public int size(){
        return sizeArray;
    }
}
