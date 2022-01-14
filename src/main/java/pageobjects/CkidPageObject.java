package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
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

    @FindBy(css = "[class='button secondary ng-scope']")
    private WebElement registerSwitchButton;

    @FindBy(xpath = "//*[contains(text(),'Create account')]")
    private WebElement registerButton;

    @FindBy(css = "a[href=\"#/login\"]")
    private WebElement loginLink;

    @FindBy(css = "input[type=email]")
    private WebElement emailInput;

    @FindBy(css = "input[type=password]")
    private WebElement passwordInput;

    @FindBy(css = "button#login-submit-button")
    private WebElement loginButton;

    @FindBy(css = "section#user-dashboard-groups [ui-sref='dashboard.myAccount']")
    private WebElement editAccountButton;

    @FindBy(css = "button[ng-click=\"deleteAccount()\"]")
    private WebElement deleteAccountButton;

    @FindBy(id = "input-validationPhrase")
    private WebElement validationPhraseInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement deleteAccountConfirmationButton;

    @FindBy(id = "input-mfa-code")
    private WebElement secondStepVerificationInput;

    @FindBy(id = "mfa-submit-btn")
    private WebElement secondStepVerificationButton;

}
