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


public class TestPositiveLogin {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void LoginTest() throws InterruptedException {

        User user = UserFactory.getUserWithValidCreds();
        MailRuLoginPage loginPage = new MailRuLoginPage(driver);
        loginPage
                .openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton();
        Thread.sleep(3000);
        loginPage.typePassword(user.getPassword())
                .clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SoftAssert anassert = new SoftAssert();
        anassert.assertTrue(loginPage.userLoginNameIsDisplayed(), "LoginName is not displayed");
        anassert.assertTrue(loginPage.isExitButtonDisplayed(), "Exit button is not displayed");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
