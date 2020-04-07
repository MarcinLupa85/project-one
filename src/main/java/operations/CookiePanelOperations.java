package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.ContactPageObject;
import pageobjects.CookiePanelObject;
import utils.FormUtils;
import utils.WaitUtils;

public class CookiePanelOperations {
    private CookiePanelObject cookiePanelObject;

    public CookiePanelOperations(WebDriver driver) {
        cookiePanelObject = new CookiePanelObject(driver);
    }


    public void clickCookieOkButton() {
        cookiePanelObject.cookieOkButton().click();
    }
}
