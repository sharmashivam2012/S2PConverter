package com.s2p;

import com.thread.TC;
import org.aeonbits.owner.ConfigFactory;

import java.lang.reflect.InvocationTargetException;

public class BasePage {

    private PropertyConfig config = ConfigFactory.create(PropertyConfig.class);

    public void launchBrowser(){
        TC.get().driver = DriverFactory.getDriver(config.getBrowser());

    }

    public void quitBrowser(){
        if(TC.get().driver !=null){
            TC.get().driver.quit();
        }

        TC.get().driver.quit();
    }

}