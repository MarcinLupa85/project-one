package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ApartmentPageObject;
import utils.FormUtils;
import utils.WaitUtils;
import java.util.List;
import java.util.concurrent.TimeoutException;
import static org.assertj.core.api.Assertions.assertThat;


public class ApartmentPageOperations {

    private ApartmentPageObject apartmentPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;
    private WebDriver driver;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;

    public ApartmentPageOperations(WebDriver driver) {
        apartmentPageObject = new ApartmentPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        this.driver = driver;
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(apartmentPageObject, driver);
    }

    public void fillContactForm(String name, String phone, String company){
        waitUtils.bringElementToViewport(apartmentPageObject.getName());
        formUtils.fillField(apartmentPageObject.getName(), name);
        formUtils.fillField(apartmentPageObject.getPhone(), phone);
        formUtils.fillField(apartmentPageObject.getCompanyNameInput(), company);
    }

    public void clickSendContactForm() {
        waitUtils.waitForVisiblityOf(apartmentPageObject.getContactSubmitButton());
        apartmentPageObject.getContactSubmitButton().click();
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = apartmentPageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/apartment",2);
        assertThat(driver.getCurrentUrl()).contains("/apartment");
    }

    public void compareTitles(List<String> apartmentTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(apartmentTitles);
    }
}
