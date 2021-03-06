package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class NavbarObject extends EvPage {

    public NavbarObject(WebDriver driver) {
        super(driver);
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

    @FindBy(css = "a[href='/elbillading/ladepartnere'].nav-link")
    private WebElement chargingPartnerLink;

    @FindBy(css = "a[href='/elbillading/bedriftslading'].nav-link")
    private WebElement companyLink;

}
