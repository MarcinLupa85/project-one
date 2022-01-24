package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.ContactPageObject;
import utils.WaitUtils;

public class ContactPageOperations extends BaseOperations {

    private ContactPageObject contactPageObject;
    private WaitUtils waitUtils;

    public ContactPageOperations(WebDriver driver) {
        super(driver);
        contactPageObject = new ContactPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void fillForm(String name, String email, String number, String company, String comment) {
        waitUtils.waitForElement(contactPageObject.getFullNameInput());
        waitUtils.bringElementToViewport(contactPageObject.getFullNameInput());
        fillField(contactPageObject.getFullNameInput(), name);
        fillField(contactPageObject.getEmailInput(), email);
        fillField(contactPageObject.getTelephoneNumberInput(), number);
        fillField(contactPageObject.getCompanyNameInput(), company);
        fillField(contactPageObject.getCommentInput(), comment);
    }

    public void clickSend() {
        contactPageObject.getSubmitButton().click();
    }

}
