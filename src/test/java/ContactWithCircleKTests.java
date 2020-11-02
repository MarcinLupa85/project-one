import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;

public class ContactWithCircleKTests extends TestsBase {
    private NavbarOperations navbarOperations;
    private ContactPageOperations contactPageOperations;
    private ApartmentPageOperations apartmentPageOperations;
    private DeveloperPageOperations developerPageOperations;
    private ReportProblemPageOperations reportProblemPageOperations;


    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
        contactPageOperations =  new ContactPageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        developerPageOperations = new DeveloperPageOperations(driver);
        reportProblemPageOperations = new ReportProblemPageOperations(driver);
    }

    @AfterMethod
    private void goBack() {
        driver.navigate().to(BASE_URL);
        driver.navigate().refresh();
    }

    @TestCaseId(testRailCaseId = 2853)
    @Test
    public void testSendGeneralContactForm() {
        navbarOperations.openContactPage();
        contactPageOperations.fillForm("Test Automation", "testSendGeneralContactForm@mailinator.com", "123873456", "Company name", "Test comment");
        contactPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 2854)
    @Test
    public void testSendApartmentContactForm() throws TimeoutException {
        navbarOperations.clickNavbarDropdown();
        navbarOperations.openApartmentPage();
        navbarOperations.clickNavbarDropdown();
        apartmentPageOperations.fillContactForm("Test", "Automation", "testSendApartmentContactForm@mailinator.com", "123873456", "Company name", "123","1234", "Test description");
        apartmentPageOperations.clickSendContactForm();
    }

    @TestCaseId(testRailCaseId = 2856)
    @Test
    public void testSendDeveloperContactForm() throws TimeoutException {
        navbarOperations.clickNavbarDropdown();
        navbarOperations.openDeveloperPage();
        navbarOperations.clickNavbarDropdown();
        developerPageOperations.fillForm("Test", "Automation", "testSendDeveloperContactForm@mailinator.com", "123873456", "Company name", "Test Project", "123", "Test description" );
        developerPageOperations.clickSendForm();
    }

    @TestCaseId(testRailCaseId = 2857)
    @Test
    public void testSendReportProblemForm(){
        reportProblemPageOperations.goToReportProblemPage();
        reportProblemPageOperations.fillReportForm("Test Automation", "testSendReportProblemForm@mailinator.com", "123873456", "123", "Test model", "Test description");
        reportProblemPageOperations.chooseCarMake();
        reportProblemPageOperations.clickSend();
    }

}
