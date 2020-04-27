package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HomePageObject;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class HomePageOperations {

    private HomePageObject homePageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private CustomizationPageOperations customizationPageOperations;

    public HomePageOperations(WebDriver driver) {
        homePageObject = new HomePageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        customizationPageOperations = new CustomizationPageOperations(driver);
    }

    public void openEaseePurchaseFlowNoExtra() {
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }
    public void openEaseePurchaseFlowWithExtra() {
        WebElement easeeLink = homePageObject.getPurchaseFlowEaseeLink();
        waitUtils.bringElementToViewport(easeeLink);
        easeeLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.tickExtraCheckbox();
    }

    public void openMennekesPurchaseFlow() {
        WebElement mennekesLink = homePageObject.getPurchaseFlowMennekesLink();
        waitUtils.bringElementToViewport(mennekesLink);
        mennekesLink.click();
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void openCablePurchaseFlow() {
        driver.navigate().to("https://emobility-test-unstable.test.gneis.io/hjemmelading-bestill/customize-order?id=2");
        waitUtils.waitForUrlToContains("/hjemmelading-bestill/customize-order");
    }

    public void logOut() {
        WebElement username = homePageObject.getUsernameText();
        waitUtils.waitForVisiblityOf(username);
        username.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("a.logout-href"));
        waitUtils.waitForVisiblityOf(logoutButton);
        logoutButton.click();
        waitUtils.waitForUrlToContains("/home");
    }
    public void goToFaq() {
        WebElement readMoreFaqButton = homePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/on-the-go",2);
        assertThat(driver.getCurrentUrl()).contains("/on-the-go");
    }

}
