package com.iosdriver.tests;

import com.iosdriver.pages.*;
import com.iosdriver.utils.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/1/14.
 */
public class UserLoginTest extends AbstractTest{

    @Test
    public void testUserLogin(){
        LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
        lp.setUserName("jpt31_7213");
        lp.setPassword("ist123");
        HomePage hp=lp.clickLoginButton();
        hp.clickCloseTutorialButton();
        hp.verifyMenuIcon();
    }

    @Test
    public void testUserLoginWithValidCredentials(){
        LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
        lp.setUserName("jpt31_7213");
        lp.setPassword("ist123");
        HomePage hp=lp.clickLoginButton();
        hp.clickCloseTutorialButton();
        Assert.assertTrue(hp.verifyMenuIcon());
    }
}
