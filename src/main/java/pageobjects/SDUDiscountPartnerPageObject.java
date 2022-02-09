package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SDUDiscountPartnerPageObject extends EvPage {
    public SDUDiscountPartnerPageObject(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(css = "img[alt='Circle K EXTRA Mastercard']")
    private WebElement mastercardBanner;

}
