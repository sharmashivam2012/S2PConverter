package com.s2p;

import com.thread.TC;
import com.thread.ThreadInstance;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    BasePage basePage = new BasePage();

    @BeforeSuite
    public void setUp(){

        TC.set(ThreadInstance.createInstance());
    }

    @BeforeMethod
    public void setUpBrowser(){
        basePage.launchBrowser();
    }

    @AfterMethod
    public void terminateSetup(){
        basePage.quitBrowser();
    }


}