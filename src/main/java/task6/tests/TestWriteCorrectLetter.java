package task6.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.Listener.TestListener;
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
public class TestWriteCorrectLetter {


    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        LoginService.login(user);
    }

    @Test
    public void writeLetter() throws InterruptedException {
        Letter letter = LetterFactory.getValidLetter();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton()
                .waitForSentLayer();
        PopupCheck.checkPopup(createdLetter);
        SoftAssert anassert = new SoftAssert();
        MainAreaPage createdInboxLetter = createdLetter.openInboxMessages()
                .openFirstItem()
                .waitForSubject();
        anassert.assertEquals(createdInboxLetter.getSubject(), letter.getSubject(), "Subjects in inbox message and sent letter don't coincide ");
        anassert.assertEquals(createdInboxLetter.getSenderMessage(), letter.getAddress(), "Sender message doesn't coincide in created letter and inbox letter");
        MainAreaPage createdSentLetter = createdLetter.openSentMessages();
        createdSentLetter.waitForFirstItem()
                .openFirstItem()
                .waitForSubject();
        anassert.assertEquals(createdSentLetter.getSubject(), letter.getSubject(), "Subjects in sent message and sent letter don't coincide");
        anassert.assertEquals(createdSentLetter.getRecepientMessage(), letter.getAddress(), "Recepient Message doesn't coincide in created letter and sent letter ");
    }

   /* @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    } */
}
