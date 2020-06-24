package task6.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import task6.bio.User;
import task6.bio.UserFactory;
import task6.screens.MailRuLoginPage;

import java.util.concurrent.TimeUnit;

public class LoginService {

    public static void login(WebDriver driver) throws InterruptedException {
        User user = UserFactory.getUserWithValidCreds();
        MailRuLoginPage loginPage = new MailRuLoginPage(driver);
        loginPage
                .openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton();
        Thread.sleep(3000);
        loginPage.typePassword(user.getPassword())
                .clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/task6/chromedriver");
        return new ChromeDriver();
    }
}
