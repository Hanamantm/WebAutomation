package com.sgtesting.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecuotorDemo
{
    private static WebDriver driver=null;
    public static void main(String[] args)
    {
        launchBrowser();
        navigateURL();
        ClickCheckBox();
        ClickRadioButton();
    }

    private static void launchBrowser()
    {
        try
        {
            driver = new FirefoxDriver();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void navigateURL()
    {
        try
        {
            driver.get("file:C://HTML/Sample.html");
            Thread.sleep(4000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void ClickCheckBox()
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('chk1windows').click();");
    }
    private static void ClickRadioButton()
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('rad1chrome').click();");
    }

}
