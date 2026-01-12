package com.sgtesting.scenarios;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        deleteUser();
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
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("pwd")).sendKeys("manager");
            driver.findElement(By.id("loginButton")).click();
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
            driver.findElement(By.id("gettingStartedShortcutsPanelId")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createUser()
    {
        try
        {
            driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
            driver.findElement(By.xpath("//div[@class='buttonText']")).click();
            driver.findElement(By.name("firstName")).sendKeys("Hanamant");
            driver.findElement(By.name("lastName")).sendKeys("Mudalagi");
            driver.findElement(By.name("email")).sendKeys("dummy@gmail.com");
            driver.findElement(By.name("username")).sendKeys("hanamantm");
            driver.findElement(By.name("password")).sendKeys("abc@123");
            driver.findElement(By.name("passwordCopy")).sendKeys("abc@123");
            driver.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")).click();
           Thread.sleep(4000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteUser()
    {
        try
        {
            driver.findElement(By.xpath("//span[normalize-space()='Mudalagi, Hanamant']")).click();
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
