package com.sgtesting.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestedDropDown
{
    private static WebDriver driver= null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        autoSuggestDropDown();

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
            driver.get("https://www.google.com/");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void autoSuggestDropDown()
    {
        try
        {
            driver.findElement(By.name("q")).sendKeys("selenium");
            Thread.sleep(5000);
            List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
            System.out.println(list.size());


            for(int i=0;i<list.size();i++)
            {
                System.out.println(list.get(i).getText());   //printing autosuggested dropdown
                if(list.get(i).getText().equals("selenium"))  //click if selenium name come
                {
                    list.get(i).click();
                    break;
                }
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
