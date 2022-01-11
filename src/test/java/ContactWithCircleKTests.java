import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static config.Constants.BASE_URL;

public class ContactWithCircleKTests extends TestsBase {
    private NavbarOperations navbarOperations;
    private ContactPageOperations contactPageOperations;
    private ApartmentPageOperations apartmentPageOperations;
    private DeveloperPageOperations developerPageOperations;
    private ReportProblemPageOperations reportProblemPageOperations;
    private HomePageOperations homePageOperations;
    private BecomeChargingPartnerPageOperations becomeChargingPartnerPageOperations;


    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
        contactPageOperations = new ContactPageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        developerPageOperations = new DeveloperPageOperations(driver);
        reportProblemPageOperations = new ReportProblemPageOperations(driver);
        homePageOperations = new HomePageOperations(driver);
        becomeChargingPartnerPageOperations = new BecomeChargingPartnerPageOperations(driver);
    }

    @AfterMethod
    private void goBack() {
        driver.navigate().to(BASE_URL);
        driver.navigate().refresh();
    }

    @TestCaseId(testRailCaseId = 1164)
    @Test
    public void testSendGeneralContactForm() {
        homePageOperations.goToContactPage();
        contactPageOperations.fillForm("Test Automation", "testSendGeneralContactForm@mailinator.com", "123873456", "Company name", "Test comment");
        contactPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 1162)
    @Test
    public void testSendApartmentContactForm() {
        navbarOperations.openApartmentPage();
        apartmentPageOperations.fillContactForm("Test", "123873456", "Company name", "testapartmentfrom@mailinator.com");
        apartmentPageOperations.clickSendContactForm();
    }

    @TestCaseId(testRailCaseId = 1204)
    @Test
    public void testSendDeveloperContactForm() {
        developerPageOperations.goToDeveloperPage();
        developerPageOperations.fillForm("Test", "Automation", "testSendDeveloperContactForm@mailinator.com", "123873456", "Company name", "Test Project", "123", "Test description");
        developerPageOperations.clickSendForm();
    }

    @TestCaseId(testRailCaseId = 1205)
    @Test
    public void testSendReportProblemForm() {
        reportProblemPageOperations.goToReportProblemPage();
        reportProblemPageOperations.fillReportForm("Test Automation", "testSendReportProblemForm@mailinator.com", "123873456", "123", "Test model", "Test description");
        reportProblemPageOperations.chooseCarMake();
        reportProblemPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 5499)
    @Test
    public void testBecomePartnerForm() {
        navbarOperations.openBecomeChargingPartnerPage();
        becomeChargingPartnerPageOperations.openForm();
        becomeChargingPartnerPageOperations.fillForm("Test", "Test", "testBecomePartnerForm@mailinator.com", "123873456", "Test Company", "Test Organisation", "123");
        becomeChargingPartnerPageOperations.sendForm();
    }
}
