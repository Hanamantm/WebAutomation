package com.sgtesting.importtask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ImportTaskDemo
{
    private static WebDriver oBrowser=null;
    public static void main(String[] args) {
        launchBrowser();
        navigate();
        login();
        minimizeFlyOutwindow();
        impostTask();
        deleteTask();
    }

    private static void launchBrowser()
    {
        try
        {
            oBrowser=new FirefoxDriver();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigate()
    {
        try
        {
            oBrowser.get("http://localhost/login.do");
            Thread.sleep(2000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void login()
    {
        try
        {
            oBrowser.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
            oBrowser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("manager");
            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

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

    private static void impostTask()
    {
        try
        {
            oBrowser.findElement(By.xpath("//a[@class='content tasks']//div[@class='img']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[contains(text(),'Add New Task')]")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[@class='item importTasks ellipsis']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.id("dropzoneClickableArea")).click();
            Thread.sleep(2000);
            String fileName ="C:\\Example\\Sample.csv";
            copyFile(fileName);
            Robot robot= new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);

            oBrowser.findElement(By.xpath("//span[@class='buttonTitle']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("(//div[@id='closeLoadTasksFromCSVPopupButton'])[1]")).click();
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
            oBrowser.findElement(By.xpath("//body[1]/div[12]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]")).click();
            Thread.sleep(2000);
            //oBrowser.findElement(By.xpath("(//div[@class='deleteButton'])[1]")).click();
            WebDriverWait wait= new WebDriverWait(oBrowser, Duration.ofSeconds(10));
            WebElement deleteBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='deleteButton'])[1]")));
            ((JavascriptExecutor) oBrowser).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
            Thread.sleep(500);
            ((JavascriptExecutor) oBrowser).executeScript("arguments[0].click();", deleteBtn);
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//span[@id='deleteTaskPopup_deleteConfirm_submitTitle']")).click();
            Thread.sleep(2000);
            System.out.println("Task deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String fileName)
    {
        StringSelection selection=new StringSelection(fileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
    }
}
