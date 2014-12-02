package com.iosdriver.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 12/1/14.
 */
public class AbstractPage {
    protected RemoteWebDriver driver= ServerHelper.driver;

    protected void waitForElement(WebElement element,int TimeOut){
        new WebDriverWait(driver,TimeOut).pollingEvery(1, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitForElement(WebElement element){
        new WebDriverWait(driver,10).pollingEvery(100, TimeUnit.MILLISECONDS).until(ExpectedConditions.visibilityOf(element));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean IsElementPresent(WebElement element)
    {
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
        try
        {
            element.isDisplayed();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return true;
        }
        catch (NoSuchElementException e)
        {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return false;
        }
    }

}
