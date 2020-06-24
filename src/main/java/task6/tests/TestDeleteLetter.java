package task6.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task6.bio.Letter;
import task6.bio.LetterFactory;
import task6.screens.NewMessagePage;
import task6.services.LoginService;
import task6.services.WriteCorrectLetterService;

public class TestDeleteLetter {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = LoginService.createChromeDriver();
        LoginService.login(driver);
    }

    @Test
    public void deleteLetter() throws InterruptedException {
        Letter letter = LetterFactory.getValidLetter();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        NewMessagePage page = WriteCorrectLetterService.writeCorrectLetter(driver, letter);
        page.clickSaveButton()
                .clickCloseButton()
                .openDraftsMessages()
                .moveToFirstItem();
        wait.until(ExpectedConditions.visibilityOf(page.getCheckbox()));
        page.clickCheckbox();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
