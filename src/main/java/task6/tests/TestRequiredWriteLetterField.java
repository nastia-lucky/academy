package task6.tests;

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
public class TestRequiredWriteLetterField {

    @BeforeClass
    public void setUp() throws InterruptedException {
        Log.logInfo("Set Up is started");
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
        CreateLettersService.createAllTypesLetters();
        CleanUpFoldersService.cleanUpFolders();
    }

    @Test
    public void writeLetterWithAddress() throws InterruptedException {
        Log.logInfo("Write Letters With Required Fields Test is started");
        Letter letter = LetterFactory.getLetterWithOnlyAddress();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton()
                .clickSendEmptyLetterButton();
        PopupCheck.checkPopup();
        SoftAssert softAssert = new SoftAssert();
        MainAreaPage createdInboxLetter = createdLetter.openInboxMessages();
        createdInboxLetter.openFirstItem();
        softAssert.assertTrue(createdInboxLetter.isEmptySubjectMessageDisplayed(),
                "Subject of inbox message is not empty");
        MainAreaPage createdSentLetter = createdLetter.openSentMessages();
        createdSentLetter.openFirstItem();
        softAssert.assertTrue(createdSentLetter.isEmptySubjectSentMessageDisplayed(),
                "Subject of sent message is not empty");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
