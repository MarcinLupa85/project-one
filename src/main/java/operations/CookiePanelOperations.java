package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.CookiePanelObject;

public class CookiePanelOperations {
    private CookiePanelObject cookiePanelObject;

    public CookiePanelOperations(WebDriver driver) {
        cookiePanelObject = new CookiePanelObject(driver);
    }

    public void clickCookieOkButton() {
        cookiePanelObject.getCookieOkButton().click();
    }
}
