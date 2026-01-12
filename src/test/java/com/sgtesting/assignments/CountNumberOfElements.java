package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CountNumberOfElements
{
    private static WebDriver driver=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateUrl();
        enterText();
        countElements();
    }

    private static void launchBrowser()
    {
        try
        {
            driver= new FirefoxDriver();
            /*driver.manage().window().maximize();*/
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateUrl()
    {
        try
        {
            driver.get("https://www.amazon.in");
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void enterText()
    {
        try
        {
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("sumsung");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static  void countElements()
    {
        try
        {
            List <WebElement> listElements=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
            System.out.println("Total products " +listElements.size());

           /* for (WebElement element:listElements)
            {

                System.out.println(element.getText());
            }*/

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
