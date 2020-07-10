package task6.screens;

import org.openqa.selenium.By;
import task6.Utilities.Browser;

public class MainMenuPage extends BasePage {

    private static final String WRITE_LETTER_BUTTON = "//span[@class='compose-button__ico']";
    private static final String INBOX_MESSAGES = "//div[@class='nav-folders']//a[@title=\"Входящие\"]";
    private static final String SENT_MESSAGES = "//div[@class='nav-folders']//a[@title=\"Отправленные\"]";
    private static final String DRAFT_MESSAGES = "//div[@class='nav-folders']//a[@title='Черновики']";
    private static final String CLOUD_LINK = "//span[@title='Облако']";

    public NewMessagePage clickWriteLetterButton() {
        browser.clickElement(By.xpath(WRITE_LETTER_BUTTON));
        return new NewMessagePage();
    }

    public MainAreaPage openInboxMessages() {
        browser.clickElement(By.xpath(INBOX_MESSAGES));
        return new MainAreaPage();
    }

    public MainAreaPage openSentMessages() {
        browser.clickElement(By.xpath(SENT_MESSAGES));
        return new MainAreaPage();
    }

    public MainAreaPage openDraftsMessages() {
        browser.clickElement(By.xpath(DRAFT_MESSAGES));
        return new MainAreaPage();
    }

    public CloudPage openCloud() {
        browser.clickElement(By.xpath(CLOUD_LINK));
        browser.switchToNewTab();
        return new CloudPage();
    }

    public MainMenuPage waitForCloudButton() {
        Browser.waitForElementToBeClickable(By.xpath(CLOUD_LINK));
        return this;
    }

    /*public WebElement getInboxMessages() {
        return inboxMessages;
    }*/
}
