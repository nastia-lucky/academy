package task6.screens;

import org.openqa.selenium.By;
import task6.logger.Log;
import task6.utilities.Browser;

public class NewMessagePage extends MainAreaPage {

    private static final By ADDRESS_FIELD = By.xpath("//div[@class='contactsContainer--3RMuQ']//input[@type='text']");
    private static final By SUBJECT_FIELD = By.xpath("//div[@class='subject__wrapper--2mk6m']//input[@type='text']");
    private static final By TEXT_LETTER = By.xpath("//div[@role='textbox']");
    private static final By SEND_BUTTON = By.xpath("//span[@title='Отправить']");
    private static final By INCORRECT_ADDRESS_MESSAGE = By.xpath("//div[@data-test-id='error:invalid-addresses']//h1[contains(text(),'Присутствуют некорректные адреса')]");
    private static final By SEND_EMPTY_LETTER_BUTTON = By.xpath("//button[@data-test-id='false']//span[contains(text(), 'Отправить')]");
    private static final By SAVE_BUTTON = By.xpath("//span[@title='Сохранить']");
    private static final By CLOSE_BUTTON = By.xpath("//div[@class='controls_container--17SRg']//button[@title='Закрыть']");
    private static final By SENT_MESSAGE_LAYER = By.xpath("//div[@class='layer-window__container']");
    private static final By CLOSE_SENT_MESSAGE_LAYER_BUTTON = By.xpath("//div[@class='layer__controls']//span[@title='Закрыть']");

    public NewMessagePage inputAddress(String address) {
        Log.logInfo("Inputting message address " + address);
        browser.typeTo(ADDRESS_FIELD, address);
        return this;
    }

    public NewMessagePage inputSubject(String subject) {
        Log.logInfo("Inputting message subject " + subject);
        browser.typeTo(SUBJECT_FIELD, subject);
        return this;
    }

    public NewMessagePage inputText(String text) {
        Log.logInfo("Inputting message text " + text);
        browser.typeTo(TEXT_LETTER, text);
        return this;
    }

    public NewMessagePage clickSendButton() {
        Log.logInfo("Clicking 'Send' button");
        browser.clickElement(SEND_BUTTON);
        return this;
    }

    public boolean isDisplayedIncorrectEmailMessage() {
        return browser.isElementDisplayed(INCORRECT_ADDRESS_MESSAGE);
    }

    public NewMessagePage clickSendEmptyLetterButton() {
        Log.logInfo("Clicking 'Send Empty Letter' button");
        browser.clickElement(SEND_EMPTY_LETTER_BUTTON);
        return this;
    }

    public NewMessagePage clickSaveButton() {
        Log.logInfo("Clicking 'Save' button");
        browser.clickElement(SAVE_BUTTON);
        return this;
    }

    public MainMenuPage clickCloseButton() {
        Log.logInfo("Clicking 'Close' button");
        browser.clickElement(CLOSE_BUTTON);
        return new MainMenuPage();
    }

    public NewMessagePage clickCloseSentMessageLayerButton() {
        Log.logInfo("Clicking 'Close' button for pop-up");
        browser.clickElement(CLOSE_SENT_MESSAGE_LAYER_BUTTON);
        return this;
    }

    public void waitForAddressField() {
        Browser.waitForElementToBeDisplayed(ADDRESS_FIELD);
    }

    public boolean isSentMessageLayerIsDisplayed() {
        Browser.waitForElementToBeDisplayed(SENT_MESSAGE_LAYER);
        return browser.isElementDisplayed(SENT_MESSAGE_LAYER);
    }
}


