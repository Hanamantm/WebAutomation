package com.sgtesting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxbrowserDemo
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
            oBrowser= new FirefoxDriver();
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
