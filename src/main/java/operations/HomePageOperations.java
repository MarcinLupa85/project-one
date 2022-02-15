package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HomePageObject;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageOperations extends BaseOperations {

    private HomePageObject homePageObject;

    public HomePageOperations(WebDriver driver) {
        super(driver);
        homePageObject = new HomePageObject(driver);
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = homePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisibilityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContain("/elbillading/ladestasjoner/faq", 2);
        assertThat(driver.getCurrentUrl()).contains("/ladestasjoner/faq");
    }

    public void goToContactPage() {
        waitUtils.waitForVisibilityOf(homePageObject.getContactButton());
        waitUtils.bringElementToViewport(homePageObject.getContactButton());
        homePageObject.getContactButton().click();
        waitUtils.waitForUrlToContain("/kontakt-oss", 2);
    }
}
