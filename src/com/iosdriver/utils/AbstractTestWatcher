package com.kroger.utils;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by srikanthvejendla on 12/19/14.
 */
public class AbstractTestWatcher extends TestWatcher{

    @Override
    protected void failed(Throwable e, Description description) {
        //System.out.println(description);
        System.out.println(description.getTestClass().getSimpleName());
        System.out.println(description.getMethodName());
        System.out.println("Test Failed");
    }

    @Override
    protected void succeeded(Description description){
        System.out.println(description);
        System.out.println("Test Passed");
    }

    @Override
    protected void starting(Description description) {
        System.out.println("Test Starting");
    }

    @Override
    protected void finished(Description description) {
        System.out.println("Test Finished");
    }
}
