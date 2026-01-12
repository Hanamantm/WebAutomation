package com.sgtesting.arrays;

public class FindHowManyDuplicatesInArray
{
    public static void main(String[] args)
    {
        int a [] = {10,20,10,30,40,10,60,10};
        int num=10;
        int count =0;

        for(int value:a)
        {
            if(value==num)
            {
                count++;  //count =count+1;
            }
        }
        System.out.println(count);
    }
}
