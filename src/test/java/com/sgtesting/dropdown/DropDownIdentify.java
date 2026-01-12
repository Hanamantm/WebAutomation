package com.sgtesting.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownIdentify
{
    private static WebDriver driver= null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        dropDownElement();
    }

    private static void launchBrowser()
    {
        try
        {
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateUrl()
    {
        try
        {
            driver.get("https://testautomationpractice.blogspot.com/");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void dropDownElement()
    {
        try
        {
            WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country']"));

            Select drpCountry=new Select(drpCountryEle); //passing parameter in select class object.
            //drpCountry.selectByVisibleText("France");  //select By text
            //drpCountry.selectByValue("japan");  //select By value
            //drpCountry.selectByIndex(2); //select By Index

            //capture the options from dropdown

            List<WebElement> options= drpCountry.getOptions();
            System.out.println("Number of options in dropdown : "+options.size());
            System.out.println("---------------------------------------");

            //printing the options in console
            //using for loop

            for(int i=0;i<options.size();i++)
            {
                System.out.println(options.get(i).getText());
            }
            System.out.println("---------------------------------------");

            //using Enhanced loop
            for(WebElement op:options)
            {
                System.out.println(op.getText());
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
