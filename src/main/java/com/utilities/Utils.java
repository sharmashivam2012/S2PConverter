package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thread.TC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static final Logger logger = LoggerFactory.getLogger(Utils.class);
    private WebDriverWait wait;

    public Utils() {
        this.wait = new WebDriverWait(TC.get().driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for an element to be visible using the default timeout.
     *
     * @param locator The locator of the element
     * @return WebElement once visible
     */
    public WebElement waitForElementToBeVisible(By locator) {
        logger.info("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeVisible(WebElement locator) {
        logger.info("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    /**
     * Waits for an element to be visible using a custom timeout.
     *
     * @param locator The locator of the element
     * @param seconds Custom timeout in seconds
     * @return WebElement once visible
     */
    public WebElement waitForElementToBeVisible(By locator, long seconds) {
        logger.info("Waiting for element to be visible with timeout {}s: {}", seconds, locator);
        WebDriverWait customWait = new WebDriverWait(TC.get().driver, Duration.ofSeconds(seconds));
        return customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Clicks on the element found by the locator.
     *
     * @param locator The locator of the element
     */
    public void clickElement(By locator) {
        logger.info("Clicking element: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.click();
    }

    public void clickElement(WebElement locator) {
        logger.info("Clicking element: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.click();
    }

    /**
     * Clears the input field and enters text.
     *
     * @param locator The locator of the element
     * @param text The text to enter
     */
    public void enterText(By locator, String text) {
        logger.info("Entering text into element: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void enterText(WebElement locator, String text) {
        logger.info("Entering text into element: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Returns the visible text of an element.
     *
     * @param locator The locator of the element
     * @return Text content of the element
     */
    public String getElementText(By locator) {
        logger.info("Getting text from element: {}", locator);
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();
    }

    /**
     * Checks if an element is present on the page.
     *
     * @param locator The locator of the element
     * @return true if element is present, false otherwise
     */
    public boolean isElementPresent(By locator) {
        logger.info("Checking presence of element: {}", locator);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            logger.warn("Element not found: {}", locator);
            return false;
        }
    }
}