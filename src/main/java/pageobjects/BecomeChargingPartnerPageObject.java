package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class BecomeChargingPartnerPageObject extends EvPage {
    public BecomeChargingPartnerPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[data-action='KONTAKT MEG']")
    private WebElement contactUsButton;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "membershipOrganization")
    private WebElement membershipOrganization;

    @FindBy(id = "parkingUnits")
    private WebElement parkingUnits;

    @FindBy(css = "button[data-action='Send']")
    private WebElement sendButton;

}
