package task6.tests.cloudsTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.bo.User;
import task6.bo.UserFactory;
import task6.listener.TestListener;
import task6.screens.CloudPage;
import task6.services.LoginService;
import task6.services.OpenCloudService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class CloudLogin {

    CloudPage cloudPage = new CloudPage();

    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
    }

    @Test
    public void loginToCloud() {
        OpenCloudService.openCloud();
        Assert.assertTrue(cloudPage.isLogoImageDisplayed(),
                "Logo isn't displayed");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
