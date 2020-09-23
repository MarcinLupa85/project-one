package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KlarnaPageObject {
    public KlarnaPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "buy-button")
    private WebElement buyButton;

    @FindBy(id = "postal_code")
    private WebElement postalCode;

    @FindBy(id = "national_identification_number")
    private WebElement nationalID;

    @FindBy(id = "given_name__label")
    private WebElement givenName;

    @FindBy(id = "family_name")
    private WebElement familyName;

    @FindBy(id = "street_address")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(css = "#identification-dialog__footer-button-wrapper button")
    private WebElement finishButton;

    @FindBy(id = "klarna-hpp-instance-fullscreen") private WebElement klarnaIFrame;

    public WebElement getBuyButton() {
        return buyButton;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getNationalID() {
        return nationalID;
    }

    public WebElement getGivenName() {
        return givenName;
    }

    public WebElement getFamilyName() {
        return familyName;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getFinishButton() {
        return finishButton;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getKlarnaIFrame() {
        return klarnaIFrame;
    }
}
