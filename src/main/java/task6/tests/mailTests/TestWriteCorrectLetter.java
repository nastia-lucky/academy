package task6.tests.mailTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.listener.TestListener;
import task6.logger.Log;
import task6.screens.MainAreaPage;
import task6.screens.NewMessagePage;
import task6.services.*;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class TestWriteCorrectLetter {

    @BeforeClass
    public void setUp() throws InterruptedException {
        Log.logInfo("Set Up is started");
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
        CreateLettersService.createAllTypesLetters();
        CleanUpFoldersService.cleanUpFolders();

    }

    @Test
    public void writeLetter() throws InterruptedException {
        Log.logInfo("Write Letter Test is started");
        Letter letter = LetterFactory.getValidLetter();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton();
        PopupCheck.checkPopup();
        SoftAssert softAssert = new SoftAssert();
        MainAreaPage createdInboxLetter = createdLetter.openInboxMessages()
                .openFirstItem();
        softAssert.assertEquals(createdInboxLetter.getSubject(), letter.getSubject(),
                "Subjects in inbox message and sent letter don't coincide ");
        softAssert.assertEquals(createdInboxLetter.getSenderMessage(), letter.getAddress(),
                "Sender message doesn't coincide in created letter and inbox letter");
        MainAreaPage createdSentLetter = createdLetter.openSentMessages();
        createdSentLetter.openFirstItem();
        softAssert.assertEquals(createdSentLetter.getSubject(), "Self: " + letter.getSubject(),
                "Subjects in sent message and sent letter don't coincide");
        softAssert.assertEquals(createdSentLetter.getRecipientMessage(), letter.getAddress(),
                "Recipient Message doesn't coincide in created letter and sent letter ");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
