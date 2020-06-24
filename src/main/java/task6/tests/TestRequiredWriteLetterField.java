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

public class TestRequiredWriteLetterField {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = LoginService.createChromeDriver();
        LoginService.login(driver);

    }

    @Test
    public void writeLetterWithAddress() throws InterruptedException {
        Letter letter = LetterFactory.getLetterWithOnlyAddress();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(driver, letter);
        createdLetter.clickSendButton()
                .clickSendEmptyLetterButton();
        PopupCheck.checkPopup(createdLetter);
        SoftAssert anassert = new SoftAssert();
        MainAreaPage createdInboxLetter = createdLetter.openInboxMessages()
                .openFirstItem();
        anassert.assertTrue(createdInboxLetter.isEmptySubjectMessageDisplayed(), "Subject of inbox message is not empty");
        MainAreaPage createdSentLetter = createdLetter.openSentMessages()
                .openFirstItem();
        anassert.assertTrue(createdSentLetter.isEmptySubjectSentMessageDisplayed(), "Subject of sent message is not empty");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
