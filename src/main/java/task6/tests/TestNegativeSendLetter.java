package task6.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.bio.Letter;
import task6.bio.LetterFactory;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;

public class TestNegativeSendLetter {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = LoginService.createChromeDriver();
        LoginService.login(driver);
    }

    @Test
    public void writeLetterWithIncorrectAddress() {
        Letter letter = LetterFactory.getLetterWithInvalidAddress();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(driver, letter);
        createdLetter.clickSendButton();
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(createdLetter.isDisplayedIncorrectEmailMessage(), "Error message is not displayed");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
