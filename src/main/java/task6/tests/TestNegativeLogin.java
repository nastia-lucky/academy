package task6.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.MailRuLoginPage;

import java.util.concurrent.TimeUnit;

public class TestNegativeLogin {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void incorrectLoginTest() {
        User user = UserFactory.getUserWittInvalidEmail();
        MailRuLoginPage loginPage = new MailRuLoginPage(driver);
        loginPage.openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(loginPage.isIncorrectLoginMessageIsDisplayed(), "Incorrect message is not displayed");
    }

    @Test
    public void incorrectPasswordTest() {
        User user = UserFactory.getUserWithInvalidPassword();
        MailRuLoginPage loginPage = new MailRuLoginPage(driver);
        loginPage.openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton()
                .typePassword(user.getPassword())
                .clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(loginPage.isIncorrectPasswordMessageIsDisplayed(), "Incorrect message is not displayed");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
