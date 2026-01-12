package com.sgtesting.pomadvancedscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AdvanceScenario1
{
    private static WebDriver driver=null;
    private static ActiPage page =null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login("admin","manager");
        minimizeFlyoutWindow();
        createUser("Hanamant","Mudalagi","hanamant@gmail.com","hanamantm","han@123");
        logout();
        login("hanamantm","han@123");
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
            driver=new FirefoxDriver();
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
            Thread.sleep(4000);
        } catch (Exception e)
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

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void minimizeFlyoutWindow()
    {
        try
        {
            page.getGettingStartedShortcutsPanelId().click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createUser(String fn,String ln, String email, String uname, String pwd)
    {
        try
        {
            page.getCrateUsers().click();
            Thread.sleep(2000);
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

    private static void modifyUserPassword(String fullName,String newPwd)
    {
        try
        {
            page.getModify().click();
            Thread.sleep(1000);
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

    private static void deleteUser(String deleteUser)
    {
        try
        {
            page.getDeleteUsers().click();
            Thread.sleep(1000);
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
