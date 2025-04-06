package com.s2p;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface PropertyConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

}