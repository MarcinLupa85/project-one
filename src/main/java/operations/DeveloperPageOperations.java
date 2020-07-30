package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.DeveloperPageObject;
import utils.FormUtils;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DeveloperPageOperations {

    private DeveloperPageObject developerPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;

    public DeveloperPageOperations(WebDriver driver) {
        developerPageObject = new DeveloperPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(developerPageObject, driver);
    }

    public void fillForm(String firstName, String lastName, String email, String mobile, String company, String project, String parkingPlaces, String description){
        waitUtils.waitForElement(developerPageObject.getFirstName());
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

    public void compareTitles(List<String> developerTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(developerTitles);
    }

}
