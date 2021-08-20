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

    @FindBy(css = "[for=withInstallation]")
    private WebElement installlationCheckbox;

    @FindBy(css = "[for=withExtra]")
    private WebElement extraCheckbox;

    @FindBy(xpath = "(.//button[@data-type='plus'])[last()]")
    private WebElement addEqualizer;

    @FindBy(css = "a[href=/hjemmelading]")
    private WebElement backButton;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(),'Totalpris')]/parent::h4")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[contains(text(),'Ladeabonnement')]/parent::h5")
    private WebElement subscriptionPrice;

    @FindBy(id = "membershipNumber")
    private  WebElement membershipNumber;

    public WebElement getEaseeNumberSelector() { return easeeNumberSelector; }

    public WebElement getInstallationCheckbox() {return installlationCheckbox; }

    public WebElement getExtraCheckbox() { return extraCheckbox; }

    public WebElement getAddEqualizer() { return addEqualizer; }

    public WebElement getSubmitButton() { return submitButton; }

    public WebElement getTotalPrice() { return totalPrice; }

    public WebElement getSubscriptionPrice() { return subscriptionPrice; }

    public WebElement getMembershipNumber() { return membershipNumber; }

}
