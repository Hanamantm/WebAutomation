package com.sgtesting.testngadvancescenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdvanceScenario1
{
    private static WebDriver driver = null;

    @BeforeClass
    public void launchBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"admin", "manager"},
                {"hanamantm", "abc@123"},
                {"swaroopn", "xyz@123"},
                {"shivarajm", "shiva@123"}
        };
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]{
                {"Hanamant", "Mudalagi", "dummy@gmail.com", "hanamantm", "abc@123"},
                {"swaroop", "nagatri", "swaroop@gmail.com", "swaroopn", "xyz@123"},
                {"shivaraj", "matagar", "shivaraj@gmail.com", "shivarajm", "shiva@123"}
        };
    }

    @Test(priority = 1)
    public void navigateToUrl() throws Exception {
        driver.get("http://localhost/login.do");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Login"), "Page title mismatch!");
    }

    @Test(priority = 2, dataProvider = "loginData")
    public void loginAndLogout(String username, String password) throws Exception {
        login(username, password);
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='logoutLink']")).isDisplayed(), "Login failed for user: " + username);
        logout();
    }

    @Test(priority = 3, dataProvider = "userData")
    public void createUserTest(String fn, String ln, String email, String uname, String pwd) throws Exception {
        login("admin", "manager");
        minimizeFlyoutWindow();
        createUser(fn, ln, email, uname, pwd);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + ln + ", " + fn + "']")).isDisplayed(),
                "User creation failed for: " + uname);
        logout();
    }

    @Test(priority = 4)
    public void modifyPasswordTest() throws Exception {
        login("admin", "manager");
        modifyUserPassword("Mudalagi, Hanamant", "hym@123");
        logout();

        login("hanamantm", "hym@123");
        modifyUserPassword("nagatri, swaroop", "swa@123");
        logout();

        login("swaroopn", "swa@123");
        modifyUserPassword("matagar, shivaraj", "s@123");
        logout();
    }

    @Test(priority = 5)
    public void deleteUserTest() throws Exception {
        login("swaroopn", "swa@123");
        deleteUser("matagar, shivaraj");
        logout();

        login("hanamantm", "hym@123");
        deleteUser("nagatri, swaroop");
        logout();

        login("admin", "manager");
        deleteUser("Mudalagi, Hanamant");
        logout();
    }

    // ---------------------- Helper Methods ----------------------

    private void login(String username, String password) throws Exception {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("pwd")).clear();
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(2000);
        if (driver.findElements(By.xpath("//div[@class='startExploringLink']")).size() > 0) {
            driver.findElement(By.xpath("//div[@class='startExploringLink']")).click();
            Thread.sleep(1000);
        }
    }

    private void logout() throws Exception {
        driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
        Thread.sleep(1000);
    }

    private void minimizeFlyoutWindow() {
        try {
            driver.findElement(By.id("gettingStartedShortcutsPanelId")).click();
        } catch (Exception ignored) {}
    }

    private void createUser(String fn, String ln, String email, String uname, String pwd) throws Exception {
        driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
        driver.findElement(By.xpath("//div[@class='buttonText']")).click();
        driver.findElement(By.name("firstName")).sendKeys(fn);
        driver.findElement(By.name("lastName")).sendKeys(ln);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("username")).sendKeys(uname);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.name("passwordCopy")).sendKeys(pwd);
        driver.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")).click();
        Thread.sleep(2000);
    }

    private void modifyUserPassword(String fullName, String newPwd) throws Exception {
        driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
        driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("userDataLightBox_passwordField")).clear();
        driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys(newPwd);
        driver.findElement(By.id("userDataLightBox_passwordCopyField")).clear();
        driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys(newPwd);
        driver.findElement(By.id("userDataLightBox_commitBtn")).click();
        Thread.sleep(2000);
    }

    private void deleteUser(String fullName) throws Exception {
        driver.findElement(By.xpath("//a[@class='content users']//div[@class='img']")).click();
        driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("userDataLightBox_deleteBtn")).click();
        Alert oAlert = driver.switchTo().alert();
        oAlert.accept();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']")).isEmpty(),
                "User not deleted: " + fullName);
    }
}



