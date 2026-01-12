package com.sgtesting.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTask_DeleteTask
{
    private static WebDriver driver = null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateToUrl();
        login();
        minimizeFlyoutWindow();
        createCustomer();
        createProject();
        createTask();
        deleteTask();
        deleteProject();
        deleteCustomer();
        logout();
        closeBrowser();
    }

    private static void launchBrowser()
    {
        try
        {
            driver=new FirefoxDriver();
            /*driver=new ChromeDriver();
            driver.manage().window().maximize();*/

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateToUrl()
    {
        try
        {
            driver.get("http://localhost/login.do");
            Thread.sleep(2000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void minimizeFlyoutWindow()
    {
        try
        {
            driver.findElement(By.id("gettingStartedShortcutsPanelId")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void login()
    {
        try
        {
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("pwd")).sendKeys("manager");
            driver.findElement(By.id("loginButton")).click();
            Thread.sleep(4000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createCustomer()
    {
        try
        {
            driver.findElement(By.xpath("//a[@class='content tasks']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='title ellipsis'][normalize-space()='Add New']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("customerLightBox_nameField")).sendKeys("TCS consultancy");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@id='customerLightBox_descriptionField']")).sendKeys("Awaiting project report");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='customerLightBox_commitBtn']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createProject()
    {
        try
        {
            driver.findElement(By.xpath("//div[@class='title ellipsis'][normalize-space()='Add New']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='item createNewProject ellipsis']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='projectPopup_projectNameField']")).sendKeys("ChargeBack");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@id='projectPopup_projectDescriptionField']")).sendKeys("It is medical domain");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='projectPopup_commitBtn']//div[@class='buttonIcon']")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createTask()
    {
        try
        {
            driver.findElement(By.xpath("//div[contains(text(),'Add New Task')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='item createNewTask ellipsis']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//body[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).sendKeys("add wholesaler");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[normalize-space()='Create Tasks']")).click();
            Thread.sleep(2000);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteTask()
    {
        try
        {
            driver.findElement(By.xpath("//div[@title='add wholesaler']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='header']//div[@class='actionButton']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='edit_task_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@id='taskPanel_deleteConfirm_submitTitle']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void deleteProject()
    {
        try
        {
            driver.findElement(By.xpath("(//div[@class='editButton available'])[2]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='editProjectPanelHeader']//div[@class='actionButton']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='edit_project_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@id='projectPanel_deleteConfirm_submitTitle']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteCustomer()
    {
        try
        {

            driver.findElement(By.xpath("//div[@class='editButton available']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='actionButton']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel']//div[@class='title'][normalize-space()='Delete']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='customerPanel_deleteConfirm_submitBtn']//div[@class='buttonIcon']")).click();
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
            driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
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
