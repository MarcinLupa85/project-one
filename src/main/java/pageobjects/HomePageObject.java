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

    @FindBy(css = "[href='/elbillading/faq'].btn")
    private WebElement readMoreFaqButton;

    @FindBy(css = "a[href='/elbillading/kontakt-oss'].btn")
    private WebElement contactButton;

    public WebElement getReadMoreFaqButton() { return  readMoreFaqButton; }
    public WebElement getContactButton() { return contactButton; }
}
