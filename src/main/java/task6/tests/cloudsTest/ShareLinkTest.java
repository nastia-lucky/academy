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
public class ShareLinkTest {

    CloudPage cloudPage = new CloudPage();

    @BeforeClass
    public void setUp() {
        User user = UserFactory.getUserWithValidLogin();
        LoginService.login(user);
        CleanUpCloudService.cleanUpFolders();
    }

    @Test
    public void shareLink() {
        Folder folder = FolderFactory.getFolderName();
        CreateFolderService.createFolder(folder);
        cloudPage.clickMyFilesButton()
                .rightClickMouseCreatedItem()
                .clickOpenLinkPublicityButton();
        cloudPage.switchToNewTab().openLinkInNewTab(cloudPage.getLink());
        Assert.assertEquals(cloudPage.getNameSharedFolder(), folder.getName(),
                "Name of created item doesn't coincide with shared link");
    }

    @AfterClass
    public void tearDown() {
        Browser.closeDriver();
    }
}
