package com.sgtesting.pomadvancedscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiPage
{
    private WebDriver driver;
    public ActiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login Page
    private WebElement username;
    private WebElement pwd;
    @FindBy(xpath = "//div[normalize-space()='Login']")
    private WebElement submitButton;

    //After login
    private WebElement gettingStartedShortcutsPanelId;

    //create users
    @FindBy(xpath = "//a[@class='content users']//div[@class='img']")
    private WebElement crateUsers;

    private WebElement logoutLink;

    @FindBy(xpath = "//div[@class='startExploringLink']")
    private WebElement exploreLink;


    @FindBy(xpath = "//div[@class='buttonText']")
    private WebElement clickAddUser;

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private  WebElement userDataLightBox_usernameField;
    private WebElement password;
    private  WebElement passwordCopy;
    @FindBy(xpath = "//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")
    private WebElement creteUserButton;

    //modify users
    @FindBy(xpath = "//a[@class='content users']//div[@class='img']")
    private WebElement modify;

    public void clickUserFullName(String fullName) {
        WebElement user = driver.findElement(
                By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']")
        );
        user.click();
    }

    @FindBy(xpath = "//input[@id='userDataLightBox_passwordField']")
    private WebElement updatePassword;

    @FindBy(xpath = "//input[@id='userDataLightBox_passwordCopyField']")
    private WebElement copyPassword;

    @FindBy(xpath = "//div[@id='userDataLightBox_commitBtn']")
    private WebElement saveChanges;

    //delete users
    @FindBy(xpath = "//a[@class='content users']//div[@class='img']")
    private WebElement deleteUsers;

    public void UserFullName(String deleteUser) {
        WebElement user = driver.findElement(
                By.xpath("//span[@class='userNameSpan'][normalize-space()='" + deleteUser + "']")
        );
        user.click();
    }
    @FindBy(xpath = "//button[@id='userDataLightBox_deleteBtn']")
    private WebElement deleteButton;




    public WebElement getUsername() {
        return username;
    }

    public WebElement getPwd() {
        return pwd;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getGettingStartedShortcutsPanelId() {
        return gettingStartedShortcutsPanelId;
    }

    public WebElement getCrateUsers() {
        return crateUsers;
    }

    public WebElement getClickAddUser() {
        return clickAddUser;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getUserDataLightBox_usernameField() {
        return userDataLightBox_usernameField;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPasswordCopy() {
        return passwordCopy;
    }

    public WebElement getCreteUserButton() {
        return creteUserButton;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    public WebElement getExploreLink() {
        return exploreLink;
    }

    public WebElement getModify() {
        return modify;
    }

    public WebElement getUpdatePassword() {
        return updatePassword;
    }

    public WebElement getCopyPassword() {
        return copyPassword;
    }

    public WebElement getSaveChanges() {
        return saveChanges;
    }

    public WebElement getDeleteUsers() {
        return deleteUsers;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }
}
