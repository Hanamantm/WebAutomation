package com.sgtesting.popbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class PopUpBrowser_ChildBrowser
{
    private static WebDriver driver=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        handlePopUp();
        popUpsBrowsers();
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
            driver.navigate().to("http://localhost/login.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handlePopUp()
    {
        try
        {
            WebElement links=driver.findElement(By.xpath("//a[normalize-space()='actiTIME Inc.']"));
            System.out.println("Before click on link the number of popup :" +getPopUpsCount());
            links.click();
            System.out.println("After click on link the number of popup :" +getPopUpsCount());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static int getPopUpsCount()
    {
        int count = 0;
        count = driver.getWindowHandles().size() - 1;
        return count;
    }

    private static void popUpsBrowsers()
    {
        try
        {
            String parentWindow;
            parentWindow=driver.getWindowHandle();
            System.out.println("Parent Browser :"+parentWindow);
            Set<String> allWindows=driver.getWindowHandles();

            for(String window:allWindows)
            {
                if(!window.equals(parentWindow))
                {
                    System.out.println("child Browser :"+window);
                    driver.switchTo().window(window);
                    System.out.println("Title :" +driver.getTitle());
                    System.out.println("current url :"+driver.getCurrentUrl());
                    Thread.sleep(2000);
                    driver.findElement(By.id("cookie-button--got-it")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.linkText("Get started")).click();
                    Thread.sleep(2000);
                    driver.close();
                }
            }
            driver.switchTo().window(parentWindow);
            System.out.println("Back to Parent :"+driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
