package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.ReportProblemPageObject;

import static config.Constants.BASE_URL;
import static testdata.EvRoutes.MOBILE_REPORT_PAGE;

public class ReportProblemPageOperations extends BaseOperations {

    private ReportProblemPageObject reportProblemPageObject;

    public ReportProblemPageOperations(WebDriver driver) {
        super(driver);
        reportProblemPageObject = new ReportProblemPageObject(driver);
    }

    public void goToReportProblemPage() {
        driver.navigate().to(BASE_URL + MOBILE_REPORT_PAGE);
    }

    public void fillReportForm(String fullNameInput, String emailInput, String telephoneNumberInput, String chargersNumber, String carModel, String description) {
        waitUtils.waitForElement(reportProblemPageObject.getFullNameInput());
        waitUtils.bringElementToViewport(reportProblemPageObject.getFullNameInput());
        fillField(reportProblemPageObject.getFullNameInput(), fullNameInput);
        fillField(reportProblemPageObject.getEmailInput(), emailInput);
        fillField(reportProblemPageObject.getTelephoneNumberInput(), telephoneNumberInput);
        fillField(reportProblemPageObject.getChargersNumber(), chargersNumber);
        fillField(reportProblemPageObject.getCarModel(), carModel);
        fillField(reportProblemPageObject.getDescription(), description);
    }

    public void chooseCarMake() {
        Select carMake = new Select(reportProblemPageObject.getCarMake());
        carMake.selectByValue("BMW");
    }

    public void clickSend() {
        reportProblemPageObject.getSubmitButton().click();
    }
}