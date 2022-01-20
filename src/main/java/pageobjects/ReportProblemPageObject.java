package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ReportProblemPageObject extends EvPage {

    public ReportProblemPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement fullNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement telephoneNumberInput;

    @FindBy(id = "chargerNumber")
    private WebElement chargersNumber;

    @FindBy(id = "carBrand")
    private WebElement carMake;

    @FindBy(id = "carModel")
    private WebElement carModel;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

}
