package com.sgtesting.assignments;

public class VowelsCount
{
    public static void main(String[] args)
    {
        String data="Hello World";
        int count =0;

        data=data.toLowerCase();

        for(int i=0;i<data.length();i++)
        {
            char ch= data.charAt(i);

            if(ch == 'a' || ch =='e' || ch=='i' || ch=='o' || ch=='u')
            {
                count=count+1;
            }
        }
        System.out.println("Vowels count " +count);
    }
}
