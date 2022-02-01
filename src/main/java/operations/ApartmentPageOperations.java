package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ApartmentPageObject;
import utils.WaitUtils;
import java.util.List;
import java.util.concurrent.TimeoutException;
import static org.assertj.core.api.Assertions.assertThat;


public class ApartmentPageOperations extends BaseOperations{

    private ApartmentPageObject apartmentPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;

    public ApartmentPageOperations(WebDriver driver) {
        super(driver);
        this.driver = driver;
        apartmentPageObject = new ApartmentPageObject(driver);
        waitUtils = new WaitUtils(driver);
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(apartmentPageObject, driver);
    }

    public void fillContactForm(String name, String phone, String company, String mail, String zipcode){
        waitUtils.bringElementToViewport(apartmentPageObject.getName());
        fillField(apartmentPageObject.getName(), name);
        fillField(apartmentPageObject.getMail(), mail);
        fillField(apartmentPageObject.getPhone(), phone);
        fillField(apartmentPageObject.getCompany(), company);
        fillField(apartmentPageObject.getZipCode(), zipcode);
    }

    public void clickSendContactForm() {
        waitUtils.waitForVisibilityOf(apartmentPageObject.getContactSubmitButton());
        apartmentPageObject.getContactSubmitButton().click();
        waitUtils.waitForVisibilityOf(apartmentPageObject.getThankYouText());
        assertThat(apartmentPageObject.getThankYouText().getText().contains("Takk for din henvendelse"));
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = apartmentPageObject.getReadMoreFaqButton();
        waitUtils.waitForVisibilityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContain("ladetjenester/faq",2);
        assertThat(driver.getCurrentUrl()).contains("ladetjenester/faq");
    }

    public void compareTitles(List<String> apartmentTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(apartmentTitles);
    }
}
