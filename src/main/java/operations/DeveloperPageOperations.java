package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.DeveloperPageObject;
import utils.FormUtils;
import utils.WaitUtils;

public class DeveloperPageOperations {

    private DeveloperPageObject developerPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;

    public DeveloperPageOperations(WebDriver driver) {
        developerPageObject = new DeveloperPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
    }

    public void fillForm(String firstName, String lastName, String email, String mobile, String company, String project, String parkingPlaces, String description){
        waitUtils.bringElementToViewport(developerPageObject.getFirstName());
        formUtils.fillField(developerPageObject.getFirstName(), firstName);
        formUtils.fillField(developerPageObject.getLastName(), lastName);
        formUtils.fillField(developerPageObject.getEmail(), email);
        formUtils.fillField(developerPageObject.getMobile(), mobile);
        formUtils.fillField(developerPageObject.getCompanyNameInput(), company);
        formUtils.fillField(developerPageObject.getProjectName(), project);
        formUtils.fillField(developerPageObject.getParkingPlaces(), parkingPlaces);
        formUtils.fillField(developerPageObject.getDescription(), description);
    }
    public void clickSendForm() {
        waitUtils.waitForVisiblityOf(developerPageObject.getSubmitButton());
        developerPageObject.getSubmitButton().click();
    }

}
