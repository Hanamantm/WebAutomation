package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class W3SchoolAppDemo
{
    private static WebDriver oBrowser=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        clickOnJavascript();
        closeApplication();
    }

    private static void launchBrowser()
    {
        try
        {
            oBrowser=new FirefoxDriver();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateUrl()
    {
        try
        {
            oBrowser.get("https://www.w3schools.com/");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void clickOnJavascript()
    {
        try
        {
            oBrowser.findElement(By.cssSelector("div[id='subtopnav'] a[title='JavaScript Tutorial']")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void closeApplication()
    {
        try
        {
            oBrowser.quit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
