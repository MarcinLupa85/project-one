package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HousePageObject;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class HousePageOperations {
    private HousePageObject housePageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;
    private NavbarOperations navbarOperations;

    public HousePageOperations(WebDriver driver) {
        housePageObject = new HousePageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(housePageObject, driver);
        navbarOperations = new NavbarOperations(driver);
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = housePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/house",2);
        assertThat(driver.getCurrentUrl()).contains("/house");
    }

    public void compareTitles(List<String> houseTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(houseTitles);
        System.out.println(houseTitles);
    }

    public void openCablePurchaseFlow() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        navbarOperations.openHousePage();
        WebElement cableLink = housePageObject.getPurchaseFlowCableLink();
        waitUtils.waitForVisiblityOf(cableLink);
        cableLink.click();
        waitUtils.waitForUrlToContains("/bestill/customize-order");
    }

}
