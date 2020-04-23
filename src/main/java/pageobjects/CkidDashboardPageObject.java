package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CkidDashboardPageObject {

    public CkidDashboardPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-dashboard > div:nth-child(3) > div > div:nth-child(4) > button")
    private WebElement editAccountButton;

    @FindBy(css = "button[ng-click=\"deleteAccount()\"]")
    private WebElement deleteAccountButton;

    @FindBy(css = "input#input-validationPhrase")
    private WebElement validationPhraseInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement deleteAccountConfirmationButton;

    public WebElement getEditAccountButton() { return editAccountButton; }

    public WebElement getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public WebElement getValidationPhraseInput() {
        return validationPhraseInput;
    }

    public WebElement getDeleteAccountConfirmationButton() {
        return deleteAccountConfirmationButton;
    }
}
