package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.NavbarObject;
import utils.WaitUtils;

import static testdata.EvRoutes.Navbar.*;

public class NavbarOperations {
    private NavbarObject navbarObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public NavbarOperations(WebDriver driver) {
        navbarObject = new NavbarObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void openOnTheGoPage() {
        waitUtils.waitForElementToBeClickable(navbarObject.getOnTheGoLink());
        navbarObject.getOnTheGoLink().click();
        waitUtils.waitForUrlToContain(ONTHEGO_PAGE);
    }

    public void openHousePage() {
        navbarObject.getHouseLink().click();
        waitUtils.waitForUrlToContain(HOUSE_PAGE);
    }

    public void openCompanyPage() {
        navbarObject.getCompanyLink().click();
        waitUtils.waitForUrlToContain(COMPANY_PAGE);
    }

    public void openPartnerPage() {
        navbarObject.getChargingPartnerLink().click();
        waitUtils.waitForUrlToContain(PARTNER_PAGE);
    }

    public void openArticlesPage() {
        navbarObject.getArticlesLink().click();
        waitUtils.waitForUrlToContain(ARTICLES_PAGE);
    }

    public void openProductsPage() {
        navbarObject.getProductsLink().click();
        waitUtils.waitForUrlToContain(PRODUCTS_PAGE);
    }

}
