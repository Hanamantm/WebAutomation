package com.sgtesting.collection;

import java.util.LinkedList;

public class LinkedListDemo3
{
    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        list.add("Dog");
        list.add("cat");
        list.add("horse");
        list.add("tiger");

        System.out.println(list);  //[Dog, cat, horse, tiger]
        list.addFirst("lion");
        list.addLast("elephent");
        System.out.println("after adding "+list);

        System.out.println("get first element "+list.getFirst());
        System.out.println("get last element "+list.getLast());

        System.out.println("remove first element "+list.removeFirst());
        System.out.println("remove last element "+list.removeLast());








    }
}
