package com.s2p;

import com.pages.LoginPage;
import com.thread.TC;
import org.openqa.selenium.support.PageFactory;

/**
 * Utility class for initializing Page Object classes using Selenium PageFactory.
 * Ensures WebElement fields are initialized with the current WebDriver instance.
 */

public class PageInitialize {

    /**
     * Initializes the given Page Object class using PageFactory.
     *
     * @param clazz The Page Object class to initialize.
     * @param <T>   The type of the Page Object.
     * @return An initialized instance of the Page Object class.
     */
    private static <T> T initPage(final Class<T> clazz){
        try {
            T pageInstance =  clazz.getDeclaredConstructor().newInstance();  // create object of the class
            PageFactory.initElements(TC.get().driver, pageInstance);        // initialize web elements
            return pageInstance;
        } catch (Exception e) {
            throw new RuntimeException("Page Initialization failed for class: " + clazz.getName(), e);
        }
    }

    /**
     * Provides an initialized instance of LoginPage.
     *
     * @return A LoginPage object with initialized WebElements.
     */
    public static LoginPage loginPage(){
        return initPage(LoginPage.class);
    }


}