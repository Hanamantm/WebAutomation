package com.sgtesting.testngassertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario2
{
    private static WebDriver oBrowser = null;
    @Test(priority = 1)
    private static void launchBrowser()
    {
        try{
            oBrowser = new FirefoxDriver();
            Assert.assertNotNull(oBrowser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2, dataProvider = "appurl")
    private static void Navigate(String url){
        try{
            String actual,expected;
            expected="actiTIME - Login";
            oBrowser.get(url);
            actual=oBrowser.getTitle();
            Assert.assertEquals(actual, expected);
            //oBrowser.get("http://localhost/login.do");
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, dataProvider = "logindata")
    private static void Login(String username,String password){
        try{
            oBrowser.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
            oBrowser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
            oBrowser.findElement(By.cssSelector("a[id='loginButton'] div")).click();
            Thread.sleep(2000);
            WebElement oEle=oBrowser.findElement(By.xpath("//td[text()='Enter Time-Track']"));
            Assert.assertTrue(oEle.isDisplayed());
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 4)
    private static void minimizeFlyOutwindow()
    {
        try
        {
            oBrowser.findElement(By.cssSelector("#gettingStartedShortcutsPanelId")).click();
            Thread.sleep(2000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test(priority = 5, dataProvider = "Createcustomer")
    private static void Createcustomer(String Custname,String CustDes)
    {
        try{
            oBrowser.findElement(By.xpath("//a[@class='content tasks']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='addNewContainer']//div[@class='downIcon']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
            Thread.sleep(2000);

            WebElement oEle=oBrowser.findElement(By.xpath("//span[@id ='customerLightBox_titlePlaceholder']"));
            Assert.assertTrue(oEle.isDisplayed());
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//input[@id='customerLightBox_nameField']")).sendKeys(Custname);
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//textarea[@id='customerLightBox_descriptionField']")).sendKeys(CustDes);
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@id='customerLightBox_commitBtn']")).click();
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 6)
    private static void Deletecustomer()
    {
        try{
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='editButton available']")).click();
            Thread.sleep(1000);

            WebElement oEle=oBrowser.findElement(By.xpath("//span[@class='customerName']"));
            Assert.assertTrue(oEle.isDisplayed());
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='actionButton']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//span[@id='customerPanel_deleteConfirm_submitTitle']")).click();
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    private static void Logout()
    {
        try
        {
            String actual,expected;
            expected="actiTIME - Login";
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);
            actual=oBrowser.getTitle();
            Assert.assertEquals(actual, expected);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test(priority = 8)
    private static void closeApplication(){
        try{
            oBrowser.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @DataProvider(name = "appurl")
    public Object[][] getURL()
    {
        return new Object[][] {{"http://localhost/login.do"}};
    }

    @DataProvider(name = "logindata")
    public Object[][] getLoginCredentails()
    {
        return new Object[][] {{"admin","manager"}};
    }

    @DataProvider(name = "Createcustomer")
    public Object[][] getCustomerDetails()
    {
        return new Object[][] {{"TCS","Awaiting for report"}};
    }
}
