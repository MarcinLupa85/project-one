package operations;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageobjects.CkidPageObject;
import utils.Users;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;

public class CkidPageOperations {

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

    public void logInWithCredentials(String username, String password) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", ckidPageObject.getLoginLink());
        waitUtils.waitForPresentOf(By.cssSelector("input[type=email]"));
        closeCookieBot();
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getLoginButton().click();
    }

    public void registerNewUser(String phoneNumber, String username, String password) {
        waitUtils.waitForPresentOf(By.cssSelector("input#edit-phone-number"));
        ckidPageObject.getCountryCodeInput().sendKeys("48");
        ckidPageObject.getPhoneNumberInput().sendKeys(phoneNumber);
        ckidPageObject.getSendCodeButton().click();
        waitUtils.waitForPresentOf(By.cssSelector("input#validation-code-input"));
        // universal SMS code for test CKID environments
        ckidPageObject.getSmsCodeInput().sendKeys("000000");
        ckidPageObject.getVerifyCodeButton().click();
        waitUtils.waitForPresentOf(By.cssSelector("input[type=email"));
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getFirstNameInput().sendKeys("Tester");
        ckidPageObject.getLastNameInput().sendKeys("Kowalski");
        ckidPageObject.getCountrySelect().selectByValue("string:NORWAY");
        waitUtils.waitForPresentOf(By.cssSelector("[class = 'icon-container']"));
        ckidPageObject.getCkidTcCheckbox().click();
        //Accepted in review
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", ckidPageObject.getRegisterButton());
    }

    public void closeCookieBot() {
        waitUtils.waitForPresentOf(By.id("CybotCookiebotDialogBodyUnderlay"));
        waitUtils.waitForPresentOf(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cookiePanelOperations.clickCookieOkButton();
    }

    public void deleteAccounts() {
        driver.navigate().to("https://test-circlekid-core-stable.test.gneis.io/#/dashboard");
        closeCookieBot();
        testUsers.forEach(this::deleteAccount);

    }

    private void deleteAccount(User testUser) {
        try {
            driver.navigate().to("https://test-circlekid-core-stable.test.gneis.io/#/dashboard");
            waitUtils.waitForDocumentReadyState();
            userName = testUser.getEmail();
            waitUtils.waitForVisiblityOf(ckidPageObject.getEmailInput());
            ckidPageObject.getEmailInput().clear();
            ckidPageObject.getEmailInput().sendKeys(userName);
            password = testUser.getPassword();
            ckidPageObject.getPasswordInput().clear();
            ckidPageObject.getPasswordInput().sendKeys(password);
            ckidPageObject.getLoginButton().click();
            waitUtils.waitForDocumentReadyState();
            waitUtils.waitForElement(ckidPageObject.getEditAccountButton());
            waitUtils.bringElementToViewport(ckidPageObject.getEditAccountButton());
            ckidPageObject.getEditAccountButton().click();
            waitUtils.waitForDocumentReadyState();
            waitUtils.waitForElement(ckidPageObject.getDeleteAccountButton()).click();
            waitUtils.waitForElement(ckidPageObject.getValidationPhraseInput()).sendKeys("CLOSE MY ACCOUNT");
            waitUtils.waitForElement(ckidPageObject.getDeleteAccountConfirmationButton()).click();
            waitUtils.waitForPresentOf(By.id("login-submit-button"));
            driver.navigate().to("https://test-circlekid-core-stable.test.gneis.io/#/dashboard");
        } catch (org.openqa.selenium.TimeoutException|TimeoutException exception) {
            System.out.printf("Cannot delete user %s due to exception %s %n", testUser.getEmail(), exception.getMessage());
            exception.printStackTrace();
        }
    }

}
