package task6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainAreaPage extends MainMenuPage {

    public MainAreaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='llc__content'][(1)]")
    private WebElement firstItem;
    WebElement firstItem2 = driver.findElement(By.xpath("//div[@class='llc__content'][(1)]"));
    @FindBy(xpath = "//h2[@class='thread__subject']")
    private WebElement subjectElement;
    @FindBy(xpath = "//div[@class='cl_768288']/div")
    private WebElement textElement;
    @FindBy(xpath = "//div[@class='thread__subject-line']//h2[contains(text(), 'Без темы')]")
    private WebElement emptySubjectInboxMessage;
    @FindBy(xpath = "//div[@class='thread__subject-line']//h2[contains(text(), 'Self:')]")
    private WebElement emptySubjectSentText;
    WebElement checkbox = driver.findElement(By.xpath("//div[@class='checkbox']"));
    WebElement firstItemCheckbox = driver.findElement(By.xpath("//div[@class='llc__content'][(1)]"));
    @FindBy(xpath = "//div[@class='letter__author']/span[@title]")
    private WebElement senderMessage;
    @FindBy(xpath = "//div[@class='letter__recipients letter__recipients_short']//span[@class='letter-contact']")
    private WebElement recepientMessage;

    public MainAreaPage openFirstItem() {
        firstItem.click();
        return this;
    }

    public String getSubject() {
        return subjectElement.getText();
    }

    public boolean isEmptySubjectMessageDisplayed() {
        return emptySubjectInboxMessage.isDisplayed();
    }

    public boolean isEmptySubjectSentMessageDisplayed() {
        return emptySubjectSentText.isDisplayed();
    }

    public MainAreaPage clickCheckbox() {
        checkbox.click();
        return this;
    }

    public MainAreaPage moveToFirstItem() {
        Actions action = new Actions(driver);
        action.moveToElement(firstItemCheckbox).perform();
        return this;
    }

    public String getSenderMessage() {
        return senderMessage.getAttribute("title");
    }

    public String getRecepientMessage() {
        return recepientMessage.getAttribute("title");
    }

    public WebElement getCheckbox() {
        return checkbox;
    }
}
