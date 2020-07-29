package task6.screens;

import org.openqa.selenium.By;
import task6.logger.Log;
import task6.utilities.Browser;

public class MainMenuPage extends BasePage {

    private static final String WRITE_LETTER_BUTTON = "//span[@class='compose-button__ico']";
    private By letterButton = By.xpath(WRITE_LETTER_BUTTON);
    private static final By INBOX_MESSAGES = By.xpath("//a[@title='Входящие']");
    private static final By SENT_MESSAGES = By.xpath("//div[@class='nav-folders']//a[@title='Отправленные']");
    private static final By DRAFT_MESSAGES = By.xpath("//div[@class='nav-folders']//a[@title='Черновики']");
    private static final By CLOUD_LINK = By.xpath("//span[@title='Облако']");
    private static final By MESSAGE_ITEM = By.xpath("//div[@class='llc__content']");

    public NewMessagePage clickWriteLetterButton() {
        Log.logInfo("Clicking 'Write Letter' button");
        Browser.waitForElementToBeClickable(letterButton);
        browser.clickElement(letterButton);
        return new NewMessagePage();
    }

    public MainAreaPage openInboxMessages() {
        Log.logInfo("Opening inbox messages");
        browser.clickElement(INBOX_MESSAGES);
        Browser.waitForElementsFromArrayIsDisplayed(MESSAGE_ITEM);
        return new MainAreaPage();
    }

    public MainAreaPage openSentMessages() {
        Log.logInfo("Opening sent messages");
        browser.clickElement(SENT_MESSAGES);
        Browser.waitForElementsFromArrayIsDisplayed(MESSAGE_ITEM);
        return new MainAreaPage();
    }

    public MainAreaPage openDraftsMessages() {
        Log.logInfo("Opening drafts messages");
        browser.clickElement(DRAFT_MESSAGES);
        Browser.waitForElementsFromArrayIsDisplayed(MESSAGE_ITEM);
        return new MainAreaPage();
    }

    public CloudPage openCloud() {
        Log.logInfo("Opening cloud");
        Browser.waitForElementToBeDisplayed(CLOUD_LINK);
        browser.clickElement(CLOUD_LINK);
        browser.switchToNewTab();
        return new CloudPage();
    }
}
