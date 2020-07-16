package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CkidPageObject {

    public CkidPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id='edit-phone-number-country-code']")
    private WebElement countryCodeInput;

    @FindBy(css = "[id='edit-phone-number']")
    private WebElement phoneNumberInput;

    @FindBy(id = "submit-registration-step-one")
    private WebElement sendCodeButton;

    @FindBy(css = "[id='validation-code-input']")
    private WebElement smsCodeInput;

    @FindBy(css = "button[id='verify-validation-code']")
    private WebElement verifyCodeButton;

    @FindBy(css = "[id='input-account-creation-first-name-input']")
    private WebElement firstNameInput;

    @FindBy(css = "[id='input-account-creation-last-name-input']")
    private WebElement lastNameInput;

    @FindBy(css = "select#edit-region-select")
    private WebElement countryDropdown;

    @FindBy(css = "[class='icon-container']")
    private WebElement CkidTcCheckbox;

    @FindBy(css = "div[id=accepted-tc-e82a3da0-0d33-46e2-9c4c-7a0ac7d86dd9] span")
    private WebElement EvTcCheckbox;

    @FindBy(css = "#main-view > div > div > div > div > form > fieldset > div:nth-child(10) > div > button")
    private WebElement registerButton;

    @FindBy(css = "a[href=\"#/login\"]")
    private WebElement loginLink;

    @FindBy(css = "input[type=email]")
    private WebElement emailInput;

    @FindBy(css = "input[type=password]")
    private WebElement passwordInput;

    @FindBy(css = "button#login-submit-button")
    private WebElement loginButton;

    @FindBy(css = "section#user-dashboard [ui-sref='dashboard.myAccount']")
    private WebElement editAccountButton;

    @FindBy(css = "button[ng-click=\"deleteAccount()\"]")
    private WebElement deleteAccountButton;

    @FindBy(css = "input#input-validationPhrase")
    private WebElement validationPhraseInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement deleteAccountConfirmationButton;

    public WebElement getEditAccountButton() { return editAccountButton; }

    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public WebElement getValidationPhraseInput() {
        return validationPhraseInput;
    }

    public WebElement getDeleteAccountConfirmationButton() {
        return deleteAccountConfirmationButton;
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getCountryCodeInput() {
        return countryCodeInput;
    }

    public WebElement getPhoneNumberInput() { return phoneNumberInput; }

    public WebElement getSendCodeButton() {
        return sendCodeButton;
    }

    public WebElement getSmsCodeInput() {
        return smsCodeInput;
    }

    public WebElement getVerifyCodeButton() {
        return verifyCodeButton;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getCountryDropdown() {
        return countryDropdown;
    }

    public Select getCountrySelect() {
        return new Select(countryDropdown);
    }

    public WebElement getCkidTcCheckbox() { return CkidTcCheckbox; }

    public WebElement getEvTcCheckbox() { return EvTcCheckbox; }

    public WebElement getRegisterButton() { return registerButton; }
}
