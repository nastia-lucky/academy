package task6.services;

import task6.logger.Log;
import task6.screens.MainMenuPage;

public class OpenCloudService {

    public static void openCloud() {
        Log.logInfo("Open cloud");
        MainMenuPage mainPage = new MainMenuPage();
        mainPage.openCloud();
    }
}
