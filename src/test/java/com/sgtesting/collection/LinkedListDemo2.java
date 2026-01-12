package com.sgtesting.collection;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDemo2
{
    public static void main(String[] args)
    {
        LinkedList l=new LinkedList();
        l.add("X");
        l.add("Y");
        l.add("Z");
        l.add("A");
        l.add("B");
        l.add("C");
        System.out.println(l);

        LinkedList ll=new LinkedList();
        ll.addAll(l);
        System.out.println(ll);

        ll.removeAll(l);
        System.out.println("After removing "+ll);

        //sort
        Collections.sort(l);
        System.out.println("after sort " +l);

        //reverse order

        Collections.sort(l,Collections.reverseOrder());
        System.out.println("after reverse "+l);
    }
}
