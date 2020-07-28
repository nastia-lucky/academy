package task6.services;

import task6.bo.Letter;
import task6.logger.Log;
import task6.screens.MainMenuPage;
import task6.screens.NewMessagePage;

public class WriteCorrectLetterService {

    public static NewMessagePage writeCorrectLetter(Letter letter) {
        Log.logInfo("Write the message " + letter.toString());
        MainMenuPage mainMenu = new MainMenuPage();
        NewMessagePage newMessage = mainMenu.clickWriteLetterButton();
        newMessage.waitForAddressField();
        newMessage.inputAddress(letter.getAddress())
                .inputSubject(letter.getSubject())
                .inputText(letter.getMessageText());
        return newMessage;
    }
}
