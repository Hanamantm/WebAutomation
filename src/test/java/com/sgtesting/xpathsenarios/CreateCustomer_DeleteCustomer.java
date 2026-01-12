package com.sgtesting.xpathsenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateCustomer_DeleteCustomer
{
    private static WebDriver driver = null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login();
        minimizeFlyoutWindow();
        createCustomer("TCS consultancy","Awaiting for Reports");
        deleteCustomer();
        logout();
        closeBrowser();

    }

    private static void launchBrowser()
    {
        try
        {
            driver= new FirefoxDriver();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateToUrl()
    {
        try
        {
            driver.get("http://localhost/login.do");
            Thread.sleep(2000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void login()
    {
        try
        {
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
            driver.findElement(By.xpath("//div[text()='Login ']")).click();
            Thread.sleep(4000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void minimizeFlyoutWindow()
    {
        try
        {
            driver.findElement(By.xpath("//div[@id='gettingStartedShortcutsPanelId']")).click();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private static void createCustomer(String createCustomer, String description)
    {
        try
        {
            driver.findElement(By.xpath("//div[text()='TASKS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Add New']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='customerLightBox_nameField']")).sendKeys(createCustomer);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@id='customerLightBox_descriptionField']")).sendKeys(description);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteCustomer()
    {
        try
        {
            driver.findElement(By.xpath("//div[@class='editButton available']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='ACTIONS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void logout()
    {
        try
        {
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void closeBrowser()
    {
        try
        {
            driver.quit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
