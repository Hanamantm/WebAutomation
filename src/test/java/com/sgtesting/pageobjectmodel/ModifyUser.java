package com.sgtesting.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ModifyUser {
    private static WebDriver driver = null;
    private static ActiTimePage page = null;

    public static void main(String[] args) {
        launchBrowser();
        navigateToUrl();
        login();
        minimizeFlyoutWindow();
        createUser();
        modifyUser("Mudalagi, Hanamant", "Pavan", "Gouda");
        deleteUser("Gouda, Pavan");
        logout();
        closeBrowser();
    }

    private static void launchBrowser() {
        try {
            driver = new FirefoxDriver();
            page = new ActiTimePage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateToUrl() {
        try {
            driver.navigate().to("http://localhost/login.do");
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void login() {
        try {
            page.getUsername().sendKeys("admin");
            page.getPwd().sendKeys("manager");
            page.getSubmitButton().click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void minimizeFlyoutWindow() {
        try {
            page.getGettingStartedShortcutsPanelId().click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createUser() {
        try {
            page.getUserImage().click();
            Thread.sleep(1000);
            page.getAddUserButton().click();
            Thread.sleep(1000);
            page.getFirstName().sendKeys("Hanamant");
            page.getLastName().sendKeys("Mudalagi");
            page.getEmail().sendKeys("hanamant@gmail.com");
            page.getUserDataLightBox_usernameField().sendKeys("Hanamantm");
            page.getPassword().sendKeys("abc@123");
            page.getPasswordCopy().sendKeys("abc@123");
            page.getCreateButton().click();
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void modifyUser(String oldName, String newFirstName, String newLastName) {
        try {
            page.selectUserByName(oldName).click();
            Thread.sleep(2000);
            page.getFirstName().clear();
            page.getFirstName().sendKeys(newFirstName);
            Thread.sleep(2000);
            page.getLastName().clear();
            page.getLastName().sendKeys(newLastName);
            Thread.sleep(2000);
            page.getSaveButton().click();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser(String fullName) {
        try {
            page.selectUserByName(fullName).click();
            Thread.sleep(1000);
            page.getUserDataLightBox_deleteBtn().click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void logout() {
        try {
            page.getLogoutLink().click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
