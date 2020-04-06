package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessPageObject {

    private NavbarObject navbarObject;

    public BusinessPageObject(WebDriver driver) {
        navbarObject =  new NavbarObject(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#name")
    private WebElement fullNameInput;

    @FindBy(css = "input#email")
    private WebElement emailInput;

    @FindBy(css = "input#phone")
    private WebElement telephoneNumberInput;

    @FindBy(css = "input#00N5800000DlrUQ")
    private WebElement companyNameInput;

    @FindBy(css = "input#description")
    private WebElement commentInput;

    @FindBy(css = "div.message a[href=\"/home\"]")
    private WebElement backButton;

    public WebElement getFullNameInput() {
        return fullNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getTelephoneNumberInput() {
        return telephoneNumberInput;
    }

    public WebElement getCompanyNameInput() {
        return companyNameInput;
    }

    public WebElement getCommentInput() {
        return commentInput;
    }

    public WebElement getBackButton() {
        return backButton;
    }
}
