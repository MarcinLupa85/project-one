package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePageObject {

    public CompletePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "p.order-successful strong")
    private WebElement emailText;

    @FindBy(css = "a[href=\"/elbillading\"]")
    private WebElement backButton;

    public WebElement getEmailText() {
        return emailText;
    }

    public WebElement getBackButton() {
        return backButton;
    }
}

