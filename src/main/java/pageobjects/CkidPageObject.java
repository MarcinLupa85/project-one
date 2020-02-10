package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CkidPageObject {

    public CkidPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"#/login\"]")
    private WebElement loginLink;

    @FindBy(css = "input[type=email]")
    private WebElement emailInput;

    @FindBy(css = "input[type=password]")
    private WebElement passwordInput;

    @FindBy(css = "button#login-submit-button")
    private WebElement loginButton;


    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

}
