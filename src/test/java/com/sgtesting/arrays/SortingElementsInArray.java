package com.sgtesting.arrays;

import java.util.Arrays;

public class SortingElementsInArray
{
    public static void main(String[] args)
    {
        int a [] = {200,100,300,500,400};

        System.out.println("Before sorting the elements ..");
        System.out.println(Arrays.toString(a));

        //Sorting the elements in array
        Arrays.sort(a); //
        System.out.println("After sorting the elements ..");
        System.out.println(Arrays.toString(a));

    }
}
