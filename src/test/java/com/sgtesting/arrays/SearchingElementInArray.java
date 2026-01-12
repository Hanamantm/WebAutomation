package com.sgtesting.arrays;

public class SearchingElementInArray
{
    public static void main(String[] args)
    {
        int a[] = {10,20,30,40,50};
        int search_element=300;

        boolean status=false;  //false means not found, true  means element found

        for(int i=0;i<a.length;i++)
        {
            if(a[i]==search_element)
            {
                System.out.println("element found..");
                status=true;
                break;
            }
        }
        if(status==false)
        {
            System.out.println("element not found..");
        }
    }
}
