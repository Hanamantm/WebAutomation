package com.sgtesting.xpathsenarios;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CreateUser_DeleteUser_Scenario
{
    private static WebDriver driver = null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login();
        minimizeFlyoutWindow();
        createUser();
        deleteUser("Mudalagi, Hanamant");
        logout();
        closeBrowser();
    }

    private static void launchBrowser()
    {
        try
        {
            driver= new FirefoxDriver();
           /* driver=new ChromeDriver();
            driver.manage().window().maximize();*/
           /* driver= new EdgeDriver();
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

    private static void createUser()
    {
        try
        {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hanamant");
            driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Mudalagi");
            driver.findElement(By.xpath("//input[@id='userDataLightBox_emailField']")).sendKeys("dummy@gmail.com");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hanamantm");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc@123");
            driver.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("abc@123");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[text()='Create User']")).click();
           Thread.sleep(4000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteUser(String fullName)
    {
        try
        {
            driver.findElement(By.xpath("//span[text()='"+fullName+"']")).click();
            driver.findElement(By.xpath("//button[@id='userDataLightBox_deleteBtn']")).click();
            Thread.sleep(2000);
            Alert oAlert = driver.switchTo().alert();
            String content = oAlert.getText();
            System.out.println(content);
            oAlert.accept();
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
