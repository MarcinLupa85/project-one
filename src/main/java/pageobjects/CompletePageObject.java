package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePageObject {

    public CompletePageObject(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(css = "a[href=\"/elbillading\"]")
    private WebElement backButton;

    public WebElement getBackButton() {
        return backButton;
    }
}

