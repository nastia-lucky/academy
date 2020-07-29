package task6.services;

import task6.logger.Log;
import task6.screens.CloudPage;
import task6.screens.MainMenuPage;

public class CleanUpCloudService {

    public static void cleanUpFolders() {
        Log.logInfo("Clean up existing cloud folders");
        MainMenuPage mainPage = new MainMenuPage();
        CloudPage cloudPage = mainPage.openCloud();
        if (!cloudPage.isFoldersNotExist()) {
            cloudPage.clickSelectAllButton()
                    .clickDeleteAllButton()
                    .clickDeleteAllConfirmButton();
            if (cloudPage.isTrashPopupDisplayed()) {
                cloudPage.clickTrashPopUpCloseButton();
            }
        }
    }
}
