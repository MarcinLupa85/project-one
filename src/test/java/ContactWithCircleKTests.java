import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void testSendGeneralContactForm() {
        navbarOperations.openContactPage();
        contactPageOperations.fillForm("Test Automation", "testSendGeneralContactForm@mailinator.com", "123873456", "Company name", "Test comment");
        cookiePanelOperations.clickCookieOkButton();
        contactPageOperations.clickSend();
    }

    @Test
    public void testSendBusinessContactForm() {

        navbarOperations.openBusinessPage();
        businessPageOperations.fillForm("Test Automation", "testSendBusinessContactForm@mailinator.com", "123873456", "Company name", "Test comment");
        cookiePanelOperations.clickCookieOkButton();
        contactPageOperations.clickSend();
    }

    @Test
    public void testSendApartmentContactForm() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openApartmentPage();
        apartmentPageOperations.fillContactForm("Test", "Automation", "testSendApartmentContactForm@mailinator.com", "123873456", "Company name", "123","1234", "Test description");
        cookiePanelOperations.clickCookieOkButton();
        apartmentPageOperations.clickSendContactForm();
    }

    @Test
    public void testSendDeveloperContactForm() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openDeveloperPage();
        developerPageOperations.fillForm("Test", "Automation", "testSendDeveloperContactForm@mailinator.com", "123873456", "Company name", "Test Project", "123", "Test description" );
        cookiePanelOperations.clickCookieOkButton();
        developerPageOperations.clickSendForm();
    }

    @Test
    public void testSendReportProblemForm(){
        reportProblemPageOperations.goToReportProblemPage();
        reportProblemPageOperations.fillReportForm("Test Automation", "testSendReportProblemForm@mailinator.com", "123873456", "123", "Test model", "Test description");
        reportProblemPageOperations.chooseCarMake();
        cookiePanelOperations.clickCookieOkButton();
        reportProblemPageOperations.clickSend();
    }

}
