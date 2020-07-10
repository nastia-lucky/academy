package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MailRuLoginPage extends BasePage {

    private static final String URL = "https://mail.ru/";
    private static final String LOGIN_INPUT_LOCATOR = "//input[@id='mailbox:login']";
    private static final String SUBMIT_BUTTON_LOCATOR = "//input[@type='submit']";
    private static final String PASSWORD_INPUT_LOCATOR = "//input[@id='mailbox:password']";
    private static final String INCORRECT_LOGIN_MESSAGE_LOCATOR = "//div[contains(text(), 'Неверное имя ящика')]";
    private static final String INCORRECT_PASSWORD_MESSAGE_LOCATOR = "//div[contains(text(), 'Неверное имя или пароль')]";

    public MailRuLoginPage openPage() {
        browser.getUrl(URL);


        return this;
    }

    public MailRuLoginPage typeUserLogin(String login) {
        browser.typeTo(By.xpath(LOGIN_INPUT_LOCATOR), login);
        return this;
    }

    public MailRuLoginPage typePassword(String password) {
        browser.typeTo(By.xpath(PASSWORD_INPUT_LOCATOR), password);
        return this;
    }

    public MailRuLoginPage clickSubmitButton() {
        browser.clickElement(By.xpath(SUBMIT_BUTTON_LOCATOR));
        return this;
    }

    public boolean isIncorrectLoginMessageIsDisplayed() {
        return browser.isElemenDisplayed(By.xpath(INCORRECT_LOGIN_MESSAGE_LOCATOR));
    }

    public boolean isIncorrectPasswordMessageIsDisplayed() {
        return browser.isElemenDisplayed(By.xpath(INCORRECT_PASSWORD_MESSAGE_LOCATOR));
    }

    public WebElement getPasswordInputLocator() {
        return browser.getElement(By.xpath(PASSWORD_INPUT_LOCATOR));
    }
}
