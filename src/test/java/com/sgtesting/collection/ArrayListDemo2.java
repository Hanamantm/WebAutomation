package com.sgtesting.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo2
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
            al.add("X");
        al.add("Y");
        al.add("Z");
        al.add("A");
        al.add("B");
        al.add("C");
       /* al.add(null);*/ // we can add null value in arraylist
        System.out.println("first arraylist :" +al);
        ArrayList list=new ArrayList();

        list.addAll(al);


        System.out.println("duplicate arraylist :"+list);

        //remove all elements
        list.removeAll(al);
        System.out.println("after removing "+list);
        System.out.println(al);

        //sort elements in arraylist using collections.sort() method

        Collections.sort(al);
        System.out.println("after sorting "+al);

        //print in reverse order
        Collections.sort(al,Collections.reverseOrder());
        System.out.println("after reverse :" +al);

        //shuffle order
        Collections.shuffle(al);
        System.out.println("after shuffle" +al);

    }
}
