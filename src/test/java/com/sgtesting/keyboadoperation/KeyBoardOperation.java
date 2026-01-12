package com.sgtesting.keyboadoperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyBoardOperation
{
    private static WebDriver driver=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        login();
    }

    private static void launchBrowser()
    {
        try
        {
            driver=new FirefoxDriver();
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

    private static void login()
    {
        try
        {
            driver.findElement(By.id("username")).sendKeys("admin");
            Thread.sleep(2000);
            driver.findElement(By.name("pwd")).sendKeys("manager");
            Thread.sleep(2000);

            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
