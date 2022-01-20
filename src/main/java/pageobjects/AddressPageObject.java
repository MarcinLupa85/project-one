package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AddressPageObject extends EvPage {

    public AddressPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billingAddress")
    private WebElement billingAddressInput;

    @FindBy(id = "billingZip")
    private WebElement billingZipCodeInput;

    @FindBy(id = "billingCity")
    private WebElement billingCityInput;

    @FindBy(id = "parkingPlace0")
    private WebElement parkingPlaceInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement nextButton;

    @FindBy(id = "comment")
    private WebElement commentInput;

    @FindBy(xpath = "//label[contains(text(), 'at installasjonen om mulig skal')]")
    private WebElement fourteenDaysCheckbox;
}
