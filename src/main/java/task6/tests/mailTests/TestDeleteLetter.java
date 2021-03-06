package task6.tests.mailTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.bo.Letter;
import task6.bo.LetterFactory;
import task6.bo.User;
import task6.bo.UserFactory;
import task6.listener.TestListener;
import task6.logger.Log;
import task6.screens.MainAreaPage;
import task6.screens.NewMessagePage;
import task6.services.CleanUpFoldersService;
import task6.services.CreateLettersService;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class TestDeleteLetter {

    MainAreaPage mainPage = new MainAreaPage();

    @BeforeClass
    public void setUp() {
        Log.logInfo("Set Up");
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
        CreateLettersService.createAllTypesLetters();
        CleanUpFoldersService.cleanUpFolders();
    }

    @Test
    public void deleteLetter() {
        Letter letter = LetterFactory.getValidLetter();
        NewMessagePage page = WriteCorrectLetterService.writeCorrectLetter(letter);
        page.clickSaveButton()
                .clickCloseButton()
                .openDraftsMessages()
                .clickPickButton()
                .clickDeleteButton();
        Assert.assertTrue(mainPage.isEmptyMessagesIconIsDisplayed(),
                "Empty message icon isn't displayed");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
