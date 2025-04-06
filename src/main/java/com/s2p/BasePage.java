package com.s2p;

import com.thread.TC;
import org.aeonbits.owner.ConfigFactory;

public class BasePage {

    private PropertyConfig config = ConfigFactory.create(PropertyConfig.class);

    /**
     * Launches the browser using the configuration specified in PropertyConfig.
     * Initializes the WebDriver instance and assigns it to the current thread.
     */
    public void launchBrowser(){
        TC.get().driver = DriverFactory.getDriver(config.getBrowser());
    }

    /**
     * Quits the browser if the WebDriver instance is not null.
     * Ensures proper cleanup of driver resources.
     */
    public void quitBrowser(){
        if(TC.get().driver !=null){
            TC.get().driver.quit();
        }

        TC.get().driver.quit();
    }

}