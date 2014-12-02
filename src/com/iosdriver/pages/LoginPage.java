package com.iosdriver.pages;

import com.iosdriver.utils.AbstractPage;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 12/1/14.
 */
public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[2]/UIATextField[1]")
    private WebElement usernameEdit;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[3]/UIASecureTextField[1]")
    private WebElement passwordEdit;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]")
    private WebElement loginButton;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
    private WebElement backButton;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")
    private WebElement checkboxRememberID;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[3]")
    private WebElement errorText;

    public void setUserName(String username){
        waitForElement(usernameEdit);
        usernameEdit.sendKeys(username);
    }

    public void setPassword(String password){
        passwordEdit.sendKeys(password);
    }

    public HomePage clickLoginButton(){
        loginButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public boolean verifyLoginButton(){
        return IsElementPresent(loginButton);
    }

    public void userLogin(String username,String password){
        usernameEdit.sendKeys(username);
        passwordEdit.sendKeys(password);
        loginButton.click();
    }

    public SignOnPage clickBackButton(){
        backButton.click();
        return PageFactory.initElements(driver,SignOnPage.class);
    }

    public void checkRememberID(){
        checkboxRememberID.click();
    }

    public boolean verifyErrorMessage(){
        return IsElementPresent(errorText);
    }
}
