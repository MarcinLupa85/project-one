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

    @FindBy(css = "[id='name']")
    private WebElement fullNameInput;

    @FindBy(css = "[id='email']")
    private WebElement emailInput;

    @FindBy(css = "[id='phone']")
    private WebElement telephoneNumberInput;

    @FindBy(css = "[id='00N1x000002heFL']")
    private WebElement chargersNumber;

    @FindBy(css = "select[id*='00N1x000002heGE']")
    private WebElement carMake;

    //@FindBy(css = "#\\30 0N1x000002heGE > option:nth-child(2)")    private WebElement carMakeBMW;

    @FindBy(css = "#\\30 0N1x000002heKR")
    private WebElement carModel;

    @FindBy(css = "[id=description]")
    private WebElement description;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public WebElement getFullNameInput() {
        return fullNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getTelephoneNumberInput() {
        return telephoneNumberInput;
    }

    public WebElement getChargersNumber() { return chargersNumber; }

    public WebElement getCarMake() { return carMake; }

    //public WebElement getCarMakeBMW() { return carMakeBMW; }

    public WebElement getCarModel() { return carModel; }

    public WebElement getDescription() { return description; }

    public WebElement getSubmitButton() { return submitButton; }
}
