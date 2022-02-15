package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.NavbarObject;

import static testdata.EvRoutes.Navbar.*;

public class NavbarOperations extends BaseOperations {
    private NavbarObject navbarObject;

    public NavbarOperations(WebDriver driver) {
        super(driver);
        navbarObject = new NavbarObject(driver);
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
