package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.BecomeChargingPartnerPageObject;
import utils.WaitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class BecomeChargingPartnerPageOperations extends BaseOperations {
    private BecomeChargingPartnerPageObject becomeChargingPartnerPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public BecomeChargingPartnerPageOperations(WebDriver driver) {
        super(driver);
        becomeChargingPartnerPageObject = new BecomeChargingPartnerPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void openForm() {
        becomeChargingPartnerPageObject.getContactUsButton().click();
        waitUtils.waitForElementToBeClickable(becomeChargingPartnerPageObject.getFirstName());
    }

    public void fillForm(String firstName, String lastName, String email, String phone, String company, String membershipOrganization, String parkingUnits) {
        fillField(becomeChargingPartnerPageObject.getFirstName(), firstName);
        fillField(becomeChargingPartnerPageObject.getLastName(), lastName);
        fillField(becomeChargingPartnerPageObject.getEmail(), email);
        fillField(becomeChargingPartnerPageObject.getPhone(), phone);
        fillField(becomeChargingPartnerPageObject.getCompany(), company);
        fillField(becomeChargingPartnerPageObject.getMembershipOrganization(), membershipOrganization);
        fillField(becomeChargingPartnerPageObject.getParkingUnits(), parkingUnits);
    }

    public void sendForm() {
        becomeChargingPartnerPageObject.getSendButton().click();
        waitUtils.waitForUrlToContain("/ladepartnere?success=1");
        assertThat(driver.getCurrentUrl()).contains("success");
    }
}
