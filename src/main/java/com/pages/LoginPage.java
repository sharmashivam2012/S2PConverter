package com.pages;

import com.s2p.PageInitialize;
import com.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    Utils util;
    public LoginPage() {
        util = new Utils();
        // initialize all elements
    }

    // Elements using @FindBy
    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    // Actions
    public void enterUsername(String user) {
        util.enterText(username,user);
      //  username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        util.enterText(password,pass);
    //    password.sendKeys(pass);
    }

    public void clickLogin() {
        util.clickElement(loginButton);
     //   loginButton.click();
    }
}