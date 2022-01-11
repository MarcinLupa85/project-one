package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.BecomeChargingPartnerPageObject;
import utils.FormUtils;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class BecomeChargingPartnerPageOperations {
    private BecomeChargingPartnerPageObject becomeChargingPartnerPageObject;
    private FormUtils formUtils;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public BecomeChargingPartnerPageOperations(WebDriver driver) {
        becomeChargingPartnerPageObject = new BecomeChargingPartnerPageObject(driver);
        formUtils = new FormUtils(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void openForm() {
        becomeChargingPartnerPageObject.getContactUsButton().click();
        waitUtils.waitForElementToBeClickable(becomeChargingPartnerPageObject.getFirstName());
    }

    public void fillForm(String firstName, String lastName, String email, String phone, String company, String membershipOrganization, String parkingUnits) {
        formUtils.fillField(becomeChargingPartnerPageObject.getFirstName(), firstName);
        formUtils.fillField(becomeChargingPartnerPageObject.getLastName(), lastName);
        formUtils.fillField(becomeChargingPartnerPageObject.getEmail(), email);
        formUtils.fillField(becomeChargingPartnerPageObject.getPhone(), phone);
        formUtils.fillField(becomeChargingPartnerPageObject.getCompany(), company);
        formUtils.fillField(becomeChargingPartnerPageObject.getMembershipOrganization(), membershipOrganization);
        formUtils.fillField(becomeChargingPartnerPageObject.getParkingUnits(), parkingUnits);
    }

    public void sendForm() {
        becomeChargingPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContain("/ladepartnere?success=1");
        assertThat(driver.getCurrentUrl()).contains("success");
    }
}
