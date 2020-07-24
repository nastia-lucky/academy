package task6.services;

import task6.businessobjects.Letter;
import task6.businessobjects.LetterFactory;
import task6.logger.Log;
import task6.screens.NewMessagePage;

public class CreateLettersService {

    public static void createAllTypesLetters() throws InterruptedException {
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
