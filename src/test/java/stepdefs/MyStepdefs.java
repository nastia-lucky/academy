package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import task6.screens.MailRuLoginPage;
import task6.screens.MainAreaPage;
import task6.utilities.Browser;

public class MyStepdefs {
    MailRuLoginPage mailRuPage = new MailRuLoginPage();

    @Given("Browser is started")
    public void browserIsStarted() {
        Browser.getInstance();
    }

    @And("mail.ru page is loaded")
    public void mailRuPageIsLoaded() {
        mailRuPage.openPage();
    }

    @When("I  type {string} to login input")
    public void iTypeToLoginInput(String arg0) {
        mailRuPage.typeUserLogin(arg0);
    }

    @Then("I see my emailId")
    public void iSeeMyEmailId(String arg) {
        org.testng.Assert.assertEquals(new MainAreaPage().getEmail(),
                "Name of logged in user doesn't coincide with expected");
    }

    @And("I click button for submit")
    public void iClickButtonForSubmit() {
        mailRuPage.clickSubmitButton();
    }

    @After
    public void iCloseBrowser() {
        Browser.closeDriver();
    }

    @Then("I see incorrectLoginMessage")
    public void iSeeIncorrectLoginMessage() {
        Assert.assertTrue(mailRuPage.isIncorrectLoginMessageIsDisplayed(),
                "Incorrect login message is not displayed");
    }

    @Then("I see incorrectPasswordMessage")
    public void iSeeIncorrectPasswordMessage() {
        org.testng.Assert.assertTrue(mailRuPage.isIncorrectPasswordMessageIsDisplayed(),
                "Incorrect password message is not displayed");
    }

    @Then("I see {string}")
    public void iSee(String arg0) {
        Assert.assertEquals(new MainAreaPage().getEmail(), arg0);
    }

    @And("I type {string} to password input")
    public void iTypeToPasswordInput(String arg0) {
        mailRuPage.typePassword(arg0);
    }

    @And("I click button for submit password")
    public void iClickButtonForSubmitPassword() {
        mailRuPage.clickSubmitPasswordButton();
    }
}
