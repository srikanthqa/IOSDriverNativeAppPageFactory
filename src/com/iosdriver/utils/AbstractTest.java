package com.iosdriver.utils;

import com.iosdriver.pages.HomePage;
import com.iosdriver.pages.LoginPage;
import com.iosdriver.pages.MenuOptionsPage;
import com.iosdriver.pages.TermsAndConditions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/1/14.
 */
public class AbstractTest{

    protected RemoteWebDriver driver= ServerHelper.driver;

    @Before
    public void setUp(){
       TermsAndConditions tc= PageFactory.initElements(driver,TermsAndConditions.class);
       if(tc.verifyAcceptButton()){
           tc.clickAcceptButton().clickSignOnButton();
       }
    }

    @After
    public void tearDown(){
        HomePage hp= PageFactory.initElements(driver, HomePage.class);
        LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
        if((!lp.verifyLoginButton()) || (hp.verifyMenuIcon())){
            MenuOptionsPage mp=hp.clickMenuIcon();
            mp.clickSignOffButton();
            mp.clickConfirmSignOffButton();
        }
    }


}
