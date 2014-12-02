package com.iosdriver.pages;

import com.iosdriver.utils.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srikanth on 12/1/14.
 */
public class TransactionPage extends AbstractPage{

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[@name='Make a Transaction']")
    private WebElement screenTitle;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
    private WebElement closeTransactionScreen;

    public boolean verifyTitle(){
        return IsElementPresent(screenTitle);
    }

    public void clickCloseTransactionScreen(){
        closeTransactionScreen.click();
    }
}
