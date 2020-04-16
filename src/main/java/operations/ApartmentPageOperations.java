package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.ApartmentPageObject;
import utils.FormUtils;
import utils.WaitUtils;

public class ApartmentPageOperations {

    private ApartmentPageObject apartmentPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;

    public ApartmentPageOperations(WebDriver driver) {
        apartmentPageObject = new ApartmentPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
    }

    public void fillContactForm(String firstName, String lastName, String email, String mobile, String company, String parkingPlaces,String zipCode, String description){
        waitUtils.bringElementToViewport(apartmentPageObject.getFirstName());
        formUtils.fillField(apartmentPageObject.getFirstName(), firstName);
        formUtils.fillField(apartmentPageObject.getLastName(), lastName);
        formUtils.fillField(apartmentPageObject.getEmail(), email);
        formUtils.fillField(apartmentPageObject.getMobile(), mobile);
        formUtils.fillField(apartmentPageObject.getCompanyNameInput(), company);
        formUtils.fillField(apartmentPageObject.getParkingPlaces(), parkingPlaces);
        formUtils.fillField(apartmentPageObject.getZipCode(), zipCode);
        formUtils.fillField(apartmentPageObject.getDescription(), description);
    }
    public void clickSendContactForm() {
        waitUtils.waitForVisiblityOf(apartmentPageObject.getContactSubmitButton());
        apartmentPageObject.getContactSubmitButton().click();
    }
}
