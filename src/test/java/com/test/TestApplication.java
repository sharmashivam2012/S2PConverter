package com.test;

import com.pages.LoginPage;
import com.s2p.BaseTest;
import com.s2p.LoginData;
import com.s2p.PageInitialize;
import com.s2p.TestDataProvider;
import com.thread.TC;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestApplication extends BaseTest {
    LoginPage login ;


    @BeforeMethod
    public void setup() {
       login = PageInitialize.loginPage();
        TC.get().driver.get("https://www.saucedemo.com/");

    }

    @Test(dataProvider = "csvLoginData", dataProviderClass = TestDataProvider.class)
    public void testLoginStandard(LoginData data) {
        login.enterUsername(data.getUsername());
        login.enterPassword(data.getPassword());
        login.clickLogin();
        Assert.assertTrue(TC.get().driver.getCurrentUrl().contains("inventory"));
    }

    @Test(dataProvider = "csvLoginData", dataProviderClass = TestDataProvider.class)
    public void testLoginLockedOut(LoginData data) {
        login.enterUsername(data.getUsername());
        login.enterPassword(data.getPassword());
        login.clickLogin();
        Assert.assertTrue(TC.get().driver.getPageSource().contains("locked out"));
    }

    @Test(dataProvider = "csvLoginData", dataProviderClass = TestDataProvider.class)
    public void testLoginProblemUser(LoginData data) {
        login.enterUsername(data.getUsername());
        login.enterPassword(data.getPassword());
        login.clickLogin();
        Assert.assertTrue(TC.get().driver.getPageSource().contains("inventory"));
    }

}