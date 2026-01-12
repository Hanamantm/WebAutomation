package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo
{
    private static WebDriver oBrowser=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        login();
        minimizeflyOutwindow();
        creatUser();
        logout();
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

    private static void login()
    {
        try
        {
            oBrowser.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
            oBrowser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("manager");
            oBrowser.findElement(By.cssSelector("a[id='loginButton'] div")).click();
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void minimizeflyOutwindow()
    {
        try
        {
            oBrowser.findElement(By.cssSelector("#gettingStartedShortcutsPanelId")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void creatUser()
    {
        try
        {
            oBrowser.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='addUserButton beigeButton useNativeActive']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//input[@id='userDataLightBox_firstNameField']")).sendKeys("hanamant");
            oBrowser.findElement(By.xpath("//input[@id='userDataLightBox_lastNameField']")).sendKeys("mudalagi");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void logout()
    {
        try
        {
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);
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
