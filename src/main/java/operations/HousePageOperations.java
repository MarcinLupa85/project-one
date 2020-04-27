package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HousePageObject;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class HousePageOperations {
    HousePageObject housePageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public HousePageOperations(WebDriver driver) {
        housePageObject = new HousePageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = housePageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/house",2);
        assertThat(driver.getCurrentUrl()).contains("/house");
    }
}
