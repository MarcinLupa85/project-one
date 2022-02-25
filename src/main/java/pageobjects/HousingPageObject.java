package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HousingPageObject extends EvPage {
    public HousingPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Sjekk status og bestill')]")
    private WebElement checkStatusLink;

    @FindBy(css = "h2[class='heading-2 heading-dash']")
    private WebElement housingCompanyTitle;

    @FindBy(css = "input[class='form-control']")
    private WebElement housingCompanyInput;

    @FindBy(id = "ngb-typeahead-0-0")
    private WebElement dropdownFirstOption;

    @FindBy(css = "button[data-element='button']")
    private WebElement searchButton;

    @FindBy(css = "a[data-action='Bestill']")
    private WebElement buyButton;
}
