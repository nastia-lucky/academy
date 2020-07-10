package task6.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.Listener.TestListener;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.CloudPage;
import task6.screens.MainMenuPage;
import task6.services.LoginService;

@Listeners({TestListener.class})
public class CloudLogin {

    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        LoginService.login(user);
    }


    @Test
    public void loginTopCloud() {
        MainMenuPage mainPage = new MainMenuPage();
        CloudPage cloudPage = mainPage.waitForCloudButton()
                .openCloud();
        cloudPage.waitForCreateButton()
                .clickCreateButton();
    }
}
