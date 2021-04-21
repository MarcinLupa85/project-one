package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportProblemPageObject {
    private ReportProblemPageObject reportProblemPageObject;

    public ReportProblemPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
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

    public WebElement getFullNameInput() { return fullNameInput; }

    public WebElement getEmailInput() { return emailInput; }

    public WebElement getTelephoneNumberInput() { return telephoneNumberInput; }

    public WebElement getChargersNumber() { return chargersNumber; }

    public WebElement getCarMake() { return carMake; }

    public WebElement getCarModel() { return carModel; }

    public WebElement getDescription() { return description; }

    public WebElement getSubmitButton() { return submitButton; }
}
