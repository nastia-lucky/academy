package task6.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task6.logger.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static String browserType;
    private static WebDriver driver;
    private static Browser browser;
    private static final int LONG_WAIT = 15;
    private static final int MIDDLE_WAIT = 15;

    private Browser() {
       /*switch (browserType) {
           case "chrome": {
               System.setProperty(
                       "webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
               driver = new ChromeDriver();
               break;
           }
           case "firefox": {
               System.setProperty(
                       "webdriver.gecko.driver", "src/main/resources/task6/geckodriver");
               driver = new FirefoxDriver();
                break;
            }
            default: {
                System.out.println("I don't know such browser type");
            }
        }*/
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
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

    public boolean isElementDisplayed(By by) {
        Log.logTheElementIsDisplayed(by);
        return driver.findElement(by).isDisplayed();
    }

    public boolean isElementsNotExist(By by) {
        Log.logTheElementIsDisplayed(by);
        return driver.findElements(by).isEmpty();
    }


    public String getText(By by) {
        Log.logTheText(by);
        return driver.findElement(by).getText();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        browser = null;
    }

    public static void waitForElementToBeClickable(By by) {
        Log.logWaitForElementToBeClickable(by);
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), LONG_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeDisplayed(By by) {
        Log.logWaitForElementToBeDisplayed(by);
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), MIDDLE_WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void switchToNewTab() {
        Log.logInfo("Switching to the new tab");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void clickElementFromArray(By by, int i) {
        Log.logClick(by);
        List<WebElement> elementsList = driver.findElements(by);
        elementsList.get(i).click();
    }

    public static void waitForElementsFromArrayIsDisplayed(By by) {
        Log.logWaitForElementToBeClickable(by);
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), LONG_WAIT);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void rightClickMouse(By by) {
        Log.logRightClickMouse(by);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.contextClick(element).perform();
    }

    public String getAttribute(By by, String name) {
        Log.logGetAttribute(by, name);
        WebElement element = driver.findElement(by);
        return element.getAttribute(name);
    }
}
