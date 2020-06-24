package task6.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.bio.Letter;
import task6.bio.LetterFactory;
import task6.screens.MainAreaPage;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.PopupCheck;
import task6.services.WriteCorrectLetterService;

public class TestWriteCorrectLetter {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = LoginService.createChromeDriver();
        LoginService.login(driver);
    }

    @Test
    public void writeLetter() {
        Letter letter = LetterFactory.getValidLetter();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(driver, letter);
        createdLetter.clickSendButton();
        PopupCheck.checkPopup(createdLetter);
        SoftAssert anassert = new SoftAssert();
        MainAreaPage createdInboxLetter = createdLetter.openInboxMessages()
                .openFirstItem();
        anassert.assertEquals(createdInboxLetter.getSubject(), letter.getSubject(), "Subjects in inbox message and sent letter don't coincide ");
        anassert.assertEquals(createdInboxLetter.getSenderMessage(), letter.getAddress(), "Sender message doesn't coincide in created letter and inbox letter");
        MainAreaPage createdSentLetter = createdLetter.openSentMessages()
                .openFirstItem();
        anassert.assertEquals(createdSentLetter.getSubject(), letter.getSubject(), "Subjects in sent message and sent letter don't coincide");
        anassert.assertEquals(createdSentLetter.getRecepientMessage(), letter.getAddress(), "Recepient Message doesn't coincide in created letter and sent letter ");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
