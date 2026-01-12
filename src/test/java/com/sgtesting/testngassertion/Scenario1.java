package com.sgtesting.testngassertion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario1
{
    private static WebDriver oBrowser = null;
    @Test(priority = 1)
    private  void launchBrowser()
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

    @Test(priority = 5, dataProvider = "Createuserdata")
    private static void CreateUser(String fn,String ln,String email,String uname,String pwd){
        try {
            oBrowser.findElement(By.xpath("//a[contains(@class,'content users')]//div[contains(@class,'img')]")).click();
            Thread.sleep(4000);

            oBrowser.findElement(By.xpath("//div[@class='buttonText']")).click();
            Thread.sleep(2000);
            WebElement oEle=oBrowser.findElement(By.xpath("//span[text()='User List']"));
            Assert.assertTrue(oEle.isDisplayed());

            oBrowser.findElement(By.name("firstName")).sendKeys(fn);
            oBrowser.findElement(By.name("lastName")).sendKeys(ln);
            oBrowser.findElement(By.name("email")).sendKeys(email);
            oBrowser.findElement(By.name("username")).sendKeys(uname);
            oBrowser.findElement(By.name("password")).sendKeys(pwd);
            oBrowser.findElement(By.name("passwordCopy")).sendKeys(pwd);
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//span[normalize-space()='Create User']")).click();
            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6, dataProvider = "Modifyuserdata")
    private static void ModifyUser(String fn,String ln,String modfn,String modln)
    {
        try {
            Thread.sleep(2000);

            // oBrowser.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='"+ ln +", "+ fn +"']")).click();
            oBrowser.findElement(By.xpath("(//span[@class ='userNameSpan'= '"+ ln +", "+ fn +"'])[1]")).click();
            Thread.sleep(4000);
            WebElement oEle=oBrowser.findElement(By.xpath("//span[text()='"+ ln +", "+ fn +"']"));
            Assert.assertTrue(oEle.isDisplayed());
            Thread.sleep(2000);
            oBrowser.findElement(By.name("firstName")).clear();
            Thread.sleep(2000);
            oBrowser.findElement(By.name("firstName")).sendKeys(modfn);
            oBrowser.findElement(By.name("lastName")).clear();
            Thread.sleep(2000);
            oBrowser.findElement(By.name("lastName")).sendKeys(modln);
            oBrowser.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']")).click();
            Thread.sleep(4000);
        }catch(Exception e)
        {
            e.printStackTrace();//
        }
    }
    @Test(priority = 7, dataProvider = "Deleteuserdata")
    private static void DeleteUser(String fn,String ln){
        try{
            oBrowser.findElement(By.xpath("(//span[@class ='userNameSpan'= '"+ ln +", "+ fn +"'])[1]")).click();
            Thread.sleep(2000);
            WebElement oEle=oBrowser.findElement(By.xpath("//span[text()='"+ ln +", "+ fn +"']"));
            Assert.assertTrue(oEle.isDisplayed());
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//button[@id='userDataLightBox_deleteBtn']")).click();
            Thread.sleep(2000);
            Alert al = oBrowser.switchTo().alert();
            String content = al.getText();
            System.out.println(content);
            al.accept();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    private static void logout()
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
    @Test(priority = 9)
    private static void closeApplication()
    {
        try
        {
            oBrowser.quit();
        }catch (Exception e)
        {
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
    @DataProvider(name = "Createuserdata")
    public Object[][] getUserData()
    {
        return new Object[][] {{"Hanamant","Mudalagi","hanamant@gmail.com","hanamantm","han@123"}};
    }

    @DataProvider(name = "Modifyuserdata")
    public Object[][] getmodifyUserData()
    {
        return new Object[][] {{"Hanamant","Mudalagi","Pavan","Gouda"}};
    }

    @DataProvider(name = "Deleteuserdata")
    public Object[][] getdeleteUserData()
    {
        return new Object[][] {{"Pavan","Gouda"}};
    }

}

