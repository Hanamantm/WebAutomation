package com.sgtesting.arrays;

import java.util.Arrays;

public class SortingStrings
{
    public static void main(String[] args)
    {
        //char c[] ={'e','a','f','c'};

        String s[] ={"scott","marry","john","david "};
        System.out.println("Before sorting " + Arrays.toString(s));

        Arrays.sort(s);  //sorting character array
        System.out.println("After sorting " + Arrays.toString(s));

    }
}
