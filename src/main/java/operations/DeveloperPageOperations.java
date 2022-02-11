package operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobjects.DeveloperPageObject;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static testdata.EvRoutes.REPORT_PAGE;

public class DeveloperPageOperations extends BaseOperations {
    private static final Logger LOGGER = LogManager.getLogger(DeveloperPageOperations.class);
    private DeveloperPageObject developerPageObject;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;

    public DeveloperPageOperations(WebDriver driver) {
        super(driver);
        developerPageObject = new DeveloperPageObject(driver);
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(developerPageObject, driver);
    }

    public void fillForm(String firstName, String lastName, String email, String mobile, String company, String project, String parkingPlaces, String description) {
        waitUtils.waitForElement(developerPageObject.getFirstName());
        waitUtils.bringElementToViewport(developerPageObject.getFirstName());
        fillField(developerPageObject.getFirstName(), firstName);
        fillField(developerPageObject.getLastName(), lastName);
        fillField(developerPageObject.getEmail(), email);
        fillField(developerPageObject.getPhone(), mobile);
        fillField(developerPageObject.getCompany(), company);
        fillField(developerPageObject.getMembershipOrganization(), project);
        fillField(developerPageObject.getParkingUnits(), parkingPlaces);
        fillField(developerPageObject.getDescription(), description);
    }

    public void clickSendForm() {
        waitUtils.waitForVisibilityOf(developerPageObject.getSubmitButton());
        developerPageObject.getSubmitButton().click();
    }

    public void compareTitles(List<String> developerTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(developerTitles);
        developerTitles.forEach(LOGGER::info);
    }

    public void goToDeveloperPage() {
        driver.navigate().to(BASE_URL + REPORT_PAGE);
    }

}
