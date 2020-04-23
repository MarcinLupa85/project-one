package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPageObject {

    private NavbarObject navbarObject;

    public ContactPageObject(WebDriver driver) {
        navbarObject =  new NavbarObject(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id='name']")
    private WebElement fullNameInput;

    @FindBy(css = "[id='email']")
    private WebElement emailInput;

    @FindBy(css = "[id='phone']")
    private WebElement telephoneNumberInput;

    @FindBy(css = "[id='00N5800000DlrUQ']")
    private WebElement companyNameInput;

    @FindBy(css = "[id='description']")
    private WebElement commentInput;

    @FindBy(css = "div.message a[href=\"/home\"]")
    private WebElement backButton;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public WebElement getFullNameInput() { return fullNameInput; }

    public WebElement getEmailInput() { return emailInput; }

    public WebElement getTelephoneNumberInput() { return telephoneNumberInput; }

    public WebElement getCompanyNameInput() { return companyNameInput; }

    public WebElement getCommentInput() { return commentInput; }

    public WebElement getBackButton() { return backButton; }

    public WebElement submitButton() { return submitButton; }
}
