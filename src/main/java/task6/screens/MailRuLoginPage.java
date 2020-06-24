package task6.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailRuLoginPage extends BasePage {

    private static final String URL = "https://mail.ru/";

    @FindBy(xpath = "//input[@id='mailbox:login']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@id='mailbox:password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[contains(text(), 'Неверное имя ящика')]")
    private WebElement incorrectLoginMessage;
    @FindBy(xpath = "//div[contains(text(), 'Неверное имя или пароль')]")
    private WebElement incorrectPasswordMessage;
    @FindBy(xpath = "//i[@id='PH_user-email'][contains(text(), 'a.shafalovich91@mail.ru')]")
    private WebElement loggedInName;
    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    private WebElement exitButton;

    public MailRuLoginPage(WebDriver driver) {
        super(driver);
    }

    public MailRuLoginPage openPage() {
        driver.get(URL);
        return this;
    }

    public MailRuLoginPage typeUserLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public MailRuLoginPage typePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public MailRuLoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public boolean isIncorrectLoginMessageIsDisplayed() {
        return incorrectLoginMessage.isDisplayed();
    }

    public boolean isIncorrectPasswordMessageIsDisplayed() {
        return incorrectPasswordMessage.isDisplayed();
    }

    public boolean userLoginNameIsDisplayed() {
        return loggedInName.isDisplayed();
    }

    public boolean isExitButtonDisplayed() {
        return exitButton.isDisplayed();
    }
}
