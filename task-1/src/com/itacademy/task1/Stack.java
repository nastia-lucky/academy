package com.itacademy.task1;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> storage = new ArrayList<>();

    public void push(T item) {
        storage.add(item);
    }

    public T pop() {
        if (storage.isEmpty()) {
            return null;
        }
        T lastItem = storage.remove(storage.size() - 1);
        return lastItem;
    }

    public boolean isEmpty(){
        return storage.isEmpty();
    }

    public T peek() {
        int size  = storage.size();

        if (size == 0){
            return null;
        };
        return storage.get(size -1);
    }

    public void  clear (){
        storage.clear();
    }


}