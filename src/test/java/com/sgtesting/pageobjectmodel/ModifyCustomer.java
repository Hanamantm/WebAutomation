package com.sgtesting.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ModifyCustomer
{
    private static WebDriver driver=null;
    private static ActiTimePage page =null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login();
        minimizeFlyoutWindow();
        createCustomer();
        modifyCustomer("TCS consultancy","Wipro");
        deleteCustomer("Wipro");
        logout();
        closeBrowser();
    }

    private static void launchBrowser()
    {
        try
        {
            driver=new FirefoxDriver();
            page=new ActiTimePage(driver);
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

    private static void login()
    {
        try
        {
            page.getUsername().sendKeys("admin");
            page.getPwd().sendKeys("manager");
            page.getSubmitButton().click();
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
            page.getGettingStartedShortcutsPanelId().click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createCustomer()
    {
        try
        {
            page.getTask().click();
            Thread.sleep(2000);
            page.getAddNew().click();
            Thread.sleep(1000);
            page.getCreateCustomer().click();
            Thread.sleep(2000);
            page.getCustomerName().sendKeys("TCS Consultancy");
            Thread.sleep(2000);
            page.getCustomerDescription().sendKeys("Awaiting project report");
            Thread.sleep(2000);
            page.getCustomerLightBox_commitBtn().click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void modifyCustomer(String oldName, String newName)
    {
        try
        {
            page.getEditButton().click();
            Thread.sleep(2000);
            page.getUpdateCustomer().click();
            Thread.sleep(2000);
            page.getEnterNewCustomer().clear();
            Thread.sleep(2000);
            page.getEnterNewCustomer().sendKeys(newName);
            Thread.sleep(2000);
            page.getModify().click();
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void deleteCustomer(String modifiedCustomer)
    {
        try
        {
            /*Thread.sleep(2000);
            page.getEditButton().click();
            Thread.sleep(4000);*/
            page.getActionButton().click();
            Thread.sleep(2000);
            page.getDeleteButton().click();
            Thread.sleep(1000);
            page.getDeletePermanent().click();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
