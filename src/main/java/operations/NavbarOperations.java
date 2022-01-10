package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.NavbarObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

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
        waitUtils.waitForUrlToContain("ladestasjoner");
    }

    public void openHousePage() {
        navbarObject.getHouseLink().click();
        waitUtils.waitForUrlToContain("/hjemmelading");
    }

    public void openCompanyPage() {
        driver.navigate().to(BASE_URL+"/bedriftslading");
    }

    public void openHouseAndCabinPage() {
        driver.navigate().to(BASE_URL+"/hjemmelading/hus-hytte");
    }

    public void openPartnerPage() {
        driver.navigate().to(BASE_URL+"/ladepartnere/utbygger");
    }

    public void openApartmentPage() {
        driver.navigate().to(BASE_URL+"/hjemmelading/borettslag-sameie");
    }

    public void openBecomeChargingPartnerPage() {
        driver.navigate().to(BASE_URL+"/ladepartnere");
    }

    public void openAndVerifyArticlesPage() throws TimeoutException {
        navbarObject.getArticlesLink().click();
        waitUtils.waitForUrlToContain("/ladenytt");
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.findElement(By.xpath("//h1[contains(text(), 'Ladenytt')]")).isDisplayed());
    }

    public void openProductsPage() {
        driver.navigate().to(BASE_URL+"/nettbutikk");
    }
}
