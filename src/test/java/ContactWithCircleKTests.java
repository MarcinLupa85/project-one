import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.FakerUtils;

import static config.Constants.BASE_URL;

public class ContactWithCircleKTests extends TestsBase {
    public static final String SEND_GENERAL_CONTACT_FORM_MAILINATOR_COM = "testSendGeneralContactForm@mailinator.com";
    public static final String TESTAPARTMENTFROM_MAILINATOR_COM = "testapartmentfrom@mailinator.com";
    public static final String TEST_SEND_DEVELOPER_CONTACT_FORM_MAILINATOR_COM = "testSendDeveloperContactForm@mailinator.com";
    public static final String TEST_SEND_REPORT_PROBLEM_FORM_MAILINATOR_COM = "testSendReportProblemForm@mailinator.com";
    public static final String TEST_BECOME_PARTNER_FORM_MAILINATOR_COM = "testBecomePartnerForm@mailinator.com";

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
        contactPageOperations.fillForm(
                FakerUtils.getFakerFullName(),
                SEND_GENERAL_CONTACT_FORM_MAILINATOR_COM,
                FakerUtils.getFakerPhone(),
                FakerUtils.getFakerCompany(),
                FakerUtils.getFakerDescription(2)
        );
        contactPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 1162)
    @Test
    public void testSendApartmentContactForm() {
        apartmentPageOperations.openApartmentPage();
        apartmentPageOperations.fillContactForm(
                FakerUtils.getFakerLastName(),
                FakerUtils.getFakerPhone(),
                FakerUtils.getFakerCompany(),
                TESTAPARTMENTFROM_MAILINATOR_COM,
                FakerUtils.getFakerZipCode());
        apartmentPageOperations.clickSendContactForm();
    }

    @TestCaseId(testRailCaseId = 1204)
    @Test
    public void testSendDeveloperContactForm() {
        developerPageOperations.goToDeveloperPage();
        developerPageOperations.fillForm(
                FakerUtils.getFakerFirstName(),
                FakerUtils.getFakerLastName(),
                TEST_SEND_DEVELOPER_CONTACT_FORM_MAILINATOR_COM,
                FakerUtils.getFakerPhone(),
                FakerUtils.getFakerCompany(),
                FakerUtils.getFakerProject(),
                FakerUtils.getFakerNumber(100, 199),
                FakerUtils.getFakerDescription(3));
        developerPageOperations.clickSendForm();
    }

    @TestCaseId(testRailCaseId = 1205)
    @Test
    public void testSendReportProblemForm() {
        reportProblemPageOperations.goToReportProblemPage();
        reportProblemPageOperations.fillReportForm(
                FakerUtils.getFakerFullName(),
                TEST_SEND_REPORT_PROBLEM_FORM_MAILINATOR_COM,
                FakerUtils.getFakerPhone(),
                FakerUtils.getFakerNumber(100, 199),
                FakerUtils.getFakerDescription(2),
                FakerUtils.getFakerDescription(3)
        );
        reportProblemPageOperations.chooseCarMake();
        reportProblemPageOperations.clickSend();
    }

    @TestCaseId(testRailCaseId = 5499)
    @Test
    public void testBecomePartnerForm() {
        navbarOperations.openPartnerPage();
        becomeChargingPartnerPageOperations.openForm();
        becomeChargingPartnerPageOperations.fillForm(
                FakerUtils.getFakerFirstName(),
                FakerUtils.getFakerLastName(),
                TEST_BECOME_PARTNER_FORM_MAILINATOR_COM,
                FakerUtils.getFakerPhone(),
                FakerUtils.getFakerCompany(),
                FakerUtils.getFakerOrganization(),
                FakerUtils.getFakerNumber(100, 199));
        becomeChargingPartnerPageOperations.sendForm();
    }
}
