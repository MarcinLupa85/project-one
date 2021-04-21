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

    public void clickNavbarDropdown() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        navbarObject.getNavbarDropdown().click();
        waitUtils.waitForUrlToContains("/ladetjenester");
    }

    public void openApartmentPage() {
        navbarObject.getApartmentLink().click();
        waitUtils.waitForUrlToContains("/borettslag-sameie");
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
        waitUtils.waitForUrlToContains("/ladenytt");
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.findElement(By.xpath("//h1[contains(text(), 'Ladenytt')]")).isDisplayed());
    }

    public void logout() {
        navbarObject.getLogoutLink().click();
    }

}
