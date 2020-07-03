package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiePanelObject{
    private CookiePanelObject cookiePanelObject;

    public CookiePanelObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement cookieOkButton;

    @FindBy(id = "CybotCookiebotDialogBodyLevelDetailsButton")
    private WebElement cookieDetailsButton;

    public WebElement getCookieOkButton() {
        return cookieOkButton;
    }

    public WebElement getCookieDetailsButton(){
        return cookieDetailsButton;
    }
}
