package task6.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.Listener.TestListener;
import task6.Utilities.Browser;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.MailRuLoginPage;

@Listeners({TestListener.class})
public class TestNegativeLogin {

 /*   @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
        driver = new ChromeDriver();
    } */

    @Test
    public void incorrectLoginTest() throws InterruptedException {
        User user = UserFactory.getUserWittInvalidEmail();
        MailRuLoginPage loginPage = new MailRuLoginPage();
        loginPage.openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton();
        Thread.sleep(1000);
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(loginPage.isIncorrectLoginMessageIsDisplayed(), "Incorrect message is not displayed");
    }

    @Test
    public void incorrectPasswordTest() throws InterruptedException {
        User user = UserFactory.getUserWithInvalidPassword();
        MailRuLoginPage loginPage = new MailRuLoginPage();
        loginPage.openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton()
                .typePassword(user.getPassword())
                .clickSubmitButton();
        Thread.sleep(1000);
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(loginPage.isIncorrectPasswordMessageIsDisplayed(), "Incorrect message is not displayed");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
