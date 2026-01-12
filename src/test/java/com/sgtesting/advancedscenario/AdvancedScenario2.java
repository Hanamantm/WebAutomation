package com.sgtesting.advancedscenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedScenario2
{
    private static WebDriver driver = null;

    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login("admin", "manager");
        minimizeFlyoutWindow();
        driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
        createUser1();
        createUser2();
        createUser3();
        logout();
        login("hanamantm","han@123");
        logout();
        login("swaroopn","swa@123");
        logout();
        login("shivarajm","shiv@123");
        logout();
        login("admin", "manager");
        driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
        modifyUser1();
        modifyUser2();
        modifyUser3();
        logout();
        login("hanamantm","hym@123");
        logout();
        login("swaroopn","nag@123");
        logout();
        login("shivarajm","nag@123");
        logout();
        login("admin", "manager");
        driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
        deleteUser1();
        deleteUser2();
        deleteUser3();
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

    private static void login(String username, String password)
    {
        try
        {
            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("pwd")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);
            if(driver.findElements(By.xpath("//div[@class='startExploringLink']")).size() > 0)
            {
                driver.findElement(By.xpath("//div[@class='startExploringLink']")).click();
                Thread.sleep(2000);
            }

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

    private static void createUser(String fn,String ln, String email, String uname, String pwd)
    {
        try
        {
            driver.findElement(By.xpath("//div[@class='buttonText']")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("firstName")).sendKeys(fn);
            driver.findElement(By.name("lastName")).sendKeys(ln);
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("username")).sendKeys(uname);
            driver.findElement(By.name("password")).sendKeys(pwd);
            driver.findElement(By.name("passwordCopy")).sendKeys(pwd);
            driver.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")).click();
            Thread.sleep(3000);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void createUser1()
    {
            createUser("Hanamant","Mudalagi","hanamant@gmail.com","hanamantm","han@123");
    }
    private static void createUser2()
    {
        createUser("Swaroop","Nagatri","swaroop@gmail.com","swaroopn","swa@123");
    }
    private static void createUser3()
    {
        createUser("Shivaraj","Matagar","shivaraj@gmail.com","shivarajm","shiv@123");
    }
    private static void modifyUserPassword(String fullName,String newPwd)
    {
        try
        {
            driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='userDataLightBox_passwordField']")).clear();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='userDataLightBox_passwordField']")).sendKeys(newPwd);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='userDataLightBox_passwordCopyField']")).clear();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='userDataLightBox_passwordCopyField']")).sendKeys(newPwd);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void modifyUser1()
    {
        modifyUserPassword("Mudalagi, Hanamant","hym@123");
    }
    private static void modifyUser2()
    {
        modifyUserPassword("Nagatri, Swaroop","nag@123");
    }
    private static void modifyUser3()
    {
        modifyUserPassword("Matagar, Shivaraj","nag@123");
    }

    private static void deleteUser(String deleteuser)
    {
        try
        {

            driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + deleteuser + "']")).click();
            Thread.sleep(2000);
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
    private static void deleteUser1()
    {
        deleteUser("Mudalagi, Hanamant");
    }
    private static void deleteUser2()
    {
        deleteUser("Nagatri, Swaroop");
    }
    private static void deleteUser3()
    {
        deleteUser("Matagar, Shivaraj");
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
