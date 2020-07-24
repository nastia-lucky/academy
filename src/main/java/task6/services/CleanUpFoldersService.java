package task6.services;

import task6.logger.Log;
import task6.screens.MainAreaPage;

public class CleanUpFoldersService {

    public static void cleanUpFolders() {
        Log.logInfo("Clean up existing messages");
        MainAreaPage mainPage = new MainAreaPage();
        mainPage.openInboxMessages();
        mainPage.isMessagesNotExist();
        if (!mainPage.isMessagesNotExist()) {
            mainPage.clickPickButton()
                    .clickSelectAllButton()
                    .clickDeleteButton()
                    .waitForDeleteAllSubmitButton()
                    .clickDeleteAllSubmitButton();
        }
        mainPage.openSentMessages();
        mainPage.isMessagesNotExist();
        if (!mainPage.isMessagesNotExist()) {
            mainPage.clickPickButton()
                    .clickSelectAllButton()
                    .clickDeleteButton();
        }
        mainPage.openDraftsMessages();
        mainPage.isMessagesNotExist();
        if (!mainPage.isMessagesNotExist()) {
            mainPage.clickPickButton()
                    .clickSelectAllButton()
                    .clickDeleteButton();
        }
        mainPage.refreshPage();
    }
}
