package task6.services;

import task6.logger.Log;
import task6.screens.NewMessagePage;

public class PopupCheck {

    public static NewMessagePage checkPopup(NewMessagePage page) {
        Log.logInfo("Checking for sending message layer");
        if (page.isSentMessageLayerIsDisplayed()) {
            page.clickCloseSentMessageLayerButton();
            return page;
        }
        {
            return page;
        }
    }

}
