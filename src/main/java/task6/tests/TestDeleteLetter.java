package task6.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.Listener.TestListener;
import task6.bio.Letter;
import task6.bio.LetterFactory;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;

@Listeners({TestListener.class})
public class TestDeleteLetter {

    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        LoginService.login(user);
    }


    @Test
    public void deleteLetter() throws InterruptedException {
        Letter letter = LetterFactory.getValidLetter();
        NewMessagePage page = WriteCorrectLetterService.writeCorrectLetter(letter);
        page.clickSaveButton()
                .clickCloseButton()
                .openDraftsMessages()
                .waitForPickButton()
                .clickPickButton();

        //wait.until(ExpectedConditions.visibilityOf(page.getCheckbox()));
        //page.clickCheckbox();
    }

    /*@AfterClass
    public void tearDown() {
       WrappedDriver.closedriver();
    }*/

}
