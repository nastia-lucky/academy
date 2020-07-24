package task6.screens;

import org.openqa.selenium.By;
import task6.logger.Log;
import task6.utilities.Browser;

public class MailRuLoginPage extends BasePage {

    private static final String URL = "https://mail.ru/";
    private static final By LOGIN_INPUT_LOCATOR = By.xpath("//input[@id='mailbox:login']");
    private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//input[@type='submit']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@id='mailbox:password']");
    private static final By INCORRECT_LOGIN_MESSAGE_LOCATOR = By.xpath("//div[contains(text(), 'Неверное имя ящика')]");
    private static final By INCORRECT_PASSWORD_MESSAGE_LOCATOR = By.xpath("//div[contains(text(), 'Неверное имя или пароль')]");

    public MailRuLoginPage openPage() {
        Log.logInfo("Opening mailRu page");
        browser.getUrl(URL);
        return this;
    }

    public MailRuLoginPage typeUserLogin(String login) {
        Log.logInfo("Type user login " + login);
        browser.typeTo(LOGIN_INPUT_LOCATOR, login);
        return this;
    }

    public MailRuLoginPage typePassword(String password) {
        Log.logInfo("Type user password " + password);
        browser.typeTo(PASSWORD_INPUT_LOCATOR, password);
        return this;
    }

    public MailRuLoginPage clickSubmitButton() {
        Log.logInfo("Clicking submit button");
        browser.clickElement(SUBMIT_BUTTON_LOCATOR);
        return this;
    }

    public boolean isIncorrectLoginMessageIsDisplayed() {
        Browser.waitForElementToBeDisplayed(INCORRECT_LOGIN_MESSAGE_LOCATOR);
        return browser.isElementDisplayed(INCORRECT_LOGIN_MESSAGE_LOCATOR);
    }

    public boolean isIncorrectPasswordMessageIsDisplayed() {
        Browser.waitForElementsFromArrayIsDisplayed(INCORRECT_PASSWORD_MESSAGE_LOCATOR);
        return browser.isElementDisplayed(INCORRECT_PASSWORD_MESSAGE_LOCATOR);
    }
}
