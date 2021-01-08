package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    private NavbarObject navbarObject;

    public HomePageObject(WebDriver driver) {
        navbarObject =  new NavbarObject(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/hjemmelading-bestill/customize-order?id=1&optionId=179")
    private WebElement purchaseFlowEaseeLink;

    @FindBy(css = "a[href='/hjemmelading-bestill/customize-order?id=0']")
    private WebElement purchaseFlowMennekesLink;

    @FindBy(css = "li a.menu-element__hyperlink--user strong")
    private WebElement usernameText;

    @FindBy(css = "[href='/sp%C3%B8rsm%C3%A5l-og-svar'].btn")
    private WebElement readMoreFaqButton;


    public WebElement getPurchaseFlowEaseeLink() { return purchaseFlowEaseeLink; }
    public WebElement getPurchaseFlowMennekesLink() {
        return purchaseFlowMennekesLink;
    }
    public WebElement getUsernameText() {
        return usernameText;
    }
    public WebElement getReadMoreFaqButton() { return  readMoreFaqButton; }
}
