package task6.services;

import org.openqa.selenium.WebDriver;
import task6.bio.Letter;
import task6.screens.MainMenuPage;
import task6.screens.NewMessagePage;

import java.util.concurrent.TimeUnit;

public class WriteCorrectLetterService {

    public static NewMessagePage writeCorrectLetter(WebDriver driver, Letter letter) {
        MainMenuPage mainMenu = new MainMenuPage(driver);
        NewMessagePage newMessage = mainMenu.clickWriteLetterButton()
                .inputAddress(letter.getAddress())
                .inputSubject(letter.getSubject())
                .inputText(letter.getMessaheText());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return newMessage;
    }

}
