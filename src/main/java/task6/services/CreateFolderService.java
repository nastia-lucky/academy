package task6.services;

import task6.businessobjects.Folder;
import task6.logger.Log;
import task6.screens.CloudPage;

public class CreateFolderService {

    public static void createFolder(Folder folder) {
        Log.logInfo("Created folder" + folder.toString());
        CloudPage cloudPage = new CloudPage();
        cloudPage.clickCreateButton()
                .clickCreateFolderButton()
                .inputFolderName(folder.getName())
                .clickCreateFolderConfirmButton();
    }
}
