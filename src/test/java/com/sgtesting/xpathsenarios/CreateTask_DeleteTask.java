package com.sgtesting.xpathsenarios;

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
        createCustomer("TCS consultancy","Awaiting for Reports");
        createProject("ChargeBack", "It is medical domain");
        createTask("add wholesaler");
        deleteTask("add wholesaler");
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
            driver.findElement(By.xpath("//div[@id='gettingStartedShortcutsPanelId']")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void login()
    {
        try
        {
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
            driver.findElement(By.xpath("//div[text()='Login ']")).click();
            Thread.sleep(4000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createCustomer(String createCustomer, String description)
    {
        try
        {
            driver.findElement(By.xpath("//div[text()='TASKS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Add New']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='customerLightBox_nameField']")).sendKeys(createCustomer);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@id='customerLightBox_descriptionField']")).sendKeys(description);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void createProject(String projectName, String description)
    {
        try
        {
            driver.findElement(By.xpath("//div[text()='Add New']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='projectPopup_projectNameField']")).sendKeys(projectName);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@name='projectDescriptionField']")).sendKeys(description);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Create Project']")).click();
            Thread.sleep(2000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void createTask(String taskname)
    {
        try
        {
            driver.findElement(By.xpath("(//div[contains(text(),'Add New Task')])[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Create new tasks']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[1]   ")).sendKeys(taskname);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Create Tasks']")).click();
            Thread.sleep(2000);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteTask(String task)
    {
        try
        {
            driver.findElement(By.xpath("(//div[@title='"+task+"'])[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='actionButton'])[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='title'][normalize-space()='Delete'])[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
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
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='action'][normalize-space()='ACTIONS'])[3]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='title'][normalize-space()='Delete'])[3]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//span[@id='projectPanel_deleteConfirm_submitTitle'])[1]")).click();
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
            driver.findElement(By.xpath("//div[text()='ACTIONS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void logout()
    {
        try
        {
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
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
