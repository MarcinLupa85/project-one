package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.HousingPageObject;
import utils.WaitUtils;

public class HousingOperations {
    private ApartmentPageOperations apartmentPageOperations;
    private HousingPageObject housingPageObject;
    private WaitUtils waitUtils;

    public HousingOperations(WebDriver driver) {
        apartmentPageOperations = new ApartmentPageOperations(driver);
        housingPageObject = new HousingPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void goToHousingCompanyPage() {
        apartmentPageOperations.openApartmentPage();
        housingPageObject.getCheckStatusLink().click();
        waitUtils.waitForVisibilityOf(housingPageObject.getHousingCompanyTitle());
    }

    public void inputHousingCompanyName(String companyName) {
        waitUtils.waitForVisibilityOf(housingPageObject.getHousingCompanyInput());
        housingPageObject.getHousingCompanyInput().sendKeys(companyName);
        waitUtils.waitForVisibilityOf(housingPageObject.getDropdownFirstOption());
        housingPageObject.getDropdownFirstOption().click();
    }

    public void clickSearchButton() {
        waitUtils.waitForElementToBeClickable(housingPageObject.getSearchButton());
        housingPageObject.getSearchButton().click();
    }

    public void clickBuyButton() {
        waitUtils.waitForElementToBeClickable(housingPageObject.getBuyButton());
        housingPageObject.getBuyButton().click();
    }
}
