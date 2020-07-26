package task6.tests.cloudsTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task6.bo.Folder;
import task6.bo.FolderFactory;
import task6.bo.User;
import task6.bo.UserFactory;
import task6.listener.TestListener;
import task6.screens.CloudPage;
import task6.services.CleanUpCloudService;
import task6.services.CreateFolderService;
import task6.services.LoginService;
import task6.utilities.Browser;

@Listeners({TestListener.class})
public class CreateFolderTest {

    CloudPage cloudPage = new CloudPage();

    @BeforeClass
    public void setUp() throws InterruptedException {
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
        CleanUpCloudService.cleanUpFolders();
    }

    @Test
    public void createFolder() {
        Folder folder = FolderFactory.getFolderName();
        CreateFolderService.createFolder(folder);
        cloudPage.clickMyFilesButton();
        Assert.assertEquals(cloudPage.getTextCreatedFolder(), folder.getName());
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
