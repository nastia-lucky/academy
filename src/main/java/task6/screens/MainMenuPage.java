package task6.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuPage extends BasePage {

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='compose-button__ico']")
    private WebElement writeLetterButton;
    @FindBy(xpath = "//div[@class='nav-folders']//a[@title=\"Входящие\"]")
    private WebElement inboxMessages;
    @FindBy(xpath = "//div[@class='nav-folders']//a[@title=\"Отправленные\"]")
    private WebElement sentMessages;
    @FindBy(xpath = "//div[@class='nav-folders']//a[@title='Черновики']")
    private WebElement draftsMessages;

    public NewMessagePage clickWriteLetterButton() {
        writeLetterButton.click();
        return new NewMessagePage(driver);
    }

    public MainAreaPage openInboxMessages() {
        inboxMessages.click();
        return new MainAreaPage(driver);
    }

    public MainAreaPage openSentMessages() {
        sentMessages.click();
        return new MainAreaPage(driver);
    }

    public MainAreaPage openDraftsMessages() {
        draftsMessages.click();
        return new MainAreaPage(driver);
    }

    public WebElement getInboxMessages() {
        return inboxMessages;
    }
}
