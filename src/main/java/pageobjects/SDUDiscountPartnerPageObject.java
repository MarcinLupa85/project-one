package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SDUDiscountPartnerPageObject {
    public SDUDiscountPartnerPageObject(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(css = "button[data-action='Logg inn']")
    private WebElement logInButton;

    @FindBy(css = "a[data-action='Bli medlem']")
    private WebElement becomeMemberButton;
}
