package task6.tests.mailTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.listener.TestListener;
import task6.logger.Log;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class TestNegativeSendLetter {

    @BeforeClass
    public void setUp() throws InterruptedException {
        Log.logInfo("Set Up");
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
    }

    @Test
    public void writeLetterWithIncorrectAddress() throws InterruptedException {
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
