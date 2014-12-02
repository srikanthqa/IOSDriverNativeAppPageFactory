package com.iosdriver.pages;

import com.iosdriver.utils.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/1/14.
 */
public class TermsAndConditions extends AbstractPage{

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")
    private WebElement acceptButton;

    public SignOnPage clickAcceptButton(){
        acceptButton.click();
        return PageFactory.initElements(driver, SignOnPage.class);
    }

    public boolean verifyAcceptButton(){
        return IsElementPresent(acceptButton);
    }
}
