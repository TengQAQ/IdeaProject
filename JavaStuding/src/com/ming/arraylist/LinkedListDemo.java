package com.ming.arraylist;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] arg){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(15);
        linkedList.add(228);
        linkedList.addFirst(32);
        System.out.println("linkedlist[0]:"+linkedList.get(0));
        linkedList.remove(2);
        linkedList.set(0,25);
        linkedList.removeFirst();
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }
}
