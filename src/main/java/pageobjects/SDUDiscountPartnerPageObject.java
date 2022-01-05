package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SDUDiscountPartnerPageObject {
    public SDUDiscountPartnerPageObject(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(css = "button[data-action='Logg inn']")
    private WebElement logInButton;

    @FindBy(css = "a[data-action='Bli medlem']")
    private WebElement becomeMemberButton;

    @FindBy(css = "a[href='/elbillading/partnere/obos/details/no-extra']")
    private WebElement noExtraLink;

    @FindBy(id = "membership-number")
    private WebElement membershipNumber;

    @FindBy(css = "button[data-action='Send inn']")
    private WebElement sendButton;

    @FindBy(id = "phone-number")
    private WebElement phone;

    @FindBy(css = "button[data-action='Send kode']")
    private WebElement sendCode;

    @FindBy(css = "input[autocomplete='one-time-code']")
    private WebElement smsCodeInput;

    @FindBy(css = "button[type='submit']")
    private WebElement confirmButton;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[data-action='Register']")
    private WebElement registerButton;

    @FindBy(css = "label[class='custom-control-label']")
    private WebElement extraCheckbox;

    public WebElement getLogInButton() { return logInButton; }

    public WebElement getBecomeMemberButton() { return becomeMemberButton; }

    public WebElement getNoExtraLink() { return noExtraLink; }

    public WebElement getMembershipNumber() { return membershipNumber; }

    public WebElement getSendButton() { return sendButton; }

    public WebElement getPhone() { return phone; }

    public WebElement getSendCode() { return sendCode; }

    public WebElement getSmsCodeInput() { return smsCodeInput; }

    public WebElement getConfirmButton() { return confirmButton; }

    public WebElement getFirstName() { return firstName; }

    public WebElement getLastName() { return lastName; }

    public WebElement getEmail() { return email; }

    public WebElement getPassword() { return password; }

    public WebElement getRegisterButton() { return registerButton; }

    public WebElement getExtraCheckbox() { return extraCheckbox; }
}
