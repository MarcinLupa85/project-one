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

    @FindBy(css = "a[href='/elbillading/bestill?with=1140446']")
    private WebElement purchaseFlowEaseeLink;

    @FindBy(css = "a[href='/elbillading/bestill?with=1166018']")
    private WebElement purchaseFlowEqualizerLink;

    @FindBy(css = "li a.menu-element__hyperlink--user strong")
    private WebElement usernameText;

    @FindBy(css = "[href='/elbillading/faq'].btn")
    private WebElement readMoreFaqButton;

    @FindBy(css = "a[href='/elbillading/kontakt-oss'].btn")
    private WebElement contactButton;

    public WebElement getPurchaseFlowEaseeLink() { return purchaseFlowEaseeLink; }
    public WebElement getPurchaseFlowEqualizerLink() { return purchaseFlowEqualizerLink; }
    public WebElement getReadMoreFaqButton() { return  readMoreFaqButton; }
    public WebElement getContactButton() { return contactButton; }
}
