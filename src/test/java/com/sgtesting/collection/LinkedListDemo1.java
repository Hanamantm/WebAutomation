package com.sgtesting.collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo1
{
    public static void main(String[] args)
    {
        //Declare linked list or create object of Linked list

        /*LinkedList list = new LinkedList(); //1.
        LinkedList <String> linkedList =  new LinkedList<>();*/ //2 generics same data type

        LinkedList list = new LinkedList();
        list.add(100);
        list.add("apple");
        list.add(89.9);
        list.add(true);
        list.add('A');
        list.add(null); //we can add null value in linkedlist also

        System.out.println(list);

        //size
        System.out.println(list.size());
        //remove
        list.remove(2); //it allows to remove by index only not object
        System.out.println("after removing :" +list);

        //insert new element
        list.add(3,"hanamant");
        System.out.println("after adding element "+list);

        //retrieving value/object
        System.out.println(list.get(3));

        //change the value
        list.set(3,"vihaan");
        System.out.println("after changing value "+list);

        //contains
        System.out.println(list.contains("vihaan"));

        //empty
        System.out.println(list.isEmpty());

        // retrieve or fetch element from linked list
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println("using list iterator");
        ListIterator lt=list.listIterator(list.size());
        while (lt.hasPrevious())
        {
            System.out.println(lt.previous());
        }
    }
}
