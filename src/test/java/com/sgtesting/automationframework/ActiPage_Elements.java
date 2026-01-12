package com.sgtesting.automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiPage_Elements
{
    private WebDriver driver=null;

    public ActiPage_Elements(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //login page
    private WebElement username;
    private WebElement pwd;
    @FindBy(xpath = "//div[normalize-space()='Login']")
    private WebElement submitButton;

    //After login
    private WebElement gettingStartedShortcutsPanelId;

    @FindBy(xpath = "//td[text()='Enter Time-Track']")
    private WebElement homeTitle;

    //create Users

    //create users
    @FindBy(xpath = "//a[@class='content users']//div[@class='img']")
    private WebElement crateUsersImage;

    @FindBy(xpath = "//span[text()='User List']")
    private WebElement userList;

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
    public WebElement selectUserByName(String fullName) {
        return driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']"));
    }

    //delete Users
    private WebElement userDataLightBox_deleteBtn;

    @FindBy(xpath = "//input[@id='userDataLightBox_passwordField']")
    private WebElement updatePassword;

    @FindBy(xpath = "//input[@id='userDataLightBox_passwordCopyField']")
    private WebElement copyPassword;

    @FindBy(xpath = "//div[@id='userDataLightBox_commitBtn']")
    private WebElement saveChanges;

    @FindBy(xpath = "//div[@class='userDataLightBox']")
    private WebElement  userDataLightBox;

    public WebElement getUpdatePassword() {
        return updatePassword;
    }

    public WebElement getCopyPassword() {
        return copyPassword;
    }

    public WebElement getSaveChanges() {
        return saveChanges;
    }

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

    public WebElement getHomeTitle() {
        return homeTitle;
    }

    public WebElement getCrateUsersImage() {
        return crateUsersImage;
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

    public WebElement getUserList() {
        return userList;
    }

    public WebElement getUserDataLightBox_deleteBtn() {
        return userDataLightBox_deleteBtn;
    }

    public WebElement getUserDataLightBox() {
        return userDataLightBox;
    }
}
