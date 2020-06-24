package task6.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewMessagePage extends MainAreaPage {

    public NewMessagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//input[@type='text']")
    private WebElement addressField;
    @FindBy(xpath = "//div[@class='subject__wrapper--2mk6m']//input[@type='text']")
    private WebElement subjectField;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textLetter;
    @FindBy(xpath = "//span[@title='Отправить']")
    private WebElement sendButton;
    @FindBy(xpath = "//div[@data-test-id='error:invalid-addresses']//h1[contains(text(),'Присутствуют некорректные адреса' )]")
    private WebElement incorrectAddressMessage;
    @FindBy(xpath = "//button[@data-test-id='false']//span[contains(text(), 'Отправить')]")
    private WebElement sendEmptyLetterButton;
    @FindBy(xpath = "//span[@title='Сохранить']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@class='controls_container--17SRg']//button[@title='Закрыть']")
    private WebElement closeButton;
    @FindBy(xpath = "//div[@class='layer-window__container']")
    private WebElement sentMessageLayer;
    @FindBy(xpath = "//div[@class='layer__controls']//span[@title='Закрыть']")
    private WebElement closeSentMessageLayerButton;

    public NewMessagePage inputAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public NewMessagePage inputSubject(String subject) {
        subjectField.sendKeys(subject);
        return this;
    }

    public NewMessagePage inputText(String text) {
        textLetter.sendKeys(text);
        return this;
    }

    public NewMessagePage clickSendButton() {
        sendButton.click();
        return this;
    }

    public boolean isDisplayedIncorrectEmailMessage() {
        return incorrectAddressMessage.isDisplayed();
    }

    public NewMessagePage clickSendEmptyLetterButton() {
        sendEmptyLetterButton.click();
        return this;
    }

    public NewMessagePage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public MainMenuPage clickCloseButton() {
        closeButton.click();
        return new MainMenuPage(driver);
    }

    public NewMessagePage clickCloseSentMessageLayerButton() {
        closeSentMessageLayerButton.click();
        return this;
    }

    public WebElement getSentMessageLayer() {
        return sentMessageLayer;
    }
}
