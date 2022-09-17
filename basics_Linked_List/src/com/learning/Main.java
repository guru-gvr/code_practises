package com.learning;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.offerFirst(10);
    }
}