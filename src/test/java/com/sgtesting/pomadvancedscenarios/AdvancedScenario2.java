package com.sgtesting.pomadvancedscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedScenario2
{
    private static WebDriver driver = null;
    private static ActiPage page =null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login("admin", "manager");
        minimizeFlyoutWindow();
        page.getCrateUsers().click();
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
        page.getModify().click();
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
        page.getModify().click();
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
            page=new ActiPage(driver);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateToUrl()
    {
        try
        {
            driver.navigate().to("http://localhost/login.do");
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
            page.getUsername().sendKeys(username);
            page.getPwd().sendKeys(password);
            page.getSubmitButton().click();
            Thread.sleep(2000);
            if(driver.findElements(By.xpath("//div[@class='startExploringLink']")).size() > 0)
            {
                page.getExploreLink().click();
                Thread.sleep(2000);
            }
            Thread.sleep(2000);
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
           /* page.getCrateUsers().click();
            Thread.sleep(2000);*/
            page.getClickAddUser().click();
            Thread.sleep(2000);
            page.getFirstName().sendKeys(fn);
            Thread.sleep(1000);
            page.getLastName().sendKeys(ln);
            Thread.sleep(1000);
            page.getEmail().sendKeys(email);
            Thread.sleep(1000);
            page.getUserDataLightBox_usernameField().sendKeys(uname);
            Thread.sleep(1000);
            page.getPassword().sendKeys(pwd);
            Thread.sleep(1000);
            page.getPasswordCopy().sendKeys(pwd);
            Thread.sleep(1000);
            page.getCreteUserButton().click();
            Thread.sleep(2000);
        } catch (Exception e)
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
            /*page.getModify().click();
            Thread.sleep(1000);*/
            page.clickUserFullName(fullName);
            Thread.sleep(1000);
            page.getUpdatePassword().clear();
            Thread.sleep(1000);
            page.getUpdatePassword().sendKeys(newPwd);
            Thread.sleep(1000);
            page.getCopyPassword().clear();
            Thread.sleep(1000);
            page.getCopyPassword().sendKeys(newPwd);
            Thread.sleep(1000);
            page.getSaveChanges().click();
            Thread.sleep(1000);
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

    private static void deleteUser(String deleteUser)
    {
        try
        {
            page.clickUserFullName(deleteUser);
            Thread.sleep(1000);
            page.getDeleteButton().click();
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
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
            page.getLogoutLink().click();
            Thread.sleep(2000);
        } catch (Exception e) {
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
