package task6.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task6.Listener.TestListener;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.MainAreaPage;
import task6.services.LoginService;

@Listeners({TestListener.class})
public class TestPositiveLogin {


    @Test
    public void LoginTest() throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        MainAreaPage mainPage = LoginService.login(user);
        SoftAssert anassert = new SoftAssert();
        anassert.assertEquals(mainPage.getEmail(), user.getEmail(), "LoginName is not displayed");
        anassert.assertTrue(mainPage.isExitButtonDisplayed(), "Exit button is not displayed");
    }

   /* @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    } */

}
