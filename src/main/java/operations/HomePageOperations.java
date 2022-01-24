package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HomePageObject;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageOperations {

    private HomePageObject homePageObject;
    private ProductsPageOperations productsPageOperations;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private CustomizationPageOperations customizationPageOperations;
    private NavbarOperations navbarOperations;

    public HomePageOperations(WebDriver driver) {
        homePageObject = new HomePageObject(driver);
        productsPageOperations = new ProductsPageOperations(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        customizationPageOperations = new CustomizationPageOperations(driver);
        navbarOperations = new NavbarOperations(driver);
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = homePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisibilityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContain("/elbillading/ladestasjoner/faq",2);
        assertThat(driver.getCurrentUrl()).contains("/ladestasjoner/faq");
    }

    public void goToContactPage() {
        waitUtils.waitForVisibilityOf(homePageObject.getContactButton());
        waitUtils.bringElementToViewport(homePageObject.getContactButton());
        homePageObject.getContactButton().click();
        waitUtils.waitForUrlToContain("/kontakt-oss",2);
    }
}
