package task6.screens;

import org.openqa.selenium.By;
import task6.logger.Log;
import task6.utilities.Browser;

public class MainAreaPage extends MainMenuPage {

    private static final By FIRST_ITEM_LOCATOR = By.xpath("//div[@class='llc__content']");
    private static final By SUBJECT_ELEMENT = By.xpath("//h2[@class='thread__subject']");
    private static final By EMPTY_SUBJECT_INBOX_MESSAGE = By.xpath("//div[@class='thread__subject-line']//h2[contains(text(), 'Без темы')]");
    private static final By EMPTY_SUBJECT_SENT_MESSAGE = By.xpath("//div[@class='thread__subject-line']//h2[contains(text(), 'Self:')]");
    private static final By SENDER_MESSAGE = By.xpath("//div[@class='letter__author']/span[@title]");
    private static final By RECEPIENT_MESSAGE = By.xpath("//div[@class='letter__recipients letter__recipients_short']//span[@class='letter-contact']");
    private static final By USER_NAME = By.xpath("//i[@id='PH_user-email']");
    private static final By EXIT_BUTTON = By.xpath("//a[@id='PH_logoutLink']");
    private static final String TITLE_ATTRIBUTE = "title";
    private static final By BUTTON_PICK = By.xpath("//button[contains(@class, 'll-av_size_common')]");
    private static final By DELETE_BUTTON = By.xpath("//span[@title='Удалить']");
    private static final By SELECT_ALL = By.xpath("//span[@title='Выделить все']");
    private static final By DELETE_ALL_SUBMIT_BUTTON = By.xpath("//span[text()='Очистить']//parent::span[@class='button2__wrapper']");
    private static final By MESSAGE_ITEM = By.xpath("//div[@class='llc__content']");
    private static final By EMPTY_MESSAGES_ICON = By.xpath("//div[@class='octopus octopus_full']");

    public MainAreaPage openFirstItem() {
        Log.logInfo("Opening first item");
        Browser.waitForElementToBeDisplayed(FIRST_ITEM_LOCATOR);
        browser.clickElement(FIRST_ITEM_LOCATOR);
        return this;
    }

    public String getSubject() {
        Browser.waitForElementToBeDisplayed(SUBJECT_ELEMENT);
        return browser.getText(SUBJECT_ELEMENT);
    }

    public boolean isEmptySubjectMessageDisplayed() {
        Browser.waitForElementToBeDisplayed(EMPTY_SUBJECT_INBOX_MESSAGE);
        return browser.isElementDisplayed(EMPTY_SUBJECT_INBOX_MESSAGE);
    }

    public boolean isEmptySubjectSentMessageDisplayed() {
        Browser.waitForElementToBeDisplayed(EMPTY_SUBJECT_SENT_MESSAGE);
        return browser.isElementDisplayed(EMPTY_SUBJECT_SENT_MESSAGE);
    }

    public String getSenderMessage() {
        return browser.getAttribute(SENDER_MESSAGE, TITLE_ATTRIBUTE);
    }

    public String getRecipientMessage() {
        return browser.getAttribute(RECEPIENT_MESSAGE, TITLE_ATTRIBUTE);
    }

    public boolean isExitButtonDisplayed() {
        return browser.isElementDisplayed(EXIT_BUTTON);
    }

    public String getEmail() {
        Browser.waitForElementToBeDisplayed(USER_NAME);
        return browser.getText(USER_NAME);
    }

    public MainAreaPage clickPickButton() {
        Log.logInfo("Clicking first item from messages");
        browser.clickElementFromArray(BUTTON_PICK, 0);
        return this;
    }

    public MainAreaPage clickDeleteButton() {
        Log.logInfo("Clicking 'Delete' button");
        Browser.waitForElementToBeDisplayed(DELETE_BUTTON);
        browser.clickElement(DELETE_BUTTON);
        return this;
    }

    public MainAreaPage clickSelectAllButton() {
        Log.logInfo("Clicking 'Select All' button");
        Browser.waitForElementToBeClickable(SELECT_ALL);
        browser.clickElement(SELECT_ALL);
        return this;
    }

    public MainAreaPage clickDeleteAllSubmitButton() {
        Log.logInfo("Clicking 'Delete All' button");
        Browser.waitForElementToBeClickable(DELETE_ALL_SUBMIT_BUTTON);
        browser.clickElement(DELETE_ALL_SUBMIT_BUTTON);
        return this;
    }

    public MainAreaPage waitForDeleteAllSubmitButton() {
        Browser.waitForElementToBeClickable(DELETE_ALL_SUBMIT_BUTTON);
        return this;
    }

    public boolean isMessagesNotExist() {
        return browser.isElementsNotExist(MESSAGE_ITEM);
    }

    public void refreshPage() {
        Log.logInfo("Refresh page");
        browser.refresh();
    }

    public boolean isEmptyMessagesIconIsDisplayed() {
        Browser.waitForElementToBeDisplayed(EMPTY_MESSAGES_ICON);
        return browser.isElementDisplayed(EMPTY_MESSAGES_ICON);
    }

    public void waitForLogin() {
        Browser.waitForElementToBeDisplayed(EXIT_BUTTON);
    }
}
