import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ApartmentPageObject;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactWithCircleKTests extends TestsBase {
    private HomePageOperations homePageOperations;
    private NavbarOperations navbarOperations;
    private CookiePanelOperations cookiePanelOperations;
    private ContactPageOperations contactPageOperations;
    private GmailPageOperations gmailPageOperations;
    private BusinessPageOperations businessPageOperations;
    private ApartmentPageOperations apartmentPageOperations;

    @BeforeMethod
    private void initOperations() {

        navbarOperations = new NavbarOperations(driver);
        contactPageOperations =  new ContactPageOperations(driver);
        cookiePanelOperations = new CookiePanelOperations(driver);
        businessPageOperations =  new BusinessPageOperations(driver);
        gmailPageOperations = new GmailPageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
    }

    @Test
    public void testSendGeneralContactForm() {
        navbarOperations.openContactPage();
        contactPageOperations.fillForm("Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment");
        cookiePanelOperations.clickCookieOkButton();
        contactPageOperations.clickSend();
        /*gmailPageOperations.openLatestMail();
        String[] data = new String[] {"Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment"};
        String emailData = gmailPageOperations.getContactFormData();
        for (String s : data)
        {
            assertThat(emailData.contains(s));
        }
        gmailPageOperations.deleteMail();*/
    }

    @Test
    public void testSendBusinessContactForm() {
        navbarOperations.openBusinessPage();
        businessPageOperations.fillForm("Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment");
        cookiePanelOperations.clickCookieOkButton();
        contactPageOperations.clickSend();
        /*gmailPageOperations.openLatestMail();
        String[] data = new String[] {"Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment"};
        String emailData = gmailPageOperations.getContactFormData();
        for (String s : data)
        {
            assertThat(emailData.contains(s));
        }
        gmailPageOperations.deleteMail();*/
    }

    @Test
    public void testSendApartmentContactForm() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openApartmentPage();
        apartmentPageOperations.fillContactForm("Test", "Automation", "evtestautomation@gmail.com", "123873456", "Company name", "123","1234", "Test comment");
        cookiePanelOperations.clickCookieOkButton();
        apartmentPageOperations.clickSendContactForm();
    }

}
