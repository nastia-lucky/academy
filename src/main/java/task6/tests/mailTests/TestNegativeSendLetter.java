package task6.tests.mailTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.bo.Letter;
import task6.bo.LetterFactory;
import task6.bo.User;
import task6.bo.UserFactory;
import task6.listener.TestListener;
import task6.logger.Log;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class TestNegativeSendLetter {

    @BeforeClass
    public void setUp() {
        Log.logInfo("Set Up");
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
    }

    @Test
    public void writeLetterWithIncorrectAddress() {
        Log.logInfo("Write Letter with incorrect address Test is started");
        Letter letter = LetterFactory.getLetterWithInvalidAddress();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton();
        Assert.assertTrue(createdLetter.isDisplayedIncorrectEmailMessage(),
                "Error message is not displayed");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
