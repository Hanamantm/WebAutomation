package com.sgtesting.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo1
{
    public static void main(String[] args)
    {
        //Declare ArrayList (3 ways)

        /*ArrayList al = new ArrayList();
        ArrayList <Integer> al1 =new ArrayList<Integer>();  //generic data type for type safe
        List al2= new ArrayList();*/

        ArrayList al = new ArrayList();

        //add elements to the arraylist

        al.add(100);
        al.add("hanamant");
        al.add(10.5);
        al.add('A');
        al.add(true);
        System.out.println(al);  //[100, hanamant, 10.5, A, true]

        //find the size of elements in arraylist
        System.out.println("Number of elements in arraylist :" +al.size());

        //remove particular element
        System.out.println("remove single element : "+al.remove(1)); //1 index
      //  System.out.println("removing by elements : "+al.remove("hanamant")); // hanamant is elements

        System.out.println("after remove elements in arraylist :" +al);

        //insert new element in the middle by add(index, object c)

        al.add(1,"aradhya");
        System.out.println("after adding new element by using index :"+al); //[100, aradhya, 10.5, A, true]

        //want to get or retrieve specific element or value from arraylist
        System.out.println("retrieve particular element : "+al.get(4));

        //replace existing value to new values
        al.set(1,"vihaan");
        System.out.println("after replacing new value :" +al);// [100, vihaan, 10.5, A, true]


        //search value in arraylist [contains()]
        System.out.println("search element is present or not :" +al.contains("vihaan")); //it returns true if element is present or returns false

        //check arraylist is empty or not

        System.out.println("checks the arraylist is empty or not : "+al.isEmpty()); //it returns false if arraylist contains elements or true if not

        //read the element from arraylist by using for loop, for each loop and iterator interface

        System.out.println("reading elements using for loop");
        for(int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i));
        }
        System.out.println("reading elements using for each loop");

        for(Object element:al)
        {
            System.out.println(element);
        }

        System.out.println("reading elements using Iterator");

        Iterator it=al.iterator();
        while (it.hasNext())  //it returns true if iteration has more element
        {
            System.out.println(it.next());// it returns the current object
        }

    }
}
