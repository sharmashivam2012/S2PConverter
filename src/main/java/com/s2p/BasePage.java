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


    public void method1(){
        System.out.println("Method-1");
    }

    public void method2(){
        System.out.println("Method-2");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
     BasePage p =    BasePage.class.getDeclaredConstructor().newInstance();
     p.method1();
    }
}