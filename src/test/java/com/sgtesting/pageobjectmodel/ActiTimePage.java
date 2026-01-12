package com.sgtesting.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ActiTimePage {
    private WebDriver driver;

    public ActiTimePage(WebDriver driver)
    {
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

    //User page
    @FindBy(xpath = "//a[@class='content users']//div[@class='img']")
    private WebElement userImage;

    @FindBy(xpath = "//div[@class='buttonText']")
    private WebElement addUserButton;

    //create user form
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement userDataLightBox_usernameField;
    private WebElement password;
    private WebElement passwordCopy;
    @FindBy(xpath = "//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")
    private WebElement createButton;

    //delete user
    private WebElement userDataLightBox_deleteBtn;

    //logout
    private WebElement logoutLink;

    //user save changes
    @FindBy(xpath = "//div[@id='userDataLightBox_commitBtn']//div[@class='buttonIcon']")
    private WebElement saveButton;


    //create customer
    @FindBy(xpath = "//a[@class='content tasks']")
    private WebElement task;

    @FindBy(xpath = "//div[@class='title ellipsis'][normalize-space()='Add New']")
    private WebElement addNew;

    @FindBy(xpath = "//div[@class='item createNewCustomer ellipsis']")
    private WebElement createCustomer;

    @FindBy(xpath = "//input[@id='customerLightBox_nameField']")
    private WebElement customerName;

    @FindBy(xpath = "//textarea[@id='customerLightBox_descriptionField']")
    private WebElement customerDescription;

    private WebElement customerLightBox_commitBtn;

    //delete customer
    @FindBy(xpath = "//div[@class='editButton available']")
    private WebElement editButton;

    @FindBy(xpath = "/html/body/div[12]/div[2]/div[2]/div[1]/div[4]/div/div/div[2]")
    private WebElement actionButton;

    @FindBy(xpath = "//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@id='customerPanel_deleteConfirm_submitBtn']//div[@class='buttonIcon']")
    private WebElement deletePermanent;

    //create New project
    @FindBy(xpath = "//div[@class='item createNewProject ellipsis']")
    private WebElement newProject;

    private WebElement projectPopup_projectNameField;
    private WebElement projectDescriptionField;
    @FindBy(xpath = "//span[normalize-space()='Create Project']")
    private WebElement createProject;

    //modify customer
    @FindBy(xpath = "//div[@class='nameLabel'][normalize-space()='TCS Consultancy']")
    private WebElement updateCustomer;

    @FindBy(xpath = "//div[@class='nameInput']//input[@placeholder='Enter Customer Name']")
    private WebElement enterNewCustomer;

    @FindBy(xpath = "//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='cpInfo']")
    private WebElement modify;


    //delete project
    @FindBy(xpath = "/html/body/div[12]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")
    private WebElement projectDeleteButton;

    @FindBy(xpath = "//div[@class='editProjectPanelHeader']//div[@class='actionButton']")
    private WebElement deleteActionButton;

    @FindBy(xpath = "//div[@class='edit_project_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")
    private WebElement deleteProject;

    @FindBy(xpath = "//span[@id='projectPanel_deleteConfirm_submitTitle']")
    private WebElement deleteConfirm;

    @FindBy(xpath = "//*[@id=\"taskListBlock\"]/div[4]/div[1]/div[2]/div[2]/div/div[1]")
    private WebElement modifyProject;

    @FindBy(xpath = "//div[@class='nameInput']//input[@placeholder='Enter Project Name']")
    private WebElement enterNewProject;

    @FindBy(xpath = "//*[@id=\"cpTreeBlock\"]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")
    private WebElement clickOnProject;

    public WebElement getProjectByName(String projectName) {
        return driver.findElement(
                By.xpath("//div[@class='node projectNode notSelected' and .//div[text()='" + projectName + "']]")
        );
    }
    

    //create Task

    @FindBy(xpath = "//div[contains(text(),'Add New Task')]")
    private WebElement newTask;

    @FindBy(xpath = "//div[@class='item createNewTask ellipsis']")
    private WebElement addNewTask;

    @FindBy(xpath = "//body[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
    private WebElement taskName;

    @FindBy(xpath = "//span[normalize-space()='Create Tasks']")
    private WebElement createTask;


    //delete Task
    @FindBy(xpath = "//div[@title='add wholesaler']")
    private WebElement clickOnTask;

    @FindBy(xpath = "//div[@class='header']//div[@class='actionButton']")
    private WebElement deleteTaskButton;

    @FindBy(xpath = "//div[@class='edit_task_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")
    private WebElement deleteConfirmTask;

    @FindBy(xpath = "//span[@id='taskPanel_deleteConfirm_submitTitle']")
    private WebElement submitTitle;



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

    public WebElement getUserImage() {
        return userImage;
    }

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getPasswordCopy() {
        return passwordCopy;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getUserDataLightBox_usernameField() {
        return userDataLightBox_usernameField;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getAddUserButton() {
        return addUserButton;
    }

    public WebElement getUserDataLightBox_deleteBtn() {
        return userDataLightBox_deleteBtn;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement selectUserByName(String fullName) {
        return driver.findElement(By.xpath("//span[@class='userNameSpan'][normalize-space()='" + fullName + "']"));
    }

    public WebElement getTask() {
        return task;
    }

    public WebElement getAddNew() {
        return addNew;
    }

    public WebElement getCreateCustomer() {
        return createCustomer;
    }

    public WebElement getCustomerName() {
        return customerName;
    }

    public WebElement getCustomerDescription() {
        return customerDescription;
    }

    public WebElement getCustomerLightBox_commitBtn() {
        return customerLightBox_commitBtn;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getActionButton() {
        return actionButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getDeletePermanent() {
        return deletePermanent;
    }

    public WebElement getNewProject() {
        return newProject;
    }

    public WebElement getProjectPopup_projectNameField() {
        return projectPopup_projectNameField;
    }

    public WebElement getProjectDescriptionField() {
        return projectDescriptionField;
    }

    public WebElement getCreateProject() {
        return createProject;
    }

    public WebElement getProjectDeleteButton() {
        return projectDeleteButton;
    }

    public WebElement getDeleteActionButton() {
        return deleteActionButton;
    }

    public WebElement getDeleteProject() {
        return deleteProject;
    }

    public WebElement getDeleteConfirm() {
        return deleteConfirm;
    }

    public WebElement getUpdateCustomer() {
        return updateCustomer;
    }

    public WebElement getEnterNewCustomer() {
        return enterNewCustomer;
    }

    public WebElement getModify() {
        return modify;
    }

    public WebElement getModifyProject() {
        return modifyProject;
    }

    public WebElement getClickOnProject() {
        return clickOnProject;
    }

    public WebElement getEnterNewProject() {
        return enterNewProject;
    }

    public WebElement getNewTask() {
        return newTask;
    }

    public WebElement getAddNewTask() {
        return addNewTask;
    }

    public WebElement getTaskName() {
        return taskName;
    }

    public WebElement getCreateTask() {
        return createTask;
    }

    public WebElement getClickOnTask() {
        return clickOnTask;
    }

    public WebElement getDeleteTaskButton() {
        return deleteTaskButton;
    }

    public WebElement getDeleteConfirmTask() {
        return deleteConfirmTask;
    }

    public WebElement getSubmitTitle() {
        return submitTitle;
    }
}
