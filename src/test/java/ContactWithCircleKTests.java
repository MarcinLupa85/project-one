import config.TestsBase;
import operations.ContactPageOperations;
import operations.HomePageOperations;
import operations.GmailPageOperations;
import operations.TopMenuOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactWithCircleKTests extends TestsBase {
    private HomePageOperations homePageOperations;
    private TopMenuOperations topMenuOperations;
    private ContactPageOperations contactPageOperations;
    private GmailPageOperations gmailPageOperations;
    private BusinessPageOperations businessPageOperations;

    @BeforeMethod
    private void initOperations() {

        topMenuOperations = new TopMenuOperations(driver);
        contactPageOperations =  new ContactPageOperations(driver);
        businessPageOperations =  new BusinessPageOperations(driver);
        gmailPageOperations = new GmailPageOperations(driver);
    }

    @Test
    public void testSendGeneralContactForm() {
        topMenuOperations.openContactPage();
        contactPageOperations.fillForm("Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment");
        contactPageOperations.clickSend();
        gmailPageOperations.openLatestMail();
        String[] data = new String[] {"Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment"};
        String emailData = gmailPageOperations.getContactFormData();
        for (String s : data)
        {
            assertThat(emailData.contains(s));
        }
        gmailPageOperations.deleteMail();
    }


    public void testSendBusinessContactForm() {
        topMenuOperations.openBusinessPage();
        businessPageOperations.fillForm("Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment");
        contactPageOperations.clickSend();
        gmailPageOperations.openLatestMail();
        String[] data = new String[] {"Test Automation", "evtestautomation@gmail.com", "123873456", "Company name", "Test comment"};
        String emailData = gmailPageOperations.getContactFormData();
        for (String s : data)
        {
            assertThat(emailData.contains(s));
        }
        gmailPageOperations.deleteMail();
    }

}
