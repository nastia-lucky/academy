package task6.logger;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Log {

    private static Logger logger = Logger.getLogger("My Logger");

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logClick(By by) {
        logger.debug(String.format("Click element located: [%s]", by));
    }

    public static void logGetUrl(String url) {
        logger.debug(String.format("Open page by URL : [%s]", url));
    }

    public static void logTypeTo(By by, String value) {
        logger.debug(String.format("Type [%s] to element located [%s]", value, by));
    }

    public static void logTheElementIsDisplayed(By by) {
        logger.debug(String.format("The next element is displayed [%s]", by));
    }

    public static void logTheText(By by) {
        logger.debug(String.format("The text has been got by locator [%s]", by));
    }

    public static void logGetAttribute(By by, String attribute) {
        logger.debug(String.format("The attribute [%s] has been got from locator [%s]", attribute, by));
    }

    public static void logWaitForElementToBeClickable(By by) {
        logger.debug(String.format("Wait for the element [%s] is clickable", by));
    }

    public static void logWaitForElementToBeDisplayed(By by) {
        logger.debug(String.format("Wait for the element [%s] is displayed", by));
    }

    public static void logRightClickMouse(By by) {
        logger.debug(String.format("Right click mouse on the element [%s]", by));
    }
}
