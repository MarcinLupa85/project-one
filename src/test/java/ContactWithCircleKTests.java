import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static config.Constants.BASE_URL;

public class ContactWithCircleKTests extends TestsBase {
    private NavbarOperations navbarOperations;
    private CookiePanelOperations cookiePanelOperations;
    private ContactPageOperations contactPageOperations;
    private BusinessPageOperations businessPageOperations;
    private ApartmentPageOperations apartmentPageOperations;
    private DeveloperPageOperations developerPageOperations;
    private ReportProblemPageOperations reportProblemPageOperations;


    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
        contactPageOperations =  new ContactPageOperations(driver);
        cookiePanelOperations = new CookiePanelOperations(driver);
        businessPageOperations =  new BusinessPageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        developerPageOperations = new DeveloperPageOperations(driver);
        reportProblemPageOperations = new ReportProblemPageOperations(driver);
    }

    @AfterMethod
    private void goBack() {
        driver.navigate().to(BASE_URL);
        driver.navigate().refresh();
    }

    @TestCaseId(testRailCaseId = 1164)
    @Test
    public void testSendGeneralContactForm() {
        navbarOperations.openContactPage();
        contactPageOperations.fillForm("Test Automation", "testSendGeneralContactForm@mailinator.com", "123873456", "Company name", "Test comment");
        contactPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 1163)
    @Test
    public void testSendBusinessContactForm() {
        navbarOperations.openBusinessPage();
        businessPageOperations.fillForm("Test Automation", "testSendBusinessContactForm@mailinator.com", "123873456", "Company name", "Test comment");
        contactPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 1162)
    @Test
    public void testSendApartmentContactForm() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openApartmentPage();
        apartmentPageOperations.fillContactForm("Test", "Automation", "testSendApartmentContactForm@mailinator.com", "123873456", "Company name", "123","1234", "Test description");
        apartmentPageOperations.clickSendContactForm();
    }

    @TestCaseId(testRailCaseId = 1204)
    @Test
    public void testSendDeveloperContactForm() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openDeveloperPage();
        developerPageOperations.fillForm("Test", "Automation", "testSendDeveloperContactForm@mailinator.com", "123873456", "Company name", "Test Project", "123", "Test description" );
        developerPageOperations.clickSendForm();
    }

    @TestCaseId(testRailCaseId = 1205)
    @Test
    public void testSendReportProblemForm(){
        reportProblemPageOperations.goToReportProblemPage();
        reportProblemPageOperations.fillReportForm("Test Automation", "testSendReportProblemForm@mailinator.com", "123873456", "123", "Test model", "Test description");
        reportProblemPageOperations.chooseCarMake();
        reportProblemPageOperations.clickSend();
    }

}
