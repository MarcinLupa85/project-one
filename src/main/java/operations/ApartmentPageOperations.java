package operations;

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

    public void fillContactForm(String name, String phone, String company, String mail){
        waitUtils.bringElementToViewport(apartmentPageObject.getName());
        formUtils.fillField(apartmentPageObject.getName(), name);
        formUtils.fillField(apartmentPageObject.getMail(), mail);
        formUtils.fillField(apartmentPageObject.getPhone(), phone);
        formUtils.fillField(apartmentPageObject.getCompanyNameInput(), company);
    }

    public void clickSendContactForm() {
        waitUtils.waitForVisiblityOf(apartmentPageObject.getContactSubmitButton());
        apartmentPageObject.getContactSubmitButton().click();
        waitUtils.waitForVisiblityOf(apartmentPageObject.getThankYouText());
        assertThat(apartmentPageObject.getThankYouText().getText().contains("Takk for din henvendelse"));
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = apartmentPageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("ladetjenester/faq",2);
        assertThat(driver.getCurrentUrl()).contains("ladetjenester/faq");
    }

    public void compareTitles(List<String> apartmentTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(apartmentTitles);
    }

    public void clickRedirectToForm() {
        apartmentPageObject.getRedirectToFormButton().click();
    }
}
