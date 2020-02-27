package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    private TopMenuObject topMenuObject;

    public HomePageObject(WebDriver driver) {
        topMenuObject =  new TopMenuObject(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/hjemmelading-bestill/customize-order?id=1']")
    private WebElement purchaseFlowEaseeLink;

    @FindBy(css = "a[href='/hjemmelading-bestill/customize-order?id=0'].buttons-wrapper__btn")
    private WebElement purchaseFlowMennekesLink;

    @FindBy(css = "li a.menu-element__hyperlink--user strong")
    private WebElement usernameText;

    public WebElement getPurchaseFlowEaseeLink() {
        return purchaseFlowEaseeLink;
    }
    public WebElement getPurchaseFlowMennekesLink() {
        return purchaseFlowMennekesLink;
    }

    public WebElement getUsernameText() {
        return usernameText;
    }
}
