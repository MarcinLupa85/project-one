package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPageObject {

    public ContactPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement fullNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement telephoneNumberInput;

    @FindBy(css = "[id='companyName']")
    private WebElement companyNameInput;

    @FindBy(id = "description")
    private WebElement commentInput;

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

    public WebElement getCompanyNameInput() {
        return companyNameInput;
    }

    public WebElement getCommentInput() {
        return commentInput;
    }

    public WebElement submitButton() {
        return submitButton;
    }
}
