package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CustomizationPageObject;
import utils.WaitUtils;
import static org.assertj.core.api.Assertions.assertThat;
import static config.Constants.BASE_URL;

public class SDUFlowOperations {
    private CustomizationPageObject customizationPageObject;
    private WaitUtils waitUtils;
    WebDriver driver;

    public SDUFlowOperations(WebDriver driver) {
        customizationPageObject = new CustomizationPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void GoToInglandGarasjen() {
        driver.navigate().to(BASE_URL + "hjemmelading-bestill/customize-order?offer_id=28a3d121e93045d8bae308dbfbcc17ca");
        WebElement submitButton = customizationPageObject.getSubmitButton();
        waitUtils.waitForVisiblityOf(submitButton);
    }

    public void checkPrice() {
        WebElement totalPrice = customizationPageObject.getTotalPrice();
        assertThat(totalPrice.getText()).containsPattern("kr\\s7.895,-");
    }
}