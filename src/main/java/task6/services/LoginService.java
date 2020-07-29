package task6.services;

import task6.bo.User;
import task6.logger.Log;
import task6.screens.MailRuLoginPage;
import task6.screens.MainAreaPage;

public class LoginService {

    public static MainAreaPage login(User user) {
        Log.logInfo("Login to mailbox with user " + user.toString());
        MailRuLoginPage loginPage = new MailRuLoginPage();
        loginPage
                .openPage()
                .typeUserLogin(user.getEmail())
                .clickSubmitButton();
        loginPage.typePassword(user.getPassword())
                .clickSubmitPasswordButton();
        return new MainAreaPage();
    }
}
