package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.NavbarObject;
import utils.WaitUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

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
        navbarObject.getOnTheGoLink().click();
        waitUtils.waitForUrlToContains("ladestasjoner");
    }

    public void openHousePage() {
        navbarObject.getHouseLink().click();
        waitUtils.waitForUrlToContains("/hjemmelading");
    }

    public void openContactPage() {
        waitUtils.waitForElement(navbarObject.getContactLink());
        navbarObject.getContactLink().click();
        waitUtils.waitForUrlToContains("/kontakt");
    }

    public void clickNavbarDropdown() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
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

    public void openAndVerifyArticlesPage() throws TimeoutException {
        navbarObject.getArticlesLink().click();
        waitUtils.waitForUrlToContains("/nyheter/1");
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.findElement(By.xpath("//h2[contains(text(), 'Nyheter')]")).isDisplayed());
    }

    public void logout() {
        navbarObject.getLogoutLink().click();
    }

}
