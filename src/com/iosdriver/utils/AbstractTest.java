package com.iosdriver.utils;

import com.iosdriver.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Srikanth on 12/1/14.
 */
public class AbstractTest{

    @Rule
    public TestName testName=new TestName();

    protected RemoteWebDriver driver= ServerHelper.driver;

    @Before
    public void setUp(){
       //System.out.println(testName.getMethodName());
       TermsAndConditions tc= PageFactory.initElements(driver,TermsAndConditions.class);
       if(tc.verifyAcceptButton()){
           tc.clickAcceptButton().clickSignOnButton();
       }
    }

    @After
    public void tearDown(){
        HomePage hp= PageFactory.initElements(driver, HomePage.class);
        LoginPage lp=PageFactory.initElements(driver,LoginPage.class);
        TransactionPage tp=PageFactory.initElements(driver,TransactionPage.class);
        if((!lp.verifyLoginButton()) || (hp.verifyMenuIcon()) || (tp.verifyTitle())){
            if((tp.verifyTitle())){
                tp.clickCloseTransactionScreen();
            }
            MenuOptionsPage mp=hp.clickMenuIcon();
            mp.clickSignOffButton();
            mp.clickConfirmSignOffButton();
        }

        //To update the test case result in tm tool
        //System.out.println(testName.getMethodName());
    }


}
