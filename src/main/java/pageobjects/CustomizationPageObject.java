package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CustomizationPageObject extends EvPage {
    public CustomizationPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li#id1 app-number-selector")
    private WebElement easeeNumberSelector;

    @FindBy(css = "[for=withInstallation]")
    private WebElement installationCheckbox;

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
    private WebElement membershipNumber;

}
