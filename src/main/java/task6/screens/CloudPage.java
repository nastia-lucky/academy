package task6.screens;

import org.openqa.selenium.By;
import task6.Utilities.Browser;

public class CloudPage extends BasePage {

    private static final String CREATE_BUTTON = "//div[@data-name='create']";


    public void clickCreateButton() {
        browser.clickElement(By.xpath(CREATE_BUTTON));
    }

    public CloudPage waitForCreateButton() {
        Browser.waitForElementToBePresent(By.xpath(CREATE_BUTTON));
        return this;
    }

}
