package task6.services;

import task6.bo.Letter;
import task6.bo.LetterFactory;
import task6.logger.Log;
import task6.screens.NewMessagePage;

public class CreateLettersService {

    public static void createAllTypesLetters() {
        Log.logInfo("Creating all types of letters");
        Letter letter = LetterFactory.getValidLetter();
        NewMessagePage createdLetter = WriteCorrectLetterService.writeCorrectLetter(letter);
        createdLetter.clickSendButton();
        PopupCheck.checkPopup();
        NewMessagePage page = WriteCorrectLetterService.writeCorrectLetter(letter);
        page.clickSaveButton()
                .clickCloseButton();
    }
}
