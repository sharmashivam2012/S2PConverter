package com.pages;

import com.utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model class representing the login page of the application.
 * Provides methods to interact with username, password fields, and login button.
 */
public class LoginPage {
    Utils util;
    public LoginPage() {
        util = new Utils();
    }


    /**
     * Username input field.
     */
    @FindBy(id = "user-name")
    WebElement username;

    /**
     * Password input field.
     */
    @FindBy(id = "password")
    WebElement password;

    /**
     * Login button element.
     */
    @FindBy(id = "login-button")
    WebElement loginButton;


    /**
     * Enters the given username into the username field.
     *
     * @param user The username to be entered.
     * @return The current instance of LoginPage.
     */
    public LoginPage enterUsername(String user) {
        util.enterText(username,user);
      return this;
    }

    /**
     * Enters the given password into the password field.
     *
     * @param pass The password to be entered.
     * @return The current instance of LoginPage.
     */
    public LoginPage enterPassword(String pass) {
        util.enterText(password,pass);
        return this;
    }

    /**
     * Clicks the login button and navigates to the HomePage.
     *
     * @return A new instance of HomePage.
     */
    public HomePage clickLogin() {
        util.clickElement(loginButton);
        return new HomePage();
    }
}