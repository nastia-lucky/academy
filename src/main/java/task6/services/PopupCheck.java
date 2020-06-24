package task6.services;

import task6.screens.NewMessagePage;

public class PopupCheck {

    public static NewMessagePage checkPopup(NewMessagePage page) {
        if (page.getSentMessageLayer().isDisplayed()) {
            page.clickCloseSentMessageLayerButton();
            return page;
        }
        return page;
    }

}
