package task6.Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task6.logger.Log;

import java.util.ArrayList;

public class Browser {
    private static WebDriver driver;
    private static Browser browser;

    private Browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
        driver = new ChromeDriver();
    }

    public static Browser getInstance() {
        if (browser == null) {
            browser = new Browser();
        }
        return browser;
    }

    public void getUrl(String url) {
        Log.logGetUrl(url);
        driver.get(url);
    }

    public void clickElement(By by) {
        Log.logClick(by);
        driver.findElement(by).click();
    }

    public void typeTo(By by, String value) {
        Log.logTypeTo(by, value);
        driver.findElement(by).sendKeys(value);
    }

    public boolean isElemenDisplayed(By by) {
        Log.logTheElementIsDisplayed(by);
        return driver.findElement(by).isDisplayed();
    }


    public String getText(By by) {
        Log.logTheText(by);
        return driver.findElement(by).getText();
    }

    public String getAttribute(By by, String attribute) {
        Log.logGetAttribute(by, attribute);
        return driver.findElement(by).getAttribute(attribute);
    }

    public WebElement getElement(By by) {
        Log.logGetElement(by);
        return driver.findElement(by);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        browser = null;
    }

    public static void waitForElementToBeClickable(By by) {
        Log.logWaitForElementToBeClickable(by);
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeDisplayed(By by) {
        Log.logWaitForElementToBeDisplayed(by);
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBePresent(By by) {
        Log.logWaitForElementToBePresent(by);
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }


}
