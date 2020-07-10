package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import task6.Utilities.Browser;

public class NewMessagePage extends MainAreaPage {

    private static final String ADDRESS_FIELD = "//div[@class='contactsContainer--3RMuQ']//input[@type='text']";
    private static final String SUBJECT_FIELD = "//div[@class='subject__wrapper--2mk6m']//input[@type='text']";
    private static final String TEXT_LETTER = "//div[@role='textbox']";
    private static final String SEND_BUTTON = "//span[@title='Отправить']";
    private static final String INCORRECT_ADDRESS_MESSAGE = "//div[@data-test-id='error:invalid-addresses']//h1[contains(text(),'Присутствуют некорректные адреса' )]";
    private static final String SEND_EMPTY_LETTER_BUTTON = "//button[@data-test-id='false']//span[contains(text(), 'Отправить')]";
    private static final String SAVE_BUTTON = "//span[@title='Сохранить']";
    private static final String CLOSE_BUTTON = "//div[@class='controls_container--17SRg']//button[@title='Закрыть']";
    private static final String SENT_MESSAGE_LAYER = "//div[@class='layer-window__container']";
    private static final String CLOSE_SENT_MESSAGE_LAYER_BUTTON = "//div[@class='layer__controls']//span[@title='Закрыть']";

    public NewMessagePage inputAddress(String address) {
        browser.typeTo(By.xpath(ADDRESS_FIELD), address);
        return this;
    }

    public NewMessagePage inputSubject(String subject) {
        browser.typeTo(By.xpath(SUBJECT_FIELD), subject);
        return this;
    }

    public NewMessagePage inputText(String text) {
        browser.typeTo(By.xpath(TEXT_LETTER), text);
        return this;
    }

    public NewMessagePage clickSendButton() {
        browser.clickElement(By.xpath(SEND_BUTTON));
        return this;
    }

    public boolean isDisplayedIncorrectEmailMessage() {
        return browser.isElemenDisplayed(By.xpath(INCORRECT_ADDRESS_MESSAGE));
    }

    public NewMessagePage clickSendEmptyLetterButton() {
        browser.clickElement(By.xpath(SEND_EMPTY_LETTER_BUTTON));
        return this;
    }

    public NewMessagePage clickSaveButton() {
        browser.clickElement(By.xpath(SAVE_BUTTON));
        return this;
    }

    public MainMenuPage clickCloseButton() {
        browser.clickElement(By.xpath(CLOSE_BUTTON));
        return new MainMenuPage();
    }

    public NewMessagePage clickCloseSentMessageLayerButton() {
        browser.clickElement(By.xpath(CLOSE_SENT_MESSAGE_LAYER_BUTTON));
        return this;
    }

    public void waitForAddressField() {
        Browser.waitForElementToBeDisplayed(By.xpath(ADDRESS_FIELD));
    }

    public boolean isSentMessageLayerIsDisplayed() {
        return browser.isElemenDisplayed(By.xpath(SENT_MESSAGE_LAYER));
    }

    public void waitForSentLayer() {
        Browser.waitForElementToBeDisplayed(By.xpath(SENT_MESSAGE_LAYER));
    }

    public void waitForSubject(By by) {
        Browser.waitForElementToBeDisplayed(by);
    }

    public WebElement getAddressField() {
        return browser.getElement(By.xpath(ADDRESS_FIELD));
    }
}


