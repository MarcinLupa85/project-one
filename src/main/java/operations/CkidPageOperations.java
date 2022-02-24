package operations;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.CkidPageObject;
import testdata.Users;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static config.Constants.CKID_URL;
import static config.Constants.SMS_CODE;

public class CkidPageOperations {
    private static final Logger LOGGER = LogManager.getLogger(CkidPageOperations.class);
    private CkidPageObject ckidPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private List<User> testUsers;
    private String userName, password;
    private CookiePanelOperations cookiePanelOperations;

    public CkidPageOperations(WebDriver driver) {
        ckidPageObject = new CkidPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        testUsers = new Users().getUsersList();
        cookiePanelOperations = new CookiePanelOperations(driver);
    }

    public void logIn(String username, String password) throws TimeoutException {
        try {
            provideLoginCredentials(username, password);
            ckidPageObject.getLoginButton().click();
        } catch (ElementClickInterceptedException e) {
            LOGGER.error("Cookie bot did not close properly", e);
            driver.navigate().refresh();
            provideLoginCredentials(username, password);
            ckidPageObject.getLoginButton().click();
        }
    }

    public void provideLoginCredentials(String username, String password) throws TimeoutException {
        waitUtils.waitForPresenceOf(By.cssSelector("input[type=email]"));
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
    }

    public void registerNewUser(String phoneNumber, String username, String password) {
        waitUtils.waitForElementToBeClickable(ckidPageObject.getRegisterSwitchButton());
        ckidPageObject.getRegisterSwitchButton().click();
        waitUtils.waitForPresenceOf(By.cssSelector("input#edit-phone-number"));
        ckidPageObject.getCountryCodeInput().sendKeys("48");
        ckidPageObject.getPhoneNumberInput().sendKeys(phoneNumber);
        ckidPageObject.getSendCodeButton().click();
        waitUtils.waitForPresenceOf(By.cssSelector("input#validation-code-input"));
        // universal SMS code for test CKID environments
        ckidPageObject.getSmsCodeInput().sendKeys(SMS_CODE);
        ckidPageObject.getVerifyCodeButton().click();
        waitUtils.waitForPresenceOf(By.cssSelector("input[type=email]"));
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getFirstNameInput().sendKeys("Tester");
        ckidPageObject.getLastNameInput().sendKeys("Kowalski");
        Select countrySelect = new Select(ckidPageObject.getCountryDropdown());
        countrySelect.selectByValue("string:NORWAY");
        waitUtils.waitForPresenceOf(By.cssSelector("[class = 'icon-container']"));
        ckidPageObject.getCkidTcCheckbox().click();
//        skipped due to Stable environment being repurposed
//        ckidPageObject.getEvTcCheckbox().click();
        //Accepted in review
        waitUtils.waitForElementToBeClickable(ckidPageObject.getRegisterButton());
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", ckidPageObject.getRegisterButton());
    }

    public void closeCookieBot() throws TimeoutException {
        waitUtils.waitForPresenceOf(By.id("CybotCookiebotDialogBodyUnderlay"));
        waitUtils.waitForPresenceOf(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookiePanelOperations.clickCookieOkButton();
        waitUtils.waitForDocumentReadyState();
    }

    public void deleteAccounts() throws TimeoutException {
        driver.navigate().to(CKID_URL);
        closeCookieBot();
        testUsers.forEach(this::deleteAccount);

    }

    private void deleteAccount(User testUser) {
        try {
            driver.navigate().to(CKID_URL);
            waitUtils.waitForDocumentReadyState();
            userName = testUser.getEmail();
            waitUtils.waitForVisibilityOf(ckidPageObject.getEmailInput());
            ckidPageObject.getEmailInput().clear();
            ckidPageObject.getEmailInput().sendKeys(userName);
            password = testUser.getPassword();
            ckidPageObject.getPasswordInput().clear();
            ckidPageObject.getPasswordInput().sendKeys(password);
            ckidPageObject.getLoginButton().click();
            waitUtils.waitForElementToBeClickable(ckidPageObject.getSecondStepVerificationInput());
            // default password for CKID test env
            ckidPageObject.getSecondStepVerificationInput().sendKeys(SMS_CODE);
            ckidPageObject.getSecondStepVerificationButton().click();
            waitUtils.waitForDocumentReadyState();
            waitUtils.waitForElement(ckidPageObject.getEditAccountButton());
            waitUtils.bringElementToViewport(ckidPageObject.getEditAccountButton());
            ckidPageObject.getEditAccountButton().click();
            waitUtils.waitForDocumentReadyState();
            waitUtils.waitForElement(ckidPageObject.getDeleteAccountButton()).click();
            waitUtils.waitForElement(ckidPageObject.getValidationPhraseInput()).sendKeys("DELETE ACCOUNT");
            waitUtils.waitForElement(ckidPageObject.getDeleteAccountConfirmationButton()).click();
            waitUtils.waitForPresenceOf(By.id("login-submit-button"));
            driver.navigate().to(CKID_URL);
        } catch (org.openqa.selenium.TimeoutException | TimeoutException exception) {
            LOGGER.error("Cannot delete user {} due to exception", testUser.getEmail());
            exception.printStackTrace();
        }
    }

}
