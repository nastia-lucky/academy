package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task6.Utilities.Browser;

public class MainAreaPage extends MainMenuPage {

    private static final String FIRST_ITEM_LOCATOR = "//div[@class='llc__content'][(1)]";
    private static final String SUBJECT_ELEMENT = "//h2[@class='thread__subject']";
    private static final String TEXT_ELEMENT = "//div[@class='cl_768288']/div";
    private static final String EMPTY_SUBJECT_INBOX_MESSAGE = "//div[@class='thread__subject-line']//h2[contains(text(), 'Без темы')]";
    private static final String EMPTY_SUBJECT_SENT_MESSAGE = "//div[@class='thread__subject-line']//h2[contains(text(), 'Self:')]";
    private static final String SENDER_MESSAGE = "//div[@class='letter__author']/span[@title]";
    private static final String RECEPIENT_MESSAGE = "//div[@class='letter__recipients letter__recipients_short']//span[@class='letter-contact']";
    private static final String USER_NAME = "//i[@id='PH_user-email']";
    private static final String EXIT_BUTTON = "//a[@id='PH_logoutLink']";
    private static final String TITLE_ATTRIBUTE = "title";
    private static final String BUTTON_PICK = "//button[contains(@class, 'll-av_size_common')]";

    public MainAreaPage openFirstItem() {
        browser.clickElement(By.xpath(FIRST_ITEM_LOCATOR));
        return this;
    }

    public void waitForEmptySubjectInboxMessage() {
        Browser.waitForElementToBeDisplayed(By.xpath(EMPTY_SUBJECT_INBOX_MESSAGE));
    }

    public MainAreaPage waitForEmptySubjectSentMessage() {
        Browser.waitForElementToBeDisplayed(By.xpath(EMPTY_SUBJECT_SENT_MESSAGE));
        return this;
    }

    public String getSubject() {
        return browser.getText(By.xpath(SUBJECT_ELEMENT));
    }

    public boolean isEmptySubjectMessageDisplayed() {
        return browser.isElemenDisplayed(By.xpath(EMPTY_SUBJECT_INBOX_MESSAGE));
    }

    public boolean isEmptySubjectSentMessageDisplayed() {
        return browser.isElemenDisplayed(By.xpath(EMPTY_SUBJECT_SENT_MESSAGE));
    }


   /* public MainAreaPage moveToFirstItem() {
        Actions action = new Actions(driver);
        action.moveToElement(firstItemCheckbox).perform();
        return this;
    }*/

    public String getSenderMessage() {
        return browser.getAttribute(By.xpath(SENDER_MESSAGE), TITLE_ATTRIBUTE);
    }

    public String getRecepientMessage() {
        return browser.getAttribute(By.xpath(RECEPIENT_MESSAGE), TITLE_ATTRIBUTE);
    }

    public boolean userLoginNameIsDisplayed() {
        return browser.isElemenDisplayed(By.xpath(USER_NAME));
    }

    public boolean isExitButtonDisplayed() {
        return browser.isElemenDisplayed(By.xpath(EXIT_BUTTON));
    }

    /*public void jusyClick() {
        firstItemCheckbox.click();
    } */

    public WebElement getUserName() {
        return browser.getElement(By.xpath(USER_NAME));
    }

    public MainAreaPage waitForSubject() {
        Browser.waitForElementToBeDisplayed(By.xpath(SUBJECT_ELEMENT));
        return this;
    }

    public String getEmail() {
        return browser.getText(By.xpath(USER_NAME));
    }

    public MainAreaPage waitForFirstItem() {
        Browser.waitForElementToBeDisplayed(By.xpath(FIRST_ITEM_LOCATOR));
        return this;
    }

    public MainAreaPage clickPickButton() {
        browser.clickElement(By.xpath(BUTTON_PICK));
        return this;
    }

    public MainAreaPage waitForPickButton() {
        Browser.waitForElementToBeClickable(By.xpath(BUTTON_PICK));
        return this;
    }


}
