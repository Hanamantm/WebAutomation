package com.sgtesting.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClassDemo
{
    private static WebDriver driver =null;

    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        //mouseAction();
        mouseAction1();
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
            driver.get("https://www.flipkart.com/");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

  /*  private static void mouseAction()
    {
        try
        {
            Actions actions=new Actions(driver);
            WebElement element=driver.findElement(By.xpath("//span[normalize-space()='Login']"));
            actions.moveToElement(element).build().perform();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/

    private static void mouseAction1()
    {
        try
        {
            Actions actions= new Actions(driver);
            WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
            actions.click(element).build().perform();
            Thread.sleep(2000);
            WebElement element1=driver.findElement(By.xpath("//span[normalize-space()='Electronics']"));
            actions.moveToElement(element1).build().perform();
            Thread.sleep(2000);
            WebElement prduct=driver.findElement(By.xpath("//a[normalize-space()='Samsung']"));
            actions.click(prduct).build().perform();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
