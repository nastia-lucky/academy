package task6.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.businessobjects.User;
import task6.businessobjects.UserFactory;
import task6.listener.TestListener;
import task6.logger.Log;
import task6.screens.MainAreaPage;
import task6.services.LoginService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class TestPositiveLogin {

    @Test
    public void LoginTest() throws InterruptedException {
        Log.logInfo("Positive Login Test is started");
        User validUser = UserFactory.getUserWithValidLogin();
        MainAreaPage mainPage = LoginService.login(validUser);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mainPage.getEmail(), validUser.getEmail(),
                "Login name is not displayed");
        softAssert.assertTrue(mainPage.isExitButtonDisplayed(),
                "Exit button is not displayed");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
