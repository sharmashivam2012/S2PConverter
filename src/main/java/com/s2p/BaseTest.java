package com.s2p;

import com.thread.TC;
import com.thread.ThreadInstance;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    BasePage basePage = new BasePage();

    /**
     * Initializes the thread-local test context.
     * This method runs once before any tests in the suite.
     */
    @BeforeSuite
    public void setUp(){
        TC.set(ThreadInstance.createInstance());
    }

    /**
     * Launches the browser before each test method.
     */
    @BeforeMethod
    public void setUpBrowser(){
        basePage.launchBrowser();
    }

    /**
     * Terminates the test setup by quitting the browser.
     * This method runs after each test method.
     */
    @AfterMethod
    public void terminateSetup(){
        basePage.quitBrowser();
    }


}