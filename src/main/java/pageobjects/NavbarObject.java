package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class NavbarObject {

    public NavbarObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/ladestasjoner'].nav-link")
    private WebElement onTheGoLink;

    @FindBy(css = "a[href='/hjemmelading'].nav-link")
    private WebElement houseLink;

    @FindBy(css = "a[href='/kontakt'].nav-link")
    private WebElement contactLink;

    @FindBy(css = "[class='nav-link dropdown-hover menu-element__hyperlink--user dropdown-toggle']")
    private WebElement navbarDropdown;

    @FindBy(css = "a[href='/sameie-borettslag'].nav-link")
    private WebElement apartmentLink;

    @FindBy(css = "a[href='/utbygger'].nav-link")
    private WebElement developerLink;

    @FindBy(css = "a[href='/bedrift'].nav-link")
    private WebElement businessLink;

    @FindBy(css = "[class='dropdown header-dropdown-menu user-panel-menu dropdown-menu']")
    private WebElement logoutLink;

    public WebElement getOnTheGoLink() { return onTheGoLink; }
    public WebElement getHouseLink() { return houseLink; }
    public WebElement getContactLink() { return contactLink; }
    public WebElement getNavbarDropdown() { return navbarDropdown; }
    public WebElement getApartmentLink() { return apartmentLink; }
    public WebElement getDeveloperLink() { return developerLink; }
    public WebElement getBusinessLink() { return businessLink; }
    public WebElement getLogoutLink() { return logoutLink; }
}
