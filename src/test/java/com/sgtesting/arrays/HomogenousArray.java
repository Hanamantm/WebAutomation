package com.sgtesting.arrays;

public class HomogenousArray
{
    public static void main(String[] args)
    {
        int [] a= new int[3];
        a[0]=1;
       // a[1]=9.3; //we can not add another type bcz array stores only homogenous data
        System.out.println(a[1]); //once we create an array object its stores default values
    }
}
