package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHrmDemo
{
    private static WebDriver oBrowser=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        login();
        logout();
        closeApplicaton();
    }

    private static void launchBrowser()
    {
        try
        {
            oBrowser= new FirefoxDriver();
            //oBrowser=new ChromeDriver();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateUrl()
    {
        try
        {
                oBrowser.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void login()
    {
        try
        {

            //oBrowser.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
            oBrowser.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
            oBrowser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
            oBrowser.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void logout()
    {
        try
        {
            oBrowser.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
            Thread.sleep(3000);

        } catch (Exception e)
        {
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
