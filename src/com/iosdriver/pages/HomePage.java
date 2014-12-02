package com.iosdriver.pages;

import com.iosdriver.utils.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 12/1/14.
 */
public class HomePage extends AbstractPage{

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[11]")
    private WebElement hamburgerMenuIcon;

    @FindBy(xpath = "//UIAButton[@name='Close Tutorial']")
    private WebElement closeTutorialButton;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[12]")
    private WebElement transactionButton;

    public boolean verifyMenuIcon(){
        return IsElementPresent(hamburgerMenuIcon);
    }

    public void clickCloseTutorialButton(){
        while ((!IsElementPresent(hamburgerMenuIcon)) || (IsElementPresent(closeTutorialButton))){
            if(IsElementPresent(closeTutorialButton)){
                closeTutorialButton.click();
            }
        }
    }

    public boolean verifyCloseTutorialButton(){
        return IsElementPresent(closeTutorialButton);
    }

    public MenuOptionsPage clickMenuIcon(){
        waitForElement(hamburgerMenuIcon);
        hamburgerMenuIcon.click();
        return PageFactory.initElements(driver, MenuOptionsPage.class);
    }

    public TransactionPage clickTransactionButton(){
        waitForElement(transactionButton);
        transactionButton.click();
        return PageFactory.initElements(driver,TransactionPage.class);
    }


}
