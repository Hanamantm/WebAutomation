package com.sgtesting.advancedscenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvanceScenario1
{
    private static WebDriver driver = null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login("admin","manager");
        minimizeFlyoutWindow();
        createUser("Hanamant","Mudalagi","dummy@gmail.com","hanamantm","abc@123");
        logout();
        login("hanamantm","abc@123");
        createUser("swaroop","nagatri","swaroop@gmail.com","swaroopn","xyz@123");
        logout();
        login("swaroopn","xyz@123");
        createUser("shivaraj","matagar","shivaraj@gmail.com","shivarajm","shiva@123");
        logout();
        login("shivarajm","shiva@123");
        logout();
        login("admin","manager");
        modifyUserPassword("Mudalagi, Hanamant","hym@123");
        logout();
        login("hanamantm","hym@123");
        modifyUserPassword("nagatri, swaroop","swa@123");
        logout();
        login("swaroopn", "swa@123");
        modifyUserPassword("matagar, shivaraj","s@123");
        logout();
        login("shivarajm","s@123");
        logout();
        login("swaroopn", "swa@123");
        deleteUser("matagar, shivaraj");
        logout();
        login("hanamantm","hym@123");
        deleteUser("nagatri, swaroop");
        logout();
        login("admin","manager");
        deleteUser("Mudalagi, Hanamant");
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
            Thread.sleep(4000);
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
            driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
            driver.findElement(By.xpath("//div[@class='buttonText']")).click();
            driver.findElement(By.name("firstName")).sendKeys(fn);
            driver.findElement(By.name("lastName")).sendKeys(ln);
            driver.findElement(By.name("email")).sendKeys(email);
            driver.findElement(By.name("username")).sendKeys(uname);
            driver.findElement(By.name("password")).sendKeys(pwd);
            driver.findElement(By.name("passwordCopy")).sendKeys(pwd);
            driver.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")).click();
            Thread.sleep(4000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void modifyUserPassword(String fullName,String newPwd)
    {
        try
        {
            driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
            Thread.sleep(2000);
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

    private static void deleteUser(String deleteuser)
    {
        try
        {
            driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
            Thread.sleep(2000);
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
