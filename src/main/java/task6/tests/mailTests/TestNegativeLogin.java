package task6.tests.mailTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.bo.User;
import task6.bo.UserFactory;
import task6.listener.TestListener;
import task6.logger.Log;
import task6.screens.MailRuLoginPage;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class TestNegativeLogin {

    @Test
    public void incorrectLoginTest() {
        Log.logInfo("Login with incorrect username test is started");
        User user = UserFactory.getUserWithInvalidEmail();
        MailRuLoginPage loginPage = new MailRuLoginPage();
        loginPage.openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton();
        Assert.assertTrue(loginPage.isIncorrectLoginMessageIsDisplayed(),
                "Incorrect message is not displayed");
    }

    @Test
    public void incorrectPasswordTest() {
        Log.logInfo(" Login with incorrect password test is started");
        User user = UserFactory.getUserWithInvalidPassword();
        MailRuLoginPage loginPage = new MailRuLoginPage();
        loginPage.openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton()
                .typePassword(user.getPassword())
                .clickSubmitButton();
        Assert.assertTrue(loginPage.isIncorrectPasswordMessageIsDisplayed(),
                "Incorrect message is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        Browser.closeDriver();
    }
}
