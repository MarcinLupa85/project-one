package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ContactPageObject;
import utils.FormUtils;
import utils.WaitUtils;

public class ContactPageOperations {

    private ContactPageObject contactPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;

    public ContactPageOperations(WebDriver driver) {
        contactPageObject = new ContactPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils =  new FormUtils(driver);
    }

    public void fillForm (String name, String email, String number, String company, String comment) {
        waitUtils.waitForElement(contactPageObject.getFullNameInput());
        waitUtils.bringElementToViewport(contactPageObject.getFullNameInput());
        formUtils.fillField(contactPageObject.getFullNameInput(), name);
        formUtils.fillField(contactPageObject.getEmailInput(), email);
        formUtils.fillField(contactPageObject.getTelephoneNumberInput(), number);
        formUtils.fillField(contactPageObject.getCompanyNameInput(), company);
        formUtils.fillField(contactPageObject.getCommentInput(), comment);
    }

    public void clickSend() {
        contactPageObject.submitButton().click();
    }

}
