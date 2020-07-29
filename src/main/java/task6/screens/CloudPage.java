package task6.screens;

import org.openqa.selenium.By;
import task6.logger.Log;
import task6.utilities.Browser;

public class CloudPage extends BasePage {

    private static final By CREATE_BUTTON = By.xpath("//div[@data-name='create']");
    private static final By LOGO_IMAGE = By.xpath("//img[@title='Облако Mail.ru']");
    private static final By CREATE_FOLDER_BUTTON = By.xpath("//div[@data-name='createFolder']");
    private static final By INPUT_FOLDER_NAME = By.xpath("//input[@placeholder='Введите имя папки']");
    private static final By CREATE_FOLDER_CONFIRM_BUTTON = By.xpath("//button[@class='ui fluid primary button']");
    private static final By SELECT_ALL_BUTTON = By.xpath("//div[@data-name='selectAll']");
    private static final By DELETE_ALL_BUTTON = By.xpath("//div[@data-name='remove']");
    private static final By DELETE_ALL_CONFIRM_BUTTON = By.xpath("//button[@data-name='remove']");
    private static final By FOLDER_ITEM = By.xpath("//div[@class='DataListItemThumb__root--3TJe9']");
    private static final By MY_FILES_BUTTON = By.xpath("//span[@bem-id='21']");
    private static final By TRASH_POPUP = By.xpath("//div[@class='layer_trashbin-tutorial']");
    private static final By TRASH_POPUP_CLOSE_BUTTON = By.xpath("//div[@class='layer_trashbin-tutorial']//button[@data-name='close']");
    private static final By UPLOAD_BUTTON = By.xpath("//div[@data-name='upload']");
    private static final By UPLOAD_FILE_BUTTON = By.xpath("//input[@type='file' and @name='files' and @class='layer_upload__controls__input' ]");
    private static final By EMPTY_FOLDER_ICON = By.xpath("//div[@class='FileIcon__icon--21fhF']");
    private static final By CREATED_ITEM = By.xpath("//div[@class='Name__name--13u3t']");
    private static final By OPEN_LINK_PUBLICITY = By.xpath("//div[contains(text(), 'Открыть доступ по ссылке')]");
    private static final By COPY_LINK = By.xpath("//input[@title='Скопировать']");
    private static final By SHARED_FOLDER = By.xpath("//div[@class='Breadcrumb__text--1Qzms']");

    public CloudPage clickCreateButton() {
        Log.logInfo("Clicking 'Create' button");
        browser.clickElementFromArray(CREATE_BUTTON, 0);
        return this;
    }

    public boolean isLogoImageDisplayed() {
        Browser.waitForElementToBeDisplayed(LOGO_IMAGE);
        return browser.isElementDisplayed(LOGO_IMAGE);
    }

    public CloudPage clickCreateFolderButton() {
        Log.logInfo("Clicking 'Create Folder' button");
        browser.clickElement(CREATE_FOLDER_BUTTON);
        return this;
    }

    public CloudPage inputFolderName(String name) {
        Log.logInfo("Inputting folder name " + name);
        browser.typeTo(INPUT_FOLDER_NAME, name);
        return this;
    }

    public CloudPage clickCreateFolderConfirmButton() {
        Log.logInfo("Clicking 'Create Folder' confirm button");
        browser.clickElement(CREATE_FOLDER_CONFIRM_BUTTON);
        Browser.waitForElementToBeDisplayed(EMPTY_FOLDER_ICON);
        return this;
    }

    public CloudPage clickSelectAllButton() {
        Log.logInfo("Clicking 'Select All' confirm button");
        browser.clickElementFromArray(SELECT_ALL_BUTTON, 0);
        return this;
    }

    public CloudPage clickDeleteAllButton() {
        Log.logInfo("Clicking 'Delete All' confirm button");
        Browser.waitForElementToBeDisplayed(DELETE_ALL_BUTTON);
        browser.clickElement(DELETE_ALL_BUTTON);
        return this;
    }

    public CloudPage clickDeleteAllConfirmButton() {
        Log.logInfo("Clicking 'Delete All' confirm button");
        browser.clickElement(DELETE_ALL_CONFIRM_BUTTON);
        return this;
    }

    public boolean isFoldersNotExist() {
        return browser.isElementsNotExist(FOLDER_ITEM);
    }

    public CloudPage clickMyFilesButton() {
        Log.logInfo("Clicking 'My files' button");
        Browser.waitForElementToBeClickable(MY_FILES_BUTTON);
        browser.clickElement(MY_FILES_BUTTON);
        return this;
    }

    public boolean isTrashPopupDisplayed() {
        Browser.waitForElementToBeDisplayed(TRASH_POPUP);
        return browser.isElementDisplayed(TRASH_POPUP);
    }

    public void clickTrashPopUpCloseButton() {
        browser.clickElement(TRASH_POPUP_CLOSE_BUTTON);
    }

    public CloudPage clickUploadButton() {
        Log.logInfo("Clicking 'Upload' button");
        browser.clickElementFromArray(UPLOAD_BUTTON, 0);
        return this;
    }

    public void chooseFile(String file) {
        Log.logInfo("Choosing file from file system " + file);
        browser.typeTo(UPLOAD_FILE_BUTTON, file);
    }

    public String getTextCreatedFolder() {
        Browser.waitForElementToBeDisplayed(CREATED_ITEM);
        return browser.getText(CREATED_ITEM);
    }

    public CloudPage clickCreatedFolder() {
        Log.logInfo("Clicking on created folder");
        browser.clickElement(CREATED_ITEM);
        return this;
    }

    public boolean createdItemIsDisplayed() {
        Browser.waitForElementToBeDisplayed(CREATED_ITEM);
        return browser.isElementDisplayed(CREATED_ITEM);
    }

    public CloudPage rightClickMouseCreatedItem() {
        Log.logInfo("Right click mouse on created item");
        Browser.waitForElementToBeDisplayed(CREATED_ITEM);
        browser.rightClickMouse(CREATED_ITEM);
        Browser.waitForElementToBeDisplayed(OPEN_LINK_PUBLICITY);
        return this;
    }

    public CloudPage clickOpenLinkPublicityButton() {
        Log.logInfo("Clicking on link for sharing");
        browser.clickElement(OPEN_LINK_PUBLICITY);
        return this;
    }

    public CloudPage switchToNewTab() {
        browser.switchToNewTab();
        return this;
    }

    public String getLink() {
        Browser.waitForElementToBeDisplayed(COPY_LINK);
        return browser.getAttribute(COPY_LINK, "value");
    }

    public void openLinkInNewTab(String url) {
        Log.logInfo("Opening link in new tab " + url);
        browser.getUrl(url);
        Browser.waitForElementToBeDisplayed(SHARED_FOLDER);
    }

    public boolean createdItemIsNotExist() {
        return browser.isElementsNotExist(CREATED_ITEM);
    }

    public String getNameSharedFolder() {
        return browser.getText(SHARED_FOLDER);
    }
}

