package com.iosdriver.testsuites;

import com.iosdriver.tests.TransactionTest;
import com.iosdriver.tests.UserLoginTest;
import com.iosdriver.tests.UserLogoutTest;
import com.iosdriver.utils.ServerHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.uiautomation.ios.IOSCapabilities;

/**
 * Created by Srikanth on 12/1/14.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({UserLoginTest.class, UserLogoutTest.class, TransactionTest.class})
public class AllTestSuiteRunner {

    static ServerHelper server=new ServerHelper();

    @BeforeClass
    public static void setUpEnvironment() throws Exception {
        server.startIOSServer();
        server.startDriver();
    }

    @AfterClass
    public static void tearDownEnvironment(){
        server.stopDriver();
        server.stopIOSServer();
    }
}
