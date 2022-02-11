package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.SalesRepPageObject;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static testdata.EvRoutes.Partner.CUSTOMIZED_PAGE;

public class SalesRepOperations extends BaseOperations {

    private SalesRepPageObject salesRepPageObject;

    private static final String repName = "Bilbutikk 1 Fredrikstad";
    private static final String repMail = "krystian.kowalski@circlekeurope.com";

    public SalesRepOperations(WebDriver driver) {
        super(driver);
        salesRepPageObject = new SalesRepPageObject(driver);
    }

    public void goToSalesRepPage() throws TimeoutException {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "forhandler/Y21-277411");
        waitUtils.waitForDocumentReadyState();
    }

    public void chooseRepName() {
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getDealerName());
        waitUtils.bringElementToViewport(salesRepPageObject.getEmail());
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getDealerName()).sendKeys(repName);
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getDropdownFirstOption()).click();
    }

    public void sendRepMail() {
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getEmail()).sendKeys(repMail);
    }

    public void verifyRep() {
        salesRepPageObject.getArrowButton().click();
    }

    public void goToForm() {
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getGoToFormButton()).click();
        waitUtils.waitForUrlToContain("/forhandler/customize-order");
    }

    public void addCharger() {
        salesRepPageObject.getAddEaseeCharger().click();
    }

    public void clickSubmitButton() {
        salesRepPageObject.getNextButton().click();
    }

    public void fillForm() {
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getFirstName()).sendKeys("Test");
        salesRepPageObject.getLastName().sendKeys("Automation");
        salesRepPageObject.getEmail().sendKeys("easeenoextra@mailinator.com");
        salesRepPageObject.getAddress().sendKeys("Test Address");
        salesRepPageObject.getZipCode().sendKeys("3000");
        salesRepPageObject.getCity().sendKeys("City");
    }

    public void clickCheckbox() {
        salesRepPageObject.getConfirmationCheckbox().click();
    }

    public void completeOrder() {
        waitUtils.waitForElementToBeClickable(salesRepPageObject.getCompleteOrderButton()).click();
        waitUtils.waitForUrlToContain(CUSTOMIZED_PAGE + "forhandler/summary");
    }
}


