package com.sgtesting.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ModifyCustomer
{
    private static WebDriver driver = null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login("admin","manager");
        minimizeFlyoutWindow();
        createCustomer("TCS consultancy","awaiting project reports");
        modifyCustomer("TCS consultancy","Wipro","waiting for final reports");
        deleteCustomer();
        logout();
        closeBrowser();
    }

    private static void launchBrowser()
    {
        try
        {
            driver=new FirefoxDriver();
            /*driver=new ChromeDriver();
            driver.manage().window().maximize();*/

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

    private static void minimizeFlyoutWindow()
    {
        try
        {
            driver.findElement(By.id("gettingStartedShortcutsPanelId")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void login(String user, String pwd)
    {
        try
        {
            driver.findElement(By.name("username")).sendKeys(user);
            driver.findElement(By.name("pwd")).sendKeys(pwd);
            driver.findElement(By.id("loginButton")).click();
            Thread.sleep(4000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createCustomer(String customerName, String description)
    {
        try
        {
            driver.findElement(By.xpath("//a[@class='content tasks']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='title ellipsis'][normalize-space()='Add New']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customerName);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@id='customerLightBox_descriptionField']")).sendKeys(description);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='customerLightBox_commitBtn']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void modifyCustomer(String oldName, String newName, String newDesc)
    {
        try
        {
            driver.findElement(By.xpath("//div[@class='editButton available']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='nameLabel'][normalize-space()='"+oldName+"']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='nameInput']//input[@placeholder='Enter Customer Name']")).clear();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='nameInput']//input[@placeholder='Enter Customer Name']")).sendKeys(newName);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='closeButton']")).click();
            Thread.sleep(3000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void deleteCustomer()
    {
        try
        {
            driver.findElement(By.xpath("(//div[@class='editButton available'])[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='actionButton'])[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='customerPanel_deleteConfirm_submitBtn']//div[@class='buttonIcon']")).click();
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
            driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
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
