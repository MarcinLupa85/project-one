package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.SalesRepPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static testdata.EvRoutes.Partner.CUSTOMIZED_PAGE;

public class SalesRepOperations {
    private WaitUtils waitUtils;
    private WebDriver driver;
    private SalesRepPageObject salesRepPageObject;

    private static final String repName = "Volvo Bergen";
    private static final String repMail = "salesrepone@volvo.bergen.no";

    public SalesRepOperations(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        salesRepPageObject = new SalesRepPageObject(driver);
    }

    public void goToSalesRepPage() throws TimeoutException {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "forhandler/Y21-429364");
        waitUtils.waitForDocumentReadyState();
    }

    public void chooseRepName() {
        waitUtils.bringElementToViewport(salesRepPageObject.getEmail());
        salesRepPageObject.getDealerName().sendKeys(repName);
        salesRepPageObject.getDropdownFirstOption().click();
    }

    public void sendRepMail() {
        salesRepPageObject.getEmail().sendKeys(repMail);
    }

    public void verifyRep() {
        salesRepPageObject.getArrowButton().click();
    }

    public void goToForm() {
        salesRepPageObject.getGoToFormButton().click();
        waitUtils.waitForUrlToContain("/forhandler/customize-order");
    }

    public void addCharger() {
        salesRepPageObject.getAddEaseeCharger().click();
    }

    public void clickSubmitButton() {
        salesRepPageObject.getNextButton().click();
    }

    public void fillForm() {
        salesRepPageObject.getName().sendKeys("Test Kowalski");
        salesRepPageObject.getEmail().sendKeys("easeenoextra@mailinator.com");
        salesRepPageObject.getAddress().sendKeys("Test Address");
        salesRepPageObject.getZipCode().sendKeys("3000");
        salesRepPageObject.getCity().sendKeys("City");
    }

    public void clickCheckbox() {
        salesRepPageObject.getConfirmationCheckbox().click();
    }

    public void completeOrder() {
        salesRepPageObject.getCompleteOrderButton().click();
        waitUtils.waitForUrlToContain(CUSTOMIZED_PAGE + "forhandler/summary");
    }
}


