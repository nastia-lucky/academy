package task6.services;

import task6.logger.Log;
import task6.screens.NewMessagePage;

public class PopupCheck {

    public static void checkPopup() {
        NewMessagePage newMessage = new NewMessagePage();
        Log.logInfo("Checking for sending message layer");
        if (newMessage.isSentMessageLayerIsDisplayed()) {
            newMessage.clickCloseSentMessageLayerButton();
        }
    }
}
