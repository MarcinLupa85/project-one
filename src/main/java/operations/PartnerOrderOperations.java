package operations;

import org.openqa.selenium.*;
import pageobjects.PartnerOrderPageObject;
import utils.FormUtils;
import utils.WaitUtils;
import static org.assertj.core.api.Assertions.assertThat;

import static config.Constants.BASE_URL;

public class PartnerOrderOperations {
    private PartnerOrderPageObject partnerOrderPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;
    private WebDriver driver;

    public PartnerOrderOperations(WebDriver driver) {
        partnerOrderPageObject = new PartnerOrderPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        this.driver = driver;
    }

    public void goToElkjop() {
        driver.navigate().to(BASE_URL + "partner-order?id=39XoLZjNS7nAM54rAGW8lEg5PijAY4l0");
    }

    public void fillElkjopForm(String firstName, String lastName, String mail, String phone, String address, String zipCode, String city) {
        waitUtils.waitForElement(partnerOrderPageObject.getFirstName());
        waitUtils.bringElementToViewport(partnerOrderPageObject.getFirstName());
        formUtils.fillField(partnerOrderPageObject.getFirstName(), firstName);
        formUtils.fillField(partnerOrderPageObject.getLastName(), lastName);
        formUtils.fillField(partnerOrderPageObject.getMail(), mail);
        formUtils.fillField(partnerOrderPageObject.getPhone(), phone);
        formUtils.fillField(partnerOrderPageObject.getAddress(), address);
        formUtils.fillField(partnerOrderPageObject.getZipCode(), zipCode);
        formUtils.fillField(partnerOrderPageObject.getCity(), city);
    }

    public void submitOrder() {
        partnerOrderPageObject.getSubmitButton().click();
        String congratulations = driver.findElement(By.cssSelector("[class='heading-4']")).getText();
        assertThat(congratulations).contains("Gratulerer!");
    }

    public void tickInstallationCheckbox() {
        waitUtils.waitForElement(partnerOrderPageObject.getInstallationCheckbox());
        partnerOrderPageObject.getInstallationCheckbox().click();
    }
}
