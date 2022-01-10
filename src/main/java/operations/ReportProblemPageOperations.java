package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.ReportProblemPageObject;
import utils.FormUtils;
import utils.WaitUtils;

import static config.Constants.BASE_URL;
import static testdata.EvRoutes.MOBILE_REPORT_PAGE;

public class ReportProblemPageOperations {

    private ReportProblemPageObject reportProblemPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;
    private WebDriver driver;

    public ReportProblemPageOperations(WebDriver driver) {
        reportProblemPageObject = new ReportProblemPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        this.driver = driver;
    }

    public void goToReportProblemPage() {
        driver.navigate().to(BASE_URL + MOBILE_REPORT_PAGE);
    }

    public void fillReportForm(String fullNameInput, String emailInput, String telephoneNumberInput, String chargersNumber, String carModel, String description) {
        waitUtils.waitForElement(reportProblemPageObject.getFullNameInput());
        waitUtils.bringElementToViewport(reportProblemPageObject.getFullNameInput());
        formUtils.fillField(reportProblemPageObject.getFullNameInput(), fullNameInput);
        formUtils.fillField(reportProblemPageObject.getEmailInput(), emailInput);
        formUtils.fillField(reportProblemPageObject.getTelephoneNumberInput(), telephoneNumberInput);
        formUtils.fillField(reportProblemPageObject.getChargersNumber(), chargersNumber);
        formUtils.fillField(reportProblemPageObject.getCarModel(), carModel);
        formUtils.fillField(reportProblemPageObject.getDescription(), description);
    }

    public void chooseCarMake() {
        Select carMake = new Select(reportProblemPageObject.getCarMake());
        carMake.selectByValue("BMW");
    }

    public void clickSend() {
        reportProblemPageObject.getSubmitButton().click();
    }
}