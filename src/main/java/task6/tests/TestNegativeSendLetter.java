package task6.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.Listener.TestListener;
import task6.Utilities.Browser;
import task6.bio.Letter;
import task6.bio.LetterFactory;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;

@Listeners({TestListener.class})
public class TestNegativeSendLetter {

    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        LoginService.login(user);
    }

    @Test
    public void writeLetterWithIncorrectAddress() throws InterruptedException {
        Letter letter = LetterFactory.getLetterWithInvalidAddress();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton();
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(createdLetter.isDisplayedIncorrectEmailMessage(), "Error message is not displayed");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
