package task6.tests.cloudsTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import task6.bo.User;
import task6.bo.UserFactory;
import task6.listener.TestListener;
import task6.screens.CloudPage;
import task6.services.LoginService;
import task6.services.OpenCloudService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class UploadFileTest {

    CloudPage cloudPage = new CloudPage();
    String file = "/Users/anastasiyashafalovich/IdeaProjects/academy/src/main/resources/TestFile";

    @BeforeClass
    public static void setUp() {
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
        OpenCloudService.openCloud();
    }

    @Test
    public void uploadFile() {
        cloudPage.clickUploadButton()
                .chooseFile(file);
        Assert.assertTrue(cloudPage.createdItemIsDisplayed(),
                "Created item doesn't exist");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
