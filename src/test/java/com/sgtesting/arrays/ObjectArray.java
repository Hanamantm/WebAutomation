package com.sgtesting.arrays;

public class ObjectArray
{
    public static void main(String[] args)
    {
        Object a[] ={100, 10.3,'A',"Welcome",true}; //Heterogeneous element or data stor by using Object class

        //reading all data type values

        for(Object val:a)
        {
            System.out.println(val);
        }
    }
}
