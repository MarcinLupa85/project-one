package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarObject {

    public NavbarObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/elbillading/ladestasjoner'].nav-link")
    private WebElement onTheGoLink;

    @FindBy(css = "a[href='/elbillading/hjemmelading'].nav-link")
    private WebElement houseLink;

    @FindBy(xpath = "//a[contains(text(), 'Borettslag/Sameie/Utbygger')]")
    private WebElement navbarDropdown;

    @FindBy(css = "a[href='/elbillading/ladetjenester/utbygger'].nav-link")
    private WebElement developerLink;

    @FindBy(css = "a[href='/elbillading/ladenytt'].nav-link")
    private WebElement articlesLink;

    @FindBy(css = "a[href='/elbillading/nettbutikk'].nav-link")
    private WebElement productsLink;

    public WebElement getOnTheGoLink() { return onTheGoLink; }
    public WebElement getHouseLink() { return houseLink; }
    public WebElement getNavbarDropdown() { return navbarDropdown; }
    public WebElement getDeveloperLink() { return developerLink; }
    public WebElement getArticlesLink() { return articlesLink; }
    public WebElement getProductsLink() { return productsLink; }
}
