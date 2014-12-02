package com.iosdriver.pages;

import com.iosdriver.utils.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/1/14.
 */
public class SignOnPage extends AbstractPage{

    @FindBy(name = "Sign on")
    private WebElement signOnButton;

    public LoginPage clickSignOnButton(){
        signOnButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
