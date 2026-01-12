package com.sgtesting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDemo
{
    private static WebDriver oBrowser=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        closeApplicaton();
    }

    private static  void launchBrowser()
    {
        try
        {
            oBrowser= new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateUrl()
    {
       try
       {
           oBrowser.get("http://localhost/login.do");
           Thread.sleep(2000);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    private static void closeApplicaton()
    {
        try
        {
            oBrowser.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
