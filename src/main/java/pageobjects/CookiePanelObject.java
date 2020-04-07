package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiePanelObject{
    private CookiePanelObject cookiePanelObject;

    public CookiePanelObject(WebDriver driver) {
        cookiePanelObject =  new CookiePanelObject(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[class='btn btn-sm btn-primary']")
    private WebElement cookieOkButton;

    public WebElement cookieOkButton() {
        return cookieOkButton;
    }
}
