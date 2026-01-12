package com.sgtesting.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertArrayToArrayList
{
    public static void main(String[] args)
    {
        String arr [] ={"hanamant","pavan", "vihaan","aradhya","laxmavva","swati"};

        for (String value:arr)
        {
            System.out.println(value);
        }

        ArrayList list= new ArrayList(Arrays.asList(arr));
        System.out.println(list);
    }
}
