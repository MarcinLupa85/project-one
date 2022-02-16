package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.HousingPageObject;

public class HousingOperations extends BaseOperations{
    private ApartmentPageOperations apartmentPageOperations;
    private HousingPageObject housingPageObject;

    public HousingOperations(WebDriver driver) {
        super(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        housingPageObject = new HousingPageObject(driver);
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
