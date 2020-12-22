package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizationPageObject
{
    public CustomizationPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li#id1 app-number-selector")
    private WebElement easeeNumberSelector;

    @FindBy(css = "label.custom-control-center")
    private WebElement installlationCheckbox;

    @FindBy(css= "label[for='join-extra']")
    private WebElement extraCheckbox;

    @FindBy(xpath = "/html/body/ev-root/ev-base-layout/ev-house-order-page/div/ev-step-customize-order/div/div/div/ev-products-ordering-list/ev-product-ordering[3]/div/div[1]/ev-number-selector/div/button[2]")
    private WebElement addEqualizer;

    @FindBy(css = "a[href=\"/hjemmelading\"]")
    private WebElement backButton;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".order-summary__total-price")
    private WebElement totalPrice;

    @FindBy(css = "[class = 'order-summary__subscription-price']")
    private WebElement subscriptionFee;

    @FindBy(id = "membershipNumber")
    private  WebElement membershipNumber;

    public WebElement getEaseeNumberSelector() { return easeeNumberSelector; }

    public WebElement getInstallationCheckbox() {return installlationCheckbox; }

    public WebElement getExtraCheckbox() { return extraCheckbox; }

    public WebElement getAddEqualizer() { return addEqualizer; }

    public WebElement getSubmitButton() { return submitButton; }

    public WebElement getTotalPrice() { return totalPrice; }

    public WebElement getSubscriptionFee() { return subscriptionFee; }

    public WebElement getMembershipNumber() { return membershipNumber; }

}
