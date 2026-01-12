package com.sgtesting.arrays;

/*1. Declare an array
2. Add values into array
3. Find length of an array
4. read single value from an array
5. read multiple values from an array*/

public class TwoDimensionalArray
{
    public static void main(String[] args)
    {
       /* int a[][] =new int[2][3];
        a[0][0] = 100;
        a[0][1] = 200;
        a[0][2] = 300;

        a[1][0] = 400;
        a[1][1] = 500;
        a[1][2] = 600;

        System.out.println("rows length "+a.length);
        System.out.println("column : "+a[0].length);*/

        int a[][] = {{100,200,300},
                     {400,500,500}};

        //find the length of rows and column
        System.out.println("length of rows : "+a.length);
        System.out.println("length of columns : "+a[0].length);

        //read single values from array
        System.out.println("read single values from array :" +a[0][1]);


        //reading multiple values
        for(int r=0;r<a.length;r++)
        {
            for(int c=0;c<a[r].length;c++)
            {
                System.out.print(a[r][c] +" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
        //by using for each loop

        for(int val[]:a)
        {
            for(int x:val)
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
