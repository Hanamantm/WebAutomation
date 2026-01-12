package com.sgtesting.automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CreateUser_DeleteUser_Scenario
{
    private static WebDriver driver =null;
    private static ActiPage_Elements page =null;
    @BeforeClass
    public  void launchBrowser()
    {
        try
        {
            driver=new FirefoxDriver();
            page=new ActiPage_Elements(driver);
            Assert.assertNotNull(driver,"Browser failed to launch");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test(priority = 1, dataProvider = "appUrl",dataProviderClass = DataProviders.class)
    public void navigateToUrl(String url)
    {
        try
        {
            driver.get(url);
            String actual=driver.getTitle();
            Assert.assertEquals(actual,"actiTIME - Login","page title mismatch");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2,dataProvider = "loginData",  dataProviderClass = DataProviders.class )
    public void login(String userName, String password)
    {
        try
        {
            page.getUsername().sendKeys(userName);
            Thread.sleep(2000);
            page.getPwd().sendKeys(password);
            Thread.sleep(2000);
            page.getSubmitButton().click();
            Thread.sleep(2000);
            WebElement element=page.getHomeTitle();
            Assert.assertTrue(element.isDisplayed(),"Login failed,Home title is not visible");
            Thread.sleep(2000);
        } catch (Exception e) {
            Assert.fail("Login test failed due to exception"+e.getMessage(),e);
        }
    }

    @Test (priority = 3)
    public void minimizeFlyOutWindow()
    {
        try
        {
            WebElement flyOut = page.getGettingStartedShortcutsPanelId();
            if(flyOut !=null && flyOut.isDisplayed()) {
                Thread.sleep(2000);
                flyOut.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4,dataProvider = "createUserData", dataProviderClass = DataProviders.class)
    public void createUser(String firstName,String lastName, String email, String userName,String password)
    {
        try
        {
            page.getCrateUsersImage().click();
            Thread.sleep(2000);
            page.getClickAddUser().click();
            Thread.sleep(2000);
            WebElement element=page.getUserList();
            Assert.assertTrue(element.isDisplayed());
            Thread.sleep(2000);
            page.getFirstName().sendKeys(firstName);
            page.getLastName().sendKeys(lastName);
            page.getEmail().sendKeys(email);
            page.getUserDataLightBox_usernameField().sendKeys(userName);
            page.getPassword().sendKeys(password);
            page.getPasswordCopy().sendKeys(password);
            page.getCreteUserButton().click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, dataProvider = "ModifyUserdata", dataProviderClass = DataProviders.class)
    public void modifyUser(String fName, String lName, String newFirstName,String newLastName)
    {
        try
        {
            String fullName=lName+", "+fName;

            page.selectUserByName(fullName).click();
            Thread.sleep(2000);
            page.getFirstName().clear();
            page.getFirstName().sendKeys(newFirstName);
            Thread.sleep(2000);
            page.getLastName().clear();
            page.getLastName().sendKeys(newLastName);
            Thread.sleep(2000);
            page.getSaveChanges().click();
            Thread.sleep(2000);

            String upatedFullName=newLastName+", "+newFirstName;
            WebElement updateUser=driver.findElement(By.xpath("//span[text()='"+upatedFullName+"']"));
            Assert.assertTrue(updateUser.isDisplayed(),"user modification failed, updated name is not visible");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6,dataProvider = "deleteUserdata", dataProviderClass = DataProviders.class)
    public void deleteUser(String fullName)
    {
        try
        {
            page.selectUserByName(fullName).click();
            Thread.sleep(2000);
            WebElement element=page.getUserDataLightBox();
            Assert.assertTrue(element.isDisplayed());
            Thread.sleep(2000);
            page.getUserDataLightBox_deleteBtn().click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
