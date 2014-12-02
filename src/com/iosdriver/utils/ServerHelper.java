package com.iosdriver.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.uiautomation.ios.IOSCapabilities;
import org.uiautomation.ios.IOSServer;
import org.uiautomation.ios.IOSServerConfiguration;
import org.uiautomation.ios.client.uiamodels.impl.RemoteIOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 12/1/14.
 */
public class ServerHelper {

    private final String[] args = {"-port", "4444", "-host", "localhost","-aut",System.getProperty("user.dir")+"/resources/R1GM225V05SIT.app"};
    private final IOSServerConfiguration config = IOSServerConfiguration.create(args);
    private final String url = "http://" + config.getHost() + ":" + config.getPort() + "/wd/hub";
    public static RemoteWebDriver driver=null;
    private IOSServer server;
    private String AppName="R1GM225V05SIT";
    private int TimeOut=20;

    public void startIOSServer() throws Exception {
        server = new IOSServer(config);
        server.start();
    }

    public void stopIOSServer() {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                System.err.println("cannot stop IOServer propery: " + e);
            }
            server = null;
        }
    }

    public void startDriver(IOSCapabilities cap){
        stopDriver();
        try {
            driver=new RemoteWebDriver(new URL(url),cap);
            driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void startDriver(){
        stopDriver();
        try {
            driver=new RemoteWebDriver(new URL(url),getCapabilities());
            driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void stopDriver(){
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("cannot quit properly: " + e.getMessage());
            }
            driver = null;
        }
    }

    public final RemoteWebDriver getDriver(IOSCapabilities cap) {
        driver = new RemoteWebDriver(getRemoteURL(), cap);
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        return driver;
    }

    public final URL getRemoteURL() {
        try {
            URL remote = new URL("http://" + config.getHost() + ":" + config.getPort() + "/wd/hub");
            return remote;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public IOSCapabilities getCapabilities(){
        IOSCapabilities cap=IOSCapabilities.iphone(AppName);
        cap.setCapability(IOSCapabilities.LANGUAGE,"en-US");
        cap.setCapability(IOSCapabilities.SIMULATOR,true);
        return cap;
    }

}
