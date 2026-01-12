package com.sgtesting.arrays;

/*1. Declare an array
2. Add values into array
3. Find length of an array
4. read single value from an array
5. read multiple values from an array*/


public class SingleDimensionalArray
{
    public static void main(String[] args)
    {
        //Declaring array
       /* int a[] =new int[5];

        //storing values into array
        a[0] =100;
        a[1] =200;
        a[2] =300;
        a[3] =400;
        a[4] =500;*/

        //approach 2
        int a[] ={100,200,300,400,500};

        //find the length of array we use length keyword.
        System.out.println("length of array :" +a.length);

        //read specific or single value from an array
        System.out.println("single value from an array : "+ a[1]);

        //reading the all values from an array
        System.out.println("reading all values from an array :");

        for(int i=0;i<a.length;i++) //i<=4  i<5  i<a.length  i<=a.length-1
        {
            System.out.println(+a[i]);
        }

        //using for each loop or enhanced for loop

        for (int val : a) {
            System.out.println(val);
        }
    }
}
