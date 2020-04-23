package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.NavbarObject;
import utils.WaitUtils;

public class NavbarOperations {

    private NavbarObject navbarObject;
    private WaitUtils waitUtils;

    public NavbarOperations(WebDriver driver) {
        navbarObject = new NavbarObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void openContactPage() {
        waitUtils.waitForElement(navbarObject.getContactLink());
        navbarObject.getContactLink().click();
        waitUtils.waitForUrlToContains("/kontakt");
    }

    public void openNavbarDropdown() {
        navbarObject.getNavbarDropdown().click();
    }

    public void openApartmentPage() {
        navbarObject.getApartmentLink().click();
        waitUtils.waitForUrlToContains("/sameie-borettslag");
    }

    public void openDeveloperPage() {
        navbarObject.getDeveloperLink().click();
        waitUtils.waitForUrlToContains("/utbygger");
    }

    public void openBusinessPage() {
        navbarObject.getBusinessLink().click();
        waitUtils.waitForUrlToContains("/bedrift");
    }

}
