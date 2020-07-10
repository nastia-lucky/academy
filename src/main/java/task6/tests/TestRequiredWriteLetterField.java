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
import task6.screens.MainAreaPage;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.PopupCheck;
import task6.services.WriteCorrectLetterService;

@Listeners({TestListener.class})
public class TestRequiredWriteLetterField {

    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        LoginService.login(user);
    }

    @Test
    public void writeLetterWithAddress() throws InterruptedException {
        Letter letter = LetterFactory.getLetterWithOnlyAddress();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton()
                .clickSendEmptyLetterButton()
                .waitForSentLayer();
        PopupCheck.checkPopup(createdLetter);
        SoftAssert anassert = new SoftAssert();
        MainAreaPage createdInboxLetter = createdLetter.openInboxMessages();
        createdInboxLetter.openFirstItem()
                .waitForEmptySubjectInboxMessage();
        anassert.assertTrue(createdInboxLetter.isEmptySubjectMessageDisplayed(), "Subject of inbox message is not empty");
        MainAreaPage createdSentLetter = createdLetter.openSentMessages();
        createdSentLetter.waitForFirstItem()
                .openFirstItem()
                .waitForEmptySubjectSentMessage();
        anassert.assertTrue(createdSentLetter.isEmptySubjectSentMessageDisplayed(), "Subject of sent message is not empty");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
