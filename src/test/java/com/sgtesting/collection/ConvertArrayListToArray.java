package com.sgtesting.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ConvertArrayListToArray
{
    public static void main(String[] args)
    {
        ArrayList <String> list=new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("sql");

        System.out.println(list);
        //convert arraylist to array

        Object arr[]=list.toArray();

        for(Object val:arr)
        {
            System.out.println(val);
        }
    }
}
