package com.s2p;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    /**
     * Returns a WebDriver instance based on the provided browser name.
     *
     * @param browserName The name of the browser (e.g., "chrome", "safari").
     * @return A corresponding WebDriver instance.
     * @throws IllegalArgumentException if the browser name is not supported.
     */
    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}