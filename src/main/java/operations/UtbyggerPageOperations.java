package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.UtbyggerPageObject;
import utils.FormUtils;
import utils.WaitUtils;

public class UtbyggerPageOperations {

    private UtbyggerPageObject utbyggerPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;

    public UtbyggerPageOperations(WebDriver driver) {
        utbyggerPageObject = new UtbyggerPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
    }

    public void fillForm(String firstName, String lastName, String email, String mobile, String company, String project, String parkingPlaces, String description){
        waitUtils.bringElementToViewport(utbyggerPageObject.getFirstName());
        formUtils.fillField(utbyggerPageObject.getFirstName(), firstName);
        formUtils.fillField(utbyggerPageObject.getLastName(), lastName);
        formUtils.fillField(utbyggerPageObject.getEmail(), email);
        formUtils.fillField(utbyggerPageObject.getMobile(), mobile);
        formUtils.fillField(utbyggerPageObject.getCompanyNameInput(), company);
        formUtils.fillField(utbyggerPageObject.getProjectName(), project);
        formUtils.fillField(utbyggerPageObject.getParkingPlaces(), parkingPlaces);
        formUtils.fillField(utbyggerPageObject.getDescription(), description);
    }
    public void clickSendForm() {
        waitUtils.waitForVisiblityOf(utbyggerPageObject.getSubmitButton());
        utbyggerPageObject.getSubmitButton().click();
    }


}
