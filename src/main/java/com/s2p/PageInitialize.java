package com.s2p;

import com.pages.LoginPage;
import com.thread.TC;
import org.openqa.selenium.support.PageFactory;

public class PageInitialize {

    private static <T> T initPage(final Class<T> clazz){
        try {
            T pageInstance =  clazz.getDeclaredConstructor().newInstance();  // create object of the class
            PageFactory.initElements(TC.get().driver, pageInstance);        // initialize web elements
            return pageInstance;
        } catch (Exception e) {
            throw new RuntimeException("Page Initialization failed for class: " + clazz.getName(), e);
        }
    }

    public static LoginPage loginPage(){
        return initPage(LoginPage.class);
    }


}