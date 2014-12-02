package com.iosdriver.tests;

import com.iosdriver.pages.HomePage;
import com.iosdriver.pages.LoginPage;
import com.iosdriver.utils.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/1/14.
 */
public class TransactionTest extends AbstractTest{

    @Test
    public void testNavigationToTransactionScreen(){
        LoginPage lp= PageFactory.initElements(driver, LoginPage.class);
        lp.setUserName("jpt31_7213");
        lp.setPassword("ist123");
        HomePage hp=lp.clickLoginButton();
        hp.verifyMenuIcon();
        Assert.assertTrue(hp.clickTransactionButton().verifyTitle());
    }
}
