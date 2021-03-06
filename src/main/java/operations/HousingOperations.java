package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.HousingPageObject;

public class HousingOperations extends ApartmentPageOperations {
    private HousingPageObject housingPageObject;

    public HousingOperations(WebDriver driver) {
        super(driver);
        housingPageObject = new HousingPageObject(driver);
    }

    public void goToHousingCompanyPage() {
        openApartmentPage();
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
