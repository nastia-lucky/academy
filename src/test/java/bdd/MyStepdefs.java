package bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import task6.screens.MailRuLoginPage;
import task6.screens.MainAreaPage;
import task6.utilities.Browser;

public class MyStepdefs {
    MailRuLoginPage mailRupage = new MailRuLoginPage();

    @Given("Browser is started")
    public void browserIsStarted() {
        Browser.getInstance();
    }

    @And("mail.ru page is loaded")
    public void mailRuPageIsLoaded() {
        mailRupage.openPage();
    }

    @When("I  type {string} to login input")
    public void iTypeToLoginInput(String arg0) {
        mailRupage.typeUserLogin(arg0);
    }

    @And("I type {string} to password input")
    public void iTypeToPasswordInput(String arg0) {
        mailRupage.typePassword(arg0);
    }

    @Then("I see my emailId")
    public void iSeeMyEmailId() {
        org.testng.Assert.assertEquals("",
                new MainAreaPage().getEmail(),
                "Name of logged in user doesn't coincide with expected");
    }

    @And("I click button for submit")
    public void iClickButtonForSubmit() {
        mailRupage.clickSubmitButton();
    }

    @Then("I close Browser")
    public void iCloseBrowser() {
        Browser.closeDriver();
    }

    @Then("I see incorrectLoginMessage")
    public void iSeeIncorrectLoginMessage() {
        Assert.assertTrue(mailRupage.isIncorrectLoginMessageIsDisplayed(),
                "Incorrect login message is not displayed");
    }

    @Then("I see incorrectPasswordMessage")
    public void iSeeIncorrectPasswordMessage() {
        org.testng.Assert.assertTrue(mailRupage.isIncorrectPasswordMessageIsDisplayed(),
                "Incorrect password message is not displayed");
    }
}
